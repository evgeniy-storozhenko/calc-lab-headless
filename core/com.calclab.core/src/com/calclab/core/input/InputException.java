package com.calclab.core.input;

/**
 * It wasn't succeeded to receive expressions for computation.
 */
public class InputException extends Exception {

	private static final long serialVersionUID = 5200741593470654802L;

	public InputException(String string, Throwable throwable) {
		super(string, throwable);
	}

}
