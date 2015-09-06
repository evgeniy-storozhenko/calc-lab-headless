package com.calclab.operands.common.internal;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.monitors.NullStepMonitor;

public class Variable implements Operand, Calculable {

	private final String key;
	private Calculable expression;
	private StepsMonitor monitor;

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
		expression.setStepMonitor(monitor);
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

	@Override
	public void setStepMonitor(StepsMonitor monitor) {
		this.monitor = monitor;
	}

}
