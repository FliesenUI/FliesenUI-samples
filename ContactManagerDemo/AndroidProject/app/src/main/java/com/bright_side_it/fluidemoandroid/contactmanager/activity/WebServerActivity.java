package com.bright_side_it.fluidemoandroid.contactmanager.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bright_side_it.fluidemoandroid.contactmanager.AndroidContactManagerBase;
import com.bright_side_it.fluidemoandroid.contactmanager.ContactManagerAndroidJettyServer;
import com.bright_side_it.fluidemoandroid.contactmanager.R;

public class WebServerActivity extends AppCompatActivity {

	private ContactManagerAndroidJettyServer jettyServer;
	private static final int PORT = 8080;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		jettyServer = new ContactManagerAndroidJettyServer(this, PORT, new AndroidContactManagerBase().createScreenManager(this, false, true));
		AndroidContactManagerBase.initDummyDataDAO(this);
		setContentView(R.layout.activity_web_server);

		Button testButton = (Button)findViewById(R.id.webserver_reloadButton);
		testButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onReloadButtonClicked();
			}
		});

		webView = (WebView)findViewById(R.id.webserver_webView);


		webView.getSettings().setJavaScriptEnabled(true);

		final Activity activity = this;
		webView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				// Activities and WebViews measure progress with different scales.
				// The progress meter will automatically disappear when we reach 100%
				activity.setProgress(progress * 1000);
			}
		});
		webView.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				Toast.makeText(activity, "Error: " + description, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
				String info = "?";
				if (error != null){
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
						info = error.getErrorCode() + ": " + error.getDescription();
					}
				}
				Toast.makeText(activity, "Error: " + info, Toast.LENGTH_SHORT).show();
				super.onReceivedError(view, request, error);
			}
		});

		TextView infoTextView = (TextView)findViewById(R.id.webserver_infoTextView);
		infoTextView.setText(jettyServer.getIPAddressInfoString(PORT));
	}

	@Override
	protected void onStart() {
		super.onStart();
		try {
			jettyServer.startServer();
			toast("server started");
		} catch (Exception e) {
			toast("start server failed");
			e.printStackTrace();
		}
		webView.loadUrl("http://localhost:8080");
	}

	@Override
	protected void onPause() {
		super.onPause();
		try {
			jettyServer.stopServer();
		} catch (Exception e) {
			toast("stop server failed");
			e.printStackTrace();
		}
	}

	private void toast(String message){
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	private void onReloadButtonClicked() {
		toast("Reloading");
		webView.loadUrl("http://localhost:8080");
	}



}
