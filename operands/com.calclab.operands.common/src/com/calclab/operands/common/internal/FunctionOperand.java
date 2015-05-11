package com.calclab.operands.common.internal;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.functions.Function;
import com.calclab.core.functions.FunctionRegistry;
import com.calclab.core.input.exceptions.FunctionNotFoundException;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.core.variables.Variable;
import com.calclab.operands.common.NullStepMonitor;

public class FunctionOperand implements Operand, Calculable {

	private final String name;
	private final List<Operand> arguments;
	private CalculationStatus status = new CalculationStatus();
	private Function function = null;
	private Operand result = null;

	public FunctionOperand(String name, List<Operand> arguments) {
		this.name = name;
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
		if (function != null) {
			return function.isExact();
		}
		return true;
	}

	@Override
	public Operand calculate() {
		if (!status.getStage().equals(CalculationStatus.Stage.WAITING)) {
			return result;
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);
		try {
			function = FunctionRegistry.getInstance().createFunction(name, arguments);
			result = function.calculate();
			status = function.getStatus();
		} catch (CoreException | FunctionNotFoundException e) {
			status.setMessage(e.getMessage());
			status.setStage(CalculationStatus.Stage.ERROR);
		}
		return function;
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

}
