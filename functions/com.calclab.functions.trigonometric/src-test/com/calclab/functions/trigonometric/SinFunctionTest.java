package com.calclab.functions.trigonometric;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class SinFunctionTest extends TestCase {

	public SinFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scale = 60;
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber sin(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new SinFunction();
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

	public void testSin_1() {
		AbstractNumber a = createNumber("0.5");
		AbstractNumber b = sin(a);

		String result = "0.479425538604203";
		assertEquals(result, b.toString());
	}

	public void testSin_2() {
		AbstractNumber a = createNumber("-6");
		AbstractNumber b = sin(a);

		String result = "0.27941549819892586";
		assertEquals(result, b.toString());
	}

	public void testSin_3() {
		AbstractNumber a = createNumber("12");
		AbstractNumber b = sin(a);
		String result = "(-0.5365729180004349)";
		assertEquals(result, b.toString());
	}

	public void testSin_4() {
		AbstractNumber a = createNumber("917976931348623157000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000");
		AbstractNumber b = sin(a);

		String result = "0.37755721058797787";
		assertEquals(result, b.toString());
	}

}
