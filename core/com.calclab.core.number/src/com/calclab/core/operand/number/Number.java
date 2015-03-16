package com.calclab.core.operand.number;

import java.math.BigDecimal;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class Number implements Operand {

	private BigDecimal numerator;
	private BigDecimal denominator;

	public Number(String str) {
		String[] split = str.split("\\.");
		numerator = new BigDecimal(split[0]);
		if (split.length == 1) {
			denominator = new BigDecimal(1);
		}
		else {
			denominator = new BigDecimal(10);
			denominator = denominator.pow(split[1].length());
			numerator = numerator.multiply(denominator);
			numerator = numerator.add(new BigDecimal(split[1]));
		}
	}

	public BigDecimal getNumerator() {
		return numerator;
	}

	public BigDecimal getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return String.valueOf(numerator.divide(denominator));
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

}
