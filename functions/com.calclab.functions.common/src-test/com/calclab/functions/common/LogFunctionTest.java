package com.calclab.functions.common;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class LogFunctionTest extends TestCase {

	public LogFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber log(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new LogFunction();
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

	private AbstractNumber log(AbstractNumber a, AbstractNumber b) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		arguments.add(b);
		Function func = new LogFunction();
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

	public void testLog_1() {
		AbstractNumber a = createNumber("1000");
		AbstractNumber b = log(a);

		String result = "6.907755278982137052053974364053092622803304465886318928099984";
		assertEquals(result, b.toString());
	}

	public void testLog_2() {
		AbstractNumber a = createNumber("1");
		AbstractNumber b = log(a);

		String result = "0";
		assertEquals(result, b.toString());
	}

	public void testLog_3() {
		AbstractNumber a = createNumber("3.14");
		AbstractNumber b = log(a);

		assertTrue(b.toString().contains("1.14422279992"));
	}

	public void testLog_4() {
		AbstractNumber a = createNumber("2");
		AbstractNumber b = createNumber("8");
		AbstractNumber c = log(a, b);

		assertEquals("3", c.toString());
	}

	public void testLog_5() {
		AbstractNumber a = createNumber("19");
		AbstractNumber b = createNumber("42052983462257059");
		AbstractNumber c = log(a, b);

		assertEquals("13", c.toString());
	}

}
