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
/*Generated! Do not modify!*/ import generated.fliesenui.dto.ContactListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class OverviewLargeView implements FLUIScreen {
/*Generated! Do not modify!*/     private OverviewLargeListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewLargeView(OverviewLargeListener listener) {
/*Generated! Do not modify!*/         this.listener = listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String onFLUIRequest(FLUIRequest request, String uploadedFileName, InputStream uploadedFileInputStream) {
/*Generated! Do not modify!*/         Map<String, Object> parameters = request.getParameters();
/*Generated! Do not modify!*/         String action = request.getAction();
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         OverviewLargeReply reply = new OverviewLargeReply();
/*Generated! Do not modify!*/         if ("widgetButtonNewButtonClicked".equals(action)) {
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
/*Generated! Do not modify!*/         return "overviewLarge";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }