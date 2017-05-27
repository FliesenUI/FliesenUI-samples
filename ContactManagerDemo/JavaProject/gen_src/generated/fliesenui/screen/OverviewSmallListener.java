/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface OverviewSmallListener{
/*Generated! Do not modify!*/     void onLoaded(OverviewSmallReply reply, FLUIClientPropertiesDTO clientProperties);
/*Generated! Do not modify!*/     void onInputDialogResult(OverviewSmallReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(OverviewSmallReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(OverviewSmallReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onLanguageEnglishButtonClicked(OverviewSmallReply reply);
/*Generated! Do not modify!*/     void onLanguageGermanButtonClicked(OverviewSmallReply reply);
/*Generated! Do not modify!*/     void onNewButtonClicked(OverviewSmallReply reply);
/*Generated! Do not modify!*/     void onExportButtonClicked(OverviewSmallReply reply);
/*Generated! Do not modify!*/     void onSearchButtonClicked(OverviewSmallReply reply, String searchNameTextFieldText);
/*Generated! Do not modify!*/     void onEditButtonClicked(OverviewSmallReply reply, ContactDTO selectedContact);
/*Generated! Do not modify!*/     void onDeleteButtonClicked(OverviewSmallReply reply, ContactDTO selectedContact);
/*Generated! Do not modify!*/     void onCancelButtonClicked(OverviewSmallReply reply);
/*Generated! Do not modify!*/     void onContactsTableRowClicked(OverviewSmallReply reply, String rowID);
/*Generated! Do not modify!*/ }