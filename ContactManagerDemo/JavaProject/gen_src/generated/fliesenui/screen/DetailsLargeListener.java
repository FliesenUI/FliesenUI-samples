/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface DetailsLargeListener{
/*Generated! Do not modify!*/     void onLoaded(DetailsLargeReply reply, FLUIClientPropertiesDTO clientProperties, ContactDTO contact);
/*Generated! Do not modify!*/     void onInputDialogResult(DetailsLargeReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(DetailsLargeReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(DetailsLargeReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onOpenWebSiteButtonClicked(DetailsLargeReply reply, ContactDTO contact);
/*Generated! Do not modify!*/     void onSetPreferredMusicButtonClicked(DetailsLargeReply reply, ContactDTO contact);
/*Generated! Do not modify!*/     void onSaveButtonClicked(DetailsLargeReply reply, ContactDTO contact, String typeSelectBoxSelectedID);
/*Generated! Do not modify!*/     void onCancelButtonClicked(DetailsLargeReply reply);
/*Generated! Do not modify!*/     void onTypeSelectBoxChanged(DetailsLargeReply reply, String itemID);
/*Generated! Do not modify!*/     void onProfileImageFileUploadFileUpload(String uploadedFileName, InputStream uploadedFileInputStream, ContactDTO contact);
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     void onProfileImageFileUploadFileUploadFinished(DetailsLargeReply reply, ContactDTO contact);
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     void onBackPressed(DetailsLargeReply reply);
/*Generated! Do not modify!*/ }