package com.calclab.core.variables;

import com.calclab.core.operands.Operand;

public interface Variable {

	Operand getValue();

	Key getKey();

	void setValue(Operand operand);

}
