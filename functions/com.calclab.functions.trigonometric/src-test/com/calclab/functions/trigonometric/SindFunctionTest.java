package com.calclab.functions.trigonometric;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class SindFunctionTest extends TestCase {

	public SindFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scale = 60;
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber sind(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new SindFunction();
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

	/**
	 * sind(30)
	 */
	public void testSind() {
		AbstractNumber a = createNumber("30");
		AbstractNumber b = sind(a);

		String result = "0.5";
		assertEquals(result, b.toString());
	}

	/**
	 * sind(90)
	 */
	public void testSind_2() {
		AbstractNumber a = createNumber("90");
		AbstractNumber b = sind(a);

		String result = "1";
		assertEquals(result, b.toString());
	}

	/**
	 * sind(-60)
	 */
	public void testSind_3() {
		AbstractNumber a = createNumber("-60");
		AbstractNumber b = sind(a);

		String result = "-0.8660254";
		assertTrue(b.toString().contains(result));
	}

	/**
	 * sind(0)
	 */
	public void testSind_5() {
		AbstractNumber a = createNumber("0");
		AbstractNumber b = sind(a);

		String result = "0";
		assertTrue(b.toString().contains(result));
	}

}
