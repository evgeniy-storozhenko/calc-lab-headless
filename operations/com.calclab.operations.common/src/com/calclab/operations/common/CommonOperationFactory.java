package com.calclab.operations.common;

import com.calclab.core.operations.Operation;

public class CommonOperationFactory {

	public Operation createCommonOperation(String operation) {
		return new CommonOperation(operation.trim());
	}

}
