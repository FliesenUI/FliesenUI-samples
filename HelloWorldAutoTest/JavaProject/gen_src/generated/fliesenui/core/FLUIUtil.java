package generated.fliesenui.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FLUIUtil {
    private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd;HH:mm:ss");

	private static final String ENCODING = "UTF-8";
	
	public static void writeFile(File file, String text) throws Exception{
		writeFile(file, text, false);
	}
	
	public static void writeFile(File file, String text, boolean append) throws Exception{
		Writer out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING));
			out.append(text);
			out.flush();
		} catch (Exception e){
			throw e;
		} finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	public static String readFile(File file) throws Exception{
	    StringBuilder result = new StringBuilder();
	    BufferedReader in = null;
	    try {
	    	in = new BufferedReader(new InputStreamReader(new FileInputStream(file), ENCODING));
	    	String line;
	    	while ((line = in.readLine()) != null) {
	    		result.append(line);
	    		result.append("\n");
			}
	    } catch (Exception e){
	    	throw e;
	    } finally {
	    	in.close();
	    }
	    return result.toString();
	}
    
    public static TextHighlighting createErrorTextHighlighting(int startLine, int startPosInLine, int endLine, int endPosInLine) {
        TextHighlighting result = new TextHighlighting();
        result.setStartLine(startLine);
        result.setStartPosInLine(startPosInLine);
        result.setEndLine(endLine);
        result.setEndPosInLine(endPosInLine);
        result.setStyle("textHighlightError");
        return result;
    }

    public static TextHighlighting createWarningTextHighlighting(int startLine, int startPosInLine, int endLine, int endPosInLine) {
        TextHighlighting result = new TextHighlighting();
        result.setStartLine(startLine);
        result.setStartPosInLine(startPosInLine);
        result.setEndLine(endLine);
        result.setEndPosInLine(endPosInLine);
        result.setStyle("textHighlightWarning");
        return result;
    }

    public static CursorPos createCursorPos(int line, int posInLine) {
        CursorPos result = new CursorPos();
        result.setLine(line);
        result.setPosInLine(posInLine);
        return result;
    }

    public static ContextAssistChoice createContextAssistChoice(String label, String text) {
        ContextAssistChoice result = new ContextAssistChoice();
        result.setLabel(label);
        result.setText(text);
        return result;
    }

    public static String toActionLogString(FLUIRequest request) {
    	if (request == null){
    		return null;
    	}
        String json = new Gson().toJson(request);
        json = json.replace("\\", "\\\\").replace("\n", "\\n");
        return TIMESTAMP_FORMAT.format(new Date()) + ";" + request.getScreenID() + ";" + request.getAction() + ";" + json;
    }
    
//    public static String toURLParameter(Object object){
//    	String json = new Gson().toJson(object);
//    	byte[] bytes = null;
//    	try{
//    		bytes = json.getBytes("UTF-8");
//    	} catch (Exception e){
//    		throw new RuntimeException("could not get bytes of string '" + json + "' in UTF-8!");
//    	}
//    	String base64 = Base64.getEncoder().encodeToString(bytes);
//    	return base64.replace("+", "-").replace("/", "_").replace("=", "~");
//    }
    
    public static String reescapeEscapeCharacters(String string) {
        return string.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r");
    }

    public static void saveActionRecording(FLUIActionRecording recording, File file) throws Exception{
        writeFile(file, new GsonBuilder().setPrettyPrinting().create().toJson(recording));
    }

    public static FLUIActionRecording loadActionRecording(File file) throws Exception{
    	String json = readFile(file);
    	return new Gson().fromJson(json, FLUIActionRecording.class);
    }

}
