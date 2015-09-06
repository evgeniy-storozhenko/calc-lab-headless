package com.calclab.core.calculations;

import com.calclab.core.internal.monitors.DefaultStep;
import com.calclab.core.internal.monitors.DefaultStepMonitor;

public class StepFactory {

	private static StepFactory instance = null;

	private StepFactory() {
	}

	public synchronized static StepFactory getInstance() {
		if (instance == null) {
			instance = new StepFactory();
		}
		return instance;
	}

	public Step createDefaultStep(String value) {
		return new DefaultStep(value);
	}

	public StepsMonitor createDefaultStepMonitor() {
		return new DefaultStepMonitor();
	}

}
