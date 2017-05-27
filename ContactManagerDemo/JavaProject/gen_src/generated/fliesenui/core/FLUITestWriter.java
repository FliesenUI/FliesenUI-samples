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

import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.dto.ContactListDTO;
import generated.fliesenui.dto.ContactTypeDTO;
import generated.fliesenui.dto.ContactTypeListDTO;

public class FLUITestWriter{
    private int dtoIndex = 0;
    private int listIndex = 0;
    private Gson gson = new Gson();
    private Set<String> declaredCreateStepDTOMethods = new HashSet<String>();

    public StringBuilder writeRequest(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        String requestClassName = Character.toUpperCase(requestData.getScreenID().charAt(0)) + requestData.getScreenID().substring(1) + "Request";
        result.append(requestClassName + " request = ");
        if (requestData.getScreenID().equals("detailsLarge")){
            result.append(requestClassName + "." + createScreenDetailsLargeFactoryMethod(step, requestData) + ";");
        } else if (requestData.getScreenID().equals("detailsSmall")){
            result.append(requestClassName + "." + createScreenDetailsSmallFactoryMethod(step, requestData) + ";");
        } else if (requestData.getScreenID().equals("overviewLarge")){
            result.append(requestClassName + "." + createScreenOverviewLargeFactoryMethod(step, requestData) + ";");
        } else if (requestData.getScreenID().equals("overviewSmall")){
            result.append(requestClassName + "." + createScreenOverviewSmallFactoryMethod(step, requestData) + ";");
        } else {
            throw new Exception("Unknown screen id: '" + requestData.getScreenID() + "'");
        }
        return result;
    }

