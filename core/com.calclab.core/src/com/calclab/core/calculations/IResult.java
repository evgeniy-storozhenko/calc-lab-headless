package com.calclab.core.calculations;

import com.calclab.core.operands.IOperand;
import com.calclab.core.variables.IVariable;

public interface IResult {

	IVariable getVariable();

	ISteps getIntermediateSteps();

	IOperand getValue();

}
