package com.calclab.operands.common.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

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

/**
 * Simple number implementation. It's used in most common cases.
 */
public class CLNumber extends AbstractNumber {

	public static final CLNumber MINUS_ONE = new CLNumber("-1"); //$NON-NLS-1$
	public static final CLNumber ZERO = new CLNumber("0"); //$NON-NLS-1$
	public static final CLNumber ONE = new CLNumber("1"); //$NON-NLS-1$
	public static final CLNumber TWO = new CLNumber("2"); //$NON-NLS-1$
	public static final CLNumber THREE = new CLNumber("3"); //$NON-NLS-1$
	public static final CLNumber TEN = new CLNumber("10"); //$NON-NLS-1$

	public static final CLNumber E = new CLNumber(MathConstants.E);
	public static final CLNumber PI = new CLNumber(MathConstants.PI);
	public static final CLNumber GAMMA = new CLNumber(MathConstants.GAMMA);
	public static final CLNumber LOG2 = new CLNumber(MathConstants.LOG2);

	private static final long serialVersionUID = -3375323002828277958L;

	private Double value;

	public CLNumber(Double num) {
		value = num;
	}

	public CLNumber(String str) {
		value = Double.parseDouble(str);
	}

	public CLNumber(BigDecimal bigResult) {
		value = bigResult.doubleValue();
	}

	public CLNumber(BigInteger bigInteger) {
		value = bigInteger.doubleValue();
	}

	@Override
	public BigDecimal getNumerator() {
		return new BigDecimal(value);
	}

	@Override
	public BigDecimal getDenominator() {
		return BigDecimal.ONE;
	}

	@Override
	public String toString() {
		String res = value.toString();
		res = (res.endsWith(".0")) ? res.substring(0, res.length() - 2) : res;
		return this.isNegative() ? "(" + res + ")" : res;
	}

	@Override
	public void optimize() {
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj instanceof AbstractNumber) {
			return value.equals(((AbstractNumber) obj).doubleValue());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
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
		return Math.signum(value) == -1;
	}

	@Override
	public int signum() {
		return (int) Math.signum(value);
	}

	@Override
	public CLNumber clone() {
		return new CLNumber(value);
	}

	@Override
	public boolean isExact() {
		return true;
	}

	@Override
	public CLNumber multiply(AbstractNumber number) {
		CLNumber result = clone();
		CLNumber bigNumber;
		if (number instanceof CLNumber) {
			bigNumber = (CLNumber) number.clone();
		} else {
			bigNumber = new CLNumber(number.toString());
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
		CLNumber result = clone();
		CLNumber bigNumber;
		if (number instanceof CLNumber) {
			bigNumber = (CLNumber) number.clone();
		} else {
			bigNumber = new CLNumber(number.toString());
		}
		result.setNumerator(result.getNumerator().multiply(bigNumber.getDenominator()));
		result.setDenominator(result.getDenominator().multiply(bigNumber.getNumerator()));
		return result;
	}

	@Override
	public AbstractNumber divideToIntegralValue(AbstractNumber number) {
		return new CLNumber(divide(number).toBigInteger());
	}

	@Override
	public AbstractNumber[] divideAndRemainder(AbstractNumber divisor) {
		CLNumber[] result = new CLNumber[2];
		result[1] = new CLNumber(value % divisor.doubleValue());
		result[0] = new CLNumber((value - result[1].doubleValue())
				/ divisor.doubleValue());
		return result;
	}

	@Override
	public CLNumber add(AbstractNumber number) {
		return new CLNumber(value + number.doubleValue());
	}

	@Override
	public CLNumber subtract(AbstractNumber number) {
		return new CLNumber(value - number.doubleValue());
	}

	@Override
	public CLNumber pow(AbstractNumber b) {
		return new CLNumber(Math.pow(value, b.doubleValue()));
	}

	public CLNumber sqrt() {
		return new CLNumber(Math.sqrt(value)); // $NON-NLS-1$
	}

	public CLNumber factorial() throws InvalidActionException {
		if (this.isNegative()) {
			String msg = Messages.getString("BigNumber.4"); //$NON-NLS-1$
			throw new InvalidActionException(msg, new Throwable());
		}

		if (this.isFractionalNumber()
				|| this.toBigDecimal().compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
			BigNumber result = BigNumberUtils.approximationStirlingMoivre(new BigNumber(value.toString()));
			return new CLNumber(result.doubleValue());
		} else {
			return new CLNumber(BigNumberUtils.streamedParallel(this.intValue()));
		}
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public BigDecimal toBigDecimal() {
		return new BigDecimal(value);
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
	public CLNumber round(MathContext mc) {
		return new CLNumber(this.toBigDecimal().round(mc));
	}

	@Override
	public CLNumber setScale(int newScale, RoundingMode roundingMode) {
		return new CLNumber(this.toBigDecimal().setScale(newScale, roundingMode));
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

	@Override
	public void setNumerator(Number numerator) {
		value = numerator.doubleValue();
	}

	@Override
	public void setDenominator(Number denominator) {
		value = value / denominator.doubleValue();
	}

}
