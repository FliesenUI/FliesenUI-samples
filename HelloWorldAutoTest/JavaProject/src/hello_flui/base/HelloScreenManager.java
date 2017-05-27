package hello_flui.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import generated.fliesenui.core.FLUIActionRecording;
import generated.fliesenui.core.FLUIScreenManager;
import generated.fliesenui.core.FLUITestClassWriter;
import generated.fliesenui.core.FLUIUtil;
import hello_flui.presenter.HelloWorldPresenter;

public class HelloScreenManager {
	private static FLUIScreenManager screenManager;
	
	public static FLUIScreenManager createScreenManager() {
		screenManager = FLUIScreenManager.createSimpleInstance();
		screenManager.setHelloWorldPresenter(new HelloWorldPresenter());
		screenManager.startRecording();
		return screenManager;
	}

	public static void onStop() {
		try {
			File dir = new File("ActionRecording");
			dir.mkdirs();
			if (!dir.exists()){
				throw new Exception("Could not create dir '" + dir.getAbsolutePath() + "'");
			}
			writeRecordedActions(screenManager.getActionRecording(), dir);
			writeTestClass(screenManager.getActionRecording(), dir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeRecordedActions(FLUIActionRecording recording, File dir) throws Exception {
		String filename = "actions_" + new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date()) + ".json";
		FLUIUtil.saveActionRecording(recording, new File(dir, filename));
	}

	private static void writeTestClass(FLUIActionRecording recording, File dir) throws Exception {
		String className = "RecordedTest" + new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date()); 
		FLUITestClassWriter testClassWriter = new FLUITestClassWriter();
		testClassWriter.writeTestClass(new File(dir, className + ".java"), className, "hello_flui.test", recording);
	}

}
