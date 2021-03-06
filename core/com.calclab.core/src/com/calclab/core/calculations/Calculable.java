package com.calclab.core.calculations;

import org.json.JSONObject;

import com.calclab.core.operands.Operand;

/**
 * Expression which can be calculated.
 */
public interface Calculable {

	Operand calculate();

	StepsMonitor getStepMonitor();

	void setStepMonitor(StepsMonitor monitor);

	CalculationStatus getStatus();

	Operand getResult();

	String getInput();

	JSONObject toJSON();
}
