/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreen;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CallbackMethodCall;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class OverviewLargeView implements FLUIScreen {
/*Generated! Do not modify!*/     private OverviewLargeListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewLargeView(OverviewLargeListener listener) {
/*Generated! Do not modify!*/         this.listener = listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIAbstractReply onFLUIRequest(boolean recordMode, FLUIRequest request, String uploadedFileName, InputStream uploadedFileInputStream) throws Exception{
/*Generated! Do not modify!*/         Map<String, Object> parameters = request.getParameters();
/*Generated! Do not modify!*/         String action = request.getAction();
/*Generated! Do not modify!*/         StringLanguage currentLanguage = null;
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             currentLanguage = StringLanguage.valueOf(request.getCurrentLanguage());
/*Generated! Do not modify!*/         } catch (Exception ignored){
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         OverviewLargeReply reply = new OverviewLargeReply(recordMode, currentLanguage);
/*Generated! Do not modify!*/         if ("widgetButtonLanguageEnglishButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onLanguageEnglishButtonClicked(reply);
/*Generated! Do not modify!*/         } else if ("widgetButtonLanguageGermanButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onLanguageGermanButtonClicked(reply);
/*Generated! Do not modify!*/         } else if ("widgetButtonNewButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onNewButtonClicked(reply);
/*Generated! Do not modify!*/         } else if ("widgetButtonExportButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onExportButtonClicked(reply);
/*Generated! Do not modify!*/         } else if ("widgetButtonSearchButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onSearchButtonClicked(reply, (String)parameters.get("searchNameTextFieldText"));
/*Generated! Do not modify!*/         } else if ("onContactsTableEditButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onContactsTableEditButtonClicked(reply, (String)parameters.get("rowID"));
/*Generated! Do not modify!*/         } else if ("onContactsTableDeleteButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onContactsTableDeleteButtonClicked(reply, (String)parameters.get("rowID"));
/*Generated! Do not modify!*/         } else if ("onContactsTableRowClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onContactsTableRowClicked(reply, (String)parameters.get("rowID"));
/*Generated! Do not modify!*/         } else if ("onLoaded".equals(action)) {
/*Generated! Do not modify!*/             listener.onLoaded(reply, gson.fromJson((String)parameters.get("_ClientProperties"), FLUIClientPropertiesDTO.class));
/*Generated! Do not modify!*/         } else if ("onInputDialogResult".equals(action)) {
/*Generated! Do not modify!*/             onStringInputDialogResult(reply, action, parameters);
/*Generated! Do not modify!*/         } else if ("onConfirmDialogResult".equals(action)) {
/*Generated! Do not modify!*/             onConfirmDialogResult(reply, action, parameters);
/*Generated! Do not modify!*/         } else if ("onListChooserResult".equals(action)) {
/*Generated! Do not modify!*/             onListChooserDialogResult(reply, action, parameters);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return reply;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void onConfirmDialogResult(OverviewLargeReply reply, String action, Map<String, Object> parameters) {
/*Generated! Do not modify!*/         String callbackDataString = (String)parameters.get("callbackData");
/*Generated! Do not modify!*/         String referenceID = (String)parameters.get("referenceID");
/*Generated! Do not modify!*/         boolean result = (boolean)parameters.get("result");
/*Generated! Do not modify!*/         if (callbackDataString == null){
/*Generated! Do not modify!*/             listener.onConfirmDialogResult(reply, referenceID, result);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         CallbackMethodCall callback = gson.fromJson(callbackDataString, CallbackMethodCall.class);
/*Generated! Do not modify!*/         Map<String, Object> callbackMethodParameters = callback.getParameterValues();
/*Generated! Do not modify!*/         switch (callback.getCallbackMethodIndex()) {
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     private void onStringInputDialogResult(OverviewLargeReply reply, String action, Map<String, Object> parameters) {
/*Generated! Do not modify!*/         String callbackDataString = (String)parameters.get("callbackData");
/*Generated! Do not modify!*/         String referenceID = (String)parameters.get("referenceID");
/*Generated! Do not modify!*/         String result = (String)parameters.get("result");
/*Generated! Do not modify!*/         if (callbackDataString == null){
/*Generated! Do not modify!*/             listener.onInputDialogResult(reply, referenceID, result);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         CallbackMethodCall callback = gson.fromJson(callbackDataString, CallbackMethodCall.class);
/*Generated! Do not modify!*/         Map<String, Object> callbackMethodParameters = callback.getParameterValues();
/*Generated! Do not modify!*/         switch (callback.getCallbackMethodIndex()) {
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     private void onListChooserDialogResult(OverviewLargeReply reply, String action, Map<String, Object> parameters) {
/*Generated! Do not modify!*/         String callbackDataString = (String)parameters.get("callbackData");
/*Generated! Do not modify!*/         String referenceID = (String)parameters.get("referenceID");
/*Generated! Do not modify!*/         java.util.List<String> result = (java.util.List<String>)parameters.get("selectedIDs");
/*Generated! Do not modify!*/         if (callbackDataString == null){
/*Generated! Do not modify!*/             listener.onListChooserResult(reply, referenceID, result);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         CallbackMethodCall callback = gson.fromJson(callbackDataString, CallbackMethodCall.class);
/*Generated! Do not modify!*/         Map<String, Object> callbackMethodParameters = callback.getParameterValues();
/*Generated! Do not modify!*/         switch (callback.getCallbackMethodIndex()) {
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public String getID() {
/*Generated! Do not modify!*/         return "overviewLarge";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }