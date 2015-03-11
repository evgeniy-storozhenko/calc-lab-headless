package com.calclab.core.operands;

import com.calclab.core.calculations.IStepsMonitor;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operators.IOperator;

/**
 * Is the object of a mathematical operation, a quantity on which an
 * operation is performed.
 */
public interface IOperand {

	IOperand perform(IOperator command, IStepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException;

	IOperand perform(IOperator command, IOperand operand, IStepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException;

}
