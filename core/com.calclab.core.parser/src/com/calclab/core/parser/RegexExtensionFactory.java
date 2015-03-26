package com.calclab.core.parser;

import java.util.regex.Pattern;

import org.eclipse.core.runtime.IConfigurationElement;

import com.calclab.core.parser.extensions.RegexExtensionImpl;

public class RegexExtensionFactory {

	public RegexExtension createRegexExtensions(int parsePriority, Pattern lexicalDefinition,
			String type, IConfigurationElement cfg) {
		return new RegexExtensionImpl(parsePriority, lexicalDefinition, type, cfg);
	}
}
