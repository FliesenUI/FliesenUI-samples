package hello_flui.helloandroidflui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import generated.fliesenui.core.FLUIAndroidWebView;

public class HelloFLUIActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FLUIAndroidWebView webView = new FLUIAndroidWebView(this);
		webView.onCreate(this, new HelloScreenManagerAndroid().createScreenManager(this));
		setContentView(webView);
	}
}
