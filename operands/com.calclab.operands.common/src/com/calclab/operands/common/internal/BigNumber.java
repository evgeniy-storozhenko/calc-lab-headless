package com.calclab.operands.common.internal;

import java.math.BigDecimal;
import java.util.Objects;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class BigNumber extends AbstractNumber {

	private static final long serialVersionUID = -3375323002828277958L;

	private BigDecimal numerator;
	private BigDecimal denominator;
	private boolean exact = true;

	public BigNumber(String str) {
		numerator = new BigDecimal(str);
		String[] split = str.split("\\.");
		if (split.length == 1) {
			denominator = BigDecimal.ONE;
		} else {
			denominator = BigDecimal.TEN;
			denominator = denominator.pow(split[1].length());
			numerator = numerator.multiply(denominator);
		}
	}

	private BigNumber(BigDecimal numerator, BigDecimal denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public BigDecimal getNumerator() {
		return numerator.stripTrailingZeros();
	}

	@Override
	public BigDecimal getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		BigDecimal result = this.toBigDecimal();
		String string = result.toPlainString();
		if (isNegative()) {
			string = "(" + string + ")";
		}
		return string;
	}

	@Override
	public void optimize() {
		try {
			BigDecimal opimized = numerator.divide(denominator);
			String stringValue = opimized.toPlainString();
			if (stringValue.contains("\\.")) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException {

		if (operation.getName().equals("+") && operand instanceof AbstractNumber) {
			return add((AbstractNumber) operand);
		} else if (operation.getName().equals("-") && operand instanceof AbstractNumber) {
			return subtract((AbstractNumber) operand);
		} else if (operation.getName().equals("*") && operand instanceof AbstractNumber) {
			return multiply((AbstractNumber) operand);
		} else if (operation.getName().equals("/") && operand instanceof AbstractNumber) {
			return divide((AbstractNumber) operand);
		} else {
			throw new OperatorNotFoundException("Operation '" + operation.getName()
					+ "' is not found.", new Throwable());
		}
	}

	@Override
	public boolean isNegative() {
		if ((numerator.signum() * denominator.signum()) == -1) {
			return true;
		}
		return false;
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
	public AbstractNumber multiply(AbstractNumber number) {
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
	public AbstractNumber add(AbstractNumber number) {
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
	public AbstractNumber subtract(AbstractNumber number) {
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
	public BigNumber pow() {
		// TODO
		return new BigNumber(numerator, denominator);
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
			result = numerator.divide(denominator, 60, BigDecimal.ROUND_CEILING);
		}
		return result.stripTrailingZeros();
	}

	@Override
	public int compareTo(AbstractNumber other) {
		BigDecimal thisBigDecimal = toBigDecimal();
		BigDecimal otherBigDecimal = other.toBigDecimal();
		return thisBigDecimal.compareTo(otherBigDecimal);
	}
}
