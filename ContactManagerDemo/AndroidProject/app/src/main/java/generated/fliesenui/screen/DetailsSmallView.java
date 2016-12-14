/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreen;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactTypeListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class DetailsSmallView implements FLUIScreen {
/*Generated! Do not modify!*/     private DetailsSmallListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsSmallView(DetailsSmallListener listener) {
/*Generated! Do not modify!*/         this.listener = listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String onFLUIRequest(FLUIRequest request, String uploadedFileName, InputStream uploadedFileInputStream) {
/*Generated! Do not modify!*/         Map<String, Object> parameters = request.getParameters();
/*Generated! Do not modify!*/         String action = request.getAction();
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         DetailsSmallReply reply = new DetailsSmallReply();
/*Generated! Do not modify!*/         if ("widgetButtonOpenWebSiteButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onOpenWebSiteButtonClicked(reply, gson.fromJson((String)parameters.get("contact"), ContactDTO.class));
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
/*Generated! Do not modify!*/         } else if ("onInputDialogResult".equals(action)) {
/*Generated! Do not modify!*/             listener.onInputDialogResult(reply, (String)parameters.get("referenceID"), (String)parameters.get("result"));
/*Generated! Do not modify!*/         } else if ("onConfirmDialogResult".equals(action)) {
/*Generated! Do not modify!*/             listener.onConfirmDialogResult(reply, (String)parameters.get("referenceID"), (boolean)parameters.get("result"));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return reply.getJSON();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public String getID() {
/*Generated! Do not modify!*/         return "detailsSmall";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }