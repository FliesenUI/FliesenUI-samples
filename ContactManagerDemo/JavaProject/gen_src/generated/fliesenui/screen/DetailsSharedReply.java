/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface DetailsSharedReply{
/*Generated! Do not modify!*/     void downloadFile(String fileStreamID);
/*Generated! Do not modify!*/     void openScreenDetailsLarge(ContactDTO contact);
/*Generated! Do not modify!*/     void openScreenDetailsSmall(ContactDTO contact);
/*Generated! Do not modify!*/     void openScreenOverviewLarge();
/*Generated! Do not modify!*/     void openScreenOverviewSmall();
/*Generated! Do not modify!*/     void openURL(String url, boolean openInNewWindow);
/*Generated! Do not modify!*/     void setCancelButtonText(String text);
/*Generated! Do not modify!*/     void setCancelButtonVisible(boolean visible);
/*Generated! Do not modify!*/     void setCityTextFieldText(String text);
/*Generated! Do not modify!*/     void setCityTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setContactDTO(ContactDTO dto);
/*Generated! Do not modify!*/     void setCountryTextFieldText(String text);
/*Generated! Do not modify!*/     void setCountryTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setErrorDialog(String title, String text);
/*Generated! Do not modify!*/     void setFirstnameTextFieldText(String text);
/*Generated! Do not modify!*/     void setFirstnameTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setInfoDialog(String title, String text);
/*Generated! Do not modify!*/     void setInfoText(String text);
/*Generated! Do not modify!*/     void setInfoToast(String text);
/*Generated! Do not modify!*/     void setInfoVisible(boolean visible);
/*Generated! Do not modify!*/     void setLastnameTextFieldText(String text);
/*Generated! Do not modify!*/     void setLastnameTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setMobileTextFieldText(String text);
/*Generated! Do not modify!*/     void setMobileTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setOpenWebSiteButtonText(String text);
/*Generated! Do not modify!*/     void setOpenWebSiteButtonVisible(boolean visible);
/*Generated! Do not modify!*/     void setPhoneTextFieldText(String text);
/*Generated! Do not modify!*/     void setPhoneTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setPostalCodeTextFieldText(String text);
/*Generated! Do not modify!*/     void setPostalCodeTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setProfileImageFileUploadVisible(boolean visible);
/*Generated! Do not modify!*/     void setProfileImageVisible(boolean visible);
/*Generated! Do not modify!*/     void setSaveButtonText(String text);
/*Generated! Do not modify!*/     void setSaveButtonVisible(boolean visible);
/*Generated! Do not modify!*/     void setStateTextFieldText(String text);
/*Generated! Do not modify!*/     void setStateTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setStreetTextFieldText(String text);
/*Generated! Do not modify!*/     void setStreetTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void setTypeLabelText(String text);
/*Generated! Do not modify!*/     void setTypeLabelVisible(boolean visible);
/*Generated! Do not modify!*/     void setTypeSelectBoxSelectedID(String selectedID);
/*Generated! Do not modify!*/     void setTypesDTO(ContactTypeListDTO dto);
/*Generated! Do not modify!*/     void setWebSiteTextFieldText(String text);
/*Generated! Do not modify!*/     void setWebSiteTextFieldVisible(boolean visible);
/*Generated! Do not modify!*/     void showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText);
/*Generated! Do not modify!*/     void showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText);
/*Generated! Do not modify!*/ }