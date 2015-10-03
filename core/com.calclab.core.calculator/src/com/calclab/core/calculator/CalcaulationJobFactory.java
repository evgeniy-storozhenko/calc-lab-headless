package com.calclab.core.calculator;

import com.calclab.core.calculator.internal.CalculationJobImpl;
import com.calclab.core.input.CalculationInput;

public class CalcaulationJobFactory {

	public CalculationJob createCalculationJob(CalculationInput input) {
		return new CalculationJobImpl(input);
	}

	public CalculationJob createCalculationJob(CalculationInput input, int scale, int scaleToDisplay) {
		return new CalculationJobImpl(input, scale, scaleToDisplay);
	}

}
