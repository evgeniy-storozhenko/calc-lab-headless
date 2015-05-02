package com.calclab.core.internal.calculations;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.variables.Variable;

public class Calculation implements Calculable {

	private Operand operand;
	private Operand result;

	public Calculation(Operand operand) {
		this.operand = operand;
	}

	@Override
	public Operand calculate() {
		result = operand;
		if (operand instanceof Calculable) {
			result = ((Calculable) operand).calculate();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operand getResult() {
		return result;
	}

	@Override
	public String toString() {
		String string = operand.toString();
		if (result != null) {
			string += "=" + result;
		}
		return string;
	}

}
