package generated.fliesenui.core;

import com.google.gson.Gson;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.io.OutputStream;


public class FLUITestWriter{
    private int dtoIndex = 0;
    private int listIndex = 0;
    private Gson gson = new Gson();
    private Set<String> declaredCreateStepDTOMethods = new HashSet<String>();

    public StringBuilder writeRequest(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        String requestClassName = Character.toUpperCase(requestData.getScreenID().charAt(0)) + requestData.getScreenID().substring(1) + "Request";
        result.append(requestClassName + " request = ");
        if (requestData.getScreenID().equals("helloWorld")){
            result.append(requestClassName + "." + createScreenHelloWorldFactoryMethod(step, requestData) + ";");
        } else {
            throw new Exception("Unknown screen id: '" + requestData.getScreenID() + "'");
        }
        return result;
    }

    public StringBuilder writeCreateDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getScreenID().equals("helloWorld")){
            result.append(createScreenHelloWorldDTOMethods(step, requestData));
        } else {
            throw new Exception("Unknown screen id: '" + requestData.getScreenID() + "'");
        }
        return result;
    }
    public StringBuilder createSetDTOObjectCode(String indent, String prefix, int loopDepth, String currentDTOName, Object dto, String className){
        return null;
    }
    public Object createDTOInstanceByClassName(String className){
        return null;
    }
    private String createScreenHelloWorldFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonGreetButtonClicked")){
            return "createOnGreetButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("nameTextFieldText")) + ")";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties())";
        } else if (requestData.getAction().equals("onInputDialogResult")){
            return "createOnInputDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + quoteIfNotNull((String)p.get("result")) + ")";
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
            return "createOnConfirmDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + p.get("result") + ")";
        } else if (requestData.getAction().equals("onListChooserResult")){
            return "createOnListChooserResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + toStringList((List<String>)p.get("selectedIDs")) + ")";
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
    }

    private StringBuilder createScreenHelloWorldDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonGreetButtonClicked")){
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenHelloWorldDTO1MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenHelloWorldDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        FLUIClientPropertiesDTO dto = gson.fromJson((String)requestData.getParameters().get("_ClientProperties"), FLUIClientPropertiesDTO.class);
        String declaration = "private FLUIClientPropertiesDTO createStep" + step + "DTO1_ClientProperties()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();\n");
        result.append(createSetDTOFLUIClientPropertiesDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createSetDTOFLUIClientPropertiesDTO(String indent, String prefix, int loopDepth, String currentDTOName, FLUIClientPropertiesDTO dto){
         StringBuilder result = new StringBuilder();
         result.append(indent + prefix + ".setUserAgent(" + quoteIfNotNull(dto.getUserAgent()) + ");\n");
         result.append(indent + prefix + ".setNavigatorLanguage(" + quoteIfNotNull(dto.getNavigatorLanguage()) + ");\n");
         result.append(indent + prefix + ".setScreenAvailableWidthInPixels(" + dto.getScreenAvailableWidthInPixels() + ");\n");
         result.append(indent + prefix + ".setScreenAvailableHeightInPixels(" + dto.getScreenAvailableHeightInPixels() + ");\n");
         result.append(indent + prefix + ".setScreenWidthInPixels(" + dto.getScreenWidthInPixels() + ");\n");
         result.append(indent + prefix + ".setScreenHeightInPixels(" + dto.getScreenHeightInPixels() + ");\n");
         result.append(indent + prefix + ".setWindowInnerWidthInPixels(" + dto.getWindowInnerWidthInPixels() + ");\n");
         result.append(indent + prefix + ".setWindowInnerHeightInPixels(" + dto.getWindowInnerHeightInPixels() + ");\n");
         result.append(indent + prefix + ".setPixelHeightPerCM(" + dto.getPixelHeightPerCM() + ");\n");
         result.append(indent + prefix + ".setPixelWidthPerCM(" + dto.getPixelWidthPerCM() + ");\n");
         result.append(indent + prefix + ".setPixelHeightPerInch(" + dto.getPixelHeightPerInch() + ");\n");
         result.append(indent + prefix + ".setPixelWidthPerInch(" + dto.getPixelWidthPerInch() + ");\n");
         result.append(indent + prefix + ".setScreenWidthInCM(" + dto.getScreenWidthInCM() + ");\n");
         result.append(indent + prefix + ".setScreenHeightInCM(" + dto.getScreenHeightInCM() + ");\n");
         result.append(indent + prefix + ".setScreenWidthInInch(" + dto.getScreenWidthInInch() + ");\n");
         result.append(indent + prefix + ".setScreenHeightInInch(" + dto.getScreenHeightInInch() + ");\n");
         result.append(indent + prefix + ".setScreenDiagonalInInch(" + dto.getScreenDiagonalInInch() + ");\n");
         result.append(indent + prefix + ".setErrorMessage(" + quoteIfNotNull(dto.getErrorMessage()) + ");\n");
         return result;
    }

    public StringBuilder generateImports(){
        StringBuilder result = new StringBuilder();
        result.append("import generated.fliesenui.screen.HelloWorldRequest;\n");
        result.append("import generated.fliesenui.screen.HelloWorldReply;\n");
         return result;
    }

    public StringBuilder generateSetPresenterStubs(){
        StringBuilder result = new StringBuilder();
        result.append("        screenManager.setHelloWorldPresenter(/* TODO: Add presenter HelloWorld*/);\n");
         return result;
    }

    private int getNextDTOIndex(){
        return ++dtoIndex;
    }

    private int getNextListIndex(){
        return ++listIndex;
    }

    private String quoteIfNotNull(String string){
        if (string == null){
            return "null";
        }
        return "\"" + string + "\"";
    }

    private String toStringList(List<String> list){
        StringBuilder result = new StringBuilder();
        if (list == null){
            return "null";
        }
        result.append("Arrays.asList(");
        boolean first = true;
        for (String i: list){
            if (first){
                first = false;
            } else {
                result.append(", ");
            }
            if (i == null){
                result.append("null");
            } else {
                result.append("\"" + i + "\"");
            }
        }
        result.append(")");
        return result.toString();
    }

}