package com.calclab.functions.trigonometric;

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

public class Log implements Function {

	private final String name = "log";
	private List<Operand> arguments = null;
	private CalculationStatus status = new CalculationStatus();
	private Operand result = null;
	private boolean exect = true;

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException, InternalExpression {
		calculate();
		if (status.getStage().equals(CalculationStatus.Stage.DONE)) {
			return result.perform(operation, monitor);
		}
		throw new InternalExpression(status);
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		calculate();
		if (status.getStage().equals(CalculationStatus.Stage.DONE)) {
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
		if (!status.getStage().equals(CalculationStatus.Stage.WAITING)) {
			return result;
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);

		// TODO calculate log

		return result;
	}

	@Override
	public Variable getVariable() {
		// TODO Auto-generated method stub
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
		StringBuilder sb = new StringBuilder();
		final int size = arguments.size();
		for (int i = 0; i < size; i++) {
			sb.append(arguments.get(i).toString());
			if (i != (size - 1)) {
				sb.append(",");
			}
		}
		return this.name + "(" + sb.toString() + ")";
	}

}
