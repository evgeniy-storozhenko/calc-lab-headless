package com.calclab.operands.common.internal;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.NullStepMonitor;

public class Variable implements Operand, Calculable {

	private final String key;
	private Calculable expression;

	public Variable(String key, Calculable expression) {
		this.key = key;
		this.expression = expression;
	}

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException, InternalExpression {
		return expression.getResult().perform(operation, monitor);
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		return expression.getResult().perform(operation, operand, monitor);
	}

	@Override
	public boolean isExact() {
		return expression.getResult().isExact();
	}

	@Override
	public String toString() {
		return key;
	}

	@Override
	public Operand calculate() {
		return expression.calculate();
	}

	@Override
	public StepsMonitor getStepMonitor() {
		return NullStepMonitor.getInstance();
	}

	@Override
	public CalculationStatus getStatus() {
		return expression.getStatus();
	}

	@Override
	public Operand getResult() {
		return expression.getResult();
	}

	@Override
	public String getInput() {
		return "";
	}

}
