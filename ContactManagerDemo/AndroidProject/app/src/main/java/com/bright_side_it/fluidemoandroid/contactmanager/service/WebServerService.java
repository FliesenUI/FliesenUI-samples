package com.bright_side_it.fluidemoandroid.contactmanager.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.bright_side_it.fluidemoandroid.contactmanager.AndroidContactManagerBase;
import com.bright_side_it.fluidemoandroid.contactmanager.ContactManagerAndroidJettyServerUploadCapable;
import com.bright_side_it.fluidemoandroid.contactmanager.R;
import com.bright_side_it.fluidemoandroid.contactmanager.activity.MainActivity;

/**
 * Created by me on 15.11.2016.
 */
public class WebServerService extends Service {
	public static final String PARAM_ACTION = "action";
	public static final String ACTION_START = "start";
	public static final String ACTION_STOP = "stop";
	private ContactManagerAndroidJettyServerUploadCapable jettyServer;
	private int ONGOING_NOTIFICATION_ID = 1;
	private static final int PORT = 8080;

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		String action = intent.getStringExtra(PARAM_ACTION);
		if (ACTION_START.equals(action)){
			startWebServer();
			return START_STICKY;
		} else if (ACTION_STOP.equals(action)){
			stopWebServer();
		} else {
			Log.w("FLUI Webserver", "Unknown action: " + action);
		}
		return START_NOT_STICKY;
	}

	private void startWebServer() {
		if (jettyServer != null){
			return;
		}
		jettyServer = new ContactManagerAndroidJettyServerUploadCapable(this, PORT, new AndroidContactManagerBase().createScreenManager(this, false, true));
		AndroidContactManagerBase.initDummyDataDAO(this);

		NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
						.setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("FLUI Server")
				.setContentText(jettyServer.getIPAddressInfoString(PORT));

		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setContentIntent(pendingIntent);
		startForeground(ONGOING_NOTIFICATION_ID, notification.build());

		new Thread(){
			@Override
			public void run() {
				try{
					jettyServer.startServer();
					toast("Web Server started");
				} catch (Throwable t){
					stopWebServer();
					toast("Error: " + t);
				}
			}
		}.start();

	}

	private void stopWebServer() {
		if (jettyServer != null){
			try {
				jettyServer.stopServer();
			} catch (Exception e) {
				toast("stop server failed");
			} finally{
				jettyServer = null;
//				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//				mNotificationManager.cancel(ONGOING_NOTIFICATION_ID);
				stopForeground(true);
				stopSelf();
			}
		}
	}

	private void toast(String message) {
		Toast.makeText(this, "FLUI Web Server: " + message, Toast.LENGTH_SHORT).show();
	}
}
