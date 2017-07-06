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
/*Generated! Do not modify!*/ public class OverviewLargeRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewLargeRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewLargeRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("overviewLarge");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnLanguageEnglishButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("widgetButtonLanguageEnglishButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnLanguageGermanButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("widgetButtonLanguageGermanButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnNewButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("widgetButtonNewButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnExportButtonClickedRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("widgetButtonExportButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnSearchButtonClickedRequest(String language, String searchNameTextFieldText){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("widgetButtonSearchButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("searchNameTextFieldText", searchNameTextFieldText);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnContactsTableEditButtonClickedRequest(String language, String rowID){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onContactsTableEditButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnContactsTableDeleteButtonClickedRequest(String language, String rowID){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onContactsTableDeleteButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnContactsTableRowClickedRequest(String language, String rowID){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onContactsTableRowClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnInputDialogResultRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnConfirmDialogResultRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static OverviewLargeRequest createOnListChooserResultRequest(String language){
/*Generated! Do not modify!*/         OverviewLargeRequest resultInstance = new OverviewLargeRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }