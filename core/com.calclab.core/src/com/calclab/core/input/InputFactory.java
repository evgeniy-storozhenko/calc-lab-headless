package com.calclab.core.input;

import com.calclab.core.CalculationConfiguration;
import com.calclab.core.input.impl.ArgumentCalculationInput;
import com.calclab.core.input.impl.FileCalculationInput;
import com.calclab.core.input.impl.StdCalculationInput;

public class InputFactory {

	public CalculationInput createCalculationInput(CalculationConfiguration config) {
		CalculationInput input = null;
		if (config.getInputFile() != null) {
			input = new FileCalculationInput(config.getInputFile());
		} else if (config.getInputData() != null) {
			input = new ArgumentCalculationInput(config.getInputData());
		} else {
			config.showVersion();
			input = new StdCalculationInput();
		}
		return input;
	}

}
