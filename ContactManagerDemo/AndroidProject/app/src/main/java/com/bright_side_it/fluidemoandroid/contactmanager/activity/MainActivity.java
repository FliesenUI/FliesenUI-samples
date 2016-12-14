package com.bright_side_it.fluidemoandroid.contactmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bright_side_it.fluidemoandroid.contactmanager.R;
import com.bright_side_it.fluidemoandroid.contactmanager.service.WebServerService;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((Button)findViewById(R.id.main_appButton)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onAppButtonClicked();
			}
		});
		((Button)findViewById(R.id.main_webServerActivityButton)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onWebServerActivityButtonClicked();
			}
		});
		((Button)findViewById(R.id.main_webServerServiceButton)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onStartWebServerServiceButtonClicked();
			}
		});
		((Button)findViewById(R.id.main_stopWebServerServiceButton)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onStopWebServerServiceButtonClicked();
			}
		});
	}

	private void onStopWebServerServiceButtonClicked() {
		Intent intent = new Intent(this, WebServerService.class);
		intent.putExtra(WebServerService.PARAM_ACTION, WebServerService.ACTION_STOP);
		startService(intent);
	}

	private void onStartWebServerServiceButtonClicked() {
		Intent intent = new Intent(this, WebServerService.class);
		intent.putExtra(WebServerService.PARAM_ACTION, WebServerService.ACTION_START);
		startService(intent);
	}

	private void onWebServerActivityButtonClicked() {
		startActivity(new Intent(this, WebServerActivity.class));
	}

	private void onAppButtonClicked() {
		startActivity(new Intent(this, AndroidAppActivity.class));
	}

}
