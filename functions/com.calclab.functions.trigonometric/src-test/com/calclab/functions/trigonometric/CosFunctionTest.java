package com.calclab.functions.trigonometric;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class CosFunctionTest extends TestCase {

	public CosFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scale = 60;
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber createNumber(String input) {
		return CommonOperandFactory.getInstance().createNumber(input);
	}

	private AbstractNumber cos(AbstractNumber a) {
		List<Operand> arguments = new ArrayList<Operand>();
		arguments.add(a);
		Function func = new CosFunction();
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
		AbstractNumber b = cos(a);

		String result = "0.8775825618903728";
		assertEquals(result, b.toString());
	}

	public void testSin_2() {
		AbstractNumber a = createNumber("-6");
		AbstractNumber b = cos(a);

		String result = "0.9601702866503661";
		assertEquals(result, b.toString());
	}

	public void testSin_3() {
		AbstractNumber a = createNumber("12");
		AbstractNumber b = cos(a);
		String result = "0.8438539587324921";
		assertEquals(result, b.toString());
	}

	public void testSin_4() {
		AbstractNumber a = createNumber("917976931348623157000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000000000000000000000");
		AbstractNumber b = cos(a);

		String result = "(-0.9259862594731227)";
		assertEquals(result, b.toString());
	}

}
