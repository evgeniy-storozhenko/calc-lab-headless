package com.calclab.core.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.calclab.core.input.exceptions.FunctionNotFoundException;
import com.calclab.core.nls.Messages;
import com.calclab.core.operands.Operand;

public class FunctionRegistry {

	private static final String extensionType = "com.calclab.function"; //$NON-NLS-1$
	private static FunctionRegistry instance = null;
	private Map<String, FunctionClient> info = null;

	private final Map<String, IConfigurationElement> extensions = new HashMap<String, IConfigurationElement>();

	private FunctionRegistry() {
		initialize();
	}

	private synchronized void initialize() {
		IConfigurationElement[] configurations = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(extensionType);
		for (IConfigurationElement cfg : configurations) {
			extensions.put(cfg.getAttribute("name"), cfg); //$NON-NLS-1$
		}
	}

	public synchronized static FunctionRegistry getInstance() {
		if (instance == null) {
			instance = new FunctionRegistry();
		}
		return instance;
	}

	public Map<String, IConfigurationElement> getExtensions() {
		return extensions;
	}

	public boolean contains(String name) {
		return extensions.containsKey(name);
	}

	public Function createFunction(String name, List<Operand> arguments)
			throws CoreException, FunctionNotFoundException {
		if (!contains(name)) {
			String msg = Messages.FunctionRegistry_2 + name + Messages.FunctionRegistry_3;
			throw new FunctionNotFoundException(msg, new Throwable());
		}
		Function provider = (Function) extensions.get(name).createExecutableExtension("class"); //$NON-NLS-1$
		provider.setArguments(arguments);
		return provider;
	}

	public Map<String, FunctionClient> getInfo() {
		if (info != null) {
			return info;
		}
		info = new HashMap<String, FunctionClient>();
		for (Map.Entry<String, IConfigurationElement> entry : extensions.entrySet()) {
			String name = entry.getKey();
			if (name.equals("help")) {
				continue;
			}
			IConfigurationElement conf = entry.getValue();
			FunctionClient client = getInfoFromConf(name, conf);
			info.put(name, client);
		}
		return info;
	}

	private FunctionClient getInfoFromConf(String name, IConfigurationElement conf) {
		FunctionClient client = new FunctionClient(name);
		for (IConfigurationElement child : conf.getChildren()) {
			FunctionInfo funcInfo = new FunctionInfo();
			funcInfo.setSyntax(child.getAttribute("syntax"));
			funcInfo.setDescription(child.getAttribute("description"));
			funcInfo.setExample(child.getAttribute("example"));
			funcInfo.setExampleResult(child.getAttribute("example_result"));

			client.getInfo().add(funcInfo);
		}
		return client;
	}

	public FunctionClient getInfoAbout(String name) {
		if (!contains(name)) {
			return null;
		}
		IConfigurationElement element = extensions.get(name);
		return getInfoFromConf(name, element);
	}
}
