package com.bright_side_it.fluidemo.contactmanager;

import generated.fliesenui.core.FLUIApplication;
import generated.fliesenui.core.FLUIScreenManager;
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
		launch(args);
	}

}
