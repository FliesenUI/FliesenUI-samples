package com.bright_side_it.fluidemo.contactmanager.presenter;

import java.io.InputStream;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.screen.DetailsLargeListener;
import generated.fliesenui.screen.DetailsLargeReply;

public class DetailsLargePresenter implements DetailsLargeListener {
	private DetailsCommonPresenter commonPresenter;

	public DetailsLargePresenter(boolean uploadFileEnabled) {
		commonPresenter = new DetailsCommonPresenter(uploadFileEnabled);
	}

	@Override
	public void onLoaded(DetailsLargeReply reply, FLUIClientPropertiesDTO clientProperties, ContactDTO contact) {
		commonPresenter.onLoaded(reply, clientProperties, contact);
	}

	@Override
	public void onInputDialogResult(DetailsLargeReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(DetailsLargeReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onOpenWebSiteButtonClicked(DetailsLargeReply reply, ContactDTO contact) {
		commonPresenter.onOpenWebSiteButtonClicked(reply, contact);
	}

	@Override
	public void onSaveButtonClicked(DetailsLargeReply reply, ContactDTO contact, String typeSelectBoxSelectedID) {
		commonPresenter.onSaveButtonClicked(reply, contact, typeSelectBoxSelectedID);
		reply.openScreenOverviewLarge();		
	}

	@Override
	public void onCancelButtonClicked(DetailsLargeReply reply) {
		reply.openScreenOverviewLarge();		
	}

	@Override
	public void onTypeSelectBoxChanged(DetailsLargeReply reply, String itemID) {
	}

	@Override
	public void onProfileImageFileUploadFileUpload(String uploadedFileName, InputStream uploadedFileInputStream, ContactDTO contact) {
		commonPresenter.onProfileImageFileUploadFileUpload(uploadedFileName, uploadedFileInputStream, contact);
	}
	
	@Override
	public void onProfileImageFileUploadFileUploadFinished(DetailsLargeReply reply, ContactDTO contact) {
		commonPresenter.onProfileImageFileUploadFileUploadFinished(reply, contact);
	}

}
