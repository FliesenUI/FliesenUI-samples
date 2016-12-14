package hello_flui.base;

import generated.fliesenui.core.FLUIScreenManager;
import hello_flui.presenter.HelloWorldPresenter;

public class HelloScreenManager {
	public static FLUIScreenManager createScreenManager() {
		FLUIScreenManager screenManager = FLUIScreenManager.createSimpleInstance();
		screenManager.setHelloWorldPresenter(new HelloWorldPresenter());
		return screenManager;
	}

}
