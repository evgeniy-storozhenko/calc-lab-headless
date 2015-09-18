package com.calclab.functions.trigonometric;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.AbstractFunction;
import com.calclab.operands.common.CommonOperandFactory;


public class CtgdFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "ctgd"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		CommonOperandFactory factory = CommonOperandFactory.getInstance();
		TgdFunction tgd = new TgdFunction();
		return factory.createNumber("1").divide((AbstractNumber) tgd.runWithOneArg(operand));
	}

}
