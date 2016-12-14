package generated.fliesenui.core;

import java.io.InputStream;
import java.io.OutputStream;

public interface FLUIScreenManagerInterface {
	String onRequest(String requestJSON, String uploadFileName, InputStream uploadFileInputStream);
	FLUIScreenManagerListener getListener();
	FLUIImageStream getCustomImageStream(String imageStreamID);
	FLUIFileStream getFileStream(String fileStreamID);
	void writeResource(String relativeLocation, OutputStream outputStream) throws Exception;
	String getStartWebPageAsString() throws Exception;
	String getResourceAsString(String relativeLocation) throws Exception;
}
