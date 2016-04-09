package com.calclab.core.calculations.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.Expression;
import com.calclab.core.calculations.StepFactory;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;

public class Calculation implements Calculable, Expression {

	private Operand operand;
	private Operand result;
	private final String input;
	private final String variable;
	private CalculationStatus status = new CalculationStatus();
	private StepsMonitor monitor = StepFactory.getInstance().createDefaultStepMonitor();

	public Calculation(Operand operand) {
		this.operand = operand;
		this.input = "";
		this.variable = null;
	}

	public Calculation(String variable, Operand operand, String input) {
		this.operand = operand;
		this.input = input;
		this.variable = variable;
	}

	public Calculation(String variable, Operand operand, String input,
			CalculationStatus status, Operand result) {
		this.operand = operand;
		this.input = input;
		this.status = status;
		this.variable = variable;
		this.result = result;
	}

	@Override
	public Operand calculate() {
		if (!status.isWaiting()) {
			return result;
		}
		if (operand instanceof Calculable) {
			status.setStage(CalculationStatus.Stage.INPROCESS);
			Calculable calculable = (Calculable) operand;
			calculable.setStepMonitor(monitor);
			result = calculable.calculate();
			status = calculable.getStatus();
		} else {
			result = operand;
			status.setStage(CalculationStatus.Stage.DONE);
		}
		return result;
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
		String string = "";
		if (result != null) {
			string = result.toString();
			if (result.isExact()) {
				string = "=" + string;
			} else {
				string = "≈" + string;
			}
		}
		string = operand.toString() + string;
		return string + ";";
	}

	@Override
	public String getInput() {
		return input;
	}

	@Override
	public void setStepMonitor(StepsMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public String getVariable() {
		return variable;
	}

	@Override
	public Operand getOperand() {
		return operand;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			jsonResult.put("type", "calculation");
			jsonResult.put("operand", operand.toJSON());
			if (result != null) {
				jsonResult.put("exact", result.isExact());
				jsonResult.put("result", result.toJSON());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
