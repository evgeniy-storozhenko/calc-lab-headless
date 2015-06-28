package com.calclab.functions.trigonometric;

import java.util.stream.Collectors;

import com.calclab.core.operands.Operand;
import com.calclab.functions.common.AbstractFunction;


public class SinFunction extends AbstractFunction {

	@Override
	public String getName() {
		return "exp";
	}

	@Override
	public Operand calculate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String args = arguments.stream().map(object -> object.toString())
				.collect(Collectors.joining(","));
		return getName() + "(" + args + ")";
	}

}
