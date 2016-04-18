package com.calclab.operands.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.operands.common.internal.BigNumber;

public class BigNumberFactory extends AbstractNumberFactory {

	@Override
	public AbstractNumber createNumber(double input) {
		return new BigNumber("" + input);
	}

	@Override
	public AbstractNumber createNumber(String input) {
		return new BigNumber(input);
	}

	@Override
	public AbstractNumber createNumber(BigDecimal input) {
		return new BigNumber(input);
	}

	@Override
	public AbstractNumber createNumber(BigDecimal num, BigDecimal denum) {
		return new BigNumber(num, denum);
	}

}
