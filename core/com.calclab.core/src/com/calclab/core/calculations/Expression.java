package com.calclab.core.calculations;

import com.calclab.core.operands.Operand;

public interface Expression {

	String getVariable();

	Operand getOperand();
}
