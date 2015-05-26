package com.calclab.headless;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;

import com.calclab.headless.internal.HeadlessCalculationPlugin;

public class CalculationConfiguration {

	private String inputData = null;
	private File inputFile = null;
	private File rowFileOutput = null;
	private File htmlFileOutput = null;
	private int scale = 60;

	enum CommandArg {
		InputData("Input expression for calculation", "input", "i"),
		InputFile("Input file for calculation", "file", "f"),
		RowFile("Output result of calculation as row", "row", "r"),
		HTMLFile("Output result of calculation as html", "html", "H"),
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
			case InputData:
				inputData = i.next();
				break;
			case InputFile:
				getFileInputArg(i);
				break;
			case RowFile:
				rowFileOutput = new File(i.next());
				break;
			case HTMLFile:
				htmlFileOutput = new File(i.next());
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
		if (fileInput.exists() && fileInput.isFile() && fileInput.canRead()) {
			inputFile = fileInput;
		} else {
			System.out.println(String.format(
					"Invalid input path or access denied in '-f' arg: %s", fileInputPath));
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

	public String getInputData() {
		return inputData;
	}

	public File getInputFile() {
		return inputFile;
	}

	public File getRowFileOutput() {
		return rowFileOutput;
	}

	public File getHtmlFileOutput() {
		return htmlFileOutput;
	}

	public int getScale() {
		return scale;
	}

}
