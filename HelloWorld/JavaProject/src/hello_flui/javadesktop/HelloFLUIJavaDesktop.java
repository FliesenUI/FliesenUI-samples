package hello_flui.javadesktop;

import generated.fliesenui.core.FLUIApplication;
import hello_flui.base.HelloScreenManager;
import javafx.stage.Stage;

public class HelloFLUIJavaDesktop extends FLUIApplication{

	public HelloFLUIJavaDesktop() {
		super("Hello World", 1000, 500, HelloScreenManager.createScreenManager());
	}

	@Override
	public void onStart(Stage stage) {
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
