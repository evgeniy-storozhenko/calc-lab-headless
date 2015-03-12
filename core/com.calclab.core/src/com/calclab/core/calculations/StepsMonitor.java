package com.calclab.core.calculations;

import java.util.List;

/**
 * Traces the intermediate steps
 */
public interface StepsMonitor {

	void addStep(Step step);

	List<Step> getSteps();

}
