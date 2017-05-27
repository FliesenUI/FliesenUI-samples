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
/*Generated! Do not modify!*/ public class DetailsSmallRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private DetailsSmallRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private DetailsSmallRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("detailsSmall");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnOpenWebSiteButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("widgetButtonOpenWebSiteButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnSetPreferredMusicButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("widgetButtonSetPreferredMusicButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnSaveButtonClickedRequest(String language, generated.fliesenui.dto.ContactDTO contact, String typeSelectBoxSelectedID){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("widgetButtonSaveButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("typeSelectBoxSelectedID", typeSelectBoxSelectedID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnCancelButtonClickedRequest(String language){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("widgetButtonCancelButtonClicked", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnTypeSelectBoxChangedRequest(String language, String rowID){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onTypeSelectBoxChanged", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnProfileImageFileUploadFileUploadRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onProfileImageFileUploadFileUpload", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnProfileImageFileUploadFileUploadFinishedRequest(String language, generated.fliesenui.dto.ContactDTO contact){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onProfileImageFileUploadFileUploadFinished", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("contact", new Gson().toJson(contact));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnBackPressedRequest(String language){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onBackPressed", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnInputDialogResultRequest(String language, String referenceID, String result){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("result", result);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnConfirmDialogResultRequest(String language, String referenceID, boolean result){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("result", result);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsSmallRequest createOnListChooserResultRequest(String language, String referenceID, java.util.List<String> selectedIDs){
/*Generated! Do not modify!*/         DetailsSmallRequest resultInstance = new DetailsSmallRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("selectedIDs", selectedIDs);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }