package com.calclab.core.input;

import com.calclab.core.input.exceptions.InputException;

/**
 * Customization of a way for input of expressions for calculation.
 */
public interface CalculationInput {

	String getExpressions() throws InputException;

	void setExpressions(String expressions);

	boolean isExpectedMoreData();

	boolean isStdIn();

}
