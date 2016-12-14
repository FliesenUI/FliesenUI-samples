/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface OverviewSharedReply{
/*Generated! Do not modify!*/     void downloadFile(String fileStreamID);
/*Generated! Do not modify!*/     void openScreenDetailsLarge(ContactDTO contact);
/*Generated! Do not modify!*/     void openScreenDetailsSmall(ContactDTO contact);
/*Generated! Do not modify!*/     void openScreenOverviewLarge();
/*Generated! Do not modify!*/     void openScreenOverviewSmall();
/*Generated! Do not modify!*/     void openURL(String url, boolean openInNewWindow);
/*Generated! Do not modify!*/     void setContactsDTO(ContactListDTO dto);
/*Generated! Do not modify!*/     void setErrorDialog(String title, String text);
/*Generated! Do not modify!*/     void setExportButtonText(String text);
/*Generated! Do not modify!*/     void setExportButtonVisible(boolean visible);
/*Generated! Do not modify!*/     void setInfoDialog(String title, String text);
/*Generated! Do not modify!*/     void setInfoText(String text);
/*Generated! Do not modify!*/     void setInfoToast(String text);
/*Generated! Do not modify!*/     void setInfoVisible(boolean visible);
/*Generated! Do not modify!*/     void setNewButtonText(String text);
/*Generated! Do not modify!*/     void setNewButtonVisible(boolean visible);
/*Generated! Do not modify!*/     void setSearchButtonText(String text);
/*Generated! Do not modify!*/     void setSearchButtonVisible(boolean visible);
/*Generated! Do not modify!*/     void setSearchNameTextFieldText(String text);
/*Generated! Do not modify!*/     void setSearchNameTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText);
/*Generated! Do not modify!*/     void showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText);
/*Generated! Do not modify!*/ }