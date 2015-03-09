package com.calclab.core.parser;

import com.calclab.core.calculations.ICalculable;
import com.calclab.core.input.ICalculationInput;

public interface ICalculationParser {

	ICalculable[] parse(ICalculationInput input);

}
