package com.calclab.functions.common;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class SqrtFunctionTest extends TestCase {

	public SqrtFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber sqrt(Double arg) {
		AbstractNumber a = CommonOperandFactory.getInstance().createNumber(arg);
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new SqrtFunction();
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

	public void testSqrt_1() {
		AbstractNumber b = sqrt(4d);
		assertEquals("2", b.toString());
	}

	public void testSqrt_2() {
		AbstractNumber b = sqrt(16d);
		assertEquals("4", b.toString());
	}

	public void testSqrt_3() {
		try {
			sqrt(-16d);
			fail();
		} catch (IllegalArgumentException a) {
			assertTrue(true);
		}
	}

	public void testSqrt_4() {
		AbstractNumber res = sqrt(4294967296d);
		assertEquals("65536", res.toString());
	}

}
