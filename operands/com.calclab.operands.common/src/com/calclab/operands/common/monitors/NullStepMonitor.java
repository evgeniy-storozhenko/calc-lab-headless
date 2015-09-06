package com.calclab.operands.common.monitors;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.calculations.Step;
import com.calclab.core.calculations.StepsMonitor;

public class NullStepMonitor implements StepsMonitor {

	private static StepsMonitor instance = null;
	private List<Step> steps = new ArrayList<Step>();

	public synchronized static StepsMonitor getInstance() {
		if (instance == null) {
			instance = new NullStepMonitor();
		}
		return instance;
	}

	private NullStepMonitor() {
	}

	@Override
	public void addStep(Step step) {
	}

	@Override
	public List<Step> getSteps() {
		return steps;
	}

}
