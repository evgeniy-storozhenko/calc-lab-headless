package com.calclab.core.parser;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;

/**
 * Converts the received data into those that can be calculated.
 */
public interface CalculationParser {

	Calculable[] parse(CalculationInput input);

}
