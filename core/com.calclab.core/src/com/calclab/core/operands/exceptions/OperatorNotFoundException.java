package com.calclab.core.operands.exceptions;

/**
 * Arises when action isn't provided for this operand.
 */
public class OperatorNotFoundException extends Exception {

	private static final long serialVersionUID = 7580832909505577503L;

	public OperatorNotFoundException(String string, Throwable throwable) {
		super(string, throwable);
	}

	public OperatorNotFoundException(String string) {
		super(string);
	}

}
