package com.bright_side_it.fluidemo.contactmanager.presenter;

import java.util.List;

import com.bright_side_it.fluidemo.contactmanager.ContactManagerConstants;
import com.bright_side_it.fluidemo.contactmanager.dao.DummyDataDAO;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.core.FLUIString.StringLanguage;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.screen.OverviewLargeReply;
import generated.fliesenui.screen.OverviewSmallListener;
import generated.fliesenui.screen.OverviewSmallReply;

public class OverviewSmallPresenter implements OverviewSmallListener {

	@Override
	public void onLoaded(OverviewSmallReply reply, FLUIClientPropertiesDTO clientProperties) {
		reply.setContactsDTO(new DummyDataDAO().readContacts(null));
	}

	@Override
	public void onInputDialogResult(OverviewSmallReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(OverviewSmallReply reply, String referenceID, boolean confirmed) {
		if (confirmed){
			new DummyDataDAO().deleteContact(referenceID);
			reply.setSearchNameTextFieldText("");
			reply.setContactsDTO(new DummyDataDAO().readContacts(null));
			reply.setInfoToast("Contact deleted");
			showTableMode(reply);
		}
	}

	@Override
	public void onNewButtonClicked(OverviewSmallReply reply) {
		reply.openScreenDetailsSmall(null);
	}

	@Override
	public void onContactsTableRowClicked(OverviewSmallReply reply, String rowID) {
		ContactDTO contact = new DummyDataDAO().getContact(rowID);
		reply.setSelectedContactDTO(contact);
		reply.setActionItemInfoText("Choose action for contact '" + contact.getFirstname() + " " + contact.getLastname() + "'");
		reply.setTableBarVisible(false);
		reply.setItemActionBarVisible(true);
		reply.setSelectedItemBarVisible(true);
	}

	@Override
	public void onSearchButtonClicked(OverviewSmallReply reply, String searchNameTextFieldText) {
		showTableMode(reply);
		reply.setContactsDTO(new DummyDataDAO().readContacts(searchNameTextFieldText));				
	}

	@Override
	public void onExportButtonClicked(OverviewSmallReply reply) {
		reply.downloadFile(ContactManagerConstants.CONTACT_EXPORT_FILE_STREAM_ID);
	}

	@Override
	public void onEditButtonClicked(OverviewSmallReply reply, ContactDTO selectedContact) {
		reply.openScreenDetailsSmall(selectedContact);
	}

	@Override
	public void onDeleteButtonClicked(OverviewSmallReply reply, ContactDTO selectedContact) {
		reply.showConfirmDialog(selectedContact.getId(), "Delete contact", "Do you want to delete contact " + selectedContact.getFirstname() + " " + selectedContact.getLastname(), "Delete", "Cancel");
	}

	@Override
	public void onCancelButtonClicked(OverviewSmallReply reply) {
		showTableMode(reply);
	}
	
	private void showTableMode(OverviewSmallReply reply){
		reply.setTableBarVisible(true);
		reply.setItemActionBarVisible(false);
		reply.setSelectedItemBarVisible(false);
	}

	@Override
	public void onListChooserResult(OverviewSmallReply reply, String referenceID, List<String> selectedIDs) {
	}
	
	@Override
	public void onLanguageEnglishButtonClicked(OverviewSmallReply reply) {
		reply.setLanguage(StringLanguage.DEFAULT);
		reply.openScreenOverviewSmall();
	}

	@Override
	public void onLanguageGermanButtonClicked(OverviewSmallReply reply) {
		reply.setLanguage(StringLanguage.DE);
		reply.openScreenOverviewSmall();
	}


}
