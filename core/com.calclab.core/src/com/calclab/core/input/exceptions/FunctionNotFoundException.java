package com.calclab.core.input.exceptions;

/**
 * It wasn't succeeded to receive expressions for computation.
 */
public class FunctionNotFoundException extends Exception {

	private static final long serialVersionUID = 5200741593470654802L;

	public FunctionNotFoundException(String string, Throwable throwable) {
		super(string, throwable);
	}

}
