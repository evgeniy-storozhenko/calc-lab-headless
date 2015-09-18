package com.calclab.functions.trigonometric;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.AbstractFunction;
import com.calclab.functions.trigonometric.nls.Messages;
import com.calclab.functions.trigonometric.utils.TrigonometricHelper;


public class TgFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "tg"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			SinFunction sin = new SinFunction();
			CosFunction cos = new CosFunction();
			AbstractNumber sinRes = (AbstractNumber) sin.runWithOneArg(operand);
			AbstractNumber cosRes = (AbstractNumber) cos.runWithOneArg(operand);
			return TrigonometricHelper.round(sinRes.divide(cosRes));
		}
		throw new OperatorNotFoundException(
				Messages.getString("CantCalculate") + getName() //$NON-NLS-1$
						+ Messages.getString("WithThisTypeOfArgument")); // $NON-NLS-2$
	}

}
