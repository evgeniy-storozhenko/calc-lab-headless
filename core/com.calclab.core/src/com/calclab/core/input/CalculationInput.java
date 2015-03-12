package com.calclab.core.input;

/**
 * Customization of a way for input of expressions for calculation.
 */
public interface CalculationInput {

	String getExpressions() throws InputException;

}
