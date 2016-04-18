package com.calclab.functions.trigonometric;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class TgFunctionTest extends TestCase {

	public TgFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scale = 60;
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber tg(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new TgFunction();
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
	 * tg(30)
	 */
	public void testTg() {
		AbstractNumber a = createNumber("1");
		AbstractNumber b = tg(a);

		String result = "1.5574077";
		assertTrue(b.toString().contains(result));
	}

	/**
	 * tg(90)
	 */
	public void testTg_2() {
		AbstractNumber a = createNumber("-4");
		AbstractNumber b = tg(a);

		String result = "(-1.15782128";
		assertTrue(b.toString().contains(result));
	}

}
