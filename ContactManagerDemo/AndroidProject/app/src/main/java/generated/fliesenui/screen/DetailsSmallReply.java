/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import java.util.TreeSet;
/*Generated! Do not modify!*/ import java.util.Set;
/*Generated! Do not modify!*/ import java.util.ArrayList;
/*Generated! Do not modify!*/ import java.util.HashSet;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelImageAssetList;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelList;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIReplyAction.ReplyActionType;
/*Generated! Do not modify!*/ import generated.fliesenui.core.InputDialogParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ConfirmDialogParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ListChooserParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabel;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelImageAsset;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ListChooserItem;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class DetailsSmallReply extends FLUIAbstractReply implements DetailsSharedReply {
/*Generated! Do not modify!*/     public DetailsSmallReply(boolean recordMode, StringLanguage currentLanguage) {
/*Generated! Do not modify!*/         super(recordMode, currentLanguage);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_info_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_info_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_info_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_info_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_info_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setProfileImageVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_profileImage_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_profileImage_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setProfileImageVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypeLabelText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_typeLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_typeLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_typeLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setTypeLabelText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypeLabelVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_typeLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_typeLabel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setTypeLabelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setFirstnameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_firstnameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_firstnameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_firstnameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setFirstnameTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setFirstnameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_firstnameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_firstnameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setFirstnameTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setFirstnameTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_firstnameTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_firstnameTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setFirstnameTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLastnameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_lastnameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_lastnameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_lastnameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLastnameTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLastnameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_lastnameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_lastnameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLastnameTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setLastnameTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_lastnameTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_lastnameTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLastnameTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPhoneTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_phoneTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_phoneTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_phoneTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPhoneTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPhoneTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_phoneTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_phoneTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPhoneTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setPhoneTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_phoneTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_phoneTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPhoneTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMobileTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_mobileTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_mobileTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_mobileTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMobileTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMobileTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_mobileTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_mobileTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMobileTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setMobileTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_mobileTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_mobileTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMobileTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStreetTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_streetTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_streetTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_streetTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setStreetTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStreetTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_streetTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_streetTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setStreetTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setStreetTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_streetTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_streetTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setStreetTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCityTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_cityTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_cityTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_cityTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCityTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCityTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_cityTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_cityTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCityTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setCityTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_cityTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_cityTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCityTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPostalCodeTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_postalCodeTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_postalCodeTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_postalCodeTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPostalCodeTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPostalCodeTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_postalCodeTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_postalCodeTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPostalCodeTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setPostalCodeTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_postalCodeTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_postalCodeTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPostalCodeTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCountryTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_countryTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_countryTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_countryTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCountryTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCountryTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_countryTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_countryTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCountryTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setCountryTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_countryTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_countryTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCountryTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStateTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_stateTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_stateTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_stateTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setStateTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setStateTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_stateTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_stateTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setStateTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setStateTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_stateTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_stateTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setStateTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setWebSiteTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_webSiteTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_webSiteTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_webSiteTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setWebSiteTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setWebSiteTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_webSiteTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_webSiteTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setWebSiteTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setWebSiteTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_webSiteTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_webSiteTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setWebSiteTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOpenWebSiteButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_openWebSiteButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_openWebSiteButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_openWebSiteButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setOpenWebSiteButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOpenWebSiteButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_openWebSiteButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_openWebSiteButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setOpenWebSiteButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPreferredMusicTitleLabelText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_preferredMusicTitleLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_preferredMusicTitleLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_preferredMusicTitleLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPreferredMusicTitleLabelText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPreferredMusicTitleLabelVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_preferredMusicTitleLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_preferredMusicTitleLabel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPreferredMusicTitleLabelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPreferredMusicContentLabelText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_preferredMusicContentLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_preferredMusicContentLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_preferredMusicContentLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPreferredMusicContentLabelText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setPreferredMusicContentLabelVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_preferredMusicContentLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_preferredMusicContentLabel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setPreferredMusicContentLabelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSetPreferredMusicButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_setPreferredMusicButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_setPreferredMusicButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_setPreferredMusicButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSetPreferredMusicButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSetPreferredMusicButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_setPreferredMusicButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_setPreferredMusicButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSetPreferredMusicButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSaveButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_saveButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_saveButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_saveButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSaveButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSaveButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_saveButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_saveButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSaveButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_cancelButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("detailsSmall_cancelButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("detailsSmall_cancelButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCancelButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_cancelButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_cancelButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCancelButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setProfileImageFileUploadVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("detailsSmall_profileImageFileUpload_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("detailsSmall_profileImageFileUpload_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setProfileImageFileUploadVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
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
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setContactDTO(", gson.toJson(dto), getClassName(dto));
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
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setTypesDTO(", gson.toJson(dto), getClassName(dto));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTypeSelectBoxSelectedID(String selectedID) {
/*Generated! Do not modify!*/         replyDTO.getSelectBoxSelectedIDs().put("detailsSmall_typeSelectBox_selectedItem", selectedID);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setTypeSelectBoxSelectedID(" + escapeString(selectedID) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public void openScreenDetailsLarge(ContactDTO contact) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(contact);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("detailsLarge");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenDetailsLarge(", gson.toJson(contact), getClassName(contact));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenDetailsSmall(ContactDTO contact) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(contact);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("detailsSmall");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenDetailsSmall(", gson.toJson(contact), getClassName(contact));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverviewLarge() {
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("overviewLarge");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenOverviewLarge(");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverviewSmall() {
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("overviewSmall");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenOverviewSmall(");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsSmallStringInputDialogOptions showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText) {
/*Generated! Do not modify!*/         InputDialogParameters inputDialogParameters = new InputDialogParameters();
/*Generated! Do not modify!*/         inputDialogParameters.setReferenceID(referenceID);
/*Generated! Do not modify!*/         inputDialogParameters.setTitle(title);
/*Generated! Do not modify!*/         inputDialogParameters.setTextContent(textContent);
/*Generated! Do not modify!*/         inputDialogParameters.setLabel(label);
/*Generated! Do not modify!*/         inputDialogParameters.setInitialValueText(initialValueText);
/*Generated! Do not modify!*/         inputDialogParameters.setOkText(okText);
/*Generated! Do not modify!*/         inputDialogParameters.setCancelText(cancelText);
/*Generated! Do not modify!*/         replyDTO.setInputDialogParameters(inputDialogParameters);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/         	addRecordedAction("showInputDialog(" + escapeString(referenceID) + ", " + escapeString(title) + ", " + escapeString(textContent) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(label) + ", " + escapeString(initialValueText) + ", " + escapeString(okText) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(cancelText)+ ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return new DetailsSmallStringInputDialogOptions(this, inputDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsSmallConfirmDialogOptions showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText) {
/*Generated! Do not modify!*/         ConfirmDialogParameters confirmDialogParameters = new ConfirmDialogParameters();
/*Generated! Do not modify!*/         confirmDialogParameters.setReferenceID(referenceID);
/*Generated! Do not modify!*/         confirmDialogParameters.setTitle(title);
/*Generated! Do not modify!*/         confirmDialogParameters.setTextContent(textContent);
/*Generated! Do not modify!*/         confirmDialogParameters.setOkText(okText);
/*Generated! Do not modify!*/         confirmDialogParameters.setCancelText(cancelText);
/*Generated! Do not modify!*/         replyDTO.setConfirmDialogParameters(confirmDialogParameters);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("showConfirmDialog(" + escapeString(referenceID) + ", " + escapeString(title) + ", " + escapeString(textContent) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(okText) + ", " + escapeString(cancelText)+ ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return new DetailsSmallConfirmDialogOptions(this, confirmDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public DetailsSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public DetailsSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/     	ListChooserParameters parameters = createListChooserParameters(referenceID, multiSelect, showFilter, title, okText, cancelText);
/*Generated! Do not modify!*/     	Set<String> selectedIDsSet = new HashSet<String>();
/*Generated! Do not modify!*/     	if (selectedIDs != null){
/*Generated! Do not modify!*/     		selectedIDsSet = new HashSet<String>(selectedIDs);
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	List<ListChooserItem> chooserItems = new ArrayList<ListChooserItem>();
/*Generated! Do not modify!*/     	for (IDLabelImageAsset i: items.getItems()){
/*Generated! Do not modify!*/     		chooserItems.add(createItem(i.getID(), i.getLabel(), i.getImageAssetID(), selectedIDsSet.contains(i.getID())));
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	parameters.setShowIcons(true);
/*Generated! Do not modify!*/     	parameters.setItems(chooserItems);
/*Generated! Do not modify!*/     	replyDTO.setListChooserParameters(parameters);
/*Generated! Do not modify!*/     	
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SHOW_LIST_CHOOSER_IMGS, "showListChooser(" + escapeString(referenceID) + ", " + multiSelect + ", " + showFilter + ", " + escapeString(title) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(okText) + ", " + escapeString(cancelText) + ", ", gson.toJson(items), selectedIDs);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         return new DetailsSmallListChoosrDialogOptions(this, parameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/     	ListChooserParameters parameters = createListChooserParameters(referenceID, multiSelect, showFilter, title, okText, cancelText);
/*Generated! Do not modify!*/     	Set<String> selectedIDsSet = new HashSet<String>();
/*Generated! Do not modify!*/     	if (selectedIDs != null){
/*Generated! Do not modify!*/     		selectedIDsSet = new HashSet<String>(selectedIDs);
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	List<ListChooserItem> chooserItems = new ArrayList<ListChooserItem>();
/*Generated! Do not modify!*/     	for (IDLabel i: items.getItems()){
/*Generated! Do not modify!*/     		chooserItems.add(createItem(i.getID(), i.getLabel(), null, selectedIDsSet.contains(i.getID())));
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	parameters.setShowIcons(false);
/*Generated! Do not modify!*/     	parameters.setItems(chooserItems);
/*Generated! Do not modify!*/     	replyDTO.setListChooserParameters(parameters);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/         	addRecordedAction(ReplyActionType.SHOW_LIST_CHOOSER_TEXTS, "showListChooser(" + escapeString(referenceID) + ", " + multiSelect + ", " + showFilter + ", " + escapeString(title) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(okText) + ", " + escapeString(cancelText) + ", ", gson.toJson(items), selectedIDs);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return new DetailsSmallListChoosrDialogOptions(this, parameters);
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private ListChooserParameters createListChooserParameters(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText) {
/*Generated! Do not modify!*/         ListChooserParameters parameters = new ListChooserParameters();
/*Generated! Do not modify!*/         parameters.setReferenceID(referenceID);
/*Generated! Do not modify!*/         parameters.setMultiSelect(multiSelect);
/*Generated! Do not modify!*/         parameters.setShowFilter(showFilter);
/*Generated! Do not modify!*/         parameters.setTitle(title);
/*Generated! Do not modify!*/         parameters.setOkText(okText);
/*Generated! Do not modify!*/         parameters.setCancelText(cancelText);
/*Generated! Do not modify!*/         return parameters;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private ListChooserItem createItem(String id, String label, String imageAssetID, boolean selected) {
/*Generated! Do not modify!*/         ListChooserItem result = new ListChooserItem();
/*Generated! Do not modify!*/         result.setID(id);
/*Generated! Do not modify!*/         result.setLabel(label);
/*Generated! Do not modify!*/         result.setImageAssetID(imageAssetID);
/*Generated! Do not modify!*/         result.setSelected(selected);
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }