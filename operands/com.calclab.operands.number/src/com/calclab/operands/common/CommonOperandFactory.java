package com.calclab.operands.common;

import com.calclab.core.operands.Operand;
import com.calclab.operands.common.internal.Number;

public class CommonOperandFactory {
	
	public Operand createNumber(String input) {
		return new Number(input);
	}
	
}
