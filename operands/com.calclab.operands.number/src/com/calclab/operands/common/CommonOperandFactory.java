package com.calclab.operands.common;

import com.calclab.core.operands.Operand;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.internal.CompositeExpression;
import com.calclab.operands.common.internal.CompositOperand;
import com.calclab.operands.common.internal.Number;

public class CommonOperandFactory {
	
	public Operand createNumber(String input) {
		return new Number(input);
	}
	
	public CompositeExpression createCompositeExpression() {
		return null;
	}

	public Operand createCompositOperand(Operand a, Operation operation, Operand b) {
		return new CompositOperand(a, operation, b);
	}

}
