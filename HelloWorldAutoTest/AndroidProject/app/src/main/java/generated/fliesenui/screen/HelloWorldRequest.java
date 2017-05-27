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
/*Generated! Do not modify!*/ public class HelloWorldRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private HelloWorldRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private HelloWorldRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("helloWorld");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static HelloWorldRequest createOnGreetButtonClickedRequest(String language, String nameTextFieldText){
/*Generated! Do not modify!*/         HelloWorldRequest resultInstance = new HelloWorldRequest("widgetButtonGreetButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("nameTextFieldText", nameTextFieldText);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static HelloWorldRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties){
/*Generated! Do not modify!*/         HelloWorldRequest resultInstance = new HelloWorldRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static HelloWorldRequest createOnInputDialogResultRequest(String language, String referenceID, String result){
/*Generated! Do not modify!*/         HelloWorldRequest resultInstance = new HelloWorldRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("result", result);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static HelloWorldRequest createOnConfirmDialogResultRequest(String language, String referenceID, boolean result){
/*Generated! Do not modify!*/         HelloWorldRequest resultInstance = new HelloWorldRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("result", result);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static HelloWorldRequest createOnListChooserResultRequest(String language, String referenceID, java.util.List<String> selectedIDs){
/*Generated! Do not modify!*/         HelloWorldRequest resultInstance = new HelloWorldRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("referenceID", referenceID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("selectedIDs", selectedIDs);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }