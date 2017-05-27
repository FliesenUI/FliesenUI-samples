/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import java.io.OutputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsLargeListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsSmallListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewLargeListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewSmallListener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface FLUIScreenManagerInterface {
/*Generated! Do not modify!*/     String onRequest(String requestJSON, String uploadFileName, InputStream uploadFileInputStream);
/*Generated! Do not modify!*/     FLUIScreenManagerListener getListener();
/*Generated! Do not modify!*/     FLUIImageStream getCustomImageStream(String imageStreamID);
/*Generated! Do not modify!*/     FLUIFileStream getFileStream(String fileStreamID);
/*Generated! Do not modify!*/     void writeResource(String relativeLocation, OutputStream outputStream) throws Exception;
/*Generated! Do not modify!*/     String getStartWebPageAsString() throws Exception;
/*Generated! Do not modify!*/     String getResourceAsString(String relativeLocation) throws Exception;
/*Generated! Do not modify!*/     void setDetailsLargePresenter(DetailsLargeListener presenter);
/*Generated! Do not modify!*/     void setDetailsSmallPresenter(DetailsSmallListener presenter);
/*Generated! Do not modify!*/     void setOverviewLargePresenter(OverviewLargeListener presenter);
/*Generated! Do not modify!*/     void setOverviewSmallPresenter(OverviewSmallListener presenter);
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 