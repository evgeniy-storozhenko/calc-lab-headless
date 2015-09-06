package com.calclab.functions.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.functions.Function;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.functions.common.nls.Messages;

public abstract class AbstractFunction implements Function {

	protected List<Operand> arguments = new ArrayList<Operand>();
	protected CalculationStatus status = new CalculationStatus();
	protected Operand result = null;
	protected boolean exect = true;
	private StepsMonitor monitor;

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
	public StepsMonitor getStepMonitor() {
		return monitor;
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
	public void setArguments(List<Operand> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String getInput() {
		return ""; //$NON-NLS-1$
	}

	@Override
	public Operand calculate() {
		if (!status.isWaiting()) {
			return result;
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);
		try {
			if (arguments.size() == 1) {
				result = runWithOneArg(arguments.get(0));
				status.setStage(CalculationStatus.Stage.DONE);
			} else {
				String message = Messages.getString("AbstractFunction.1") + getName() + "'."; //$NON-NLS-1$ //$NON-NLS-2$
				throw new OperatorNotFoundException(message, new Throwable());
			}
		} catch (OperatorNotFoundException e) {
			status.setMessage(e.getMessage());
			status.setStage(CalculationStatus.Stage.ERROR);
		}
		return result;
	}

	@Override
	public String toString() {
		String args = arguments.stream().map(object -> object.toString())
				.collect(Collectors.joining(",")); //$NON-NLS-1$
		return getName() + "(" + args + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public void setStepMonitor(StepsMonitor monitor) {
		this.monitor = monitor;
	}

	protected abstract Operand runWithOneArg(Operand operand) throws OperatorNotFoundException;

}
