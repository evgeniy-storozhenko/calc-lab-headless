package com.calclab.functions.trigonometric;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.AbstractFunction;
import com.calclab.operands.common.CommonOperandFactory;


public class CtgFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "ctg"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		CommonOperandFactory factory = CommonOperandFactory.getInstance();
		TgFunction tg = new TgFunction();
		return factory.createNumber("1").divide((AbstractNumber) tg.runWithOneArg(operand));
	}

}
