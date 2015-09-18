package com.calclab.functions.trigonometric;

import java.math.BigDecimal;

import com.calclab.core.constants.MathConstants;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.AbstractFunction;
import com.calclab.functions.trigonometric.nls.Messages;
import com.calclab.functions.trigonometric.utils.TrigonometricHelper;
import com.calclab.operands.common.CommonOperandFactory;

public class CosFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "cos"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		CommonOperandFactory factory = CommonOperandFactory.getInstance();
		if (operand instanceof AbstractNumber) {
			AbstractNumber number = (AbstractNumber) operand;
			if (number.withinLimitsOfDouble()) {
				AbstractNumber res = factory.createNumber(Math.cos(number.doubleValue()));
				return TrigonometricHelper.round(res);
			}
			AbstractNumber twoPi = factory.createNumber(MathConstants.PI.multiply(BigDecimal.valueOf(2)));
			AbstractNumber[] divideAndRemainderResult = number.divideAndRemainder(twoPi);
			double remainder = divideAndRemainderResult[1].doubleValue();
			AbstractNumber res = factory.createNumber(Math.cos(remainder));
			return TrigonometricHelper.round(res);
		}
		throw new OperatorNotFoundException(
				Messages.getString("CantCalculate") + getName() //$NON-NLS-1$
						+ Messages.getString("WithThisTypeOfArgument")); // $NON-NLS-2$
	}

}
