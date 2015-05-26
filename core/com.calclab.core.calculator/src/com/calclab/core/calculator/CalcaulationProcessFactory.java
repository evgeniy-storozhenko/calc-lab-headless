package com.calclab.core.calculator;

import com.calclab.core.calculator.internal.CalculationProcessImpl;
import com.calclab.core.input.CalculationInput;

public class CalcaulationProcessFactory {

	public CalculationProcess createCalculationProcess(CalculationInput input) {
		return new CalculationProcessImpl(input);
	}

	public CalculationProcess createCalculationProcess(CalculationInput input, int scale) {
		return new CalculationProcessImpl(input, scale);
	}

}
