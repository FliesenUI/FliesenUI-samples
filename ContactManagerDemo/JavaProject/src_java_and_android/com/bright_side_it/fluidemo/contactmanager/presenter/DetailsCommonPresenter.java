package com.bright_side_it.fluidemo.contactmanager.presenter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.bright_side_it.fluidemo.contactmanager.dao.DummyDataDAO;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
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


}
