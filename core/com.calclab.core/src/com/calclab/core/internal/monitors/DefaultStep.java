package com.calclab.core.internal.monitors;

import com.calclab.core.calculations.Step;

public class DefaultStep implements Step {

	private final String value;

	public DefaultStep(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
