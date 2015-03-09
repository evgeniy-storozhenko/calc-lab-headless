package com.calclab.core.variables;

import com.calclab.core.operands.IOperand;

public interface IVariable {

	IOperand getValue();

	IKey getKey();

	void setValue(IOperand operand);

	void setKey(IKey operand);

}
