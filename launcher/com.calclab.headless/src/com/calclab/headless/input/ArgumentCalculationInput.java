package com.calclab.headless.input;

import com.calclab.core.input.CalculationInput;

public class ArgumentCalculationInput implements CalculationInput {

	private final String expressions;

	public ArgumentCalculationInput(String expressions) {
		this.expressions = expressions;
	}

	@Override
	public String getExpressions() {
		return expressions;
	}

}
