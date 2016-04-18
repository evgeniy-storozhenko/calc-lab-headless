package com.calclab.operands.common;

import java.math.BigDecimal;
import java.util.List;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.internal.CompositeOperand;
import com.calclab.operands.common.internal.FunctionOperand;
import com.calclab.operands.common.internal.Infinity;
import com.calclab.operands.common.internal.Matrix;
import com.calclab.operands.common.internal.StringOperand;
import com.calclab.operands.common.internal.UnaryOperand;
import com.calclab.operands.common.internal.Variable;
import com.calclab.operands.common.internal.VoidOperand;

public class CommonOperandFactory {

	private AbstractNumberFactory numberFactory = null;

	private static CommonOperandFactory instance = null;

	private CommonOperandFactory() {
		if (AbstractNumber.scale > 15) {
			numberFactory = new BigNumberFactory();
		} else {
			numberFactory = new CLNumberFactory();
		}
	}

	public synchronized static CommonOperandFactory getInstance() {
		if (instance == null) {
			instance = new CommonOperandFactory();
		}
		return instance;
	}

	public AbstractNumber createNumber(double input) {
		return numberFactory.createNumber(input);
	}

	public AbstractNumber createNumber(String input) {
		return numberFactory.createNumber(input);
	}

	public AbstractNumber createNumber(BigDecimal input) {
		return numberFactory.createNumber(input);
	}

	public AbstractNumber createNumber(BigDecimal num, BigDecimal denum) {
		return numberFactory.createNumber(num, denum);
	}

	public Operand createStringOperand(String input) {
		return new StringOperand(input);
	}

	public Operand createVoidOperand() {
		return new VoidOperand();
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

	public Operand createInfinity() {
		return new Infinity();
	}

}
