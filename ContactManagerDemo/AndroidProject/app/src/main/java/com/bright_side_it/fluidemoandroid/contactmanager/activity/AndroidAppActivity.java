package com.bright_side_it.fluidemoandroid.contactmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bright_side_it.fluidemoandroid.contactmanager.AndroidContactManagerBase;

import generated.fliesenui.core.FLUIAndroidWebView;

public class AndroidAppActivity extends AppCompatActivity {
	private FLUIAndroidWebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		webView = new FLUIAndroidWebView(this);
		webView.onCreate(this, new AndroidContactManagerBase().createScreenManager(this, true, true));
		AndroidContactManagerBase.initDummyDataDAO(this);
		setContentView(webView);
	}

	@Override
	public void onBackPressed() {
		webView.fireEventOnBackPressed();
	}
}
