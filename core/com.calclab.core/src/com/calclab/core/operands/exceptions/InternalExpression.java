package com.calclab.core.operands.exceptions;

import com.calclab.core.calculations.CalculationStatus;

public class InternalExpression extends Exception {

	private static final long serialVersionUID = 8366338263181985008L;

	private final CalculationStatus status;
	
	public InternalExpression(CalculationStatus status) {
		this.status = status;
	}

	@Override
	public String getMessage() {
		return status.getMessage();
	}
	
}
