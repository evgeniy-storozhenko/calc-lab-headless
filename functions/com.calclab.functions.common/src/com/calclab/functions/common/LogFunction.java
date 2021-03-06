package com.calclab.functions.common;

import java.math.BigDecimal;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.functions.common.nls.Messages;
import com.calclab.operands.common.CommonOperandFactory;

import numbercruncher.mathutils.BigFunctions;

public class LogFunction extends AbstractFunction {

	@Override
	public Operand calculate() {
		if (!status.isWaiting()) {
			return result;
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);
		try {
			if (arguments.size() == 1) {
				result = log(arguments.get(0));
				status.setStage(CalculationStatus.Stage.DONE);
			} else if (arguments.size() == 2) {
				result = log(arguments.get(0), arguments.get(1));
				status.setStage(CalculationStatus.Stage.DONE);
			} else {
				String message = Messages.getString("LogFunction.0") + getName() + Messages.getString("LogFunction.1"); //$NON-NLS-1$ //$NON-NLS-2$
				throw new OperatorNotFoundException(message, new Throwable());
			}
		} catch (OperatorNotFoundException e) {
			status.setMessage(e.getMessage());
			status.setStage(CalculationStatus.Stage.ERROR);
		}
		return result;
	}

	private Operand log(Operand arg1, Operand arg2) throws OperatorNotFoundException {
		if (arg1 instanceof AbstractNumber && arg2 instanceof AbstractNumber) {
			AbstractNumber a = (AbstractNumber) arg1;
			AbstractNumber b = (AbstractNumber) arg2;
			if (b.isNegative()) {
				throw new OperatorNotFoundException(Messages.getString("LogFunction.2") + b + " <=  0", //$NON-NLS-1$ //$NON-NLS-2$
						new Throwable());
			}
			BigDecimal resA = BigFunctions.ln(a.toBigDecimal(), AbstractNumber.scale);
			BigDecimal resB = BigFunctions.ln(b.toBigDecimal(), AbstractNumber.scale);

			AbstractNumber res = CommonOperandFactory.getInstance().createNumber(resB)
					.divide(CommonOperandFactory.getInstance().createNumber(resA));

			return round(res);
		}
		String message = Messages.getString("LogFunction.4") + getName() + Messages.getString("LogFunction.5"); //$NON-NLS-1$ //$NON-NLS-2$
		throw new OperatorNotFoundException(message, new Throwable());
	}

	private AbstractNumber round(AbstractNumber num) {
		AbstractNumber result = num;
		BigDecimal bigDecNum = num.toBigDecimal();
		BigDecimal bigIntNum = new BigDecimal(num.toBigInteger());
		BigDecimal error = BigDecimal.ONE.divide(BigDecimal.TEN.pow(AbstractNumber.scale - 1));
		if (!bigIntNum.equals(BigDecimal.ZERO) && bigDecNum.subtract(bigIntNum).abs().compareTo(error) < 0) {
			result = CommonOperandFactory.getInstance().createNumber(bigIntNum);
		}
		return result;
	}

	private Operand log(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			AbstractNumber arg = (AbstractNumber) operand;
			if (arg.isNegative()) {
				throw new OperatorNotFoundException(Messages.getString("LogFunction.6") + arg + " <=  0", //$NON-NLS-1$ //$NON-NLS-2$
						new Throwable());
			}
			BigDecimal res = BigFunctions.ln(arg.toBigDecimal(), AbstractNumber.scale);
			return CommonOperandFactory.getInstance().createNumber(res);
		}
		String message = Messages.getString("LogFunction.8") + getName() + Messages.getString("LogFunction.9"); //$NON-NLS-1$ //$NON-NLS-2$
		throw new OperatorNotFoundException(message, new Throwable());
	}

	@Override
	public String getName() {
		return "log"; //$NON-NLS-1$
	}

	@Override
	protected Operand runWithOneArg(Operand operand) throws OperatorNotFoundException {
		return null;
	}

}
