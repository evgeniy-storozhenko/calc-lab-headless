package com.calclab.core.operands;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

/**
 * Is the object of a mathematical operation, a quantity on which an
 * operation is performed. {@link} com.calclab.core.operators#Operation
 */
public interface Operand {

	Operand perform(Operation operation, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression;

	Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression;

}
