package com.calclab.headless.input;

import com.calclab.core.input.ICalculationInput;
import com.calclab.headless.CalculationConfiguration;

public class InputFactory {

	public ICalculationInput createCalculationInput(CalculationConfiguration config) {
		ICalculationInput input = null;
		if (config.getInputFile() != null) {
			input = new FileCalculationInput(config.getInputFile());
		} else if (config.getInputData() != null) {
			input = new ArgumentCalculationInput(config.getInputData());
		} else {
			input = new PipeCalculationInput();
		}
		return input;
	}

}
