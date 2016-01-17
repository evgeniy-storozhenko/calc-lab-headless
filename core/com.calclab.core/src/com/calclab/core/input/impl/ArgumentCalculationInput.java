package com.calclab.core.input.impl;

import com.calclab.core.input.CalculationInput;

public class ArgumentCalculationInput implements CalculationInput {

	private String expressions;

	public ArgumentCalculationInput(String expressions) {
		this.expressions = expressions;
	}

	@Override
	public String getExpressions() {
		return expressions;
	}

	@Override
	public boolean isExpectedMoreData() {
		return false;
	}

	@Override
	public void setExpressions(String expressions) {
		this.expressions = expressions;
	}

	@Override
	public boolean isStdIn() {
		return false;
	}

}
