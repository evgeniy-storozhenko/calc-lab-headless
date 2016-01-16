package com.calclab.functions.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.operands.common.CommonOperandFactory;

import junit.framework.TestCase;

public class MaxFunctionTest extends TestCase {

	public MaxFunctionTest(String testName) {
		super(testName);
		AbstractNumber.scaleToDisplay = 1000;
	}

	private AbstractNumber max(Double[] args) {
		List<Double> argsList = Arrays.asList(args);
		List<Operand> arguments = argsList.stream()
				.map(item -> CommonOperandFactory.getInstance().createNumber(item))
				.collect(Collectors.toList());

		Function func = new MaxFunction();
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

	public void testMax() {
		Double[] numbers = { 4d, 6d, 2d, 8d };
		AbstractNumber res = max(numbers);
		assertEquals("8", res.toString());
	}

	public void testMax_2() {
		Double[] numbers = { -4d, -6d, -2d, -8d };
		AbstractNumber res = max(numbers);
		assertEquals("(-2)", res.toString());
	}

	public void testMax_3() {
		Double[] numbers = { 10d };
		AbstractNumber res = max(numbers);
		assertEquals("10", res.toString());
	}

}
