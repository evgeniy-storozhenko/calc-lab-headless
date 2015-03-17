package com.calclab.core.parser.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.calclab.core.parser.RegexExtension;
import com.calclab.core.parser.RegexExtensionFactory;

public class CalclabExtensionManager {

	public static final String[] extensionTypes = {
			"com.calclab.operand",
			"com.calclab.operation"
	};

	private static CalclabExtensionManager instance = null;

	private RegexExtensionFactory regexExtensionsFactory = new RegexExtensionFactory();
	private List<RegexExtension> regexExtensions = new ArrayList<RegexExtension>();

	private CalclabExtensionManager() {
		initialize();
	}

	private synchronized void initialize() {
		for (String type : CalclabExtensionManager.extensionTypes) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(type);
			findRegexExtensions(elements, type);
		}
		sortRegexExtensions();
	}

	private void findRegexExtensions(IConfigurationElement[] elements, String type) {
		for (IConfigurationElement cfg : elements) {
			Pattern lexicalDefinition = Pattern.compile(cfg.getAttribute("lexicalDefinition"));
			int parsePriority = Integer.parseInt(cfg.getAttribute("parsePriority"));
			RegexExtension extension = regexExtensionsFactory.createRegexExtensions(parsePriority,
					lexicalDefinition, type, cfg);
			regexExtensions.add(extension);
		}
	}

	private void sortRegexExtensions() {
		Collections.sort(regexExtensions, new Comparator<RegexExtension>() {

			@Override
			public int compare(RegexExtension e1, RegexExtension e2) {
				return (e1.getPriority() - e2.getPriority());
			}

		});
	}

	public synchronized static CalclabExtensionManager getInstance() {
		if (instance == null) {
			instance = new CalclabExtensionManager();
		}
		return instance;
	}

}
