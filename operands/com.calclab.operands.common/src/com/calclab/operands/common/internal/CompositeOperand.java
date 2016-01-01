package com.calclab.operands.common.internal;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class CompositeOperand implements Operand, Calculable {

	private final Operand a;
	private final Operation operation;
	private final Operand b;
	private final CalculationStatus status = new CalculationStatus();
	private StepsMonitor monitor;

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
	public synchronized Operand calculate() {
		if (status.isWaiting()) {
			try {
				status.setStage(CalculationStatus.Stage.INPROCESS);

				Operand o1 = prepare(a);
				Operand o2 = prepare(b);
				result = o1.perform(operation, o2, monitor);

				status.setStage(CalculationStatus.Stage.DONE);
			} catch (OperatorNotFoundException | InvalidActionException | InternalExpression e) {
				status.setStage(CalculationStatus.Stage.ERROR);
				status.setMessage(e.getMessage());
			}
		}
		return result;
	}

	private Operand prepare(Operand o) {
		if (o instanceof Calculable) {
			Calculable calculable = (Calculable) o;
			calculable.setStepMonitor(monitor);
			return calculable.calculate();
		}
		return o;
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

	@Override
	public void setStepMonitor(StepsMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			jsonResult.put("type", "CompositeOperand");
			jsonResult.put("a", a.toJSON());
			jsonResult.put("b", b.toJSON());
			jsonResult.put("operation", operation.toString());
			jsonResult.put("exect", isExact());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
