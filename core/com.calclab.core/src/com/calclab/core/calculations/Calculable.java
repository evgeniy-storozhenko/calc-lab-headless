package com.calclab.core.calculations;

import com.calclab.core.operands.Operand;

/**
 * Expression which can be calculated.
 */
public interface Calculable {

	Operand calculate();

	StepsMonitor getStepMonitor();

	CalculationStatus getStatus();

	Operand getResult();

	String getInput();
}
