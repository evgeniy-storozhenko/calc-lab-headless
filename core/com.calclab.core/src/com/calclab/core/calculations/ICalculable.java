package com.calclab.core.calculations;

import com.calclab.core.operands.IOperand;
import com.calclab.core.variables.IVariable;

/**
 * Expression which can be calculated.
 */
public interface ICalculable {

	IOperand calculate();

	IVariable getVariable();

	IStepsMonitor getStepMonitor();

	CalculationStatus getStatus();

}
