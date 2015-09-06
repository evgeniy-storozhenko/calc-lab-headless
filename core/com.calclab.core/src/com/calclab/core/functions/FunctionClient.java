package com.calclab.core.functions;

import java.util.ArrayList;
import java.util.List;

import com.calclab.core.nls.Messages;

public class FunctionClient {

	private String name;
	private List<FunctionInfo> info = new ArrayList<>();

	public FunctionClient(String name) {
		this.name = name;
	}

	public FunctionClient(String name, List<FunctionInfo> info) {
		this.name = name;
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public List<FunctionInfo> getInfo() {
		return info;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInfo(List<FunctionInfo> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(Messages.Function);
		builder.append(": ");
		builder.append(name);
		for (FunctionInfo functionInfo : info) {
			builder.append(functionInfo.toString());
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

}
