package com.calclab.headless.input;

import com.calclab.core.input.CalculationInput;
import com.calclab.headless.CalculationConfiguration;

public class InputFactory {

	public CalculationInput createCalculationInput(CalculationConfiguration config) {
		CalculationInput input = null;
		if (config.getInputFile() != null) {
			input = new FileCalculationInput(config.getInputFile());
		} else if (config.getInputData() != null) {
			input = new ArgumentCalculationInput(config.getInputData());
		} else {
			input = new StdCalculationInput();
		}
		return input;
	}

}
