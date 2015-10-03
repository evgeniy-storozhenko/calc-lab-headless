package com.calclab.core.functions;

import com.calclab.core.nls.Messages;

public class FunctionInfo {
	
	private String syntax;
	private String description;
	private String example;
	private String exampleResult;
	
	public String getSyntax() {
		return syntax;
	}

	public String getDescription() {
		return description;
	}

	public String getExample() {
		return example;
	}

	public String getExampleResult() {
		return exampleResult;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public void setExampleResult(String exampleResult) {
		this.exampleResult = exampleResult;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(Messages.FunctionInfo_0);
		builder.append(syntax);
		builder.append(System.lineSeparator());
		builder.append(Messages.FunctionInfo_1);
		builder.append(description);
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(Messages.FunctionInfo_2);
		builder.append(System.lineSeparator());
		builder.append("\t"); //$NON-NLS-1$
		builder.append(example);
		builder.append(System.lineSeparator());
		builder.append(Messages.FunctionInfo_4);
		builder.append(System.lineSeparator());
		builder.append("\t"); //$NON-NLS-1$
		builder.append(exampleResult);
		return builder.toString();
	}
}
