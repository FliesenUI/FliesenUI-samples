/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import java.io.ByteArrayOutputStream;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import java.nio.charset.Charset;
/*Generated! Do not modify!*/ import java.io.OutputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsLargeView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsLargeListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsSmallView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsSmallListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewLargeView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewLargeListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewSmallView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewSmallListener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIScreenManager implements FLUIScreenManagerInterface{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static final String FILE_UPLOAD_FORM_REQUEST_PARAMETER_NAME = "requestData";
/*Generated! Do not modify!*/     public static final String FILE_UPLOAD_FORM_FILE_PARAMETER_NAME = "uploadedFile";
/*Generated! Do not modify!*/     private static final String RESOURCE_BASE_DIR = "generated/fliesenui/web";
/*Generated! Do not modify!*/     private static final String TEXT_CHARSET = "UTF-8";
/*Generated! Do not modify!*/     private FLUIWebView webView;
/*Generated! Do not modify!*/     private boolean singlePageApp = true;
/*Generated! Do not modify!*/     private FLUIScreenManagerListener listener;
/*Generated! Do not modify!*/     private FLUIWebCallHandler fluiWebCallHandler = new FLUIWebCallHandler(this);
/*Generated! Do not modify!*/     private Map<String, FLUIScreen> screenIDToViewMap = new TreeMap<String, FLUIScreen>();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIScreenManager() {
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static FLUIScreenManager createInstance(boolean singlePageApp, FLUIScreenManagerListener listener) {
/*Generated! Do not modify!*/         FLUIScreenManager result = new FLUIScreenManager();
/*Generated! Do not modify!*/         result.singlePageApp = singlePageApp;
/*Generated! Do not modify!*/         result.listener = listener;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static FLUIScreenManager createInstance(FLUIScreenManagerListener listener) {
/*Generated! Do not modify!*/         FLUIScreenManager result = new FLUIScreenManager();
/*Generated! Do not modify!*/         result.singlePageApp = true;
/*Generated! Do not modify!*/         result.listener = listener;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static FLUIScreenManager createSimpleInstance() {
/*Generated! Do not modify!*/         FLUIScreenManager result = new FLUIScreenManager();
/*Generated! Do not modify!*/         result.singlePageApp = true;
/*Generated! Do not modify!*/         result.listener = new SimpleManagerListener();
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSinglePageApp(boolean singlePageApp) {
/*Generated! Do not modify!*/         this.singlePageApp = singlePageApp;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public boolean isSinglePageApp() {
/*Generated! Do not modify!*/         return singlePageApp;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIImageStream getCustomImageStream(String imageStreamID) {
/*Generated! Do not modify!*/         return listener.getCustomImageStream(imageStreamID);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIFileStream getFileStream(String fileStreamID) {
/*Generated! Do not modify!*/         return listener.getFileStream(fileStreamID);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setWebView(FLUIWebView webView) {
/*Generated! Do not modify!*/         this.webView = webView;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIScreenManagerListener getListener() {
/*Generated! Do not modify!*/         return listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void handleWebCall(FLUIWebCall webCall, String method, String requestPath) throws Exception {
/*Generated! Do not modify!*/         fluiWebCallHandler.handle(webCall, method, requestPath);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void handleWebUpload(FLUIWebCall webCall, String requestJSON, String uploadFilename, InputStream uploadFileInputStream) throws Exception {
/*Generated! Do not modify!*/         fluiWebCallHandler.handleUpload(webCall, requestJSON, uploadFilename, uploadFileInputStream);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openStartScreen() {
/*Generated! Do not modify!*/         String urlSuffix = null;
/*Generated! Do not modify!*/ //        if (object != null){
/*Generated! Do not modify!*/ //            try {
/*Generated! Do not modify!*/ //                urlSuffix = "?parameterDTO=" + FLUIUtil.toURLParameter(object);
/*Generated! Do not modify!*/ //            } catch (Exception e){
/*Generated! Do not modify!*/ //                listener.onError(e);
/*Generated! Do not modify!*/ //            }
/*Generated! Do not modify!*/ //        }
/*Generated! Do not modify!*/         if (singlePageApp){
/*Generated! Do not modify!*/             webView.openScreen("overviewLarge", "_jfx_app.html", urlSuffix, singlePageApp);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             webView.openScreen("overviewLarge", "overviewLarge_jfx.html", urlSuffix, singlePageApp);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private String getStartWebPageFilename() {
/*Generated! Do not modify!*/         if (singlePageApp){
/*Generated! Do not modify!*/             return "_web_app.html";
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             return "overviewLarge_web.html";
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String getStartWebPageAsString() throws Exception{
/*Generated! Do not modify!*/         return getResourceAsString(getStartWebPageFilename());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String getResourceAsString(String relativeLocation) throws Exception{
/*Generated! Do not modify!*/         InputStream inputStream = null;
/*Generated! Do not modify!*/         String useRelativeLocation = relativeLocation;
/*Generated! Do not modify!*/         if (!useRelativeLocation.startsWith("/")){
/*Generated! Do not modify!*/             useRelativeLocation = "/" + useRelativeLocation;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         String location = null;
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             location = "/" + RESOURCE_BASE_DIR + useRelativeLocation;
/*Generated! Do not modify!*/             inputStream = this.getClass().getResourceAsStream(location);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw new Exception("Could not get internal URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'", e);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         if (inputStream == null){
/*Generated! Do not modify!*/             throw new Exception("Could not get input stream URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             writeAllBytesToStream(inputStream, outputStream);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw e;
/*Generated! Do not modify!*/         } finally {
/*Generated! Do not modify!*/             if (inputStream != null) {
/*Generated! Do not modify!*/                 inputStream.close();
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         
/*Generated! Do not modify!*/         String text = new String(outputStream.toByteArray(), Charset.forName(TEXT_CHARSET));
/*Generated! Do not modify!*/         return text;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void writeResource(String relativeLocation, OutputStream outputStream) throws Exception{
/*Generated! Do not modify!*/         InputStream inputStream = null;
/*Generated! Do not modify!*/         String useRelativeLocation = relativeLocation;
/*Generated! Do not modify!*/         if (!useRelativeLocation.startsWith("/")){
/*Generated! Do not modify!*/             useRelativeLocation = "/" + useRelativeLocation;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         String location = null;
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             location = "/" + RESOURCE_BASE_DIR + useRelativeLocation;
/*Generated! Do not modify!*/             inputStream = this.getClass().getResourceAsStream(location);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw new Exception("Could not get internal URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'", e);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         if (inputStream == null){
/*Generated! Do not modify!*/             throw new Exception("Could not get input stream URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             writeAllBytesToStream(inputStream, outputStream);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw e;
/*Generated! Do not modify!*/         } finally {
/*Generated! Do not modify!*/             if (inputStream != null) {
/*Generated! Do not modify!*/                 inputStream.close();
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void writeAllBytesToStream(InputStream inputStream, OutputStream outputStream) throws Exception {
/*Generated! Do not modify!*/         int readBytes;
/*Generated! Do not modify!*/         byte[] buffer = new byte[4096];
/*Generated! Do not modify!*/         while ((readBytes = inputStream.read(buffer)) > 0) {
/*Generated! Do not modify!*/             outputStream.write(buffer, 0, readBytes);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public void setDetailsLargePresenter(DetailsLargeListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("detailsLarge", new DetailsLargeView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDetailsSmallPresenter(DetailsSmallListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("detailsSmall", new DetailsSmallView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOverviewLargePresenter(OverviewLargeListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("overviewLarge", new OverviewLargeView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOverviewSmallPresenter(OverviewSmallListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("overviewSmall", new OverviewSmallView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void reply(String screenID, String json) {
/*Generated! Do not modify!*/         if (webView != null){
/*Generated! Do not modify!*/             webView.executeWithResultString(screenID + "$processReply(\"" + FLUIUtil.reescapeEscapeCharacters(json) + "\");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String onRequest(String requestJSON, String uploadFileName, InputStream uploadFileInputStream) {
/*Generated! Do not modify!*/         String replyJSON = null;
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             FLUIRequest request = new Gson().fromJson(requestJSON, FLUIRequest.class);
/*Generated! Do not modify!*/             listener.onRequest(request);
/*Generated! Do not modify!*/             FLUIScreen view = screenIDToViewMap.get(request.getScreenID());
/*Generated! Do not modify!*/             if (view != null){
/*Generated! Do not modify!*/                 replyJSON = view.onFLUIRequest(request, uploadFileName, uploadFileInputStream);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             if (replyJSON != null){
/*Generated! Do not modify!*/                 reply(request.getScreenID(), replyJSON);
/*Generated! Do not modify!*/             } else {
/*Generated! Do not modify!*/                 listener.onWarning(new Exception("No presenter defined for screen '" + request.getScreenID() + "'"));
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         } catch (Throwable error){
/*Generated! Do not modify!*/             listener.onError(error);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return replyJSON;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }