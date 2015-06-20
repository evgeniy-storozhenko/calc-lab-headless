package com.calclab.functions.common;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.functions.Function;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.core.variables.Variable;
import com.calclab.operands.common.NullStepMonitor;

public abstract class AbstractFunction implements Function {

	protected List<Operand> arguments = new ArrayList<Operand>();
	protected CalculationStatus status = new CalculationStatus();
	protected Operand result = null;
	protected boolean exect = true;

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
	public void setArguments(List<Operand> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String getInput() {
		return "";
	}

}
