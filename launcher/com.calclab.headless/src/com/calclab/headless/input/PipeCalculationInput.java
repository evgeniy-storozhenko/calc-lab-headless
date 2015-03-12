package com.calclab.headless.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.InputException;

public class PipeCalculationInput implements CalculationInput {

	private String expressions = null;

	@Override
	public String getExpressions() throws InputException {
		if (expressions == null) {
			try {
				expressions = getExpressionsFromPipe();
			} catch (IOException e) {
				throw new InputException("Can't reading System.in", e);
			}
		}
		return expressions;
	}

	private String getExpressionsFromPipe() throws IOException {
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return sb.toString();
	}

}
