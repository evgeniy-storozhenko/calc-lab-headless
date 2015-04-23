package com.calclab.core.calculations;

import com.calclab.core.internal.calculations.Calculation;
import com.calclab.core.operands.Operand;

public class CalculationFactory {

	public Calculation createCalculation(Operand operand) {
		return new Calculation(operand);
	}

}
