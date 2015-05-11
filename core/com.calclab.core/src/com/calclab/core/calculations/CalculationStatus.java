package com.calclab.core.calculations;

/**
 * Calculation Status of expression.
 */
public class CalculationStatus {

	private Stage stage = Stage.WAITING;

	private String message = null;

	public Stage getStage() {
		return stage;
	}

	public String getMessage() {
		return message;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Stages of life cycle of expression.
	 */
	public enum Stage {
		WAITING,
		INPROCESS,
		DONE,
		ERROR
	}

	public boolean isDone() {
		return getStage().equals(Stage.DONE);
	}

	public boolean isInProcess() {
		return getStage().equals(Stage.INPROCESS);
	}

	public boolean isWaiting() {
		return getStage().equals(Stage.WAITING);
	}

	public boolean isError() {
		return getStage().equals(Stage.ERROR);
	}

}
