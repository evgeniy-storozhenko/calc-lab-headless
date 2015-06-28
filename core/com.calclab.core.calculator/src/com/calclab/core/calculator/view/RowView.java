package com.calclab.core.calculator.view;

import java.io.File;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculator.CalculationProcess;
import com.calclab.core.calculator.CalculationView;
import com.calclab.core.operands.Operand;

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
		if (calculationProcess.getStatus().isError()) {
			return calculationProcess.getStatus().getMessage();
		}
		for (Calculable expression : calculationProcess.getExpressions()) {
			if (expression.getStatus().isDone()) {
				Operand res = expression.getResult();
				result.append(expression.getInput());
				result.append((res.isExact()) ? "=" : "≈");
				result.append(res.toString());
				result.append(System.lineSeparator());
			} else {
				result.append(expression.getStatus().getMessage());
				result.append(System.lineSeparator());
			}
		}
		return result.toString();
	}

	@Override
	public void setOutputFile(File file) {
		// TODO Auto-generated method stub

	}

}
