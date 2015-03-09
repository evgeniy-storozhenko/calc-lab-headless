package com.calclab.headless.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.calclab.core.input.ICalculationInput;
import com.calclab.core.input.InputException;

public class FileCalculationInput implements ICalculationInput {

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
				throw new InputException("Can't get expressions from file", e);
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

}
