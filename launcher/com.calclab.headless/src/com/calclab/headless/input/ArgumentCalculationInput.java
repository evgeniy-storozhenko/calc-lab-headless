package com.calclab.headless.input;

import com.calclab.core.input.ICalculationInput;

public class ArgumentCalculationInput implements ICalculationInput {

	private final String expressions;

	public ArgumentCalculationInput(String expressions) {
		this.expressions = expressions;
	}

	@Override
	public String getExpressions() {
		return expressions;
	}

}
