package com.calclab.core.calculator.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.Expression;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.calculator.CalculationView;
import com.calclab.operands.common.CommonOperandFactory;

public class JsonView implements CalculationView {

	private CalculationJob calculationProcess = null;

	@Override
	public void setCalculationProcess(CalculationJob calculationProcess) {
		this.calculationProcess = calculationProcess;
	}

	@Override
	public String output() {
		return toString();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (calculationProcess == null) {
			return result.toString();
		}
		if (calculationProcess.getStatus().getStage().equals(CalculationStatus.Stage.DONE)) {
			List<JSONObject> jsonResult = calculationProcess.getExpressions().stream()
					.filter(item -> item != null)
					.map(item -> itemToJson(item))
					.collect(Collectors.toList());

			result.append(jsonResult.toString());
		} else {
			result.append(calculationProcess.getStatus().getMessage());
		}
		return result.toString();
	}

	private JSONObject itemToJson(Calculable expression) {
		JSONObject result = expression.toJSON();
		Calculable ans = calculationProcess.getVariables().get("ans");
		if (ans != null && ans.equals(expression)) {
			result = CommonOperandFactory.getInstance()
					.createVariableOperand("ans", expression).toJSON();
		} else if (expression instanceof Expression) {
			String varName = ((Expression) expression).getVariable();
			Calculable var = calculationProcess.getVariables().get(varName);
			if (var != null && var.equals(expression)) {
				result = CommonOperandFactory.getInstance()
						.createVariableOperand(varName, expression).toJSON();
			}
		}
		addSteps(expression, result);
		return result;
	}

	private void addSteps(Calculable expression, JSONObject result) {
		StepsMonitor monitor = expression.getStepMonitor();
		List<String> jsonSteps = new ArrayList<>();
		if (monitor != null && monitor.getSteps().size() > 0) {
			jsonSteps = monitor.getSteps().stream()
					.filter(item -> item != null)
					.map(item -> item.toString())
					.collect(Collectors.toList());
		}
		try {
			result.put("steps", jsonSteps);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setOutputFile(File file) {
		// TODO Auto-generated method stub

	}

}
