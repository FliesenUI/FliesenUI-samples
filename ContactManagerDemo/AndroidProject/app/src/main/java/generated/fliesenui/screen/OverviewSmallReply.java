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
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class OverviewSmallReply extends FLUIAbstractReply implements OverviewSharedReply {
/*Generated! Do not modify!*/     public OverviewSmallReply(boolean recordMode, StringLanguage currentLanguage) {
/*Generated! Do not modify!*/         super(recordMode, currentLanguage);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_info_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_info_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_info_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_info_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_info_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLanguageEnglishButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_languageEnglishButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_languageEnglishButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_languageEnglishButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLanguageEnglishButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLanguageEnglishButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_languageEnglishButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_languageEnglishButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLanguageEnglishButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLanguageGermanButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_languageGermanButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_languageGermanButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_languageGermanButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLanguageGermanButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLanguageGermanButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_languageGermanButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_languageGermanButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setLanguageGermanButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNewButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_newButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_newButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_newButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNewButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNewButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_newButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_newButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNewButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setExportButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_exportButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_exportButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_exportButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setExportButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setExportButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_exportButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_exportButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setExportButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchNameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_searchNameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_searchNameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_searchNameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSearchNameTextFieldText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchNameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_searchNameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_searchNameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSearchNameTextFieldVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setSearchNameTextFieldBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_searchNameTextField_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_searchNameTextField_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSearchNameTextFieldBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_searchButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_searchButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_searchButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSearchButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_searchButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_searchButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSearchButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setActionItemInfoText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_actionItemInfo_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_actionItemInfo_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_actionItemInfo_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setActionItemInfoText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setActionItemInfoVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_actionItemInfo_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_actionItemInfo_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setActionItemInfoVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_editButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_editButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_editButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_editButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_editButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDeleteButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_deleteButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_deleteButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_deleteButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setDeleteButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDeleteButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_deleteButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_deleteButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setDeleteButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_cancelButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewSmall_cancelButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewSmall_cancelButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCancelButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_cancelButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_cancelButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCancelButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTableBarVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_tableBar_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_tableBar_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setTableBarVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSelectedItemBarVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_selectedItemBar_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_selectedItemBar_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSelectedItemBarVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setItemActionBarVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_itemActionBar_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_itemActionBar_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setItemActionBarVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLanguageEnglishButtonImageAsset(ImageAsset imageAsset) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_languageEnglishButton_propertyImageSource");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_languageEnglishButton_propertyImageSource", imageAsset.getFilename());
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_IMAGE_ASSET, "setLanguageEnglishButtonImageAsset(", imageAsset);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLanguageGermanButtonImageAsset(ImageAsset imageAsset) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewSmall_languageGermanButton_propertyImageSource");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewSmall_languageGermanButton_propertyImageSource", imageAsset.getFilename());
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_IMAGE_ASSET, "setLanguageGermanButtonImageAsset(", imageAsset);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setContactsDTO(ContactListDTO dto) {
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("contacts");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("contacts");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("contacts", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setContactsDTO(", gson.toJson(dto), getClassName(dto));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSelectedContactDTO(ContactDTO dto) {
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("selectedContact");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("selectedContact");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("selectedContact", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setSelectedContactDTO(", gson.toJson(dto), getClassName(dto));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
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
/*Generated! Do not modify!*/     public OverviewSmallStringInputDialogOptions showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText) {
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
/*Generated! Do not modify!*/         return new OverviewSmallStringInputDialogOptions(this, inputDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewSmallConfirmDialogOptions showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText) {
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
/*Generated! Do not modify!*/         return new OverviewSmallConfirmDialogOptions(this, confirmDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public OverviewSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public OverviewSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs){
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
/*Generated! Do not modify!*/         return new OverviewSmallListChoosrDialogOptions(this, parameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewSmallListChoosrDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs){
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
/*Generated! Do not modify!*/         return new OverviewSmallListChoosrDialogOptions(this, parameters);
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