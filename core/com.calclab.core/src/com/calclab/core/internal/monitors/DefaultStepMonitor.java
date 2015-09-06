package com.calclab.core.internal.monitors;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.calculations.Step;
import com.calclab.core.calculations.StepsMonitor;

public class DefaultStepMonitor implements StepsMonitor {

	private List<Step> steps = new ArrayList<Step>();

	@Override
	public void addStep(Step step) {
		steps.add(step);
	}

	@Override
	public List<Step> getSteps() {
		return steps;
	}

}
