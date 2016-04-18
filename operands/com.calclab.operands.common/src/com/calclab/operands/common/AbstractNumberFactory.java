package com.calclab.operands.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;

public abstract class AbstractNumberFactory {

	public abstract AbstractNumber createNumber(double input);

	public abstract AbstractNumber createNumber(String input);

	public abstract AbstractNumber createNumber(BigDecimal input);

	public abstract AbstractNumber createNumber(BigDecimal num, BigDecimal denum);

}
