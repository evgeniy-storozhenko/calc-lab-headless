package com.calclab.core.parser;

import java.util.List;
import java.util.Map;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;

/**
 * Converts the received data into those that can be calculated.
 */
public interface Parser {

	String prepareInputHook(String input);

	void parse(CalculationInput input) throws InputException;

	List<Calculable> getExpressions();

	Map<String, Calculable> getVariables();

}
