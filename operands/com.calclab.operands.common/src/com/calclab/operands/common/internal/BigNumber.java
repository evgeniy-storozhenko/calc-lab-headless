package com.calclab.operands.common.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.constants.MathConstants;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.nls.Messages;
import com.calclab.operands.common.utils.BigNumberUtils;

import numbercruncher.mathutils.BigFunctions;

/**
 * Heavy implementation of number. It's used for high accuracy calculations
 */
public class BigNumber extends AbstractNumber {

	public static final BigNumber MINUS_ONE = new BigNumber("-1"); //$NON-NLS-1$
	public static final BigNumber ZERO = new BigNumber("0"); //$NON-NLS-1$
	public static final BigNumber ONE = new BigNumber("1"); //$NON-NLS-1$
	public static final BigNumber TWO = new BigNumber("2"); //$NON-NLS-1$
	public static final BigNumber THREE = new BigNumber("3"); //$NON-NLS-1$
	public static final BigNumber TEN = new BigNumber("10"); //$NON-NLS-1$

	public static final BigNumber E = new BigNumber(MathConstants.E);
	public static final BigNumber PI = new BigNumber(MathConstants.PI);
	public static final BigNumber GAMMA = new BigNumber(MathConstants.GAMMA);
	public static final BigNumber LOG2 = new BigNumber(MathConstants.LOG2);

	private static final long serialVersionUID = -3375323002828277958L;

	private BigDecimal numerator;
	private BigDecimal denominator;
	private boolean exact = true;

	public BigNumber(String str) {
		numerator = new BigDecimal(str);
		String[] split = str.split(AbstractNumber.dsecimalMarkRegEx);
		if (split.length == 1) {
			denominator = BigDecimal.ONE;
		} else {
			denominator = BigDecimal.TEN;
			denominator = denominator.pow(split[1].length());
			numerator = numerator.multiply(denominator);
		}
	}

