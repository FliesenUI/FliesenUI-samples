/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreen;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreenRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class OverviewSmallRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewSmallRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewSmallRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("overviewSmall");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnLanguageEnglishButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonLanguageEnglishButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnLanguageGermanButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonLanguageGermanButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnNewButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonNewButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnExportButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonExportButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnSearchButtonClickedRequest(String language, String searchNameTextFieldText){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonSearchButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("searchNameTextFieldText", searchNameTextFieldText);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnEditButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO selectedContact){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonEditButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("selectedContact", new Gson().toJson(selectedContact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnDeleteButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO selectedContact){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonDeleteButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("selectedContact", new Gson().toJson(selectedContact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnCancelButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("widgetButtonCancelButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnContactsTableRowClickedRequest(String language, String rowID){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("onContactsTableRowClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnInputDialogResultRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnConfirmDialogResultRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewSmallRequest createOnListChooserResultRequest(String language){
/*Generated! Do not modify!*/         OverviewSmallRequest resultInstance = new OverviewSmallRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }