package com.calclab.operands.common.internal;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.Void;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.nls.Messages;

public class VoidOperand implements Void, Operand {

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException, InternalExpression {
		throw new OperatorNotFoundException(Messages.getString("BigNumber.0")
				+ operation.toString() + Messages.getString("BigNumber.1"));
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		throw new OperatorNotFoundException(Messages.getString("BigNumber.0")
				+ operation.toString() + Messages.getString("BigNumber.1"));
	}

	@Override
	public boolean isExact() {
		return true;
	}

	@Override
	public String toString() {
		return "";
	}

}
