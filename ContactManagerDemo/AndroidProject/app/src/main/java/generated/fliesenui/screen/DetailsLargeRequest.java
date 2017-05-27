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
/*Generated! Do not modify!*/ public class DetailsLargeRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private DetailsLargeRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private DetailsLargeRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("detailsLarge");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnOpenWebSiteButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("widgetButtonOpenWebSiteButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnSetPreferredMusicButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("widgetButtonSetPreferredMusicButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnSaveButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO contact, String typeSelectBoxSelectedID){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("widgetButtonSaveButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("typeSelectBoxSelectedID", typeSelectBoxSelectedID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnCancelButtonClickedRequest(String language){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("widgetButtonCancelButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnTypeSelectBoxChangedRequest(String language, String rowID){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onTypeSelectBoxChanged", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnProfileImageFileUploadFileUploadRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onProfileImageFileUploadFileUpload", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnProfileImageFileUploadFileUploadFinishedRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onProfileImageFileUploadFileUploadFinished", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnBackPressedRequest(String language){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onBackPressed", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnInputDialogResultRequest(String language, String referenceID, String result){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("result", result);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnConfirmDialogResultRequest(String language, String referenceID, boolean result){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("result", result);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsLargeRequest createOnListChooserResultRequest(String language, String referenceID, java.util.List<String> selectedIDs){
/*Generated! Do not modify!*/         DetailsLargeRequest resultInstance = new DetailsLargeRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("selectedIDs", selectedIDs);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }