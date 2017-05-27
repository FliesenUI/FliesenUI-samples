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


public class AutoTestLanguageSwitch{

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
        testStep003(); //: overviewLarge: widgetButtonLanguageGermanButtonClicked
        testStep004(); //: overviewLarge: onLoaded
        testStep005(); //: overviewSmall: onLoaded
        testStep006(); //: overviewSmall: widgetButtonSearchButtonClicked
        testStep007(); //: overviewSmall: onContactsTableRowClicked
        testStep008(); //: overviewSmall: widgetButtonEditButtonClicked
        testStep009(); //: detailsSmall: onLoaded
        testStep010(); //: detailsSmall: widgetButtonCancelButtonClicked
        testStep011(); //: overviewSmall: onLoaded
        testStep012(); //: overviewSmall: widgetButtonLanguageEnglishButtonClicked
        testStep013(); //: overviewSmall: onLoaded
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
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "smi");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep2Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep003(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnLanguageGermanButtonClickedRequest("DEFAULT");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setLanguage(StringLanguage.DE);
        expectedReply.openScreenOverviewLarge();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep004(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnLoadedRequest("DE", createStep4DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DE);
        expectedReply.openScreenOverviewSmall();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep005(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnLoadedRequest("DE", createStep5DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DE);
        expectedReply.setContactsDTO(createReplyParamForStep5Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep006(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnSearchButtonClickedRequest("DE", "smi");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DE);
        expectedReply.setTableBarVisible(true);
        expectedReply.setItemActionBarVisible(false);
        expectedReply.setSelectedItemBarVisible(false);
        expectedReply.setContactsDTO(createReplyParamForStep6Action4());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep007(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnContactsTableRowClickedRequest("DE", "0");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DE);
        expectedReply.setSelectedContactDTO(createReplyParamForStep7Action1());
        expectedReply.setActionItemInfoText("Choose action for contact 'Mary Smith'");
        expectedReply.setTableBarVisible(false);
        expectedReply.setItemActionBarVisible(true);
        expectedReply.setSelectedItemBarVisible(true);

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep008(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnEditButtonClickedRequest("DE", createStep8DTO1SelectedContact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DE);
        expectedReply.openScreenDetailsSmall(createReplyParamForStep8Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep009(){
        DetailsSmallRequest request = DetailsSmallRequest.createOnLoadedRequest("DE", createStep9DTO1_ClientProperties(), createStep9DTO2Contact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsSmallReply expectedReply = new DetailsSmallReply(false, StringLanguage.DE);
        expectedReply.setProfileImageFileUploadVisible(true);
        expectedReply.setTypesDTO(createReplyParamForStep9Action2());
        expectedReply.setTypeSelectBoxSelectedID("fam");
        expectedReply.setPreferredMusicContentLabelText("Classic, Jazz");

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep010(){
        DetailsSmallRequest request = DetailsSmallRequest.createOnCancelButtonClickedRequest("DE");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsSmallReply expectedReply = new DetailsSmallReply(false, StringLanguage.DE);
        expectedReply.openScreenOverviewSmall();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep011(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnLoadedRequest("DE", createStep11DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DE);
        expectedReply.setContactsDTO(createReplyParamForStep11Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep012(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnLanguageEnglishButtonClickedRequest("DE");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DE);
        expectedReply.setLanguage(StringLanguage.DEFAULT);
        expectedReply.openScreenOverviewSmall();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep013(){
        OverviewSmallRequest request = OverviewSmallRequest.createOnLoadedRequest("DEFAULT", createStep13DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewSmallReply expectedReply = new OverviewSmallReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep13Action1());

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

    private FLUIClientPropertiesDTO createStep4DTO1_ClientProperties(){
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

    private ContactDTO createStep8DTO1SelectedContact(){
        ContactDTO result = new ContactDTO();
        result.setId("0");
        result.setTypeID("fam");
        result.setProfileImage("star.png");
        result.setTypeImageAsset("family");
        result.setFirstname("Mary");
        result.setLastname("Smith");
        result.setPhone("+1 123 0000");
        result.setMobile("+1 456 1234");
        result.setStreet("My Street");
        result.setCountry("USA");
        result.setState("Mystate");
        result.setCity("Mycity");
        result.setPostalCode("1234");
        result.setWebSite("");

        List<String> list1 = new ArrayList<String>();
        result.setPreferredMusic(list1);
        list1.add("Classic");
        list1.add("Jazz");
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

    private ContactDTO createStep9DTO2Contact(){
        ContactDTO result = new ContactDTO();
        result.setId("0");
        result.setTypeID("fam");
        result.setProfileImage("star.png");
        result.setTypeImageAsset("family");
        result.setFirstname("Mary");
        result.setLastname("Smith");
        result.setPhone("+1 123 0000");
        result.setMobile("+1 456 1234");
        result.setStreet("My Street");
        result.setCountry("USA");
        result.setState("Mystate");
        result.setCity("Mycity");
        result.setPostalCode("1234");
        result.setWebSite("");

        List<String> list2 = new ArrayList<String>();
        result.setPreferredMusic(list2);
        list2.add("Classic");
        list2.add("Jazz");
        return result;
    }

    private FLUIClientPropertiesDTO createStep11DTO1_ClientProperties(){
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

    private FLUIClientPropertiesDTO createStep13DTO1_ClientProperties(){
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


        ContactDTO dto9 = new ContactDTO();
        list9.add(dto9);
        dto9.setId("1");
        dto9.setTypeID("fam");
        dto9.setProfileImage("triangle.png");
        dto9.setTypeImageAsset("family");
        dto9.setFirstname("Tom");
        dto9.setLastname("Smith");
        dto9.setPhone("+1 123 0000");
        dto9.setMobile("+1 456 1222");
        dto9.setStreet("My Street");
        dto9.setCountry("USA");
        dto9.setState("Mystate");
        dto9.setCity("Mycity");
        dto9.setPostalCode("1234");
        dto9.setWebSite("");

        List<String> list11 = new ArrayList<String>();
        dto9.setPreferredMusic(list11);
        list11.add("Classic");
        list11.add("Jazz");


        ContactDTO dto10 = new ContactDTO();
        list9.add(dto10);
        dto10.setId("6");
        dto10.setTypeID("fam");
        dto10.setProfileImage("default.png");
        dto10.setTypeImageAsset("family");
        dto10.setFirstname("Bob");
        dto10.setLastname("Smith");
        dto10.setPhone("+1 123 0000");
        dto10.setMobile("+1 456 1333");
        dto10.setStreet("My Street");
        dto10.setCountry("USA");
        dto10.setState("Mystate");
        dto10.setCity("Mycity");
        dto10.setPostalCode("1234");
        dto10.setWebSite("");

        List<String> list12 = new ArrayList<String>();
        dto10.setPreferredMusic(list12);
        list12.add("Pop");
        list12.add("Electro");

        return dto;
    }

    private ContactListDTO createReplyParamForStep5Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list13 = new ArrayList<ContactDTO>();
        dto.setItems(list13);

        ContactDTO dto11 = new ContactDTO();
        list13.add(dto11);
        dto11.setId("0");
        dto11.setTypeID("fam");
        dto11.setProfileImage("star.png");
        dto11.setTypeImageAsset("family");
        dto11.setFirstname("Mary");
        dto11.setLastname("Smith");
        dto11.setPhone("+1 123 0000");
        dto11.setMobile("+1 456 1234");
        dto11.setStreet("My Street");
        dto11.setCountry("USA");
        dto11.setState("Mystate");
        dto11.setCity("Mycity");
        dto11.setPostalCode("1234");
        dto11.setWebSite("");

        List<String> list14 = new ArrayList<String>();
        dto11.setPreferredMusic(list14);
        list14.add("Classic");
        list14.add("Jazz");


        ContactDTO dto12 = new ContactDTO();
        list13.add(dto12);
        dto12.setId("1");
        dto12.setTypeID("fam");
        dto12.setProfileImage("triangle.png");
        dto12.setTypeImageAsset("family");
        dto12.setFirstname("Tom");
        dto12.setLastname("Smith");
        dto12.setPhone("+1 123 0000");
        dto12.setMobile("+1 456 1222");
        dto12.setStreet("My Street");
        dto12.setCountry("USA");
        dto12.setState("Mystate");
        dto12.setCity("Mycity");
        dto12.setPostalCode("1234");
        dto12.setWebSite("");

        List<String> list15 = new ArrayList<String>();
        dto12.setPreferredMusic(list15);
        list15.add("Classic");
        list15.add("Jazz");


        ContactDTO dto13 = new ContactDTO();
        list13.add(dto13);
        dto13.setId("2");
        dto13.setTypeID("fri");
        dto13.setProfileImage("default.png");
        dto13.setTypeImageAsset("friend");
        dto13.setFirstname("Ronald");
        dto13.setLastname("Lee");
        dto13.setPhone("+1 453 2346");
        dto13.setMobile("+1 456 1666");
        dto13.setStreet("Long Street");
        dto13.setCountry("USA");
        dto13.setState("Mystate");
        dto13.setCity("Mycity");
        dto13.setPostalCode("1234");
        dto13.setWebSite("");

        List<String> list16 = new ArrayList<String>();
        dto13.setPreferredMusic(list16);
        list16.add("Rock");
        list16.add("Pop");


        ContactDTO dto14 = new ContactDTO();
        list13.add(dto14);
        dto14.setId("3");
        dto14.setTypeID("com");
        dto14.setProfileImage("painted-globe.jpg");
        dto14.setTypeImageAsset("company");
        dto14.setFirstname("");
        dto14.setLastname("Wiki Corp");
        dto14.setPhone("+1 300 34342");
        dto14.setMobile("+1 342 3554");
        dto14.setStreet("New Street");
        dto14.setCountry("Web-Land");
        dto14.setState("Web-State");
        dto14.setCity("Webcity");
        dto14.setPostalCode("1234");
        dto14.setWebSite("http://www.wikipedia.org");

        List<String> list17 = new ArrayList<String>();
        dto14.setPreferredMusic(list17);
        list17.add("Classic");
        list17.add("Jazz");


        ContactDTO dto15 = new ContactDTO();
        list13.add(dto15);
        dto15.setId("4");
        dto15.setTypeID("col");
        dto15.setProfileImage("default.png");
        dto15.setTypeImageAsset("colleague");
        dto15.setFirstname("John");
        dto15.setLastname("Miller");
        dto15.setPhone("+1 300 1111");
        dto15.setMobile("+1 456 444");
        dto15.setStreet("Some Street");
        dto15.setCountry("USA");
        dto15.setState("Mystate");
        dto15.setCity("Mycity");
        dto15.setPostalCode("1234");
        dto15.setWebSite("");

        List<String> list18 = new ArrayList<String>();
        dto15.setPreferredMusic(list18);
        list18.add("Pop");
        list18.add("Electro");


        ContactDTO dto16 = new ContactDTO();
        list13.add(dto16);
        dto16.setId("5");
        dto16.setTypeID("col");
        dto16.setProfileImage("default.png");
        dto16.setTypeImageAsset("colleague");
        dto16.setFirstname("Robert");
        dto16.setLastname("Meyer");
        dto16.setPhone("+1 300 2222");
        dto16.setMobile("+1 456 555");
        dto16.setStreet("New Street");
        dto16.setCountry("USA");
        dto16.setState("Mystate");
        dto16.setCity("Mycity");
        dto16.setPostalCode("3456");
        dto16.setWebSite("");

        List<String> list19 = new ArrayList<String>();
        dto16.setPreferredMusic(list19);
        list19.add("Pop");
        list19.add("Electro");


        ContactDTO dto17 = new ContactDTO();
        list13.add(dto17);
        dto17.setId("6");
        dto17.setTypeID("fam");
        dto17.setProfileImage("default.png");
        dto17.setTypeImageAsset("family");
        dto17.setFirstname("Bob");
        dto17.setLastname("Smith");
        dto17.setPhone("+1 123 0000");
        dto17.setMobile("+1 456 1333");
        dto17.setStreet("My Street");
        dto17.setCountry("USA");
        dto17.setState("Mystate");
        dto17.setCity("Mycity");
        dto17.setPostalCode("1234");
        dto17.setWebSite("");

        List<String> list20 = new ArrayList<String>();
        dto17.setPreferredMusic(list20);
        list20.add("Pop");
        list20.add("Electro");

        return dto;
    }

    private ContactListDTO createReplyParamForStep6Action4(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list21 = new ArrayList<ContactDTO>();
        dto.setItems(list21);

        ContactDTO dto18 = new ContactDTO();
        list21.add(dto18);
        dto18.setId("0");
        dto18.setTypeID("fam");
        dto18.setProfileImage("star.png");
        dto18.setTypeImageAsset("family");
        dto18.setFirstname("Mary");
        dto18.setLastname("Smith");
        dto18.setPhone("+1 123 0000");
        dto18.setMobile("+1 456 1234");
        dto18.setStreet("My Street");
        dto18.setCountry("USA");
        dto18.setState("Mystate");
        dto18.setCity("Mycity");
        dto18.setPostalCode("1234");
        dto18.setWebSite("");

        List<String> list22 = new ArrayList<String>();
        dto18.setPreferredMusic(list22);
        list22.add("Classic");
        list22.add("Jazz");


        ContactDTO dto19 = new ContactDTO();
        list21.add(dto19);
        dto19.setId("1");
        dto19.setTypeID("fam");
        dto19.setProfileImage("triangle.png");
        dto19.setTypeImageAsset("family");
        dto19.setFirstname("Tom");
        dto19.setLastname("Smith");
        dto19.setPhone("+1 123 0000");
        dto19.setMobile("+1 456 1222");
        dto19.setStreet("My Street");
        dto19.setCountry("USA");
        dto19.setState("Mystate");
        dto19.setCity("Mycity");
        dto19.setPostalCode("1234");
        dto19.setWebSite("");

        List<String> list23 = new ArrayList<String>();
        dto19.setPreferredMusic(list23);
        list23.add("Classic");
        list23.add("Jazz");


        ContactDTO dto20 = new ContactDTO();
        list21.add(dto20);
        dto20.setId("6");
        dto20.setTypeID("fam");
        dto20.setProfileImage("default.png");
        dto20.setTypeImageAsset("family");
        dto20.setFirstname("Bob");
        dto20.setLastname("Smith");
        dto20.setPhone("+1 123 0000");
        dto20.setMobile("+1 456 1333");
        dto20.setStreet("My Street");
        dto20.setCountry("USA");
        dto20.setState("Mystate");
        dto20.setCity("Mycity");
        dto20.setPostalCode("1234");
        dto20.setWebSite("");

        List<String> list24 = new ArrayList<String>();
        dto20.setPreferredMusic(list24);
        list24.add("Pop");
        list24.add("Electro");

        return dto;
    }

    private ContactDTO createReplyParamForStep7Action1(){
        ContactDTO dto = new ContactDTO();
        dto.setId("0");
        dto.setTypeID("fam");
        dto.setProfileImage("star.png");
        dto.setTypeImageAsset("family");
        dto.setFirstname("Mary");
        dto.setLastname("Smith");
        dto.setPhone("+1 123 0000");
        dto.setMobile("+1 456 1234");
        dto.setStreet("My Street");
        dto.setCountry("USA");
        dto.setState("Mystate");
        dto.setCity("Mycity");
        dto.setPostalCode("1234");
        dto.setWebSite("");

        List<String> list25 = new ArrayList<String>();
        dto.setPreferredMusic(list25);
        list25.add("Classic");
        list25.add("Jazz");
        return dto;
    }

    private ContactDTO createReplyParamForStep8Action1(){
        ContactDTO dto = new ContactDTO();
        dto.setId("0");
        dto.setTypeID("fam");
        dto.setProfileImage("star.png");
        dto.setTypeImageAsset("family");
        dto.setFirstname("Mary");
        dto.setLastname("Smith");
        dto.setPhone("+1 123 0000");
        dto.setMobile("+1 456 1234");
        dto.setStreet("My Street");
        dto.setCountry("USA");
        dto.setState("Mystate");
        dto.setCity("Mycity");
        dto.setPostalCode("1234");
        dto.setWebSite("");

        List<String> list26 = new ArrayList<String>();
        dto.setPreferredMusic(list26);
        list26.add("Classic");
        list26.add("Jazz");
        return dto;
    }

    private ContactTypeListDTO createReplyParamForStep9Action2(){
        ContactTypeListDTO dto = new ContactTypeListDTO();

        List<ContactTypeDTO> list27 = new ArrayList<ContactTypeDTO>();
        dto.setItems(list27);

        ContactTypeDTO dto21 = new ContactTypeDTO();
        list27.add(dto21);
        dto21.setId("col");
        dto21.setLabel("Colleague");
        dto21.setImageAssetID("colleague");


        ContactTypeDTO dto22 = new ContactTypeDTO();
        list27.add(dto22);
        dto22.setId("com");
        dto22.setLabel("Company");
        dto22.setImageAssetID("company");


        ContactTypeDTO dto23 = new ContactTypeDTO();
        list27.add(dto23);
        dto23.setId("fam");
        dto23.setLabel("Family");
        dto23.setImageAssetID("family");


        ContactTypeDTO dto24 = new ContactTypeDTO();
        list27.add(dto24);
        dto24.setId("fri");
        dto24.setLabel("Friend");
        dto24.setImageAssetID("friend");

        return dto;
    }

    private ContactListDTO createReplyParamForStep11Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list28 = new ArrayList<ContactDTO>();
        dto.setItems(list28);

        ContactDTO dto25 = new ContactDTO();
        list28.add(dto25);
        dto25.setId("0");
        dto25.setTypeID("fam");
        dto25.setProfileImage("star.png");
        dto25.setTypeImageAsset("family");
        dto25.setFirstname("Mary");
        dto25.setLastname("Smith");
        dto25.setPhone("+1 123 0000");
        dto25.setMobile("+1 456 1234");
        dto25.setStreet("My Street");
        dto25.setCountry("USA");
        dto25.setState("Mystate");
        dto25.setCity("Mycity");
        dto25.setPostalCode("1234");
        dto25.setWebSite("");

        List<String> list29 = new ArrayList<String>();
        dto25.setPreferredMusic(list29);
        list29.add("Classic");
        list29.add("Jazz");


        ContactDTO dto26 = new ContactDTO();
        list28.add(dto26);
        dto26.setId("1");
        dto26.setTypeID("fam");
        dto26.setProfileImage("triangle.png");
        dto26.setTypeImageAsset("family");
        dto26.setFirstname("Tom");
        dto26.setLastname("Smith");
        dto26.setPhone("+1 123 0000");
        dto26.setMobile("+1 456 1222");
        dto26.setStreet("My Street");
        dto26.setCountry("USA");
        dto26.setState("Mystate");
        dto26.setCity("Mycity");
        dto26.setPostalCode("1234");
        dto26.setWebSite("");

        List<String> list30 = new ArrayList<String>();
        dto26.setPreferredMusic(list30);
        list30.add("Classic");
        list30.add("Jazz");


        ContactDTO dto27 = new ContactDTO();
        list28.add(dto27);
        dto27.setId("2");
        dto27.setTypeID("fri");
        dto27.setProfileImage("default.png");
        dto27.setTypeImageAsset("friend");
        dto27.setFirstname("Ronald");
        dto27.setLastname("Lee");
        dto27.setPhone("+1 453 2346");
        dto27.setMobile("+1 456 1666");
        dto27.setStreet("Long Street");
        dto27.setCountry("USA");
        dto27.setState("Mystate");
        dto27.setCity("Mycity");
        dto27.setPostalCode("1234");
        dto27.setWebSite("");

        List<String> list31 = new ArrayList<String>();
        dto27.setPreferredMusic(list31);
        list31.add("Rock");
        list31.add("Pop");


        ContactDTO dto28 = new ContactDTO();
        list28.add(dto28);
        dto28.setId("3");
        dto28.setTypeID("com");
        dto28.setProfileImage("painted-globe.jpg");
        dto28.setTypeImageAsset("company");
        dto28.setFirstname("");
        dto28.setLastname("Wiki Corp");
        dto28.setPhone("+1 300 34342");
        dto28.setMobile("+1 342 3554");
        dto28.setStreet("New Street");
        dto28.setCountry("Web-Land");
        dto28.setState("Web-State");
        dto28.setCity("Webcity");
        dto28.setPostalCode("1234");
        dto28.setWebSite("http://www.wikipedia.org");

        List<String> list32 = new ArrayList<String>();
        dto28.setPreferredMusic(list32);
        list32.add("Classic");
        list32.add("Jazz");


        ContactDTO dto29 = new ContactDTO();
        list28.add(dto29);
        dto29.setId("4");
        dto29.setTypeID("col");
        dto29.setProfileImage("default.png");
        dto29.setTypeImageAsset("colleague");
        dto29.setFirstname("John");
        dto29.setLastname("Miller");
        dto29.setPhone("+1 300 1111");
        dto29.setMobile("+1 456 444");
        dto29.setStreet("Some Street");
        dto29.setCountry("USA");
        dto29.setState("Mystate");
        dto29.setCity("Mycity");
        dto29.setPostalCode("1234");
        dto29.setWebSite("");

        List<String> list33 = new ArrayList<String>();
        dto29.setPreferredMusic(list33);
        list33.add("Pop");
        list33.add("Electro");


        ContactDTO dto30 = new ContactDTO();
        list28.add(dto30);
        dto30.setId("5");
        dto30.setTypeID("col");
        dto30.setProfileImage("default.png");
        dto30.setTypeImageAsset("colleague");
        dto30.setFirstname("Robert");
        dto30.setLastname("Meyer");
        dto30.setPhone("+1 300 2222");
        dto30.setMobile("+1 456 555");
        dto30.setStreet("New Street");
        dto30.setCountry("USA");
        dto30.setState("Mystate");
        dto30.setCity("Mycity");
        dto30.setPostalCode("3456");
        dto30.setWebSite("");

        List<String> list34 = new ArrayList<String>();
        dto30.setPreferredMusic(list34);
        list34.add("Pop");
        list34.add("Electro");


        ContactDTO dto31 = new ContactDTO();
        list28.add(dto31);
        dto31.setId("6");
        dto31.setTypeID("fam");
        dto31.setProfileImage("default.png");
        dto31.setTypeImageAsset("family");
        dto31.setFirstname("Bob");
        dto31.setLastname("Smith");
        dto31.setPhone("+1 123 0000");
        dto31.setMobile("+1 456 1333");
        dto31.setStreet("My Street");
        dto31.setCountry("USA");
        dto31.setState("Mystate");
        dto31.setCity("Mycity");
        dto31.setPostalCode("1234");
        dto31.setWebSite("");

        List<String> list35 = new ArrayList<String>();
        dto31.setPreferredMusic(list35);
        list35.add("Pop");
        list35.add("Electro");

        return dto;
    }

    private ContactListDTO createReplyParamForStep13Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list36 = new ArrayList<ContactDTO>();
        dto.setItems(list36);

        ContactDTO dto32 = new ContactDTO();
        list36.add(dto32);
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

        List<String> list37 = new ArrayList<String>();
        dto32.setPreferredMusic(list37);
        list37.add("Classic");
        list37.add("Jazz");


        ContactDTO dto33 = new ContactDTO();
        list36.add(dto33);
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

        List<String> list38 = new ArrayList<String>();
        dto33.setPreferredMusic(list38);
        list38.add("Classic");
        list38.add("Jazz");


        ContactDTO dto34 = new ContactDTO();
        list36.add(dto34);
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
        dto34.setPostalCode("1234");
        dto34.setWebSite("");

        List<String> list39 = new ArrayList<String>();
        dto34.setPreferredMusic(list39);
        list39.add("Rock");
        list39.add("Pop");


        ContactDTO dto35 = new ContactDTO();
        list36.add(dto35);
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

        List<String> list40 = new ArrayList<String>();
        dto35.setPreferredMusic(list40);
        list40.add("Classic");
        list40.add("Jazz");


        ContactDTO dto36 = new ContactDTO();
        list36.add(dto36);
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

        List<String> list41 = new ArrayList<String>();
        dto36.setPreferredMusic(list41);
        list41.add("Pop");
        list41.add("Electro");


        ContactDTO dto37 = new ContactDTO();
        list36.add(dto37);
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

        List<String> list42 = new ArrayList<String>();
        dto37.setPreferredMusic(list42);
        list42.add("Pop");
        list42.add("Electro");


        ContactDTO dto38 = new ContactDTO();
        list36.add(dto38);
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

        List<String> list43 = new ArrayList<String>();
        dto38.setPreferredMusic(list43);
        list43.add("Pop");
        list43.add("Electro");

        return dto;
    }

}
