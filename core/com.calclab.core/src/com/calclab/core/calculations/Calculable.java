package com.calclab.core.calculations;

import com.calclab.core.operands.Operand;
import com.calclab.core.variables.Variable;

/**
 * Expression which can be calculated.
 */
public interface Calculable {

	Operand calculate();

	Variable getVariable();

	StepsMonitor getStepMonitor();

	CalculationStatus getStatus();

	Operand getResult();
}
