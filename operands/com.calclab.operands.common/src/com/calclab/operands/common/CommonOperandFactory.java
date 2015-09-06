package com.calclab.operands.common;

import java.math.BigDecimal;
import java.util.List;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.internal.BigNumber;
import com.calclab.operands.common.internal.CompositeOperand;
import com.calclab.operands.common.internal.FunctionOperand;
import com.calclab.operands.common.internal.Matrix;
import com.calclab.operands.common.internal.StringOperand;
import com.calclab.operands.common.internal.UnaryOperand;
import com.calclab.operands.common.internal.Variable;
import com.calclab.operands.common.internal.VoidOperand;

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

	public AbstractNumber createNumber(double input) {
		return new BigNumber("" + input);
	}

	public AbstractNumber createNumber(String input) {
		return new BigNumber(input);
	}

	public Operand createStringOperand(String input) {
		return new StringOperand(input);
	}

	public Operand createVoidOperand() {
		return new VoidOperand();
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

	public Operand createVariableOperand(String key, Calculable expression) {
		return new Variable(key, expression);
	}

	public Operand createMatrix(Operand[][] arguments) {
		return new Matrix(arguments);
	}

}
