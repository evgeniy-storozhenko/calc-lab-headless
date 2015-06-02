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

public class CompositeOperand implements Operand, Calculable {

	private final Operand a;
	private final Operation operation;
	private final Operand b;
	private final CalculationStatus status = new CalculationStatus();
	private final StepsMonitor monitor = NullStepMonitor.getInstance();

	private Operand result = null;

	public CompositeOperand(Operand a, Operation operation, Operand b) {
		this.a = a;
		this.b = b;
		this.operation = operation;
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
				Operand o1 = (a instanceof Calculable) ? ((Calculable) a).calculate() : a;
				Operand o2 = (b instanceof Calculable) ? ((Calculable) b).calculate() : b;
				result = o1.perform(operation, o2, monitor);
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
	public CalculationStatus getStatus() {
		return status;
	}

	@Override
	public Operand getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "(" + a + operation + b + ")";
	}

	@Override
	public boolean isExact() {
		return true;
	}

	@Override
	public String getInput() {
		return null;
	}

}
