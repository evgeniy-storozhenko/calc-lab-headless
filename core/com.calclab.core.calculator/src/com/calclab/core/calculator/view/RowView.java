package com.calclab.core.calculator.view;

import java.io.File;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculator.CalculationProcess;
import com.calclab.core.calculator.CalculationView;

public class RowView implements CalculationView {

	private CalculationProcess calculationProcess = null;

	@Override
	public void setCalculationProcess(CalculationProcess calculationProcess) {
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
			for (Calculable expression : calculationProcess.getExpressions()) {
				result.append(expression.toString() + System.lineSeparator());
			}
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
