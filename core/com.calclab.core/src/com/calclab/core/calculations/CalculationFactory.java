package com.calclab.core.calculations;

import com.calclab.core.calculations.impl.Calculation;
import com.calclab.core.operands.Operand;

public class CalculationFactory {

	public Calculable createCalculation(Operand operand) {
		return new Calculation(operand);
	}

	public Calculable createCalculation(Operand operand, String input) {
		return new Calculation(null, operand, input);
	}

	public Calculable createCalculation(String variable, Operand operand, String input) {
		return new Calculation(variable, operand, input);
	}

	public Calculable createCalculation(String variable, Operand operand, String input,
			CalculationStatus status, Operand result) {
		return new Calculation(variable, operand, input, status, result);
	}
}
