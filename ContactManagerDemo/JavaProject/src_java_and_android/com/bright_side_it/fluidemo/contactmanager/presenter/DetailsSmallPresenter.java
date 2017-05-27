package com.bright_side_it.fluidemo.contactmanager.presenter;

import java.io.InputStream;
import java.util.List;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.screen.DetailsSmallListener;
import generated.fliesenui.screen.DetailsSmallReply;

public class DetailsSmallPresenter implements DetailsSmallListener {
	private DetailsCommonPresenter commonPresenter;

	public DetailsSmallPresenter(boolean uploadFileEnabled) {
		commonPresenter = new DetailsCommonPresenter(uploadFileEnabled);
	}

	@Override
	public void onLoaded(DetailsSmallReply reply, FLUIClientPropertiesDTO clientProperties, ContactDTO contact) {
		commonPresenter.onLoaded(reply, clientProperties, contact);
	}

	@Override
	public void onInputDialogResult(DetailsSmallReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(DetailsSmallReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onOpenWebSiteButtonClicked(DetailsSmallReply reply, ContactDTO contact) {
		commonPresenter.onOpenWebSiteButtonClicked(reply, contact);
	}

	@Override
	public void onSaveButtonClicked(DetailsSmallReply reply, ContactDTO contact, String typeSelectBoxSelectedID) {
		commonPresenter.onSaveButtonClicked(reply, contact, typeSelectBoxSelectedID);
		reply.openScreenOverviewSmall();		
	}

	@Override
	public void onCancelButtonClicked(DetailsSmallReply reply) {
		reply.openScreenOverviewSmall();		
	}

	@Override
	public void onTypeSelectBoxChanged(DetailsSmallReply reply, String itemID) {
	}

	@Override
	public void onProfileImageFileUploadFileUpload(String uploadedFileName, InputStream uploadedFileInputStream, ContactDTO contact) {
		commonPresenter.onProfileImageFileUploadFileUpload(uploadedFileName, uploadedFileInputStream, contact);
	}

	@Override
	public void onProfileImageFileUploadFileUploadFinished(DetailsSmallReply reply, ContactDTO contact) {
		commonPresenter.onProfileImageFileUploadFileUploadFinished(reply, contact);
	}

	@Override
	public void onBackPressed(DetailsSmallReply reply) {
		reply.openScreenOverviewSmall();
	}

	@Override
	public void onListChooserResult(DetailsSmallReply reply, String referenceID, List<String> selectedIDs) {
		commonPresenter.onListChooserResult(reply, referenceID, selectedIDs);
	}

	@Override
	public void onSetPreferredMusicButtonClicked(DetailsSmallReply reply, ContactDTO contact) {
		commonPresenter.onSetPreferredMusicButtonClicked(reply, contact);
	}

}
