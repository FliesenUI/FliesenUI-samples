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
/*Generated! Do not modify!*/ public class DetailsSmallView implements FLUIScreen {
/*Generated! Do not modify!*/     private DetailsSmallListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsSmallView(DetailsSmallListener listener) {
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
/*Generated! Do not modify!*/         DetailsSmallReply reply = new DetailsSmallReply(recordMode, currentLanguage);
/*Generated! Do not modify!*/         if ("widgetButtonOpenWebSiteButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onOpenWebSiteButtonClicked(reply, gson.fromJson((String)parameters.get("contact"), ContactDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonSetPreferredMusicButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onSetPreferredMusicButtonClicked(reply, gson.fromJson((String)parameters.get("contact"), ContactDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonSaveButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onSaveButtonClicked(reply, gson.fromJson((String)parameters.get("contact"), ContactDTO.class), (String)parameters.get("typeSelectBoxSelectedID"));
/*Generated! Do not modify!*/         } else if ("widgetButtonCancelButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onCancelButtonClicked(reply);
/*Generated! Do not modify!*/         } else if ("onTypeSelectBoxChanged".equals(action)) {
/*Generated! Do not modify!*/             listener.onTypeSelectBoxChanged(reply, (String)parameters.get("rowID"));
/*Generated! Do not modify!*/         } else if ("onLoaded".equals(action)) {
/*Generated! Do not modify!*/             listener.onLoaded(reply, gson.fromJson((String)parameters.get("_ClientProperties"), FLUIClientPropertiesDTO.class), gson.fromJson((String)parameters.get("contact"), ContactDTO.class));
/*Generated! Do not modify!*/         } else if ("onProfileImageFileUploadFileUpload".equals(action)) {
/*Generated! Do not modify!*/             listener.onProfileImageFileUploadFileUpload(uploadedFileName, uploadedFileInputStream, gson.fromJson((String)parameters.get("contact"), ContactDTO.class));
/*Generated! Do not modify!*/         } else if ("onProfileImageFileUploadFileUploadFinished".equals(action)) {
/*Generated! Do not modify!*/             listener.onProfileImageFileUploadFileUploadFinished(reply, gson.fromJson((String)parameters.get("contact"), ContactDTO.class));
/*Generated! Do not modify!*/         } else if ("onBackPressed".equals(action)) {
/*Generated! Do not modify!*/             listener.onBackPressed(reply);
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
/*Generated! Do not modify!*/     private void onConfirmDialogResult(DetailsSmallReply reply, String action, Map<String, Object> parameters) {
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
/*Generated! Do not modify!*/     private void onStringInputDialogResult(DetailsSmallReply reply, String action, Map<String, Object> parameters) {
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
/*Generated! Do not modify!*/     private void onListChooserDialogResult(DetailsSmallReply reply, String action, Map<String, Object> parameters) {
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
/*Generated! Do not modify!*/         return "detailsSmall";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }