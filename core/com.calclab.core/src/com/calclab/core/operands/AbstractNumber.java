package com.calclab.core.operands;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class AbstractNumber extends Number
		implements Operand, Comparable<AbstractNumber>, Cloneable {

	private static final long serialVersionUID = 6728533579589019981L;

	public static final String dsecimalMark = "\\.";

	public static int scale = 60;

	public abstract Number getNumerator();

	public abstract Number getDenominator();

	public abstract void setNumerator(Number numerator);

	public abstract void setDenominator(Number denominator);

	public abstract AbstractNumber multiply(AbstractNumber number);

	public abstract AbstractNumber divide(AbstractNumber number);

	public abstract AbstractNumber add(AbstractNumber number);

	public abstract AbstractNumber subtract(AbstractNumber number);

	public abstract AbstractNumber pow(AbstractNumber number);

	public abstract AbstractNumber round(MathContext mc);

	public abstract AbstractNumber setScale(int newScale, RoundingMode roundingMode);

	public abstract boolean isNegative();

	public abstract boolean isEven();

	public abstract boolean isFractionalNumber();

	public abstract void optimize();

	public abstract BigDecimal toBigDecimal();

	@Override
	public abstract AbstractNumber clone();

	public abstract String toScientificNotation();

}
