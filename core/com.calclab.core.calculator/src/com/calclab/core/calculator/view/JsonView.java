package com.calclab.core.calculator.view;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.calculator.CalculationView;

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
					.map(item -> item.toJSON())
					.collect(Collectors.toList());

			result.append(jsonResult.toString());
		} else {
			result.append(calculationProcess.getStatus().getMessage());
		}
		return result.toString();
	}

	@Override
	public void setOutputFile(File file) {
		// TODO Auto-generated method stub

	}

}
