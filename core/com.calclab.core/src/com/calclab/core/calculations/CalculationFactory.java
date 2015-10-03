package com.calclab.core.calculations;

import com.calclab.core.internal.calculations.Calculation;
import com.calclab.core.operands.Operand;

public class CalculationFactory {

	public Calculable createCalculation(Operand operand) {
		return new Calculation(operand);
	}

	public Calculable createCalculation(String variable, Operand operand, String input) {
		return new Calculation(variable, operand, input);
	}
}
