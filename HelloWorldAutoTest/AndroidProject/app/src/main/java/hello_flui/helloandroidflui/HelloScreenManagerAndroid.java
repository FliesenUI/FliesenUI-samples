package hello_flui.helloandroidflui;

import android.content.Context;

import generated.fliesenui.core.FLUIScreenManagerAndroid;
import hello_flui.presenter.HelloWorldPresenter;

public class HelloScreenManagerAndroid {
	public static FLUIScreenManagerAndroid createScreenManager(Context context) {
		FLUIScreenManagerAndroid screenManager = FLUIScreenManagerAndroid.createSimpleInstance(context);
		screenManager.setHelloWorldPresenter(new HelloWorldPresenter());
		return screenManager;
	}

}
