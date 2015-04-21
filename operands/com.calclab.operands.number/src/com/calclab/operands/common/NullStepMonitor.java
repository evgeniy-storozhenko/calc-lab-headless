package com.calclab.operands.common;

import java.util.List;

import com.calclab.core.calculations.Step;
import com.calclab.core.calculations.StepsMonitor;

public class NullStepMonitor implements StepsMonitor {

	@Override
	public void addStep(Step step) {
	}

	@Override
	public List<Step> getSteps() {
		return null;
	}

}
