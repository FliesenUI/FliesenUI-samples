/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface OverviewLargeListener{
/*Generated! Do not modify!*/     void onLoaded(OverviewLargeReply reply, FLUIClientPropertiesDTO clientProperties);
/*Generated! Do not modify!*/     void onInputDialogResult(OverviewLargeReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(OverviewLargeReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onNewButtonClicked(OverviewLargeReply reply);
/*Generated! Do not modify!*/     void onExportButtonClicked(OverviewLargeReply reply);
/*Generated! Do not modify!*/     void onSearchButtonClicked(OverviewLargeReply reply, String searchNameTextFieldText);
/*Generated! Do not modify!*/     void onContactsTableEditButtonClicked(OverviewLargeReply reply, String rowID);
/*Generated! Do not modify!*/     void onContactsTableDeleteButtonClicked(OverviewLargeReply reply, String rowID);
/*Generated! Do not modify!*/     void onContactsTableRowClicked(OverviewLargeReply reply, String rowID);
/*Generated! Do not modify!*/ }