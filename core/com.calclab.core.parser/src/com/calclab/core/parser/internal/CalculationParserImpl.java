package com.calclab.core.parser.internal;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.parser.CalculationParser;

public class CalculationParserImpl implements CalculationParser {

	private static CalculationParser instance = null;

	public synchronized static CalculationParser getInstance() {
		if (instance == null) {
			instance = new CalculationParserImpl();
		}
		return instance;
	}

	private CalculationParserImpl() {
		CalclabExtensionManager.getInstance(); // TODO remove
	}

	@Override
	public Calculable[] parse(CalculationInput input) {
		// TODO Auto-generated method stub
		return null;
	}

}
