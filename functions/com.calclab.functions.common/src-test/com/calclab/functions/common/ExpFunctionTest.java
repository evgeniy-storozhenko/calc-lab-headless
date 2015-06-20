package com.calclab.functions.common;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class ExpFunctionTest extends TestCase {

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber exp(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new ExpFunction();
		func.setArguments(arguments);
		Operand result = func.calculate();
		boolean isNumber = result instanceof AbstractNumber;
		assertTrue(isNumber);
		assertTrue(func.getStatus().isDone());
		if (isNumber) {
			return (AbstractNumber) result;
		} else {
			return null;
		}
	}

	public void testExp_1() {
		AbstractNumber a = createNumber("1");
		AbstractNumber b = exp(a);

		String result = "2.718281828459045235360287471352662497757247093699959574966967";
		assertEquals(result, b.toString());
	}

	public void testExp_2() {
		AbstractNumber a = createNumber("2");
		AbstractNumber b = exp(a);

		String result = "7.389056098930650227230427460575007813180315570551847324087124";
		assertEquals(result, b.toString());
	}

}
