package com.calclab.functions.trigonometric;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.AbstractFunction;
import com.calclab.functions.trigonometric.nls.Messages;
import com.calclab.operands.common.utils.UnitOfMeasureConvertor;


public class TgdFunction extends AbstractFunction {

	private TgFunction tg = new TgFunction();

	@Override
	public String getName() {
		return "tgd"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			AbstractNumber number = (AbstractNumber) operand;
			return tg.runWithOneArg(UnitOfMeasureConvertor.radiansToDegrees(number));
		}
		throw new OperatorNotFoundException(
				Messages.getString("CantCalculate") + getName() //$NON-NLS-1$
						+ Messages.getString("WithThisTypeOfArgument")); // $NON-NLS-2$
	}

}
