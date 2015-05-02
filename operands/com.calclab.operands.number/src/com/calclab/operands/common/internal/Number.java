package com.calclab.operands.common.internal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class Number implements Operand {

	private BigDecimal numerator;
	private BigDecimal denominator;

	public Number(String str) {
		numerator = new BigDecimal(str);
		String[] split = str.split("\\.");
		if (split.length == 1) {
			denominator = new BigDecimal(1);
		} else {
			denominator = new BigDecimal(10);
			denominator = denominator.pow(split[1].length());
			numerator = numerator.multiply(denominator);
		}
	}

	private Number(BigDecimal numerator, BigDecimal denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public BigDecimal getNumerator() {
		return numerator.stripTrailingZeros();
	}

	public BigDecimal getDenominator() {
		return denominator;
	}

	public void setNumerator(BigDecimal numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(BigDecimal denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		BigDecimal result = numerator.divide(denominator);
		result = result.stripTrailingZeros();
		String string = String.valueOf(result);
		if (isNegative()) {
			string = "(" + string + ")";
		}
		return string;
	}

	public Number Multiply(Number number) {
		number = number.clone();
		Number result = clone();
		result.setNumerator(result.getNumerator().multiply(number.getNumerator()));
		result.setDenominator(result.getDenominator().multiply(number.getDenominator()));
		return result;
	}

	public Number Divide(Number number) {
		number = number.clone();
		Number result = clone();
		result.setNumerator(result.getNumerator().multiply(number.getDenominator()));
		result.setDenominator(result.getDenominator().multiply(number.getNumerator()));
		return result;
	}

	public Number Add(Number number) {
		number = number.clone();
		Number result = clone();
		result.setNumerator(result.getNumerator().multiply(number.getDenominator()));
		number.setNumerator(number.getNumerator().multiply(denominator));
		result.setNumerator(result.getNumerator().add(number.getNumerator()));
		result.setDenominator(result.getDenominator().multiply(number.getDenominator()));
		return result;
	}

	public Number Subtract(Number number) {
		number = number.clone();
		Number result = clone();
		result.setNumerator(result.getNumerator().multiply(number.getDenominator()));
		number.setNumerator(number.getNumerator().multiply(denominator));
		result.setNumerator(result.getNumerator().subtract(number.getNumerator()));
		result.setDenominator(result.getDenominator().multiply(number.getDenominator()));
		return result;
	}

	public Number Pow() {
		// TODO
		return new Number(numerator, denominator);
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
		final Number other = (Number) obj;
		BigDecimal expResult = numerator.divide(denominator, 4, RoundingMode.UP);
		BigDecimal Result = other.getNumerator().divide(other.getDenominator(), 4, RoundingMode.UP);
		if (expResult.compareTo(Result) == 0) {
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

		if (operation.getName().equals("+") && operand instanceof Number) {
			return Add((Number) operand);
		} else if (operation.getName().equals("-") && operand instanceof Number) {
			return Subtract((Number) operand);
		} else if (operation.getName().equals("*") && operand instanceof Number) {
			return Multiply((Number) operand);
		} else if (operation.getName().equals("/") && operand instanceof Number) {
			return Divide((Number) operand);
		} else {
			throw new OperatorNotFoundException("Operation '" + operation.getName()
					+ "' is not found.", new Throwable());
		}
	}

	public boolean isNegative() {
		if ((numerator.signum() * denominator.signum()) == -1) {
			return true;
		}
		return false;
	}

	@Override
	public Number clone() {
		return new Number(numerator, denominator);
	}

}
