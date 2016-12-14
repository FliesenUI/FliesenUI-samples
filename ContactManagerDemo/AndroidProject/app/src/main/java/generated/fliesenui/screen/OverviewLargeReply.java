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
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class OverviewLargeReply extends FLUIAbstractReply implements OverviewSharedReply {
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_info_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewLarge_info_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewLarge_info_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_info_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewLarge_info_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNewButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_newButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewLarge_newButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewLarge_newButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNewButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_newButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewLarge_newButton_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setExportButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_exportButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewLarge_exportButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewLarge_exportButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setExportButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_exportButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewLarge_exportButton_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchNameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_searchNameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewLarge_searchNameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewLarge_searchNameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchNameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_searchNameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewLarge_searchNameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_searchButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("overviewLarge_searchButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("overviewLarge_searchButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSearchButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("overviewLarge_searchButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("overviewLarge_searchButton_propertyVisible", visible);
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
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
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