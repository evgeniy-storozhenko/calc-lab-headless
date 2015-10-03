package com.calclab.functions.trigonometric;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class CosdFunctionTest extends TestCase {

	public CosdFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber cosd(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new CosdFunction();
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
	 * cosd(30)
	 */
	public void testCosd() {
		AbstractNumber a = createNumber("30");
		AbstractNumber b = cosd(a);

		String result = "0.866025";
		assertTrue(b.toString().contains(result));
	}

	/**
	 * cosd(90)
	 */
	public void testCosd_2() {
		AbstractNumber a = createNumber("90");
		AbstractNumber b = cosd(a);

		String result = "0";
		assertEquals(result, b.toString());
	}

	/**
	 * cosd(-60)
	 */
	public void testCosd_3() {
		AbstractNumber a = createNumber("-60");
		AbstractNumber b = cosd(a);

		String result = "0.5";
		assertEquals(result, b.toString());
	}

	/**
	 * cosd(0)
	 */
	public void testCosd_5() {
		AbstractNumber a = createNumber("0");
		AbstractNumber b = cosd(a);

		String result = "1";
		assertTrue(b.toString().contains(result));
	}

}
