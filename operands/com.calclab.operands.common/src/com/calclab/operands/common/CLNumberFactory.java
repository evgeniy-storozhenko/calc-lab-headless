package com.calclab.operands.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.operands.common.internal.CLNumber;

public class CLNumberFactory extends AbstractNumberFactory {

	@Override
	public AbstractNumber createNumber(double input) {
		return new CLNumber(input);
	}

	@Override
	public AbstractNumber createNumber(String input) {
		return new CLNumber(input);
	}

	@Override
	public AbstractNumber createNumber(BigDecimal input) {
		return new CLNumber(input);
	}

	@Override
	public AbstractNumber createNumber(BigDecimal num, BigDecimal denum) {
		return new CLNumber(num.doubleValue() / denum.doubleValue());
	}

}
