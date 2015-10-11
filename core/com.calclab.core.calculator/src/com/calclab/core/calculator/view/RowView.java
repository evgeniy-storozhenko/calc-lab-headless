package com.calclab.core.calculator.view;

import java.io.File;
import java.util.List;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.Expression;
import com.calclab.core.calculations.Step;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.calculator.CalculationView;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.Void;

public class RowView implements CalculationView {

	private boolean isStdIn = false;
	private CalculationJob calculationProcess = null;

	public RowView(boolean isStdIn) {
		this.isStdIn = isStdIn;
	}

	@Override
	public void setCalculationProcess(CalculationJob calculationProcess) {
		this.calculationProcess = calculationProcess;
	}

	@Override
	public String output() {
		StringBuilder result = new StringBuilder();
		if (calculationProcess == null) {
			return result.toString();
		}
		if (calculationProcess.getStatus().isError()) {
			return calculationProcess.getStatus().getMessage();
		}
		boolean single = calculationProcess.getExpressions().size() == 1;
		for (Calculable expression : calculationProcess.getExpressions()) {
			appendInput(expression, result, single);
			appendSteps(expression, result);
			appendResult(expression, result);
		}
		return result.toString();
	}

	private void appendInput(Calculable expression, StringBuilder result, boolean single) {
		if (!(single && isStdIn)) {
			result.append(expression.getInput());
		} else {
			Calculable ans = calculationProcess.getVariables().get("ans");
			if (ans != null && ans.equals(expression)) {
				result.append("ans");
			} else if (expression instanceof Expression) {
				String varName = ((Expression) expression).getVariable();
				Calculable var = calculationProcess.getVariables().get(varName);
				if (var != null && var.equals(expression)) {
					result.append(varName);
				}
			}
		}
	}

	private void appendSteps(Calculable expression, StringBuilder result) {
		List<Step> steps = expression.getStepMonitor().getSteps();
		for (Step step : steps) {
			result.append(step);
			result.append(System.lineSeparator());
		}
	}

	public void appendResult(Calculable expression, StringBuilder result) {
		if (expression.getStatus().isDone()) {
			Operand res = expression.getResult();
			if (res instanceof Void) {
				return;
			}
			result.append((res.isExact()) ? " = " : " ≈ ");

			result.append(res.toString());
			result.append(System.lineSeparator());
		} else {
			result.append(expression.getStatus().getMessage());
			result.append(System.lineSeparator());
		}
	}

	@Override
	public String toString() {
		return output();
	}

	@Override
	public void setOutputFile(File file) {
		// TODO Auto-generated method stub

	}

}
