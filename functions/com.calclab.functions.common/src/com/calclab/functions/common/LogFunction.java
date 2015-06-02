package com.calclab.functions.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import numbercruncher.mathutils.BigFunctions;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.core.variables.Variable;
import com.calclab.operands.common.CommonOperandFactory;
import com.calclab.operands.common.NullStepMonitor;

public class LogFunction implements Function {

	private final String name = "log";
	private List<Operand> arguments = null;
	private CalculationStatus status = new CalculationStatus();
	private Operand result = null;
	private boolean exect = true;

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException, InternalExpression {
		calculate();
		if (status.isDone()) {
			return result.perform(operation, monitor);
		}
		throw new InternalExpression(status);
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		calculate();
		if (status.isDone()) {
			return result.perform(operation, operand, monitor);
		}
		throw new InternalExpression(status);
	}

	@Override
	public boolean isExact() {
		return exect;
	}

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
				String message = "Can't calculate '" + name + "' with this type of argument.";
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
				throw new OperatorNotFoundException("Illegal argument: " + b + " <=  0",
						new Throwable());
			}
			BigDecimal resA = BigFunctions.ln(a.toBigDecimal(), AbstractNumber.scale);
			BigDecimal resB = BigFunctions.ln(b.toBigDecimal(), AbstractNumber.scale);

			AbstractNumber res = CommonOperandFactory.getInstance().createNumber(resB)
					.divide(CommonOperandFactory.getInstance().createNumber(resA));
			return res;
		}
		String message = "Can't calculate '" + name + "' with this type of argument.";
		throw new OperatorNotFoundException(message, new Throwable());
	}

	private Operand log(Operand operand) throws OperatorNotFoundException {
		if (operand instanceof AbstractNumber) {
			AbstractNumber arg = (AbstractNumber) operand;
			if (arg.isNegative()) {
				throw new OperatorNotFoundException("Illegal argument: " + arg + " <=  0",
						new Throwable());
			}
			BigDecimal res = BigFunctions.ln(arg.toBigDecimal(), AbstractNumber.scale);
			return CommonOperandFactory.getInstance().createNumber(res);
		}
		String message = "Can't calculate '" + name + "' with this type of argument.";
		throw new OperatorNotFoundException(message, new Throwable());
	}

	@Override
	public Variable getVariable() {
		return null;
	}

	@Override
	public StepsMonitor getStepMonitor() {
		return NullStepMonitor.getInstance();
	}

	@Override
	public CalculationStatus getStatus() {
		return status;
	}

	@Override
	public Operand getResult() {
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setArguments(List<Operand> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		String args = arguments.stream().map(object -> object.toString())
				.collect(Collectors.joining(","));
		return this.name + "(" + args + ")";
	}

}
