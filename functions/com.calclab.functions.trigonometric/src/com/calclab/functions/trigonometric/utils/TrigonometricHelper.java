package com.calclab.functions.trigonometric.utils;

import java.math.RoundingMode;

import com.calclab.core.operands.AbstractNumber;

public final class TrigonometricHelper {

	public static AbstractNumber round(AbstractNumber res) {
		AbstractNumber roundedRes = res.setScale(3, RoundingMode.HALF_EVEN);
		String strRes = res.toString();
		if (strRes.length() > 2 && roundedRes.toString().startsWith(strRes.substring(0, 3))) {
			return res;
		} else {
			return roundedRes;
		}
	}

}
