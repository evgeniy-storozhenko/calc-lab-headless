package com.calclab.operands.common;

import com.calclab.core.operands.Operand;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.internal.CompositeExpression;
import com.calclab.operands.common.internal.CompositeOperand;
import com.calclab.operands.common.internal.Number;
import com.calclab.operands.common.internal.UnaryOperand;

public class CommonOperandFactory {
	
	public Operand createNumber(String input) {
		return new Number(input);
	}
	
	public CompositeExpression createCompositeExpression() {
		return null;
	}

	public Operand createCompositeOperand(Operand a, Operation operation, Operand b) {
		return new CompositeOperand(a, operation, b);
	}

	public Operand createUnaryOperand(Operand operand, Operation operation) {
		return new UnaryOperand(operand, operation);
	}

	public Operand createUnaryOperand(Operation operation, Operand operand) {
		return new UnaryOperand(operation, operand);
	}

	public Operand createUnaryOperand(Operand operand, Operation operation, boolean after) {
		return new UnaryOperand(operand, operation, after);
	}

}
