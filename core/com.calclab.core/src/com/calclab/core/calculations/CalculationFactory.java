package com.calclab.core.calculations;

import com.calclab.core.internal.calculations.Calculation;

public class CalculationFactory {

	public Calculation createCalculation() {
		return new Calculation();
	}

}
