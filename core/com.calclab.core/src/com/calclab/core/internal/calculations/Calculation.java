package com.calclab.core.internal.calculations;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepFactory;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;

public class Calculation implements Calculable {

	private Operand operand;
	private Operand result;
	private final String input;
	private CalculationStatus status = new CalculationStatus();
	private StepsMonitor monitor = StepFactory.getInstance().createDefaultStepMonitor();

	public Calculation(Operand operand) {
		this.operand = operand;
		this.input = "";
	}

	public Calculation(Operand operand, String input) {
		this.operand = operand;
		this.input = input;
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

}
