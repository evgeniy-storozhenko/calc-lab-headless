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
		String result = String.valueOf(numerator.divide(denominator));
		if (isNegative()) {
			result = "(" + result + ")";
		}
		return result;
	}

	public Number Multiply(Number number) {
		numerator = numerator.multiply(number.getNumerator());
		denominator = denominator.multiply(number.getDenominator());
		return new Number(numerator, denominator);
	}

	public Number Divide(Number number) {
		numerator = numerator.multiply(number.getDenominator());
		denominator = denominator.multiply(number.getNumerator());
		return new Number(numerator, denominator);
	}

	public Number Add(Number number) {
		numerator = numerator.multiply(number.getDenominator());
		number.setNumerator(number.getNumerator().multiply(denominator));
		numerator = numerator.add(number.getNumerator());
		denominator = denominator.multiply(number.getDenominator());
		return new Number(numerator, denominator);
	}

	public Number Subtract(Number number) {
		numerator = numerator.multiply(number.getDenominator());
		number.setNumerator(number.getNumerator().multiply(denominator));
		numerator = numerator.subtract(number.getNumerator());
		denominator = denominator.multiply(number.getDenominator());
		return new Number(numerator, denominator);
	}

	public Number Pow() {
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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isNegative() {
		if ((numerator.signum() * denominator.signum()) == -1) {
			return true;
		}
		return false;
	}

}
