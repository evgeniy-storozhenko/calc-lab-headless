package com.calclab.core.operands;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class AbstractNumber extends Number
		implements Operand, Comparable<AbstractNumber>, Cloneable {

	private static final long serialVersionUID = 6728533579589019981L;

	public static final String dsecimalMarkRegEx = "\\.";

	public static final String dsecimalMark = ".";

	public static int scale = 15;

	public static int scaleToDisplay = 8;

	public abstract Number getNumerator();

	public abstract Number getDenominator();

	public abstract void setNumerator(Number numerator);

	public abstract void setDenominator(Number denominator);

	public abstract AbstractNumber setScale(int newScale, RoundingMode roundingMode);

	public abstract AbstractNumber multiply(AbstractNumber number);

	public abstract AbstractNumber divide(AbstractNumber number);

	public abstract AbstractNumber divideToIntegralValue(AbstractNumber number);

	public abstract AbstractNumber[] divideAndRemainder(AbstractNumber number);

	public abstract AbstractNumber add(AbstractNumber number);

	public abstract AbstractNumber subtract(AbstractNumber number);

	public abstract AbstractNumber pow(AbstractNumber number);

	public abstract AbstractNumber negate();

	public abstract AbstractNumber round(MathContext mc);

	public abstract AbstractNumber abs();

	/**
	 * Returns true if this number lesser or equals then max value of Double
	 * 
	 * @return
	 */
	public abstract boolean withinLimitsOfDouble();

	/**
	 * Return true if this number lesser then 0
	 * 
	 * @return
	 */
	public abstract boolean isNegative();

	/**
	 * Return 1 if this number bigger then 0, -1 if lesser then 0, 0 if it equals 0
	 * 
	 * @return
	 */
	public abstract int signum();

	/**
	 * Return true if this number multiple to two
	 * 
	 * @return
	 */
	public abstract boolean isEven();

	/**
	 * Returns true if this number fractional
	 * 
	 * @return
	 */
	public abstract boolean isFractionalNumber();

	/**
	 * Optimizes numerator and a denominator
	 */
	public abstract void optimize();

	/**
	 * Return BigDecimal value of this number
	 * 
	 * @return
	 */
	public abstract BigDecimal toBigDecimal();

	/**
	 * Return BigInteger value of this number
	 * 
	 * @return
	 */
	public abstract BigInteger toBigInteger();

	/**
	 * String value of number in scientific notation
	 * 
	 * @return
	 */
	public abstract String toScientificNotation();

	@Override
	public abstract AbstractNumber clone();

}