	public BigNumber(BigDecimal numerator, BigDecimal denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public BigNumber(BigDecimal bigResult) {
		this(bigResult.toPlainString());
	}

	public BigNumber(BigInteger bigInteger) {
		this(bigInteger.toString());
	}

	@Override
	public BigDecimal getNumerator() {
		return numerator.stripTrailingZeros();
	}

	@Override
	public BigDecimal getDenominator() {
		return denominator.stripTrailingZeros();
	}

	@Override
	public String toString() {
		int offset = 0;
		BigDecimal result = this.toBigDecimal().abs();
		String plainString = result.toPlainString();
		final int length = plainString.length();
		final int firstNotZeroIndex = findFirstNotZeroIndex(plainString, length);
		final boolean isNegative = this.isNegative();

		if (length <= AbstractNumber.scaleToDisplay) {
			return isNegative ? "(-" + plainString + ")" : plainString; //$NON-NLS-1$ //$NON-NLS-2$
		}

		int position = plainString.indexOf(AbstractNumber.dsecimalMark);
		if (position == -1) {
			position = length;
		}

		offset = position - AbstractNumber.scaleToDisplay;
		String mantissa = getMantissa(offset, firstNotZeroIndex, plainString);
		if (firstNotZeroIndex > 0 && offset < 0) {
			offset -= firstNotZeroIndex - 1;
		}

		String sciNotation = mantissa;
		if (offset > 0 || firstNotZeroIndex > 3) {
			sciNotation += "e";
			sciNotation += (offset < 0) ? "" : "+";
			sciNotation += offset;
		}
		sciNotation = isNegative ? "(-" + sciNotation + ")" : sciNotation; //$NON-NLS-1$ //$NON-NLS-2$ ;
		return sciNotation;
	}

	private String getMantissa(int offset, int firstNotZeroIndex, String plainString) {
		String mantissa = null;
		if (offset > 0 || firstNotZeroIndex == 0) {
			mantissa = plainString.substring(0, AbstractNumber.scaleToDisplay);
		} else {
			int endIndex = (AbstractNumber.scaleToDisplay + firstNotZeroIndex);
			mantissa = plainString.substring(firstNotZeroIndex, endIndex);
		}
		return mantissa;
	}

	private int findFirstNotZeroIndex(String plainString, int length) {
		int firstNotZero = 0;
		char dsecimalMark = AbstractNumber.dsecimalMark.toCharArray()[0];
		for (int i = 0; i < length; i++) {
			if (plainString.charAt(i) != dsecimalMark && plainString.charAt(i) != '0') {
				break;
			}
			firstNotZero++;
		}
		return firstNotZero;
	}

	@Override
	public void optimize() {
		try {
			BigDecimal opimized = numerator.divide(denominator);
			String stringValue = opimized.toPlainString();
			if (stringValue.contains(AbstractNumber.dsecimalMarkRegEx)) {
				BigNumber result = new BigNumber(stringValue);
				numerator = result.getNumerator();
				denominator = result.getDenominator();
			} else {
				numerator = opimized;
				denominator = BigDecimal.ONE;
			}
			exact = true;
		} catch (ArithmeticException e) {
			exact = false;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		final BigNumber other = (BigNumber) obj;
		BigDecimal thisBigDecimal = toBigDecimal();
		BigDecimal otheBigDecimal = other.toBigDecimal();
		if (thisBigDecimal.compareTo(otheBigDecimal) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.numerator);
		hash = 67 * hash + Objects.hashCode(this.denominator);
		return hash;
	}

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException {

		if (operation.getName().equals("!")) { //$NON-NLS-1$
			return factorial();
		} else if (operation.getName().equals("-")) { //$NON-NLS-1$
			return negate();
		}

		throw new OperatorNotFoundException(Messages.getString("BigNumber.0") + operation.getName() //$NON-NLS-1$
				+ Messages.getString("BigNumber.1"), new Throwable()); //$NON-NLS-1$
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException {

		if (operation.getName().equals("+") && operand instanceof AbstractNumber) { //$NON-NLS-1$
			return add((AbstractNumber) operand);
		} else if (operation.getName().equals("-") && operand instanceof AbstractNumber) { //$NON-NLS-1$
			return subtract((AbstractNumber) operand);
		} else if (operation.getName().equals("%") && operand instanceof AbstractNumber) { //$NON-NLS-1$
			return divideAndRemainder((AbstractNumber) operand)[1];
		} else if (operation.getName().equals("*") && operand instanceof AbstractNumber) { //$NON-NLS-1$
			return multiply((AbstractNumber) operand);
		} else if (operation.getName().equals("/") && operand instanceof AbstractNumber) { //$NON-NLS-1$
			return divide((AbstractNumber) operand);
		} else if (operation.getName().equals("^") && operand instanceof AbstractNumber) { //$NON-NLS-1$
			return pow((AbstractNumber) operand);
		}

		throw new OperatorNotFoundException(Messages.getString("BigNumber.2") + operation.getName() //$NON-NLS-1$
				+ Messages.getString("BigNumber.3"), new Throwable()); //$NON-NLS-1$
	}

	@Override
	public boolean isNegative() {
		if ((numerator.signum() * denominator.signum()) == -1) {
			return true;
		}
		return false;
	}

	@Override
	public int signum() {
		return numerator.signum() * denominator.signum();
	}

	@Override
	public BigNumber clone() {
		return new BigNumber(numerator, denominator);
	}

	@Override
	public boolean isExact() {
		return exact;
	}

	@Override
	public void setNumerator(Number numerator) {
		if (numerator instanceof BigDecimal) {
			this.numerator = (BigDecimal) numerator;
		} else {
			this.numerator = new BigDecimal(numerator.toString());
		}
	}

	@Override
	public void setDenominator(Number denominator) {
		if (denominator instanceof BigDecimal) {
			this.denominator = (BigDecimal) denominator;
		} else {
			this.denominator = new BigDecimal(denominator.toString());
		}
	}

	@Override
	public BigNumber multiply(AbstractNumber number) {
		BigNumber result = clone();
		BigNumber bigNumber;
		if (number instanceof BigNumber) {
			bigNumber = (BigNumber) number.clone();
		} else {
			bigNumber = new BigNumber(number.toString());
		}
		result.setNumerator(result.getNumerator().multiply(bigNumber.getNumerator()));
		result.setDenominator(result.getDenominator().multiply(bigNumber.getDenominator()));
		return result;
	}

	@Override
	public AbstractNumber divide(AbstractNumber number) {
		if (number.toString().equals("0")) {
			return new Infinity();
		}
		BigNumber result = clone();
		BigNumber bigNumber;
		if (number instanceof BigNumber) {
			bigNumber = (BigNumber) number.clone();
		} else {
			bigNumber = new BigNumber(number.toString());
		}
		result.setNumerator(result.getNumerator().multiply(bigNumber.getDenominator()));
		result.setDenominator(result.getDenominator().multiply(bigNumber.getNumerator()));
		return result;
	}

	@Override
	public AbstractNumber divideToIntegralValue(AbstractNumber number) {
		return new BigNumber(divide(number).toBigInteger());
	}

	@Override
	public AbstractNumber[] divideAndRemainder(AbstractNumber divisor) {
		AbstractNumber[] result = new AbstractNumber[2];
		BigNumber a = this.clone();

		result[0] = a.divideToIntegralValue(divisor);
		result[1] = a.subtract(result[0].multiply(divisor));
		return result;
	}

	@Override
	public BigNumber add(AbstractNumber number) {
		BigNumber result = clone();
		BigNumber bigNumber;
		if (number instanceof BigNumber) {
			bigNumber = (BigNumber) number.clone();
		} else {
			bigNumber = new BigNumber(number.toString());
		}
		result.setNumerator(result.getNumerator().multiply(bigNumber.getDenominator()));
		bigNumber.setNumerator(bigNumber.getNumerator().multiply(denominator));
		result.setNumerator(result.getNumerator().add(bigNumber.getNumerator()));
		result.setDenominator(result.getDenominator().multiply(bigNumber.getDenominator()));
		return result;
	}

	@Override
	public BigNumber subtract(AbstractNumber number) {
		BigNumber result = clone();
		BigNumber bigNumber;
		if (number instanceof BigNumber) {
			bigNumber = (BigNumber) number.clone();
		} else {
			bigNumber = new BigNumber(number.toString());
		}
		result.setNumerator(result.getNumerator().multiply(bigNumber.getDenominator()));
		bigNumber.setNumerator(bigNumber.getNumerator().multiply(denominator));
		result.setNumerator(result.getNumerator().subtract(bigNumber.getNumerator()));
		result.setDenominator(result.getDenominator().multiply(bigNumber.getDenominator()));
		return result;
	}

	@Override
	public BigNumber pow(AbstractNumber b) {
		if (!b.isFractionalNumber()) {
			try {
				int intB = b.toBigDecimal().intValueExact();
				return bigDecimalPow(this.toBigDecimal(), intB);
			} catch (ArithmeticException e) {
				return bigDecimalPow(b);
			}
		} else {
			try {
				return simplePow(this.doubleValue(), b.doubleValue());
			} catch (Exception e) {
				return bigDecimalPow(b);
			}
		}
	}

	public BigNumber sqrt() {
		return pow(new BigNumber("0.5")); //$NON-NLS-1$
	}

	public BigNumber factorial() throws InvalidActionException {
		if (this.isNegative()) {
			String msg = Messages.getString("BigNumber.4"); //$NON-NLS-1$
			throw new InvalidActionException(msg, new Throwable());
		}

		if (this.isFractionalNumber()
				|| this.toBigDecimal().compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
			return BigNumberUtils.approximationStirlingMoivre(this);
		} else {
			return new BigNumber(BigNumberUtils.streamedParallel(this.intValue()));
		}
	}

	private BigNumber bigDecimalPow(BigDecimal a, int b) {
		return new BigNumber(a.pow(b));
	}

	private BigNumber bigDecimalPow(AbstractNumber b) {
		BigDecimal signum = BigDecimal.ONE;
		BigDecimal bigNumber = b.toBigDecimal();
		BigDecimal bigThis;

		if (this.isNegative() && !b.isEven()) {
			signum = signum.negate();
		}

		if (b.isNegative()) {
			BigNumber viceVersa = this.clone();
			viceVersa.setDenominator(numerator);
			viceVersa.setNumerator(denominator);
			bigThis = viceVersa.toBigDecimal().abs();
			bigNumber = bigNumber.abs();
		} else {
			bigThis = this.toBigDecimal();
		}

		BigDecimal bigResult;
		bigResult = BigFunctions.exp(BigFunctions.ln(bigThis, AbstractNumber.scale)
				.multiply(bigNumber), AbstractNumber.scale).multiply(signum);
		return new BigNumber(bigResult);
	}

	private BigNumber simplePow(Double a, Double b) {
		Double signum = 1D;
		boolean isEven = ((b.intValue() % 2) == 0);
		if (a < 0 && !isEven) {
			signum = -1D;
			a = a * (-1);
		}
		Double doubleC = signum * Math.pow(a, b);
		return new BigNumber(doubleC.toString());
	}

	@Override
	public int intValue() {
		return toBigDecimal().intValue();
	}

	@Override
	public long longValue() {
		return toBigDecimal().longValue();
	}

	@Override
	public float floatValue() {
		return toBigDecimal().floatValue();
	}

	@Override
	public double doubleValue() {
		return toBigDecimal().doubleValue();
	}

	@Override
	public BigDecimal toBigDecimal() {
		optimize();
		BigDecimal result;
		if (exact) {
			result = numerator.divide(denominator, BigDecimal.ROUND_UNNECESSARY);
		} else {
			result = numerator.divide(denominator, AbstractNumber.scale, BigDecimal.ROUND_CEILING);
		}
		return result.stripTrailingZeros();
	}

	@Override
	public BigInteger toBigInteger() {
		return toBigDecimal().toBigInteger();
	}

	@Override
	public int compareTo(AbstractNumber other) {
		BigDecimal thisBigDecimal = toBigDecimal();
		BigDecimal otherBigDecimal = other.toBigDecimal();
		return thisBigDecimal.compareTo(otherBigDecimal);
	}

	@Override
	public boolean isFractionalNumber() {
		return this.toBigDecimal().toString().contains("."); //$NON-NLS-1$
	}

	@Override
	public String toScientificNotation() {
		return toString();
	}

	@Override
	public boolean isEven() {
		BigInteger integer = this.toBigDecimal().stripTrailingZeros().unscaledValue();
		return !integer.testBit(0);
	}

	@Override
	public BigNumber round(MathContext mc) {
		return new BigNumber(this.toBigDecimal().round(mc));
	}

	@Override
	public BigNumber setScale(int newScale, RoundingMode roundingMode) {
		return new BigNumber(this.toBigDecimal().setScale(newScale, roundingMode));
	}

	@Override
	public AbstractNumber negate() {
		return this.multiply(MINUS_ONE);
	}

	@Override
	public AbstractNumber abs() {
		if (isNegative()) {
			return negate();
		}
		return this;
	}

	@Override
	public boolean withinLimitsOfDouble() {
		if (this.isNegative()) {
			BigDecimal doubleMin = new BigDecimal(Double.MIN_VALUE);
			if (this.toBigDecimal().compareTo(doubleMin) == -1) {
				return false;
			}
		} else {
			BigDecimal doubleMax = new BigDecimal(Double.MAX_VALUE);
			if (this.toBigDecimal().compareTo(doubleMax) == 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			jsonResult.put("type", "number");
			jsonResult.put("value", toString());
			jsonResult.put("exact", isExact());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
