package com.bright_side_it.fluidemo.contactmanager;

import generated.fliesenui.core.FLUIActionRecording;
import generated.fliesenui.core.FLUIApplication;
import generated.fliesenui.core.FLUIScreenManager;
import generated.fliesenui.core.FLUITestClassWriter;
import generated.fliesenui.core.FLUIUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.stage.Stage;

public class ContactManagerDesktopApplication extends FLUIApplication{
	private static FLUIScreenManager screenManager = new ContactManagerBase(true).createScreenManager();
	
	public ContactManagerDesktopApplication() {
		super("Fliesen UI - Contact Manager Demo", 1000, 700, screenManager);
	}

	@Override
	public void onStart(Stage stage) {
	}

	
	public static void main(String[] args) {
		screenManager.startRecording();
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		try {
			File dir = new File("ActionRecording");
			dir.mkdirs();
			if (!dir.exists()){
				throw new Exception("Could not create dir '" + dir.getAbsolutePath() + "'");
			}
			writeRecordedActions(screenManager.getActionRecording(), dir);
			writeTestClass(screenManager.getActionRecording(), dir);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		super.stop();
	}

	private static void writeRecordedActions(FLUIActionRecording recording, File dir) throws Exception {
		String filename = "actions_" + new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date()) + ".json";
		FLUIUtil.saveActionRecording(recording, new File(dir, filename));
	}

	private static void writeTestClass(FLUIActionRecording recording, File dir) throws Exception {
		String className = "RecordedTest" + new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date()); 
		FLUITestClassWriter testClassWriter = new FLUITestClassWriter();
		testClassWriter.writeTestClass(new File(dir, className + ".java"), className, "com.bright_side_it.fluidemo.contactmanager.test", recording);
	}
}
