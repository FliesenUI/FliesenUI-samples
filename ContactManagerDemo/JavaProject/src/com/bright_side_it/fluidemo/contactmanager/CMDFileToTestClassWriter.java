package com.bright_side_it.fluidemo.contactmanager;

import generated.fliesenui.core.FLUIActionRecording;
import generated.fliesenui.core.FLUITestClassWriter;
import generated.fliesenui.core.FLUIUtil;

import java.io.File;

import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsLargePresenter;

public class CMDFileToTestClassWriter {
	
	public static void main(String[] args) {
		try {
			writeTestFile("AutoTestGeneral", "actions_2017_02_13__08_21_50.json");
			writeTestFile("AutoTestLanguageSwitch", "actions_2017_02_15__08_11_04.json");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Finished successfully");
	}

	private static void writeTestFile(String outputClassName, String actionsJSON) throws Exception {
		File redordingFile = new File("ActionRecording", actionsJSON);
		File outputFile = new File("gen_tests");
		outputFile = new File(outputFile, "com");
		outputFile = new File(outputFile, "bright_side_it");
		outputFile = new File(outputFile, "fluidemo");
		outputFile = new File(outputFile, "contactmanager");
		outputFile = new File(outputFile, "test");
		outputFile.mkdirs();
		outputFile = new File(outputFile, outputClassName + ".java");
		FLUIActionRecording recording = FLUIUtil.loadActionRecording(redordingFile);
		String string = new FLUITestClassWriter().getTestClassString(outputClassName, "com.bright_side_it.fluidemo.contactmanager.test", recording);
		
		string = string.replace("/* TODO: Add presenter DetailsLarge*/", "new DetailsLargePresenter(true)");
		string = string.replace("/* TODO: Add presenter DetailsSmall*/", "new DetailsSmallPresenter(true)");
		string = string.replace("/* TODO: Add presenter OverviewLarge*/", "new OverviewLargePresenter(false)");
		string = string.replace("/* TODO: Add presenter OverviewSmall*/", "new OverviewSmallPresenter()");

		string = string.replace("/* TODO: Add imports for presenters */", "import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsLargePresenter;\nimport com.bright_side_it.fluidemo.contactmanager.presenter.DetailsSmallPresenter;\nimport com.bright_side_it.fluidemo.contactmanager.presenter.OverviewLargePresenter;\nimport com.bright_side_it.fluidemo.contactmanager.presenter.OverviewSmallPresenter;\n");
		
		
		FLUIUtil.writeFile(outputFile, string);
	}

	private static String insertPresenter(String string) {
		String result = string;
		int pos = result.indexOf("public void setupPresenters(){");
		int endPos = result.indexOf("}", pos + 1);
		String newString = "public void setupPresenters(){\n        screenManager.setAutoTestScreenPresenter(new AutoTestScreenPresenter(screenManager));\n    ";
		result = result.substring(0, pos) + newString + result.substring(endPos);
		
		pos = result.indexOf("import static org.junit.Assert.*;");
		endPos = result.indexOf("\n", pos + 1);
		newString = "import static org.junit.Assert.*;\nimport actualapp.presenter.AutoTestScreenPresenter;";
		result = result.substring(0, pos) + newString + result.substring(endPos);
		
		
		return result;
	}

}
