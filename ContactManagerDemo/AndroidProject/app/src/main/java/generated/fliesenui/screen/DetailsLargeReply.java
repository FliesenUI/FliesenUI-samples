/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class DetailsLargeReply extends FLUIAbstractReply implements DetailsSharedReply {
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_info_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_info_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_info_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_info_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_info_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypeLabelText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_typeLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_typeLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_typeLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypeLabelVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_typeLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_typeLabel_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setFirstnameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_firstnameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_firstnameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_firstnameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setFirstnameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_firstnameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_firstnameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLastnameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_lastnameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_lastnameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_lastnameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLastnameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_lastnameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_lastnameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setProfileImageFileUploadVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_profileImageFileUpload_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_profileImageFileUpload_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setProfileImageVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_profileImage_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_profileImage_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPhoneTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_phoneTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_phoneTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_phoneTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPhoneTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_phoneTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_phoneTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMobileTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_mobileTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_mobileTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_mobileTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMobileTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_mobileTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_mobileTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStreetTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_streetTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_streetTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_streetTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStreetTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_streetTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_streetTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCityTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_cityTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_cityTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_cityTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCityTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_cityTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_cityTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPostalCodeTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_postalCodeTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_postalCodeTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_postalCodeTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPostalCodeTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_postalCodeTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_postalCodeTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCountryTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_countryTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_countryTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_countryTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCountryTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_countryTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_countryTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStateTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_stateTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_stateTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_stateTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStateTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_stateTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_stateTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setWebSiteTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_webSiteTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_webSiteTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_webSiteTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setWebSiteTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_webSiteTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_webSiteTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOpenWebSiteButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_openWebSiteButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_openWebSiteButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_openWebSiteButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOpenWebSiteButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_openWebSiteButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_openWebSiteButton_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSaveButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_saveButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_saveButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_saveButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSaveButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_saveButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_saveButton_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_cancelButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsLarge_cancelButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsLarge_cancelButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsLarge_cancelButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsLarge_cancelButton_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setContactDTO(ContactDTO dto) {
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("contact");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("contact");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("contact", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypesDTO(ContactTypeListDTO dto) {
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("types");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("types");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("types", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypeSelectBoxSelectedID(String selectedID) {
/*Generated! Do not modify!*/         replyDTO.getSelectBoxSelectedIDs().put("detailsLarge_typeSelectBox_selectedItem", selectedID);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public void openScreenDetailsLarge(ContactDTO contact) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(contact);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("detailsLarge");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenDetailsSmall(ContactDTO contact) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(contact);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("detailsSmall");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverviewLarge() {
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("overviewLarge");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverviewSmall() {
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("overviewSmall");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }