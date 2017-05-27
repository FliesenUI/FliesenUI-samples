/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface DetailsSmallListener{
/*Generated! Do not modify!*/     void onLoaded(DetailsSmallReply reply, FLUIClientPropertiesDTO clientProperties, ContactDTO contact);
/*Generated! Do not modify!*/     void onInputDialogResult(DetailsSmallReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(DetailsSmallReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(DetailsSmallReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onOpenWebSiteButtonClicked(DetailsSmallReply reply, ContactDTO contact);
/*Generated! Do not modify!*/     void onSetPreferredMusicButtonClicked(DetailsSmallReply reply, ContactDTO contact);
/*Generated! Do not modify!*/     void onSaveButtonClicked(DetailsSmallReply reply, ContactDTO contact, String typeSelectBoxSelectedID);
/*Generated! Do not modify!*/     void onCancelButtonClicked(DetailsSmallReply reply);
/*Generated! Do not modify!*/     void onTypeSelectBoxChanged(DetailsSmallReply reply, String itemID);
/*Generated! Do not modify!*/     void onProfileImageFileUploadFileUpload(String uploadedFileName, InputStream uploadedFileInputStream, ContactDTO contact);
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     void onProfileImageFileUploadFileUploadFinished(DetailsSmallReply reply, ContactDTO contact);
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     void onBackPressed(DetailsSmallReply reply);
/*Generated! Do not modify!*/ }