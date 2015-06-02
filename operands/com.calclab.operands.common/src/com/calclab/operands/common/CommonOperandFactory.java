package com.calclab.operands.common;

import java.math.BigDecimal;
import java.util.List;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.internal.BigNumber;
import com.calclab.operands.common.internal.CompositeOperand;
import com.calclab.operands.common.internal.FunctionOperand;
import com.calclab.operands.common.internal.UnaryOperand;

public class CommonOperandFactory {

	private static CommonOperandFactory instance = null;

	private CommonOperandFactory() {
	}

	public synchronized static CommonOperandFactory getInstance() {
		if (instance == null) {
			instance = new CommonOperandFactory();
		}
		return instance;
	}

	public AbstractNumber createNumber(String input) {
		return new BigNumber(input);
	}

	public AbstractNumber createNumber(BigDecimal input) {
		return new BigNumber(input);
	}

	public AbstractNumber createNumber(BigDecimal num, BigDecimal denum) {
		return new BigNumber(num, denum);
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

	public Operand createFunctionOperand(String name, List<Operand> arguments) {
		return new FunctionOperand(name, arguments);
	}

}
