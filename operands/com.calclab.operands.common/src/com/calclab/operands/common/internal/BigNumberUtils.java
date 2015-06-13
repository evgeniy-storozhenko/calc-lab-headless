package com.calclab.operands.common.internal;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class BigNumberUtils {

	/**
	 * Stirling - Moivre approximation
	 * sqrt(2πn) * (n/e) ^ n
	 */
	public static BigNumber approximationStirlingMoivre(BigNumber n) {

		BigNumber first = BigNumber.TWO.multiply(BigNumber.PI).multiply(n).sqrt();
		BigNumber second = n.divide(BigNumber.E).pow(n);
		BigNumber approximation = BigNumber.ONE;
		approximation = approximation.add(BigNumber.ONE
				.divide(n.multiply(new BigNumber("12"))));
		approximation = approximation.add(BigNumber.ONE
				.divide(n.pow(BigNumber.TWO).multiply(new BigNumber("288"))));
		approximation = approximation.add((new BigNumber("139"))
				.divide(n.pow(BigNumber.THREE).multiply(new BigNumber("51840"))));
		approximation = approximation.add((new BigNumber("571"))
				.divide(n.pow(new BigNumber("4")).multiply(new BigNumber("2488320"))));
		approximation = approximation.add((new BigNumber("163879"))
				.divide(n.pow(new BigNumber("5")).multiply(new BigNumber("209018880"))));
		approximation = approximation.add((new BigNumber("5246819"))
				.divide(n.pow(new BigNumber("6")).multiply(new BigNumber("75246796800"))));

		return first.multiply(second).multiply(approximation);
	}

	public static BigInteger streamedParallel(int n) {
		if (n < 2)
			return BigInteger.valueOf(1);
		return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
	}

	public static String stripTrailingZeros(String input) {
		return input.replaceAll("(?<=^\\d+)\\.0*$", "");
	}

}
