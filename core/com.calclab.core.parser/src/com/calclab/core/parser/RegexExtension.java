package com.calclab.core.parser;

import java.util.regex.Pattern;

import org.eclipse.core.runtime.IConfigurationElement;

public interface RegexExtension {

	int getPriority();

	Pattern getRegex();

	String getExtensionType();

	IConfigurationElement getConfig();
}
