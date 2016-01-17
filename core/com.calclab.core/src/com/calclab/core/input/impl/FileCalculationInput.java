package com.calclab.core.input.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;
import com.calclab.core.nls.Messages;

public class FileCalculationInput implements CalculationInput {

	private final File file;
	private String expressions = null;

	public FileCalculationInput(File file) {
		this.file = file;
	}

	@Override
	public String getExpressions() throws InputException {
		if (expressions == null) {
			try {
				expressions = getExpressionsFromFile();
			} catch (IOException e) {
				throw new InputException(Messages.FileCalculationInput_0, e);
			}
		}
		return expressions;
	}

	private String getExpressionsFromFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}

	@Override
	public boolean isExpectedMoreData() {
		return false;
	}

	@Override
	public void setExpressions(String expressions) {
		this.expressions = expressions;
	}

	@Override
	public boolean isStdIn() {
		return false;
	}

}
