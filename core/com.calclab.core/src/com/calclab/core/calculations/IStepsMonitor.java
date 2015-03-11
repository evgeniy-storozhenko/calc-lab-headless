package com.calclab.core.calculations;

import java.util.List;

/**
 * Traces the intermediate steps
 */
public interface IStepsMonitor {

	void addStep(IStep step);

	List<IStep> getSteps();

}
