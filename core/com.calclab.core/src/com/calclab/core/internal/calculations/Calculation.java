package com.calclab.core.internal.calculations;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.variables.Variable;

public class Calculation implements Calculable {

	private Operand operand;
	private Operand result;
	private final String input;
	private CalculationStatus status = new CalculationStatus();

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
		if (!status.getStage().equals(CalculationStatus.Stage.WAITING)) {
			return result;
		}
		if (operand instanceof Calculable) {
			status.setStage(CalculationStatus.Stage.INPROCESS);
			result = ((Calculable) operand).calculate();
			status = ((Calculable) operand).getStatus();
		}
		return result;
	}

	@Override
	public Variable getVariable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StepsMonitor getStepMonitor() {
		// TODO Auto-generated method stub
		return null;
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

}
