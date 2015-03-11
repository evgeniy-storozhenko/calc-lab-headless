package com.calclab.core.parser;

import com.calclab.core.calculations.ICalculable;
import com.calclab.core.input.ICalculationInput;

/**
 * Converts the received data into those that can be calculated.
 */
public interface ICalculationParser {

	ICalculable[] parse(ICalculationInput input);

}
