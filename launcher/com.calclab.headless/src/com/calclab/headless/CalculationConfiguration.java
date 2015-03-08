package com.calclab.headless;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;

import com.calclab.headless.internal.HeadlessCalculationPlugin;

public class CalculationConfiguration {

	private String inputData = null;
	private File fileInput = null;
	private File rowOutput = null;
	private File htmlOutput = null;

	enum CommandArg {
		Input("Input expression for calculation", "input", "i"),
		FileInput("Input file for calculation", "f"),
		Row("Output result of calculation as row", "row"),
		HTML("Output result of calculation as html", "html"),
		Help("Help", "help", "h", "?"),
		Version("Current version", "version", "v");

		CommandArg(String message, String... val) {
			this.val = val;
			this.message = message;
		}

		private String message;
		private String[] val;

		public String[] getCommands() {
			return val;
		}

		public String getMessage() {
			return message;
		}
	};

	public boolean processArgs(String[] args) {
		Iterator<String> i = Arrays.asList(args).iterator();
		while (i.hasNext()) {
			final String arg = i.next();
			CommandArg cmdArg = findArg(arg);
			if (cmdArg == null) {
				System.out.println("Invalid argument:" + arg);
				continue;
			}
			switch (cmdArg) {
			case Input:
				inputData = i.next();
				break;
			case FileInput:
				getFileInputArg(i);
				break;
			case Row:
				rowOutput = new File(i.next());
				break;
			case HTML:
				htmlOutput = new File(i.next());
				break;
			case Help:
				showHelp();
				break;
			case Version:
				showVersion();
				break;
			default:
				return false;
			}
		}
		return true;
	}

	private void getFileInputArg(Iterator<String> i) {
		final String fileInputPath = i.next();
		final File fileInput = new File(fileInputPath);
		if (fileInput.exists() && fileInput.isDirectory()) {
			this.fileInput = fileInput;
		} else {
			System.out.println(String.format(
					"Invalid input path in '-f' arg: %s", fileInputPath));
		}
	}

	private CommandArg findArg(String arg) {
		CommandArg[] values = CommandArg.values();
		for (CommandArg commandArg : values) {
			String[] val = commandArg.getCommands();
			for (String s : val) {
				if (("-" + s).equals(arg) || ("--" + s).equals(arg)) {
					return commandArg;
				}
			}
		}
		return null;
	}

	public void showHelp() {
		System.out.println("Calculation Laboratory Headless command line arguments:");
		for (CommandArg v : CommandArg.values()) {
			System.out.print("\t");
			String[] commands = v.getCommands();
			for (int k = 0; k < commands.length; ++k) {
				System.out.print("-" + commands[k]);
				if (k != commands.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print(":\t" + v.getMessage());
			System.out.println();
		}
	}

	private void showVersion() {
		System.out.println(String.format("Calculation Laboratory Headless version: %s",
				getRunnerVersion()));
	}

	public static String getRunnerVersion() {
		String version = Platform.getBundle(HeadlessCalculationPlugin.PLUGIN_ID).getHeaders()
				.get("Bundle-Version");
		if (version == null)
			return "[unknown]";
		int dotPos = version.lastIndexOf('.');
		if (dotPos < 0)
			return version;
		return version.substring(0, dotPos);
	}

	public File getRowOutput() {
		return rowOutput;
	}

	public String getInputData() {
		return inputData;
	}

	public File getFileInput() {
		return fileInput;
	}

	public File getHtmlFileOutput() {
		return htmlOutput;
	}

}
