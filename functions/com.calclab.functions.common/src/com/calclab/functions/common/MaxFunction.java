package com.calclab.functions.common;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.nls.Messages;

public class MaxFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "max"; //$NON-NLS-1$
	}

	@Override
	public Operand calculate() {
		if (!status.isWaiting()) {
			return result;
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);
		try {
			if (arguments.size() == 0) {
				String message = Messages.getString("AbstractFunction.1") + getName() + "'."; //$NON-NLS-1$ //$NON-NLS-2$
				throw new OperatorNotFoundException(message, new Throwable());
			}
			result = arguments.get(0);
			for (Operand argument : arguments) {
				if (!(argument instanceof AbstractNumber)) {
					String message = Messages.getString("ExpFunction.1") + getName() //$NON-NLS-1$
							+ Messages.getString("ExpFunction.2"); //$NON-NLS-1$

					throw new OperatorNotFoundException(message, new Throwable());
				}

				if (((AbstractNumber) result).compareTo((AbstractNumber) argument) < 0) {
					result = argument;
				}
			}
			status.setStage(CalculationStatus.Stage.DONE);

		} catch (OperatorNotFoundException e) {
			status.setMessage(e.getMessage());
			status.setStage(CalculationStatus.Stage.ERROR);
		}
		return result;
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		return operand;
	}

}
