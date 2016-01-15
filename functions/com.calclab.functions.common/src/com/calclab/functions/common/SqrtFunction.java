package com.calclab.functions.common;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.nls.Messages;
import com.calclab.operands.common.CommonOperandFactory;

public class SqrtFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "sqrt"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			AbstractNumber half = CommonOperandFactory.getInstance().createNumber(0.5d);
			return ((AbstractNumber) operand).pow(half);
		}
		String message = Messages.getString("ExpFunction.1") + getName() + Messages.getString("ExpFunction.2"); //$NON-NLS-1$ //$NON-NLS-2$
		throw new OperatorNotFoundException(message, new Throwable());
	}

}
