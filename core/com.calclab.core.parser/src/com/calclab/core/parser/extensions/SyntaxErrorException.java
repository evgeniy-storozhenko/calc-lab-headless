package com.calclab.core.parser.extensions;

public class SyntaxErrorException extends RuntimeException {

	private static final long serialVersionUID = -863326536758801943L;

	public final int line;
	public final int col;

	public SyntaxErrorException(int line, int col) {
		this(line, col, null);
	}

	public SyntaxErrorException(int line, int col, String msg) {
		super(SyntaxErrorException.prepareErrorMessage(msg));
		this.line = line;
		this.col = col;
	}

	@Override
	public String toString() {
		String result = "Syntax error on line " + line + ", col " + col;
		if (getMessage() != null && getMessage().length() > 0)
			result += ". " + getMessage();
		return result;
	}

	private static String prepareErrorMessage(String msg) {
		if (msg.contains("missing EXPRESSIONS_SEPARATOR")) {
			msg = "Every calculation expression must end with a semicolon ';'.";
		}
		return msg;
	}
}
