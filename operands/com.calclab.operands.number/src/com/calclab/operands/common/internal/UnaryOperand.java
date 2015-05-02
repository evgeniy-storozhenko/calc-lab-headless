package com.calclab.operands.common.internal;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.core.variables.Variable;
import com.calclab.operands.common.NullStepMonitor;

public class UnaryOperand implements Operand, Calculable {

	private final boolean after;
	private final Operand operand;
	private final Operation operation;
	private final CalculationStatus status = new CalculationStatus();
	private final StepsMonitor monitor = NullStepMonitor.getInstance();

	private Operand result = null;

	public UnaryOperand(Operand operand, Operation operation) {
		this.operand = operand;
		this.operation = operation;
		this.after = true;
	}

	public UnaryOperand(Operation operation, Operand operand) {
		this.operand = operand;
		this.operation = operation;
		this.after = false;
	}

	public UnaryOperand(Operand operand, Operation operation, boolean after) {
		this.operand = operand;
		this.operation = operation;
		this.after = after;
	}

	@Override
	public String toString() {
		String string = "(" + operation + operand + ")";
		if (this.after) {
			string = "" + operand + operation;
		}
		return string;
	}

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
	public synchronized Operand calculate() {
		if (status.getStage().equals(CalculationStatus.Stage.WAITING)) {
			try {
				status.setStage(CalculationStatus.Stage.INPROCESS);
				result = operand.perform(operation, monitor);
				status.setStage(CalculationStatus.Stage.DONE);
			} catch (OperatorNotFoundException | InvalidActionException | InternalExpression e) {
				status.setStage(CalculationStatus.Stage.ERROR);
				status.setMessage(e.getMessage());
			}
		}
		return result;
	}

	@Override
	public Variable getVariable() {
		return null;
	}

	@Override
	public StepsMonitor getStepMonitor() {
		return monitor;
	}

	@Override
	public Operand getResult() {
		return result;
	}

	@Override
	public CalculationStatus getStatus() {
		return status;
	}

}
