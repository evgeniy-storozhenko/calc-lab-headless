package com.calclab.core.functions;

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
		builder.append("Syntax: ");
		builder.append(syntax);
		builder.append(System.lineSeparator());
		builder.append("Description: ");
		builder.append(description);
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append("Example: ");
		builder.append(System.lineSeparator());
		builder.append("\t");
		builder.append(example);
		builder.append(System.lineSeparator());
		builder.append("Result: ");
		builder.append(System.lineSeparator());
		builder.append("\t");
		builder.append(exampleResult);
		return builder.toString();
	}
}
