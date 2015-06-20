package com.calclab.functions.common;

import java.math.BigDecimal;

import numbercruncher.mathutils.BigFunctions;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.operands.common.CommonOperandFactory;

public class ExpFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "exp";
	}

	@Override
	public Operand calculate() {
		if (!status.isWaiting()) {
			return result;
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);
		try {
			if (arguments.size() == 1) {
				result = exp(arguments.get(0));
				status.setStage(CalculationStatus.Stage.DONE);
			} else {
				String message = "One argument is necessary for the function '" + getName() + "'.";
				throw new OperatorNotFoundException(message, new Throwable());
			}
		} catch (OperatorNotFoundException e) {
			status.setMessage(e.getMessage());
			status.setStage(CalculationStatus.Stage.ERROR);
		}
		return result;
	}

	private Operand exp(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			BigDecimal result = BigFunctions.exp(((AbstractNumber) operand).toBigDecimal(),
					AbstractNumber.scale);
			return CommonOperandFactory.getInstance().createNumber(result);
		}
		String message = "Can't calculate '" + getName() + "' with this type of argument.";
		throw new OperatorNotFoundException(message, new Throwable());
	}

}
