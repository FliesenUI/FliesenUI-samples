package com.bright_side_it.fluidemoandroid.contactmanager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bright_side_it.fluidemo.contactmanager.dao.DummyDataDAO;
import com.bright_side_it.fluidemo.contactmanager.dao.ProjectImageReader;
import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsLargePresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsSmallPresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.OverviewLargePresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.OverviewSmallPresenter;

import java.io.InputStream;

import generated.fliesenui.core.FLUIFileStream;
import generated.fliesenui.core.FLUIImageStream;
import generated.fliesenui.core.FLUIRequest;
import generated.fliesenui.core.FLUIScreenManagerAndroid;
import generated.fliesenui.core.FLUIScreenManagerListener;
import generated.fliesenui.core.FLUIUtil;

/**
 * Created by me on 07.11.2016.
 */

public class AndroidContactManagerBase {

	public FLUIScreenManagerAndroid createScreenManager(Context context, boolean alwaysUseSmallScreen, boolean uploadFileEnabled){
		FLUIScreenManagerAndroid screenManager = FLUIScreenManagerAndroid.createInstance(context, createListener(context));
		screenManager.setDetailsLargePresenter(new DetailsLargePresenter(true));
		screenManager.setDetailsSmallPresenter(new DetailsSmallPresenter(uploadFileEnabled));
		screenManager.setOverviewLargePresenter(new OverviewLargePresenter(alwaysUseSmallScreen));
		screenManager.setOverviewSmallPresenter(new OverviewSmallPresenter());
		return screenManager;
	}

	public static void initDummyDataDAO(final Context context){
		DummyDataDAO.setProjectImageReader(new ProjectImageReader() {
			@Override
			public InputStream getImageInputStream(String imageStreamID) throws Exception {
				try{
					return context.getAssets().open(imageStreamID);
				} catch (Exception e){
					new Exception("Could not read image asset with name '" + imageStreamID + "'").printStackTrace();
					throw e;
				}
			}
		});
	}

	private FLUIScreenManagerListener createListener(final Context context) {
		return new FLUIScreenManagerListener() {
			@Override
			public void onError(Throwable error) {
				error.printStackTrace();
				toast("Error: " + error);
			}

			@Override
			public void onWarning(Throwable warning) {
				warning.printStackTrace();
				toast("Warning: " + warning);
			}

			@Override
			public void onLogDebug(String message) {
				Log.d("ContactManager", message);
			}

			@Override
			public void onWebViewConsoleLog(String message) {
				Log.d("ContactManager-WebView", message);
			}

			@Override
			public void onRequest(FLUIRequest request) {
				Log.d("ContactManager", "request: " + FLUIUtil.toActionLogString(request));
			}

			@Override
			public FLUIImageStream getCustomImageStream(String imageStreamID) {
				return new DummyDataDAO().getImageStream(imageStreamID);
			}

			@Override
			public FLUIFileStream getFileStream(String fileStreamID) {
				return new DummyDataDAO().getFileStream(fileStreamID);
			}

			private void toast(String message) {
				Toast.makeText(context, "Contact Manager: " + message, Toast.LENGTH_SHORT).show();
			}
		};
	}


}
