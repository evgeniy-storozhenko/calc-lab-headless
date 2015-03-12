package com.calclab.core.operands.exceptions;

/**
 * Appears when in computation there was something inadmissible, for example,
 * division into zero.
 */
public class InvalidActionException extends Exception {

	private static final long serialVersionUID = 3568712157312341281L;

	public InvalidActionException(String string, Throwable throwable) {
		super(string, throwable);
	}

}
