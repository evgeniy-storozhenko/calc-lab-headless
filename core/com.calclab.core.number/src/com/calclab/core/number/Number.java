package com.calclab.core.number;

import java.math.BigDecimal;

public class Number {

	private BigDecimal numerator;
	private BigDecimal denominator;

	public Number(String str) {
		String[] split = str.split("\\.");
		numerator = new BigDecimal(split[0]);
		if (split.length == 1) {
			denominator = new BigDecimal(1);
		}
		else {
			denominator = new BigDecimal(10);
			denominator = denominator.pow(split[1].length());
			numerator = numerator.multiply(denominator);
			numerator = numerator.add(new BigDecimal(split[1]));
		}
	}

	public BigDecimal getNumerator() {
		return numerator;
	}

	public BigDecimal getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return String.valueOf(numerator.divide(denominator));
	}

}
