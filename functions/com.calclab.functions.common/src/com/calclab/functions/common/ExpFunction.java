package com.calclab.functions.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.nls.Messages;
import com.calclab.operands.common.CommonOperandFactory;

import numbercruncher.mathutils.BigFunctions;

public class ExpFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "exp"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			BigDecimal result = BigFunctions.exp(((AbstractNumber) operand).toBigDecimal(),
					AbstractNumber.scale);
			return CommonOperandFactory.getInstance().createNumber(result);
		}
		String message = Messages.getString("ExpFunction.1") + getName() + Messages.getString("ExpFunction.2"); //$NON-NLS-1$ //$NON-NLS-2$
		throw new OperatorNotFoundException(message, new Throwable());
	}

}
