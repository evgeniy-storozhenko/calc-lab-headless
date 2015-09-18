package com.calclab.functions.trigonometric;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class TgdFunctionTest extends TestCase {

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber tgd(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new TgdFunction();
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
	 * tgd(30)
	 */
	public void testTgd() {
		AbstractNumber a = createNumber("30");
		AbstractNumber b = tgd(a);

		String result = "0.5773502";
		assertTrue(b.toString().contains(result));
	}

	/**
	 * tgd(90)
	 */
	public void testTgd_2() {
		AbstractNumber a = createNumber("90");
		AbstractNumber b = tgd(a);

		String result = "∞";
		assertEquals(result, b.toString());
	}

	/**
	 * tgd(-60)
	 */
	public void testTgd_3() {
		AbstractNumber a = createNumber("-60");
		AbstractNumber b = tgd(a);

		String result = "(-1.7320508";
		assertTrue(b.toString().contains(result));
	}

	/**
	 * tgd(0)
	 */
	public void testTgd_5() {
		AbstractNumber a = createNumber("0");
		AbstractNumber b = tgd(a);

		String result = "0";
		assertTrue(b.toString().contains(result));
	}

}
