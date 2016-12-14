package com.bright_side_it.fluidemo.contactmanager;

import com.bright_side_it.fluidemo.contactmanager.dao.DummyDataDAO;
import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsLargePresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsSmallPresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.OverviewLargePresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.OverviewSmallPresenter;

import generated.fliesenui.core.FLUIFileStream;
import generated.fliesenui.core.FLUIImageStream;
import generated.fliesenui.core.FLUIScreenManager;
import generated.fliesenui.core.FLUIScreenManagerListener;
import generated.fliesenui.core.SimpleManagerListener;

public class ContactManagerBase {
	private boolean uploadFilesEnabeld = false;
	
	public ContactManagerBase(boolean uploadFilesEnabeld){
		this.uploadFilesEnabeld = uploadFilesEnabeld;
	}
	
	public FLUIScreenManager createScreenManager(){
		FLUIScreenManager screenManager = FLUIScreenManager.createInstance(createManagerListener());
		screenManager.setOverviewLargePresenter(new OverviewLargePresenter(false));
		screenManager.setOverviewSmallPresenter(new OverviewSmallPresenter());
		screenManager.setDetailsLargePresenter(new DetailsLargePresenter(uploadFilesEnabeld));
		screenManager.setDetailsSmallPresenter(new DetailsSmallPresenter(uploadFilesEnabeld));
		return screenManager;
	}
	
	private static FLUIScreenManagerListener createManagerListener() {
		return new SimpleManagerListener(){
			@Override
			public FLUIImageStream getCustomImageStream(String imageStreamID) {
				return new DummyDataDAO().getImageStream(imageStreamID);
			}
			
			@Override
			public FLUIFileStream getFileStream(String fileStreamID) {
				return new DummyDataDAO().getFileStream(fileStreamID);
			}
		};
	}

}
