package com.calclab.operands.common.utils;

import com.calclab.core.constants.MathConstants;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.operands.common.CommonOperandFactory;

public final class UnitOfMeasureConvertor {

	private UnitOfMeasureConvertor() {
	}

	public static AbstractNumber degreesToRadians(AbstractNumber number) {
		CommonOperandFactory factory = CommonOperandFactory.getInstance();
		AbstractNumber pi = factory.createNumber(MathConstants.PI);
		AbstractNumber n180 = factory.createNumber("180");
		return number.multiply(pi).divide(n180);
	}

	public static AbstractNumber radiansToDegrees(AbstractNumber number) {
		CommonOperandFactory factory = CommonOperandFactory.getInstance();
		AbstractNumber pi = factory.createNumber(MathConstants.PI);
		AbstractNumber n180 = factory.createNumber("180");
		return number.multiply(pi).divide(n180);
	}
}
