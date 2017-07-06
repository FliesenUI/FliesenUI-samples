package com.bright_side_it.fluidemo.contactmanager.presenter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.bright_side_it.fluidemo.contactmanager.dao.DummyDataDAO;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
import generated.fliesenui.core.FLUIReplyUtil;
import generated.fliesenui.core.IDLabelImageAssetList;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.screen.DetailsSharedReply;

public class DetailsCommonPresenter {
	private boolean uploadFileEnabled;

	public DetailsCommonPresenter(boolean uploadFileEnabled) {
		this.uploadFileEnabled = uploadFileEnabled;
	}

	public void onLoaded(DetailsSharedReply reply, FLUIClientPropertiesDTO clientProperties, ContactDTO contact) {
		if (uploadFileEnabled){
			reply.setProfileImageFileUploadVisible(true);
		}
		reply.setTypesDTO(DummyDataDAO.getTypes());
		if ((contact != null) && (contact.getTypeID() != null)){
			reply.setTypeSelectBoxSelectedID(contact.getTypeID());
		} else {
			reply.setTypeSelectBoxSelectedID(null);
		}
		reply.setPreferredMusicContentLabelText(createMusicInfoText(contact.getPreferredMusic()));
	}

	private String createMusicInfoText(List<String> preferredMusic) {
		if ((preferredMusic == null) || (preferredMusic.isEmpty())){
			return "none";
		}
		String result = "";
		for (String i: preferredMusic){
			if (result.length() > 0) {
				result += ", "; 
			}
			result += i;
		}
		return result;
	}

	public void onOpenWebSiteButtonClicked(DetailsSharedReply reply, ContactDTO contact) {
		if ((contact == null) || (contact.getWebSite() == null) || (contact.getWebSite().trim().isEmpty())){
			reply.setInfoToast("Please enter a web site first");
			return;
		}
		reply.openURL(contact.getWebSite(), true);
	}

	public void onSaveButtonClicked(DetailsSharedReply reply, ContactDTO contact, String typeSelectBoxSelectedID) {
		contact.setTypeID(typeSelectBoxSelectedID);
		new DummyDataDAO().saveContact(contact);
	}

	public void onProfileImageFileUploadFileUpload(String uploadedFileName, InputStream uploadedFileInputStream, ContactDTO contact) {
		ByteArrayOutputStream imageData = new ByteArrayOutputStream();
		try {
			writeAllBytesToStream(uploadedFileInputStream, imageData);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		new DummyDataDAO().updateContactProfileImage(contact, imageData.toByteArray());
	}

	private void writeAllBytesToStream(InputStream inputStream, OutputStream outputStream) throws Exception {
		int readBytes;
		byte[] buffer = new byte[4096];
		while ((readBytes = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, readBytes);
		}
	}

	public void onProfileImageFileUploadFileUploadFinished(DetailsSharedReply reply, ContactDTO contact) {
		//: update contact DTO with new profile image id
		reply.setContactDTO(new DummyDataDAO().getContact(contact.getId()));
		reply.setInfoToast("Profile image updated");
	}

	public void onSetPreferredMusicButtonClicked(DetailsSharedReply reply, ContactDTO contact) {
		IDLabelImageAssetList items = new IDLabelImageAssetList();
		for (String i: DummyDataDAO.PREFERRED_MUISC_TYPES){
			items.addItem(i, i, ImageAsset.MUSIC);
		}
		FLUIReplyUtil.showListChooser(reply , contact.getId(), true, false, "Preferred Music", items, contact.getPreferredMusic());
	}

	public void onListChooserResult(DetailsSharedReply reply, String referenceID, List<String> selectedIDs) {
		if (selectedIDs == null){
			//: dialog was cancelled
			return;
		}
		ContactDTO contact = new DummyDataDAO().getContact(referenceID);
		contact.setPreferredMusic(new ArrayList<String>(selectedIDs));
		reply.setContactDTO(contact);
		reply.setPreferredMusicContentLabelText(createMusicInfoText(contact.getPreferredMusic()));
	}


}
