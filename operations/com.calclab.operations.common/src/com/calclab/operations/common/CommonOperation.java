package com.calclab.operations.common;

import com.calclab.core.operations.Operation;

public class CommonOperation implements Operation {

	private final String operation;

	public CommonOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String getName() {
		return operation;
	}

}
