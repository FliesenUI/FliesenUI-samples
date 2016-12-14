package com.bright_side_it.fluidemo.contactmanager.presenter;

import com.bright_side_it.fluidemo.contactmanager.ContactManagerConstants;
import com.bright_side_it.fluidemo.contactmanager.dao.DummyDataDAO;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.screen.OverviewLargeListener;
import generated.fliesenui.screen.OverviewLargeReply;

public class OverviewLargePresenter implements OverviewLargeListener {
	private final boolean alwaysUseSmallSceen;

	public OverviewLargePresenter(boolean alwaysUseSmallSceen) {
		this.alwaysUseSmallSceen = alwaysUseSmallSceen;
	}

	@Override
	public void onLoaded(OverviewLargeReply reply, FLUIClientPropertiesDTO clientProperties) {
		if ((alwaysUseSmallSceen) || (clientProperties.getScreenDiagonalInInch() < 9)){
			reply.openScreenOverviewSmall();
			return;
		}
		reply.setContactsDTO(new DummyDataDAO().readContacts(null));
	}

	@Override
	public void onInputDialogResult(OverviewLargeReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(OverviewLargeReply reply, String referenceID, boolean confirmed) {
		if (confirmed){
			new DummyDataDAO().deleteContact(referenceID);
			reply.setSearchNameTextFieldText("");
			reply.setContactsDTO(new DummyDataDAO().readContacts(null));
			reply.setInfoToast("Contact deleted");
		}
	}

	@Override
	public void onNewButtonClicked(OverviewLargeReply reply) {
		reply.openScreenDetailsLarge(null);
	}

	@Override
	public void onContactsTableEditButtonClicked(OverviewLargeReply reply, String rowID) {
		ContactDTO contact = new DummyDataDAO().getContact(rowID);
		reply.openScreenDetailsLarge(contact);
	}

	@Override
	public void onContactsTableDeleteButtonClicked(OverviewLargeReply reply, String rowID) {
		ContactDTO contact = new DummyDataDAO().getContact(rowID);
		reply.showConfirmDialog(rowID, "Delete contact", "Do you want to delete contact " + contact.getFirstname() + " " + contact.getLastname(), "Delete", "Cancel");
	}

	@Override
	public void onContactsTableRowClicked(OverviewLargeReply reply, String rowID) {
		ContactDTO contact = new DummyDataDAO().getContact(rowID);
		reply.openScreenDetailsLarge(contact);
	}

	@Override
	public void onSearchButtonClicked(OverviewLargeReply reply, String searchNameTextFieldText) {
		reply.setContactsDTO(new DummyDataDAO().readContacts(searchNameTextFieldText));				
	}

	@Override
	public void onExportButtonClicked(OverviewLargeReply reply) {
		reply.downloadFile(ContactManagerConstants.CONTACT_EXPORT_FILE_STREAM_ID);
	}

}
