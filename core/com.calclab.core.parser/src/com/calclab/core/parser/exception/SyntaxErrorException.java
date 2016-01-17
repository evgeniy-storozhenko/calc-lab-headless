package com.calclab.core.parser.exception;

import com.calclab.core.parser.nls.Messages;

public class SyntaxErrorException extends RuntimeException {

	private static final long serialVersionUID = -863326536758801943L;

	public final int line;
	public final int col;

	public SyntaxErrorException(int line, int col) {
		this(line, col, ""); //$NON-NLS-1$
	}

	public SyntaxErrorException(int line, int col, String msg) {
		super(SyntaxErrorException.prepareErrorMessage(msg));
		this.line = line;
		this.col = col;
	}

	@Override
	public String toString() {
		String result = Messages.getString("SyntaxErrorException.1") + line + Messages.getString("SyntaxErrorException.2") + col; //$NON-NLS-1$ //$NON-NLS-2$
		if (getMessage() != null && getMessage().length() > 0)
			result += ". " + getMessage(); //$NON-NLS-1$
		return result;
	}

	private static String prepareErrorMessage(String msg) {
		if (msg.contains("missing EXPRESSIONS_SEPARATOR")) { //$NON-NLS-1$
			msg = Messages.getString("SyntaxErrorException.5"); //$NON-NLS-1$
		}
		return msg;
	}
}
