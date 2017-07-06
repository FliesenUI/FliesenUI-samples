package com.bright_side_it.fluidemo.contactmanager.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generated.fliesenui.core.FLUIReplyDTO;
import generated.fliesenui.core.FLUIString.StringLanguage;
import generated.fliesenui.core.FLUIAbstractReply;
import generated.fliesenui.core.FLUIReplyAction;
import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.core.FLUIScreenManager;
import generated.fliesenui.core.IDLabelList;
import generated.fliesenui.core.IDLabelImageAssetList;
import generated.fliesenui.dto.ContactDTO;
import generated.fliesenui.dto.ContactListDTO;
import generated.fliesenui.dto.ContactTypeDTO;
import generated.fliesenui.dto.ContactTypeListDTO;
import generated.fliesenui.screen.DetailsLargeRequest;
import generated.fliesenui.screen.DetailsLargeReply;
import generated.fliesenui.screen.DetailsSmallRequest;
import generated.fliesenui.screen.DetailsSmallReply;
import generated.fliesenui.screen.OverviewLargeRequest;
import generated.fliesenui.screen.OverviewLargeReply;
import generated.fliesenui.screen.OverviewSmallRequest;
import generated.fliesenui.screen.OverviewSmallReply;

import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsLargePresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.DetailsSmallPresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.OverviewLargePresenter;
import com.bright_side_it.fluidemo.contactmanager.presenter.OverviewSmallPresenter;


public class AutoTestGeneral{

    private FLUIScreenManager screenManager = FLUIScreenManager.createSimpleInstance();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void setupPresenters(){
        screenManager.setDetailsLargePresenter(new DetailsLargePresenter(true));
        screenManager.setDetailsSmallPresenter(new DetailsSmallPresenter(true));
        screenManager.setOverviewLargePresenter(new OverviewLargePresenter(false));
        screenManager.setOverviewSmallPresenter(new OverviewSmallPresenter());
    }

    @Test
    public void testMain(){
        setupPresenters();
        testStep001(); //: overviewLarge: onLoaded
        testStep002(); //: overviewLarge: widgetButtonSearchButtonClicked
        testStep003(); //: overviewLarge: widgetButtonSearchButtonClicked
        testStep004(); //: overviewLarge: widgetButtonNewButtonClicked
        testStep005(); //: detailsLarge: onLoaded
        testStep006(); //: detailsLarge: onTypeSelectBoxChanged
        testStep007(); //: detailsLarge: widgetButtonSaveButtonClicked
        testStep008(); //: overviewLarge: onLoaded
        testStep009(); //: overviewSmall: onLoaded
        testStep010(); //: overviewSmall: onContactsTableRowClicked
        testStep011(); //: overviewSmall: widgetButtonEditButtonClicked
        testStep012(); //: detailsSmall: onLoaded
        testStep013(); //: detailsSmall: widgetButtonSetPreferredMusicButtonClicked
        testStep014(); //: detailsSmall: onListChooserResult
        testStep015(); //: detailsSmall: widgetButtonSaveButtonClicked
        testStep016(); //: overviewSmall: onLoaded
    }

    private void testStep001(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnLoadedRequest("DEFAULT", createStep1DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep1Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep002(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "ary");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep2Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep003(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep3Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep004(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnNewButtonClickedRequest("DEFAULT");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenDetailsLarge(null);

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep005(){
        DetailsLargeRequest request = DetailsLargeRequest.createOnLoadedRequest("DEFAULT", createStep5DTO1_ClientProperties(), createStep5DTO2Contact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsLargeReply expectedReply = new DetailsLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setProfileImageFileUploadVisible(true);
        expectedReply.setTypesDTO(createReplyParamForStep5Action2());
        expectedReply.setTypeSelectBoxSelectedID(null);
        expectedReply.setPreferredMusicContentLabelText("none");

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep006(){
        DetailsLargeRequest request = DetailsLargeRequest.createOnTypeSelectBoxChangedRequest("DEFAULT", "col");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsLargeReply expectedReply = new DetailsLargeReply(false, StringLanguage.DEFAULT);

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep007(){
        DetailsLargeRequest request = DetailsLargeRequest.createOnSaveButtonClickedRequest("DEFAULT", createStep7DTO1Contact(), "col");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsLargeReply expectedReply = new DetailsLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenOverviewLarge();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep008(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnLoadedRequest("DEFAULT", createStep8DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenOverviewSmall();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep009(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnLoadedRequest("DEFAULT", createStep9DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep9Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep010(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnContactsTableRowClickedRequest("DEFAULT", "2");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.setSelectedContactDTO(createReplyParamForStep10Action1());
        expectedReply.setActionItemInfoText("Choose action for contact 'Ronald Lee'");
        expectedReply.setTableBarVisible(false);
        expectedReply.setItemActionBarVisible(true);
        expectedReply.setSelectedItemBarVisible(true);

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep011(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnEditButtonClickedRequest("DEFAULT", createStep11DTO1SelectedContact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenDetailsSmall(createReplyParamForStep11Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep012(){
        DetailsSmallRequest request = DetailsSmallRequest.createOnLoadedRequest("DEFAULT", createStep12DTO1_ClientProperties(), createStep12DTO2Contact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsSmallReply expectedReply = new DetailsSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.setProfileImageFileUploadVisible(true);
        expectedReply.setTypesDTO(createReplyParamForStep12Action2());
        expectedReply.setTypeSelectBoxSelectedID("fri");
        expectedReply.setPreferredMusicContentLabelText("Rock, Pop");

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep013(){
        DetailsSmallRequest request = DetailsSmallRequest.createOnSetPreferredMusicButtonClickedRequest("DEFAULT", createStep13DTO1Contact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsSmallReply expectedReply = new DetailsSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.showListChooser("2", true, false, "Preferred Music", "OK", "Cancel", createReplyParamForStep13Action1(), Arrays.asList("Rock", "Pop"));

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep014(){
        DetailsSmallRequest request = DetailsSmallRequest.createOnListChooserResultRequest("DEFAULT");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsSmallReply expectedReply = new DetailsSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactDTO(createReplyParamForStep14Action1());
        expectedReply.setPreferredMusicContentLabelText("Rock, Electro");

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep015(){
        DetailsSmallRequest request = DetailsSmallRequest.createOnSaveButtonClickedRequest("DEFAULT", createStep15DTO1Contact(), "fri");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsSmallReply expectedReply = new DetailsSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenOverviewSmall();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep016(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnLoadedRequest("DEFAULT", createStep16DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep16Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private FLUIClientPropertiesDTO createStep1DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(1280);
        result.setScreenAvailableHeightInPixels(760);
        result.setScreenWidthInPixels(1280);
        result.setScreenHeightInPixels(800);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(33.68421052631579);
        result.setScreenHeightInCM(21.05263157894737);
        result.setScreenWidthInInch(13.261507368421052);
        result.setScreenHeightInInch(8.28844210526316);
        result.setScreenDiagonalInInch(15.63860128703923);
        result.setErrorMessage(null);
        return result;
    }

    private FLUIClientPropertiesDTO createStep5DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(0);
        result.setScreenAvailableHeightInPixels(0);
        result.setScreenWidthInPixels(0);
        result.setScreenHeightInPixels(0);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(0.0);
        result.setScreenHeightInCM(0.0);
        result.setScreenWidthInInch(0.0);
        result.setScreenHeightInInch(0.0);
        result.setScreenDiagonalInInch(0.0);
        result.setErrorMessage(null);
        return result;
    }

    private ContactDTO createStep5DTO2Contact(){
        ContactDTO result = new ContactDTO();
        result.setId(null);
        result.setTypeID(null);
        result.setProfileImage(null);
        result.setTypeImageAsset(null);
        result.setFirstname("first");
        result.setLastname("last");
        result.setPhone("phone");
        result.setMobile("mobile");
        result.setStreet("street");
        result.setCountry("country");
        result.setState("state");
        result.setCity("city");
        result.setPostalCode("postalCode");
        result.setWebSite("web site");

        result.setPreferredMusic(null);
        return result;
    }

    private ContactDTO createStep7DTO1Contact(){
        ContactDTO result = new ContactDTO();
        result.setId(null);
        result.setTypeID(null);
        result.setProfileImage(null);
        result.setTypeImageAsset(null);
        result.setFirstname("first1");
        result.setLastname("last1");
        result.setPhone("phone1");
        result.setMobile("mobile1");
        result.setStreet("street1");
        result.setCountry("country1");
        result.setState("state1");
        result.setCity("city1");
        result.setPostalCode("postalCode1");
        result.setWebSite("web site1");

        result.setPreferredMusic(null);
        return result;
    }

    private FLUIClientPropertiesDTO createStep8DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(0);
        result.setScreenAvailableHeightInPixels(0);
        result.setScreenWidthInPixels(0);
        result.setScreenHeightInPixels(0);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(0.0);
        result.setScreenHeightInCM(0.0);
        result.setScreenWidthInInch(0.0);
        result.setScreenHeightInInch(0.0);
        result.setScreenDiagonalInInch(0.0);
        result.setErrorMessage(null);
        return result;
    }

    private FLUIClientPropertiesDTO createStep9DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(0);
        result.setScreenAvailableHeightInPixels(0);
        result.setScreenWidthInPixels(0);
        result.setScreenHeightInPixels(0);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(0.0);
        result.setScreenHeightInCM(0.0);
        result.setScreenWidthInInch(0.0);
        result.setScreenHeightInInch(0.0);
        result.setScreenDiagonalInInch(0.0);
        result.setErrorMessage(null);
        return result;
    }

    private ContactDTO createStep11DTO1SelectedContact(){
        ContactDTO result = new ContactDTO();
        result.setId("2");
        result.setTypeID("fri");
        result.setProfileImage("default.png");
        result.setTypeImageAsset("friend");
        result.setFirstname("Ronald");
        result.setLastname("Lee");
        result.setPhone("+1 453 2346");
        result.setMobile("+1 456 1666");
        result.setStreet("Long Street");
        result.setCountry("USA");
        result.setState("Mystate");
        result.setCity("Mycity");
        result.setPostalCode("1234");
        result.setWebSite("");

        List<String> list3 = new ArrayList<String>();
        result.setPreferredMusic(list3);
        list3.add("Rock");
        list3.add("Pop");
        return result;
    }

    private FLUIClientPropertiesDTO createStep12DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(0);
        result.setScreenAvailableHeightInPixels(0);
        result.setScreenWidthInPixels(0);
        result.setScreenHeightInPixels(0);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(0.0);
        result.setScreenHeightInCM(0.0);
        result.setScreenWidthInInch(0.0);
        result.setScreenHeightInInch(0.0);
        result.setScreenDiagonalInInch(0.0);
        result.setErrorMessage(null);
        return result;
    }

    private ContactDTO createStep12DTO2Contact(){
        ContactDTO result = new ContactDTO();
        result.setId("2");
        result.setTypeID("fri");
        result.setProfileImage("default.png");
        result.setTypeImageAsset("friend");
        result.setFirstname("Ronald");
        result.setLastname("Lee");
        result.setPhone("+1 453 2346");
        result.setMobile("+1 456 1666");
        result.setStreet("Long Street");
        result.setCountry("USA");
        result.setState("Mystate");
        result.setCity("Mycity");
        result.setPostalCode("1234");
        result.setWebSite("");

        List<String> list4 = new ArrayList<String>();
        result.setPreferredMusic(list4);
        list4.add("Rock");
        list4.add("Pop");
        return result;
    }

    private ContactDTO createStep13DTO1Contact(){
        ContactDTO result = new ContactDTO();
        result.setId("2");
        result.setTypeID("fri");
        result.setProfileImage("default.png");
        result.setTypeImageAsset("friend");
        result.setFirstname("Ronald");
        result.setLastname("Lee");
        result.setPhone("+1 453 2346");
        result.setMobile("+1 456 1666");
        result.setStreet("Long Street");
        result.setCountry("USA");
        result.setState("Mystate");
        result.setCity("Mycity");
        result.setPostalCode("1234");
        result.setWebSite("");

        List<String> list5 = new ArrayList<String>();
        result.setPreferredMusic(list5);
        list5.add("Rock");
        list5.add("Pop");
        return result;
    }

    private ContactDTO createStep15DTO1Contact(){
        ContactDTO result = new ContactDTO();
        result.setId("2");
        result.setTypeID("fri");
        result.setProfileImage("default.png");
        result.setTypeImageAsset("friend");
        result.setFirstname("Ronald");
        result.setLastname("Lee");
        result.setPhone("+1 453 2346");
        result.setMobile("+1 456 1666");
        result.setStreet("Long Street");
        result.setCountry("USA");
        result.setState("Mystate");
        result.setCity("Mycity");
        result.setPostalCode("12345");
        result.setWebSite("");

        List<String> list6 = new ArrayList<String>();
        result.setPreferredMusic(list6);
        list6.add("Rock");
        list6.add("Electro");
        return result;
    }

    private FLUIClientPropertiesDTO createStep16DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(0);
        result.setScreenAvailableHeightInPixels(0);
        result.setScreenWidthInPixels(0);
        result.setScreenHeightInPixels(0);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(0.0);
        result.setScreenHeightInCM(0.0);
        result.setScreenWidthInInch(0.0);
        result.setScreenHeightInInch(0.0);
        result.setScreenDiagonalInInch(0.0);
        result.setErrorMessage(null);
        return result;
    }

    private ContactListDTO createReplyParamForStep1Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list1 = new ArrayList<ContactDTO>();
        dto.setItems(list1);

        ContactDTO dto1 = new ContactDTO();
        list1.add(dto1);
        dto1.setId("0");
        dto1.setTypeID("fam");
        dto1.setProfileImage("star.png");
        dto1.setTypeImageAsset("family");
        dto1.setFirstname("Mary");
        dto1.setLastname("Smith");
        dto1.setPhone("+1 123 0000");
        dto1.setMobile("+1 456 1234");
        dto1.setStreet("My Street");
        dto1.setCountry("USA");
        dto1.setState("Mystate");
        dto1.setCity("Mycity");
        dto1.setPostalCode("1234");
        dto1.setWebSite("");

        List<String> list2 = new ArrayList<String>();
        dto1.setPreferredMusic(list2);
        list2.add("Classic");
        list2.add("Jazz");


        ContactDTO dto2 = new ContactDTO();
        list1.add(dto2);
        dto2.setId("1");
        dto2.setTypeID("fam");
        dto2.setProfileImage("triangle.png");
        dto2.setTypeImageAsset("family");
        dto2.setFirstname("Tom");
        dto2.setLastname("Smith");
        dto2.setPhone("+1 123 0000");
        dto2.setMobile("+1 456 1222");
        dto2.setStreet("My Street");
        dto2.setCountry("USA");
        dto2.setState("Mystate");
        dto2.setCity("Mycity");
        dto2.setPostalCode("1234");
        dto2.setWebSite("");

        List<String> list3 = new ArrayList<String>();
        dto2.setPreferredMusic(list3);
        list3.add("Classic");
        list3.add("Jazz");


        ContactDTO dto3 = new ContactDTO();
        list1.add(dto3);
        dto3.setId("2");
        dto3.setTypeID("fri");
        dto3.setProfileImage("default.png");
        dto3.setTypeImageAsset("friend");
        dto3.setFirstname("Ronald");
        dto3.setLastname("Lee");
        dto3.setPhone("+1 453 2346");
        dto3.setMobile("+1 456 1666");
        dto3.setStreet("Long Street");
        dto3.setCountry("USA");
        dto3.setState("Mystate");
        dto3.setCity("Mycity");
        dto3.setPostalCode("1234");
        dto3.setWebSite("");

        List<String> list4 = new ArrayList<String>();
        dto3.setPreferredMusic(list4);
        list4.add("Rock");
        list4.add("Pop");


        ContactDTO dto4 = new ContactDTO();
        list1.add(dto4);
        dto4.setId("3");
        dto4.setTypeID("com");
        dto4.setProfileImage("painted-globe.jpg");
        dto4.setTypeImageAsset("company");
        dto4.setFirstname("");
        dto4.setLastname("Wiki Corp");
        dto4.setPhone("+1 300 34342");
        dto4.setMobile("+1 342 3554");
        dto4.setStreet("New Street");
        dto4.setCountry("Web-Land");
        dto4.setState("Web-State");
        dto4.setCity("Webcity");
        dto4.setPostalCode("1234");
        dto4.setWebSite("http://www.wikipedia.org");

        List<String> list5 = new ArrayList<String>();
        dto4.setPreferredMusic(list5);
        list5.add("Classic");
        list5.add("Jazz");


        ContactDTO dto5 = new ContactDTO();
        list1.add(dto5);
        dto5.setId("4");
        dto5.setTypeID("col");
        dto5.setProfileImage("default.png");
        dto5.setTypeImageAsset("colleague");
        dto5.setFirstname("John");
        dto5.setLastname("Miller");
        dto5.setPhone("+1 300 1111");
        dto5.setMobile("+1 456 444");
        dto5.setStreet("Some Street");
        dto5.setCountry("USA");
        dto5.setState("Mystate");
        dto5.setCity("Mycity");
        dto5.setPostalCode("1234");
        dto5.setWebSite("");

        List<String> list6 = new ArrayList<String>();
        dto5.setPreferredMusic(list6);
        list6.add("Pop");
        list6.add("Electro");


        ContactDTO dto6 = new ContactDTO();
        list1.add(dto6);
        dto6.setId("5");
        dto6.setTypeID("col");
        dto6.setProfileImage("default.png");
        dto6.setTypeImageAsset("colleague");
        dto6.setFirstname("Robert");
        dto6.setLastname("Meyer");
        dto6.setPhone("+1 300 2222");
        dto6.setMobile("+1 456 555");
        dto6.setStreet("New Street");
        dto6.setCountry("USA");
        dto6.setState("Mystate");
        dto6.setCity("Mycity");
        dto6.setPostalCode("3456");
        dto6.setWebSite("");

        List<String> list7 = new ArrayList<String>();
        dto6.setPreferredMusic(list7);
        list7.add("Pop");
        list7.add("Electro");


        ContactDTO dto7 = new ContactDTO();
        list1.add(dto7);
        dto7.setId("6");
        dto7.setTypeID("fam");
        dto7.setProfileImage("default.png");
        dto7.setTypeImageAsset("family");
        dto7.setFirstname("Bob");
        dto7.setLastname("Smith");
        dto7.setPhone("+1 123 0000");
        dto7.setMobile("+1 456 1333");
        dto7.setStreet("My Street");
        dto7.setCountry("USA");
        dto7.setState("Mystate");
        dto7.setCity("Mycity");
        dto7.setPostalCode("1234");
        dto7.setWebSite("");

        List<String> list8 = new ArrayList<String>();
        dto7.setPreferredMusic(list8);
        list8.add("Pop");
        list8.add("Electro");

        return dto;
    }

    private ContactListDTO createReplyParamForStep2Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list9 = new ArrayList<ContactDTO>();
        dto.setItems(list9);

        ContactDTO dto8 = new ContactDTO();
        list9.add(dto8);
        dto8.setId("0");
        dto8.setTypeID("fam");
        dto8.setProfileImage("star.png");
        dto8.setTypeImageAsset("family");
        dto8.setFirstname("Mary");
        dto8.setLastname("Smith");
        dto8.setPhone("+1 123 0000");
        dto8.setMobile("+1 456 1234");
        dto8.setStreet("My Street");
        dto8.setCountry("USA");
        dto8.setState("Mystate");
        dto8.setCity("Mycity");
        dto8.setPostalCode("1234");
        dto8.setWebSite("");

        List<String> list10 = new ArrayList<String>();
        dto8.setPreferredMusic(list10);
        list10.add("Classic");
        list10.add("Jazz");

        return dto;
    }

    private ContactListDTO createReplyParamForStep3Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list11 = new ArrayList<ContactDTO>();
        dto.setItems(list11);

        ContactDTO dto9 = new ContactDTO();
        list11.add(dto9);
        dto9.setId("0");
        dto9.setTypeID("fam");
        dto9.setProfileImage("star.png");
        dto9.setTypeImageAsset("family");
        dto9.setFirstname("Mary");
        dto9.setLastname("Smith");
        dto9.setPhone("+1 123 0000");
        dto9.setMobile("+1 456 1234");
        dto9.setStreet("My Street");
        dto9.setCountry("USA");
        dto9.setState("Mystate");
        dto9.setCity("Mycity");
        dto9.setPostalCode("1234");
        dto9.setWebSite("");

        List<String> list12 = new ArrayList<String>();
        dto9.setPreferredMusic(list12);
        list12.add("Classic");
        list12.add("Jazz");


        ContactDTO dto10 = new ContactDTO();
        list11.add(dto10);
        dto10.setId("1");
        dto10.setTypeID("fam");
        dto10.setProfileImage("triangle.png");
        dto10.setTypeImageAsset("family");
        dto10.setFirstname("Tom");
        dto10.setLastname("Smith");
        dto10.setPhone("+1 123 0000");
        dto10.setMobile("+1 456 1222");
        dto10.setStreet("My Street");
        dto10.setCountry("USA");
        dto10.setState("Mystate");
        dto10.setCity("Mycity");
        dto10.setPostalCode("1234");
        dto10.setWebSite("");

        List<String> list13 = new ArrayList<String>();
        dto10.setPreferredMusic(list13);
        list13.add("Classic");
        list13.add("Jazz");


        ContactDTO dto11 = new ContactDTO();
        list11.add(dto11);
        dto11.setId("2");
        dto11.setTypeID("fri");
        dto11.setProfileImage("default.png");
        dto11.setTypeImageAsset("friend");
        dto11.setFirstname("Ronald");
        dto11.setLastname("Lee");
        dto11.setPhone("+1 453 2346");
        dto11.setMobile("+1 456 1666");
        dto11.setStreet("Long Street");
        dto11.setCountry("USA");
        dto11.setState("Mystate");
        dto11.setCity("Mycity");
        dto11.setPostalCode("1234");
        dto11.setWebSite("");

        List<String> list14 = new ArrayList<String>();
        dto11.setPreferredMusic(list14);
        list14.add("Rock");
        list14.add("Pop");


        ContactDTO dto12 = new ContactDTO();
        list11.add(dto12);
        dto12.setId("3");
        dto12.setTypeID("com");
        dto12.setProfileImage("painted-globe.jpg");
        dto12.setTypeImageAsset("company");
        dto12.setFirstname("");
        dto12.setLastname("Wiki Corp");
        dto12.setPhone("+1 300 34342");
        dto12.setMobile("+1 342 3554");
        dto12.setStreet("New Street");
        dto12.setCountry("Web-Land");
        dto12.setState("Web-State");
        dto12.setCity("Webcity");
        dto12.setPostalCode("1234");
        dto12.setWebSite("http://www.wikipedia.org");

        List<String> list15 = new ArrayList<String>();
        dto12.setPreferredMusic(list15);
        list15.add("Classic");
        list15.add("Jazz");


        ContactDTO dto13 = new ContactDTO();
        list11.add(dto13);
        dto13.setId("4");
        dto13.setTypeID("col");
        dto13.setProfileImage("default.png");
        dto13.setTypeImageAsset("colleague");
        dto13.setFirstname("John");
        dto13.setLastname("Miller");
        dto13.setPhone("+1 300 1111");
        dto13.setMobile("+1 456 444");
        dto13.setStreet("Some Street");
        dto13.setCountry("USA");
        dto13.setState("Mystate");
        dto13.setCity("Mycity");
        dto13.setPostalCode("1234");
        dto13.setWebSite("");

        List<String> list16 = new ArrayList<String>();
        dto13.setPreferredMusic(list16);
        list16.add("Pop");
        list16.add("Electro");


        ContactDTO dto14 = new ContactDTO();
        list11.add(dto14);
        dto14.setId("5");
        dto14.setTypeID("col");
        dto14.setProfileImage("default.png");
        dto14.setTypeImageAsset("colleague");
        dto14.setFirstname("Robert");
        dto14.setLastname("Meyer");
        dto14.setPhone("+1 300 2222");
        dto14.setMobile("+1 456 555");
        dto14.setStreet("New Street");
        dto14.setCountry("USA");
        dto14.setState("Mystate");
        dto14.setCity("Mycity");
        dto14.setPostalCode("3456");
        dto14.setWebSite("");

        List<String> list17 = new ArrayList<String>();
        dto14.setPreferredMusic(list17);
        list17.add("Pop");
        list17.add("Electro");


        ContactDTO dto15 = new ContactDTO();
        list11.add(dto15);
        dto15.setId("6");
        dto15.setTypeID("fam");
        dto15.setProfileImage("default.png");
        dto15.setTypeImageAsset("family");
        dto15.setFirstname("Bob");
        dto15.setLastname("Smith");
        dto15.setPhone("+1 123 0000");
        dto15.setMobile("+1 456 1333");
        dto15.setStreet("My Street");
        dto15.setCountry("USA");
        dto15.setState("Mystate");
        dto15.setCity("Mycity");
        dto15.setPostalCode("1234");
        dto15.setWebSite("");

        List<String> list18 = new ArrayList<String>();
        dto15.setPreferredMusic(list18);
        list18.add("Pop");
        list18.add("Electro");

        return dto;
    }

    private ContactTypeListDTO createReplyParamForStep5Action2(){
        ContactTypeListDTO dto = new ContactTypeListDTO();

        List<ContactTypeDTO> list19 = new ArrayList<ContactTypeDTO>();
        dto.setItems(list19);

        ContactTypeDTO dto16 = new ContactTypeDTO();
        list19.add(dto16);
        dto16.setId("col");
        dto16.setLabel("Colleague");
        dto16.setImageAssetID("colleague");


        ContactTypeDTO dto17 = new ContactTypeDTO();
        list19.add(dto17);
        dto17.setId("com");
        dto17.setLabel("Company");
        dto17.setImageAssetID("company");


        ContactTypeDTO dto18 = new ContactTypeDTO();
        list19.add(dto18);
        dto18.setId("fam");
        dto18.setLabel("Family");
        dto18.setImageAssetID("family");


        ContactTypeDTO dto19 = new ContactTypeDTO();
        list19.add(dto19);
        dto19.setId("fri");
        dto19.setLabel("Friend");
        dto19.setImageAssetID("friend");

        return dto;
    }

    private ContactListDTO createReplyParamForStep9Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list20 = new ArrayList<ContactDTO>();
        dto.setItems(list20);

        ContactDTO dto20 = new ContactDTO();
        list20.add(dto20);
        dto20.setId("0");
        dto20.setTypeID("fam");
        dto20.setProfileImage("star.png");
        dto20.setTypeImageAsset("family");
        dto20.setFirstname("Mary");
        dto20.setLastname("Smith");
        dto20.setPhone("+1 123 0000");
        dto20.setMobile("+1 456 1234");
        dto20.setStreet("My Street");
        dto20.setCountry("USA");
        dto20.setState("Mystate");
        dto20.setCity("Mycity");
        dto20.setPostalCode("1234");
        dto20.setWebSite("");

        List<String> list21 = new ArrayList<String>();
        dto20.setPreferredMusic(list21);
        list21.add("Classic");
        list21.add("Jazz");


        ContactDTO dto21 = new ContactDTO();
        list20.add(dto21);
        dto21.setId("1");
        dto21.setTypeID("fam");
        dto21.setProfileImage("triangle.png");
        dto21.setTypeImageAsset("family");
        dto21.setFirstname("Tom");
        dto21.setLastname("Smith");
        dto21.setPhone("+1 123 0000");
        dto21.setMobile("+1 456 1222");
        dto21.setStreet("My Street");
        dto21.setCountry("USA");
        dto21.setState("Mystate");
        dto21.setCity("Mycity");
        dto21.setPostalCode("1234");
        dto21.setWebSite("");

        List<String> list22 = new ArrayList<String>();
        dto21.setPreferredMusic(list22);
        list22.add("Classic");
        list22.add("Jazz");


        ContactDTO dto22 = new ContactDTO();
        list20.add(dto22);
        dto22.setId("2");
        dto22.setTypeID("fri");
        dto22.setProfileImage("default.png");
        dto22.setTypeImageAsset("friend");
        dto22.setFirstname("Ronald");
        dto22.setLastname("Lee");
        dto22.setPhone("+1 453 2346");
        dto22.setMobile("+1 456 1666");
        dto22.setStreet("Long Street");
        dto22.setCountry("USA");
        dto22.setState("Mystate");
        dto22.setCity("Mycity");
        dto22.setPostalCode("1234");
        dto22.setWebSite("");

        List<String> list23 = new ArrayList<String>();
        dto22.setPreferredMusic(list23);
        list23.add("Rock");
        list23.add("Pop");


        ContactDTO dto23 = new ContactDTO();
        list20.add(dto23);
        dto23.setId("3");
        dto23.setTypeID("com");
        dto23.setProfileImage("painted-globe.jpg");
        dto23.setTypeImageAsset("company");
        dto23.setFirstname("");
        dto23.setLastname("Wiki Corp");
        dto23.setPhone("+1 300 34342");
        dto23.setMobile("+1 342 3554");
        dto23.setStreet("New Street");
        dto23.setCountry("Web-Land");
        dto23.setState("Web-State");
        dto23.setCity("Webcity");
        dto23.setPostalCode("1234");
        dto23.setWebSite("http://www.wikipedia.org");

        List<String> list24 = new ArrayList<String>();
        dto23.setPreferredMusic(list24);
        list24.add("Classic");
        list24.add("Jazz");


        ContactDTO dto24 = new ContactDTO();
        list20.add(dto24);
        dto24.setId("4");
        dto24.setTypeID("col");
        dto24.setProfileImage("default.png");
        dto24.setTypeImageAsset("colleague");
        dto24.setFirstname("John");
        dto24.setLastname("Miller");
        dto24.setPhone("+1 300 1111");
        dto24.setMobile("+1 456 444");
        dto24.setStreet("Some Street");
        dto24.setCountry("USA");
        dto24.setState("Mystate");
        dto24.setCity("Mycity");
        dto24.setPostalCode("1234");
        dto24.setWebSite("");

        List<String> list25 = new ArrayList<String>();
        dto24.setPreferredMusic(list25);
        list25.add("Pop");
        list25.add("Electro");


        ContactDTO dto25 = new ContactDTO();
        list20.add(dto25);
        dto25.setId("5");
        dto25.setTypeID("col");
        dto25.setProfileImage("default.png");
        dto25.setTypeImageAsset("colleague");
        dto25.setFirstname("Robert");
        dto25.setLastname("Meyer");
        dto25.setPhone("+1 300 2222");
        dto25.setMobile("+1 456 555");
        dto25.setStreet("New Street");
        dto25.setCountry("USA");
        dto25.setState("Mystate");
        dto25.setCity("Mycity");
        dto25.setPostalCode("3456");
        dto25.setWebSite("");

        List<String> list26 = new ArrayList<String>();
        dto25.setPreferredMusic(list26);
        list26.add("Pop");
        list26.add("Electro");


        ContactDTO dto26 = new ContactDTO();
        list20.add(dto26);
        dto26.setId("6");
        dto26.setTypeID("fam");
        dto26.setProfileImage("default.png");
        dto26.setTypeImageAsset("family");
        dto26.setFirstname("Bob");
        dto26.setLastname("Smith");
        dto26.setPhone("+1 123 0000");
        dto26.setMobile("+1 456 1333");
        dto26.setStreet("My Street");
        dto26.setCountry("USA");
        dto26.setState("Mystate");
        dto26.setCity("Mycity");
        dto26.setPostalCode("1234");
        dto26.setWebSite("");

        List<String> list27 = new ArrayList<String>();
        dto26.setPreferredMusic(list27);
        list27.add("Pop");
        list27.add("Electro");


        ContactDTO dto27 = new ContactDTO();
        list20.add(dto27);
        dto27.setId("7");
        dto27.setTypeID("col");
        dto27.setProfileImage("");
        dto27.setTypeImageAsset("colleague");
        dto27.setFirstname("first1");
        dto27.setLastname("last1");
        dto27.setPhone("phone1");
        dto27.setMobile("mobile1");
        dto27.setStreet("street1");
        dto27.setCountry("country1");
        dto27.setState("state1");
        dto27.setCity("city1");
        dto27.setPostalCode("postalCode1");
        dto27.setWebSite("web site1");

        dto27.setPreferredMusic(null);

        return dto;
    }

    private ContactDTO createReplyParamForStep10Action1(){
        ContactDTO dto = new ContactDTO();
        dto.setId("2");
        dto.setTypeID("fri");
        dto.setProfileImage("default.png");
        dto.setTypeImageAsset("friend");
        dto.setFirstname("Ronald");
        dto.setLastname("Lee");
        dto.setPhone("+1 453 2346");
        dto.setMobile("+1 456 1666");
        dto.setStreet("Long Street");
        dto.setCountry("USA");
        dto.setState("Mystate");
        dto.setCity("Mycity");
        dto.setPostalCode("1234");
        dto.setWebSite("");

        List<String> list29 = new ArrayList<String>();
        dto.setPreferredMusic(list29);
        list29.add("Rock");
        list29.add("Pop");
        return dto;
    }

    private ContactDTO createReplyParamForStep11Action1(){
        ContactDTO dto = new ContactDTO();
        dto.setId("2");
        dto.setTypeID("fri");
        dto.setProfileImage("default.png");
        dto.setTypeImageAsset("friend");
        dto.setFirstname("Ronald");
        dto.setLastname("Lee");
        dto.setPhone("+1 453 2346");
        dto.setMobile("+1 456 1666");
        dto.setStreet("Long Street");
        dto.setCountry("USA");
        dto.setState("Mystate");
        dto.setCity("Mycity");
        dto.setPostalCode("1234");
        dto.setWebSite("");

        List<String> list30 = new ArrayList<String>();
        dto.setPreferredMusic(list30);
        list30.add("Rock");
        list30.add("Pop");
        return dto;
    }

    private ContactTypeListDTO createReplyParamForStep12Action2(){
        ContactTypeListDTO dto = new ContactTypeListDTO();

        List<ContactTypeDTO> list31 = new ArrayList<ContactTypeDTO>();
        dto.setItems(list31);

        ContactTypeDTO dto28 = new ContactTypeDTO();
        list31.add(dto28);
        dto28.setId("col");
        dto28.setLabel("Colleague");
        dto28.setImageAssetID("colleague");


        ContactTypeDTO dto29 = new ContactTypeDTO();
        list31.add(dto29);
        dto29.setId("com");
        dto29.setLabel("Company");
        dto29.setImageAssetID("company");


        ContactTypeDTO dto30 = new ContactTypeDTO();
        list31.add(dto30);
        dto30.setId("fam");
        dto30.setLabel("Family");
        dto30.setImageAssetID("family");


        ContactTypeDTO dto31 = new ContactTypeDTO();
        list31.add(dto31);
        dto31.setId("fri");
        dto31.setLabel("Friend");
        dto31.setImageAssetID("friend");

        return dto;
    }

    private IDLabelImageAssetList createReplyParamForStep13Action1(){
        IDLabelImageAssetList items = new IDLabelImageAssetList();
        items.addItem("Classic", "Classic", "music");
        items.addItem("Jazz", "Jazz", "music");
        items.addItem("Rock", "Rock", "music");
        items.addItem("Pop", "Pop", "music");
        items.addItem("Electro", "Electro", "music");
        return items;
    }

    private ContactDTO createReplyParamForStep14Action1(){
        ContactDTO dto = new ContactDTO();
        dto.setId("2");
        dto.setTypeID("fri");
        dto.setProfileImage("default.png");
        dto.setTypeImageAsset("friend");
        dto.setFirstname("Ronald");
        dto.setLastname("Lee");
        dto.setPhone("+1 453 2346");
        dto.setMobile("+1 456 1666");
        dto.setStreet("Long Street");
        dto.setCountry("USA");
        dto.setState("Mystate");
        dto.setCity("Mycity");
        dto.setPostalCode("1234");
        dto.setWebSite("");

        List<String> list32 = new ArrayList<String>();
        dto.setPreferredMusic(list32);
        list32.add("Rock");
        list32.add("Electro");
        return dto;
    }

    private ContactListDTO createReplyParamForStep16Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list33 = new ArrayList<ContactDTO>();
        dto.setItems(list33);

        ContactDTO dto32 = new ContactDTO();
        list33.add(dto32);
        dto32.setId("0");
        dto32.setTypeID("fam");
        dto32.setProfileImage("star.png");
        dto32.setTypeImageAsset("family");
        dto32.setFirstname("Mary");
        dto32.setLastname("Smith");
        dto32.setPhone("+1 123 0000");
        dto32.setMobile("+1 456 1234");
        dto32.setStreet("My Street");
        dto32.setCountry("USA");
        dto32.setState("Mystate");
        dto32.setCity("Mycity");
        dto32.setPostalCode("1234");
        dto32.setWebSite("");

        List<String> list34 = new ArrayList<String>();
        dto32.setPreferredMusic(list34);
        list34.add("Classic");
        list34.add("Jazz");


        ContactDTO dto33 = new ContactDTO();
        list33.add(dto33);
        dto33.setId("1");
        dto33.setTypeID("fam");
        dto33.setProfileImage("triangle.png");
        dto33.setTypeImageAsset("family");
        dto33.setFirstname("Tom");
        dto33.setLastname("Smith");
        dto33.setPhone("+1 123 0000");
        dto33.setMobile("+1 456 1222");
        dto33.setStreet("My Street");
        dto33.setCountry("USA");
        dto33.setState("Mystate");
        dto33.setCity("Mycity");
        dto33.setPostalCode("1234");
        dto33.setWebSite("");

        List<String> list35 = new ArrayList<String>();
        dto33.setPreferredMusic(list35);
        list35.add("Classic");
        list35.add("Jazz");


        ContactDTO dto34 = new ContactDTO();
        list33.add(dto34);
        dto34.setId("2");
        dto34.setTypeID("fri");
        dto34.setProfileImage("default.png");
        dto34.setTypeImageAsset("friend");
        dto34.setFirstname("Ronald");
        dto34.setLastname("Lee");
        dto34.setPhone("+1 453 2346");
        dto34.setMobile("+1 456 1666");
        dto34.setStreet("Long Street");
        dto34.setCountry("USA");
        dto34.setState("Mystate");
        dto34.setCity("Mycity");
        dto34.setPostalCode("12345");
        dto34.setWebSite("");

        List<String> list36 = new ArrayList<String>();
        dto34.setPreferredMusic(list36);
        list36.add("Rock");
        list36.add("Electro");


        ContactDTO dto35 = new ContactDTO();
        list33.add(dto35);
        dto35.setId("3");
        dto35.setTypeID("com");
        dto35.setProfileImage("painted-globe.jpg");
        dto35.setTypeImageAsset("company");
        dto35.setFirstname("");
        dto35.setLastname("Wiki Corp");
        dto35.setPhone("+1 300 34342");
        dto35.setMobile("+1 342 3554");
        dto35.setStreet("New Street");
        dto35.setCountry("Web-Land");
        dto35.setState("Web-State");
        dto35.setCity("Webcity");
        dto35.setPostalCode("1234");
        dto35.setWebSite("http://www.wikipedia.org");

        List<String> list37 = new ArrayList<String>();
        dto35.setPreferredMusic(list37);
        list37.add("Classic");
        list37.add("Jazz");


        ContactDTO dto36 = new ContactDTO();
        list33.add(dto36);
        dto36.setId("4");
        dto36.setTypeID("col");
        dto36.setProfileImage("default.png");
        dto36.setTypeImageAsset("colleague");
        dto36.setFirstname("John");
        dto36.setLastname("Miller");
        dto36.setPhone("+1 300 1111");
        dto36.setMobile("+1 456 444");
        dto36.setStreet("Some Street");
        dto36.setCountry("USA");
        dto36.setState("Mystate");
        dto36.setCity("Mycity");
        dto36.setPostalCode("1234");
        dto36.setWebSite("");

        List<String> list38 = new ArrayList<String>();
        dto36.setPreferredMusic(list38);
        list38.add("Pop");
        list38.add("Electro");


        ContactDTO dto37 = new ContactDTO();
        list33.add(dto37);
        dto37.setId("5");
        dto37.setTypeID("col");
        dto37.setProfileImage("default.png");
        dto37.setTypeImageAsset("colleague");
        dto37.setFirstname("Robert");
        dto37.setLastname("Meyer");
        dto37.setPhone("+1 300 2222");
        dto37.setMobile("+1 456 555");
        dto37.setStreet("New Street");
        dto37.setCountry("USA");
        dto37.setState("Mystate");
        dto37.setCity("Mycity");
        dto37.setPostalCode("3456");
        dto37.setWebSite("");

        List<String> list39 = new ArrayList<String>();
        dto37.setPreferredMusic(list39);
        list39.add("Pop");
        list39.add("Electro");


        ContactDTO dto38 = new ContactDTO();
        list33.add(dto38);
        dto38.setId("6");
        dto38.setTypeID("fam");
        dto38.setProfileImage("default.png");
        dto38.setTypeImageAsset("family");
        dto38.setFirstname("Bob");
        dto38.setLastname("Smith");
        dto38.setPhone("+1 123 0000");
        dto38.setMobile("+1 456 1333");
        dto38.setStreet("My Street");
        dto38.setCountry("USA");
        dto38.setState("Mystate");
        dto38.setCity("Mycity");
        dto38.setPostalCode("1234");
        dto38.setWebSite("");

        List<String> list40 = new ArrayList<String>();
        dto38.setPreferredMusic(list40);
        list40.add("Pop");
        list40.add("Electro");


        ContactDTO dto39 = new ContactDTO();
        list33.add(dto39);
        dto39.setId("7");
        dto39.setTypeID("col");
        dto39.setProfileImage("");
        dto39.setTypeImageAsset("colleague");
        dto39.setFirstname("first1");
        dto39.setLastname("last1");
        dto39.setPhone("phone1");
        dto39.setMobile("mobile1");
        dto39.setStreet("street1");
        dto39.setCountry("country1");
        dto39.setState("state1");
        dto39.setCity("city1");
        dto39.setPostalCode("postalCode1");
        dto39.setWebSite("web site1");

        dto39.setPreferredMusic(null);

        return dto;
    }

}