    public StringBuilder writeCreateDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getScreenID().equals("detailsLarge")){
            result.append(createScreenDetailsLargeDTOMethods(step, requestData));
        } else if (requestData.getScreenID().equals("detailsSmall")){
            result.append(createScreenDetailsSmallDTOMethods(step, requestData));
        } else if (requestData.getScreenID().equals("overviewLarge")){
            result.append(createScreenOverviewLargeDTOMethods(step, requestData));
        } else if (requestData.getScreenID().equals("overviewSmall")){
            result.append(createScreenOverviewSmallDTOMethods(step, requestData));
        } else {
            throw new Exception("Unknown screen id: '" + requestData.getScreenID() + "'");
        }
        return result;
    }
    public StringBuilder createSetDTOContactDTO(String indent, String prefix, int loopDepth, String currentDTOName, ContactDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setId(" + quoteIfNotNull((String)dto.getId()) + ");\n");
         result.append(indent + prefix + ".setTypeID(" + quoteIfNotNull((String)dto.getTypeID()) + ");\n");
         result.append(indent + prefix + ".setProfileImage(" + quoteIfNotNull((String)dto.getProfileImage()) + ");\n");
         result.append(indent + prefix + ".setTypeImageAsset(" + quoteIfNotNull((String)dto.getTypeImageAsset()) + ");\n");
         result.append(indent + prefix + ".setFirstname(" + quoteIfNotNull((String)dto.getFirstname()) + ");\n");
         result.append(indent + prefix + ".setLastname(" + quoteIfNotNull((String)dto.getLastname()) + ");\n");
         result.append(indent + prefix + ".setPhone(" + quoteIfNotNull((String)dto.getPhone()) + ");\n");
         result.append(indent + prefix + ".setMobile(" + quoteIfNotNull((String)dto.getMobile()) + ");\n");
         result.append(indent + prefix + ".setStreet(" + quoteIfNotNull((String)dto.getStreet()) + ");\n");
         result.append(indent + prefix + ".setCountry(" + quoteIfNotNull((String)dto.getCountry()) + ");\n");
         result.append(indent + prefix + ".setState(" + quoteIfNotNull((String)dto.getState()) + ");\n");
         result.append(indent + prefix + ".setCity(" + quoteIfNotNull((String)dto.getCity()) + ");\n");
         result.append(indent + prefix + ".setPostalCode(" + quoteIfNotNull((String)dto.getPostalCode()) + ");\n");
         result.append(indent + prefix + ".setWebSite(" + quoteIfNotNull((String)dto.getWebSite()) + ");\n");
         listName = "list" + getNextListIndex();
         result.append("\n");
         if (dto.getPreferredMusic() != null){
             result.append(indent + "List<String> " + listName + " = new ArrayList<String>();\n");
             result.append(indent + prefix + ".setPreferredMusic(" + listName + ");\n");
             for (String i : dto.getPreferredMusic()){
                 result.append(indent + listName + ".add(\"" + i + "\");\n");
             }
         } else {
             result.append(indent + prefix + ".setPreferredMusic(null);\n");
         }
         return result;
    }

    public StringBuilder createSetDTOContactListDTO(String indent, String prefix, int loopDepth, String currentDTOName, ContactListDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         listName = "list" + getNextListIndex();
         result.append("\n");
         if (dto.getItems() != null){
             result.append(indent + "List<ContactDTO> " + listName + " = new ArrayList<ContactDTO>();\n");
             result.append(indent + prefix + ".setItems(" + listName + ");\n");
             for (ContactDTO i : dto.getItems()){
                 dtoName = "dto" + getNextDTOIndex();
                 result.append("\n");                 result.append(indent + "ContactDTO " + dtoName + " = new ContactDTO();\n");
                 result.append(indent + listName + ".add(" + dtoName + ");\n");
                 result.append(createSetDTOContactDTO(indent, dtoName, loopDepth + 1, dtoName, i));
                 result.append("\n");             }
         } else {
             result.append(indent + prefix + ".setItems(null);\n");
         }
         return result;
    }

    public StringBuilder createSetDTOContactTypeDTO(String indent, String prefix, int loopDepth, String currentDTOName, ContactTypeDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setId(" + quoteIfNotNull((String)dto.getId()) + ");\n");
         result.append(indent + prefix + ".setLabel(" + quoteIfNotNull((String)dto.getLabel()) + ");\n");
         result.append(indent + prefix + ".setImageAssetID(" + quoteIfNotNull((String)dto.getImageAssetID()) + ");\n");
         return result;
    }

    public StringBuilder createSetDTOContactTypeListDTO(String indent, String prefix, int loopDepth, String currentDTOName, ContactTypeListDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         listName = "list" + getNextListIndex();
         result.append("\n");
         if (dto.getItems() != null){
             result.append(indent + "List<ContactTypeDTO> " + listName + " = new ArrayList<ContactTypeDTO>();\n");
             result.append(indent + prefix + ".setItems(" + listName + ");\n");
             for (ContactTypeDTO i : dto.getItems()){
                 dtoName = "dto" + getNextDTOIndex();
                 result.append("\n");                 result.append(indent + "ContactTypeDTO " + dtoName + " = new ContactTypeDTO();\n");
                 result.append(indent + listName + ".add(" + dtoName + ");\n");
                 result.append(createSetDTOContactTypeDTO(indent, dtoName, loopDepth + 1, dtoName, i));
                 result.append("\n");             }
         } else {
             result.append(indent + prefix + ".setItems(null);\n");
         }
         return result;
    }

    public StringBuilder createSetDTOObjectCode(String indent, String prefix, int loopDepth, String currentDTOName, Object dto, String className){
        if (className.equals("ContactDTO")){
            return createSetDTOContactDTO(indent, prefix, loopDepth, currentDTOName, (ContactDTO) dto);
        } else if (className.equals("ContactListDTO")){
            return createSetDTOContactListDTO(indent, prefix, loopDepth, currentDTOName, (ContactListDTO) dto);
        } else if (className.equals("ContactTypeDTO")){
            return createSetDTOContactTypeDTO(indent, prefix, loopDepth, currentDTOName, (ContactTypeDTO) dto);
        } else if (className.equals("ContactTypeListDTO")){
            return createSetDTOContactTypeListDTO(indent, prefix, loopDepth, currentDTOName, (ContactTypeListDTO) dto);
        }
        return null;
    }
    public Object createDTOInstanceByClassName(String className){
        if (className.equals("ContactDTO")){
            return new ContactDTO();
        } else if (className.equals("ContactListDTO")){
            return new ContactListDTO();
        } else if (className.equals("ContactTypeDTO")){
            return new ContactTypeDTO();
        } else if (className.equals("ContactTypeListDTO")){
            return new ContactTypeListDTO();
        }
        return null;
    }
    private String createScreenDetailsLargeFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonOpenWebSiteButtonClicked")){
            return "createOnOpenWebSiteButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("widgetButtonSetPreferredMusicButtonClicked")){
            return "createOnSetPreferredMusicButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("widgetButtonSaveButtonClicked")){
            return "createOnSaveButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact(), " + quoteIfNotNull((String)p.get("typeSelectBoxSelectedID")) + ")";
        } else if (requestData.getAction().equals("widgetButtonCancelButtonClicked")){
            return "createOnCancelButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("onTypeSelectBoxChanged")){
            return "createOnTypeSelectBoxChangedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ")";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties(), createStep" + step + "DTO2Contact())";
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUpload")){
            return "createOnProfileImageFileUploadFileUploadRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUploadFinished")){
            return "createOnProfileImageFileUploadFileUploadFinishedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("onBackPressed")){
            return "createOnBackPressedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
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

    private String createScreenDetailsSmallFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonOpenWebSiteButtonClicked")){
            return "createOnOpenWebSiteButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("widgetButtonSetPreferredMusicButtonClicked")){
            return "createOnSetPreferredMusicButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("widgetButtonSaveButtonClicked")){
            return "createOnSaveButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact(), " + quoteIfNotNull((String)p.get("typeSelectBoxSelectedID")) + ")";
        } else if (requestData.getAction().equals("widgetButtonCancelButtonClicked")){
            return "createOnCancelButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("onTypeSelectBoxChanged")){
            return "createOnTypeSelectBoxChangedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ")";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties(), createStep" + step + "DTO2Contact())";
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUpload")){
            return "createOnProfileImageFileUploadFileUploadRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUploadFinished")){
            return "createOnProfileImageFileUploadFileUploadFinishedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Contact())";
        } else if (requestData.getAction().equals("onBackPressed")){
            return "createOnBackPressedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
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

    private String createScreenOverviewLargeFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonLanguageEnglishButtonClicked")){
            return "createOnLanguageEnglishButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonLanguageGermanButtonClicked")){
            return "createOnLanguageGermanButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonNewButtonClicked")){
            return "createOnNewButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonExportButtonClicked")){
            return "createOnExportButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonSearchButtonClicked")){
            return "createOnSearchButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("searchNameTextFieldText")) + ")";
        } else if (requestData.getAction().equals("onContactsTableEditButtonClicked")){
            return "createOnContactsTableEditButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ")";
        } else if (requestData.getAction().equals("onContactsTableDeleteButtonClicked")){
            return "createOnContactsTableDeleteButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ")";
        } else if (requestData.getAction().equals("onContactsTableRowClicked")){
            return "createOnContactsTableRowClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ")";
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

    private String createScreenOverviewSmallFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonLanguageEnglishButtonClicked")){
            return "createOnLanguageEnglishButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonLanguageGermanButtonClicked")){
            return "createOnLanguageGermanButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonNewButtonClicked")){
            return "createOnNewButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonExportButtonClicked")){
            return "createOnExportButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("widgetButtonSearchButtonClicked")){
            return "createOnSearchButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("searchNameTextFieldText")) + ")";
        } else if (requestData.getAction().equals("widgetButtonEditButtonClicked")){
            return "createOnEditButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1SelectedContact())";
        } else if (requestData.getAction().equals("widgetButtonDeleteButtonClicked")){
            return "createOnDeleteButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1SelectedContact())";
        } else if (requestData.getAction().equals("widgetButtonCancelButtonClicked")){
            return "createOnCancelButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ")";
        } else if (requestData.getAction().equals("onContactsTableRowClicked")){
            return "createOnContactsTableRowClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ")";
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

    private StringBuilder createScreenDetailsLargeDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonOpenWebSiteButtonClicked")){
            result.append(createScreenDetailsLargeDTO1MethodForActionWidgetButtonOpenWebSiteButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonSetPreferredMusicButtonClicked")){
            result.append(createScreenDetailsLargeDTO1MethodForActionWidgetButtonSetPreferredMusicButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonSaveButtonClicked")){
            result.append(createScreenDetailsLargeDTO1MethodForActionWidgetButtonSaveButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonCancelButtonClicked")){
        } else if (requestData.getAction().equals("onTypeSelectBoxChanged")){
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenDetailsLargeDTO1MethodForActionOnLoaded(step, requestData));
            result.append(createScreenDetailsLargeDTO2MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUpload")){
            result.append(createScreenDetailsLargeDTO1MethodForActionOnProfileImageFileUploadFileUpload(step, requestData));
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUploadFinished")){
            result.append(createScreenDetailsLargeDTO1MethodForActionOnProfileImageFileUploadFileUploadFinished(step, requestData));
        } else if (requestData.getAction().equals("onBackPressed")){
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonOpenWebSiteButtonClicked")){
            result.append(createScreenDetailsSmallDTO1MethodForActionWidgetButtonOpenWebSiteButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonSetPreferredMusicButtonClicked")){
            result.append(createScreenDetailsSmallDTO1MethodForActionWidgetButtonSetPreferredMusicButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonSaveButtonClicked")){
            result.append(createScreenDetailsSmallDTO1MethodForActionWidgetButtonSaveButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonCancelButtonClicked")){
        } else if (requestData.getAction().equals("onTypeSelectBoxChanged")){
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenDetailsSmallDTO1MethodForActionOnLoaded(step, requestData));
            result.append(createScreenDetailsSmallDTO2MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUpload")){
            result.append(createScreenDetailsSmallDTO1MethodForActionOnProfileImageFileUploadFileUpload(step, requestData));
        } else if (requestData.getAction().equals("onProfileImageFileUploadFileUploadFinished")){
            result.append(createScreenDetailsSmallDTO1MethodForActionOnProfileImageFileUploadFileUploadFinished(step, requestData));
        } else if (requestData.getAction().equals("onBackPressed")){
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenOverviewLargeDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonLanguageEnglishButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonLanguageGermanButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonNewButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonExportButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonSearchButtonClicked")){
        } else if (requestData.getAction().equals("onContactsTableEditButtonClicked")){
        } else if (requestData.getAction().equals("onContactsTableDeleteButtonClicked")){
        } else if (requestData.getAction().equals("onContactsTableRowClicked")){
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenOverviewLargeDTO1MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenOverviewSmallDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonLanguageEnglishButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonLanguageGermanButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonNewButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonExportButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonSearchButtonClicked")){
        } else if (requestData.getAction().equals("widgetButtonEditButtonClicked")){
            result.append(createScreenOverviewSmallDTO1MethodForActionWidgetButtonEditButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonDeleteButtonClicked")){
            result.append(createScreenOverviewSmallDTO1MethodForActionWidgetButtonDeleteButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonCancelButtonClicked")){
        } else if (requestData.getAction().equals("onContactsTableRowClicked")){
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenOverviewSmallDTO1MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenDetailsLargeDTO1MethodForActionWidgetButtonOpenWebSiteButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsLargeDTO1MethodForActionWidgetButtonSetPreferredMusicButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsLargeDTO1MethodForActionWidgetButtonSaveButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsLargeDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
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

    private StringBuilder createScreenDetailsLargeDTO2MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO2Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsLargeDTO1MethodForActionOnProfileImageFileUploadFileUpload(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsLargeDTO1MethodForActionOnProfileImageFileUploadFileUploadFinished(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTO1MethodForActionWidgetButtonOpenWebSiteButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTO1MethodForActionWidgetButtonSetPreferredMusicButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTO1MethodForActionWidgetButtonSaveButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
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

    private StringBuilder createScreenDetailsSmallDTO2MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO2Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTO1MethodForActionOnProfileImageFileUploadFileUpload(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsSmallDTO1MethodForActionOnProfileImageFileUploadFileUploadFinished(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("contact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1Contact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewLargeDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
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

    private StringBuilder createScreenOverviewSmallDTO1MethodForActionWidgetButtonEditButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("selectedContact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1SelectedContact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewSmallDTO1MethodForActionWidgetButtonDeleteButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        ContactDTO dto = gson.fromJson((String)requestData.getParameters().get("selectedContact"), ContactDTO.class);
        String declaration = "private ContactDTO createStep" + step + "DTO1SelectedContact()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        ContactDTO result = new ContactDTO();\n");
        result.append(createSetDTOContactDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewSmallDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
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
        result.append("import generated.fliesenui.dto.ContactDTO;\n");
        result.append("import generated.fliesenui.dto.ContactListDTO;\n");
        result.append("import generated.fliesenui.dto.ContactTypeDTO;\n");
        result.append("import generated.fliesenui.dto.ContactTypeListDTO;\n");
        result.append("import generated.fliesenui.screen.DetailsLargeRequest;\n");
        result.append("import generated.fliesenui.screen.DetailsLargeReply;\n");
        result.append("import generated.fliesenui.screen.DetailsSmallRequest;\n");
        result.append("import generated.fliesenui.screen.DetailsSmallReply;\n");
        result.append("import generated.fliesenui.screen.OverviewLargeRequest;\n");
        result.append("import generated.fliesenui.screen.OverviewLargeReply;\n");
        result.append("import generated.fliesenui.screen.OverviewSmallRequest;\n");
        result.append("import generated.fliesenui.screen.OverviewSmallReply;\n");
         return result;
    }

    public StringBuilder generateSetPresenterStubs(){
        StringBuilder result = new StringBuilder();
        result.append("        screenManager.setDetailsLargePresenter(/* TODO: Add presenter DetailsLarge*/);\n");
        result.append("        screenManager.setDetailsSmallPresenter(/* TODO: Add presenter DetailsSmall*/);\n");
        result.append("        screenManager.setOverviewLargePresenter(/* TODO: Add presenter OverviewLarge*/);\n");
        result.append("        screenManager.setOverviewSmallPresenter(/* TODO: Add presenter OverviewSmall*/);\n");
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