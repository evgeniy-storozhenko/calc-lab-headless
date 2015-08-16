package com.calclab.functions.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.operands.common.CommonOperandFactory;

import numbercruncher.mathutils.BigFunctions;

public class ExpFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "exp";
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			BigDecimal result = BigFunctions.exp(((AbstractNumber) operand).toBigDecimal(),
					AbstractNumber.scale);
			return CommonOperandFactory.getInstance().createNumber(result);
		}
		String message = "Can't calculate '" + getName() + "' with this type of argument.";
		throw new OperatorNotFoundException(message, new Throwable());
	}

}
