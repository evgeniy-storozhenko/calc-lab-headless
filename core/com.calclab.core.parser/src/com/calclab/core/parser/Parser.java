package com.calclab.core.parser;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;

/**
 * Converts the received data into those that can be calculated.
 */
public interface Parser {

	Calculable[] parse(CalculationInput input) throws InputException;

}
