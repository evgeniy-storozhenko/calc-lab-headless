package com.calclab.core.parser.internal;

import java.util.regex.Pattern;

import org.eclipse.core.runtime.IConfigurationElement;

import com.calclab.core.parser.RegexExtension;

public class RegexExtensionImpl implements RegexExtension {

	private int priority;
	private Pattern regex;
	private String extensionType;
	private IConfigurationElement config;

	public RegexExtensionImpl(int priority, Pattern regex, String extensionType,
			IConfigurationElement config) {
		this.priority = priority;
		this.regex = regex;
		this.extensionType = extensionType;
		this.config = config;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public Pattern getRegex() {
		return regex;
	}

	@Override
	public String getExtensionType() {
		return extensionType;
	}

	@Override
	public IConfigurationElement getConfig() {
		return config;
	}

}
