package generated.fliesenui.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FLUIReplyDTO {
    private Set<String> dtosToSet;
    private Set<String> variablesToSet;
    private Set<String> objectsToSetValue;
    private Map<String, Object> variableValues;
    private Map<String, Object> dtoValues;
    private Map<String, Object> objectSetValueValues;
    private Map<String, String> selectBoxSelectedIDs;
    private Map<String, List<TextHighlighting>> textHighlighting;
    private Map<String, CursorPos> cursorPosValues;
    private Map<String, ContextAssist> contextAssists;
    private ConfirmDialogParameters confirmDialogParameters;
    private InputDialogParameters inputDialogParameters;
    private String urlToOpen;
    private Boolean openURLInNewWindow;
    private String screenToOpen;
    private Object openParameter;
    private String downloadFileStreamID;
    
    private FLUIMessage message;
    private String nextPageToOpen;

    public Set<String> getDTOsToSet() {
        return dtosToSet;
    }

    public void setDTOsToSet(Set<String> dtosToSet) {
        this.dtosToSet = dtosToSet;
    }

    public Set<String> getVariablesToSet() {
        return variablesToSet;
    }

    public void setVariablesToSet(Set<String> variablesToSet) {
        this.variablesToSet = variablesToSet;
    }

    public Map<String, Object> getVariableValues() {
        return variableValues;
    }

    public void setVariableValues(Map<String, Object> variableValues) {
        this.variableValues = variableValues;
    }

    public Map<String, Object> getDTOValues() {
        return dtoValues;
    }

    public void setDTOValues(Map<String, Object> dtoValues) {
        this.dtoValues = dtoValues;
    }

    public String getNextPageToOpen() {
        return nextPageToOpen;
    }

    public void setNextPageToOpen(String nextPageToOpen) {
        this.nextPageToOpen = nextPageToOpen;
    }

    public FLUIMessage getMessage() {
        return message;
    }

    public void setMessage(FLUIMessage message) {
        this.message = message;
    }

    public Set<String> getObjectsToSetValue() {
        return objectsToSetValue;
    }

    public void setObjectsToSetValue(Set<String> objectsToSetValue) {
        this.objectsToSetValue = objectsToSetValue;
    }

    public Map<String, Object> getObjectSetValueValues() {
        return objectSetValueValues;
    }

    public void setObjectSetValueValues(Map<String, Object> objectSetValueValues) {
        this.objectSetValueValues = objectSetValueValues;
    }

    public Map<String, List<TextHighlighting>> getTextHighlighting() {
        return textHighlighting;
    }

    public void setTextHighlighting(Map<String, List<TextHighlighting>> textHighlighting) {
        this.textHighlighting = textHighlighting;
    }

    public Map<String, CursorPos> getCursorPosValues() {
        return cursorPosValues;
    }

    public void setCursorPosValues(Map<String, CursorPos> cursorPosValues) {
        this.cursorPosValues = cursorPosValues;
    }

    public Map<String, ContextAssist> getContextAssists() {
        return contextAssists;
    }

    public void setContextAssists(Map<String, ContextAssist> contextAssists) {
        this.contextAssists = contextAssists;
    }

    public ConfirmDialogParameters getConfirmDialogParameters() {
        return confirmDialogParameters;
    }

    public void setConfirmDialogParameters(ConfirmDialogParameters confirmDialogParameters) {
        this.confirmDialogParameters = confirmDialogParameters;
    }

    public InputDialogParameters getInputDialogParameters() {
        return inputDialogParameters;
    }

    public void setInputDialogParameters(InputDialogParameters inputDialogParameters) {
        this.inputDialogParameters = inputDialogParameters;
    }

	public String getURLToOpen() {
		return urlToOpen;
	}

	public void setURLToOpen(String urlToOpen) {
		this.urlToOpen = urlToOpen;
	}

	public String getScreenToOpen() {
		return screenToOpen;
	}

	public void setScreenToOpen(String screenToOpen) {
		this.screenToOpen = screenToOpen;
	}

	public Object getOpenParameter() {
		return openParameter;
	}

	public void setOpenParameter(Object openParameter) {
		this.openParameter = openParameter;
	}

	public Map<String, String> getSelectBoxSelectedIDs() {
		return selectBoxSelectedIDs;
	}

	public void setSelectBoxSelectedIDs(Map<String, String> selectBoxSelectedIDs) {
		this.selectBoxSelectedIDs = selectBoxSelectedIDs;
	}

	public Boolean getOpenURLInNewWindow() {
		return openURLInNewWindow;
	}

	public void setOpenURLInNewWindow(Boolean openURLInNewWindow) {
		this.openURLInNewWindow = openURLInNewWindow;
	}

	public String getDownloadFileStreamID() {
		return downloadFileStreamID;
	}

	public void setDownloadFileStreamID(String downloadFileStreamID) {
		this.downloadFileStreamID = downloadFileStreamID;
	}

}