package com.calclab.functions.trigonometric;

import java.math.BigDecimal;

import com.calclab.core.constants.MathConstants;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.AbstractFunction;
import com.calclab.operands.common.CommonOperandFactory;


public class CosFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "cos";
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		CommonOperandFactory factory = CommonOperandFactory.getInstance();
		if (operand instanceof AbstractNumber) {
			AbstractNumber number = (AbstractNumber) operand;
			if (number.withinLimitsOfDouble()) {
				return factory.createNumber(Math.cos(number.doubleValue()));
			}
			AbstractNumber twoPi = factory.createNumber(MathConstants.PI.multiply(BigDecimal.valueOf(2)));
			AbstractNumber[] divideAndRemainderResult = number.divideAndRemainder(twoPi);
			double remainder = divideAndRemainderResult[1].doubleValue();
			return factory.createNumber(Math.cos(remainder));
		}
		throw new OperatorNotFoundException("");
	}

}