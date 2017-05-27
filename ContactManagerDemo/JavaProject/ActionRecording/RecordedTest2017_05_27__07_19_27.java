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

/* TODO: Add imports for presenters */

public class RecordedTest2017_05_27__07_19_27{

    private FLUIScreenManager screenManager = FLUIScreenManager.createSimpleInstance();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void setupPresenters(){
        screenManager.setDetailsLargePresenter(/* TODO: Add presenter DetailsLarge*/);
        screenManager.setDetailsSmallPresenter(/* TODO: Add presenter DetailsSmall*/);
        screenManager.setOverviewLargePresenter(/* TODO: Add presenter OverviewLarge*/);
        screenManager.setOverviewSmallPresenter(/* TODO: Add presenter OverviewSmall*/);
    }

    @Test
    public void testMain(){
        setupPresenters();
        testStep001(); //: overviewLarge: onLoaded
        testStep002(); //: overviewLarge: onContactsTableRowClicked
        testStep003(); //: detailsLarge: onLoaded
        testStep004(); //: detailsLarge: widgetButtonCancelButtonClicked
        testStep005(); //: overviewLarge: onLoaded
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
        OverviewLargeRequest request = OverviewLargeRequest.createOnContactsTableRowClickedRequest("DEFAULT", "0");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenDetailsLarge(createReplyParamForStep2Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep003(){
        DetailsLargeRequest request = DetailsLargeRequest.createOnLoadedRequest("DEFAULT", createStep3DTO1_ClientProperties(), createStep3DTO2Contact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsLargeReply expectedReply = new DetailsLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setProfileImageFileUploadVisible(true);
        expectedReply.setTypesDTO(createReplyParamForStep3Action2());
        expectedReply.setTypeSelectBoxSelectedID("fam");
        expectedReply.setPreferredMusicContentLabelText("Classic, Jazz");

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep004(){
        DetailsLargeRequest request = DetailsLargeRequest.createOnCancelButtonClickedRequest("DEFAULT");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsLargeReply expectedReply = new DetailsLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenOverviewLarge();

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep005(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnLoadedRequest("DEFAULT", createStep5DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep5Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private FLUIClientPropertiesDTO createStep1DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(1366);
        result.setScreenAvailableHeightInPixels(728);
        result.setScreenWidthInPixels(1366);
        result.setScreenHeightInPixels(768);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(35.94736842105263);
        result.setScreenHeightInCM(20.210526315789473);
        result.setScreenWidthInInch(14.152514894736843);
        result.setScreenHeightInInch(7.956904421052632);
        result.setScreenDiagonalInInch(16.2359479492734);
        result.setErrorMessage(null);
        return result;
    }

    private FLUIClientPropertiesDTO createStep3DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(1366);
        result.setScreenAvailableHeightInPixels(728);
        result.setScreenWidthInPixels(1366);
        result.setScreenHeightInPixels(768);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(35.94736842105263);
        result.setScreenHeightInCM(20.210526315789473);
        result.setScreenWidthInInch(14.152514894736843);
        result.setScreenHeightInInch(7.956904421052632);
        result.setScreenDiagonalInInch(16.2359479492734);
        result.setErrorMessage(null);
        return result;
    }

    private ContactDTO createStep3DTO2Contact(){
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

    private FLUIClientPropertiesDTO createStep5DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19");
        result.setNavigatorLanguage(null);
        result.setScreenAvailableWidthInPixels(1366);
        result.setScreenAvailableHeightInPixels(728);
        result.setScreenWidthInPixels(1366);
        result.setScreenHeightInPixels(768);
        result.setWindowInnerWidthInPixels(1000);
        result.setWindowInnerHeightInPixels(700);
        result.setPixelHeightPerCM(38.0);
        result.setPixelWidthPerCM(38.0);
        result.setPixelHeightPerInch(14.960638000000001);
        result.setPixelWidthPerInch(14.960638000000001);
        result.setScreenWidthInCM(35.94736842105263);
        result.setScreenHeightInCM(20.210526315789473);
        result.setScreenWidthInInch(14.152514894736843);
        result.setScreenHeightInInch(7.956904421052632);
        result.setScreenDiagonalInInch(16.2359479492734);
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

    private ContactDTO createReplyParamForStep2Action1(){
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

        List<String> list9 = new ArrayList<String>();
        dto.setPreferredMusic(list9);
        list9.add("Classic");
        list9.add("Jazz");
        return dto;
    }

    private ContactTypeListDTO createReplyParamForStep3Action2(){
        ContactTypeListDTO dto = new ContactTypeListDTO();

        List<ContactTypeDTO> list10 = new ArrayList<ContactTypeDTO>();
        dto.setItems(list10);

        ContactTypeDTO dto8 = new ContactTypeDTO();
        list10.add(dto8);
        dto8.setId("col");
        dto8.setLabel("Colleague");
        dto8.setImageAssetID("colleague");


        ContactTypeDTO dto9 = new ContactTypeDTO();
        list10.add(dto9);
        dto9.setId("com");
        dto9.setLabel("Company");
        dto9.setImageAssetID("company");


        ContactTypeDTO dto10 = new ContactTypeDTO();
        list10.add(dto10);
        dto10.setId("fam");
        dto10.setLabel("Family");
        dto10.setImageAssetID("family");


        ContactTypeDTO dto11 = new ContactTypeDTO();
        list10.add(dto11);
        dto11.setId("fri");
        dto11.setLabel("Friend");
        dto11.setImageAssetID("friend");

        return dto;
    }

    private ContactListDTO createReplyParamForStep5Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list11 = new ArrayList<ContactDTO>();
        dto.setItems(list11);

        ContactDTO dto12 = new ContactDTO();
        list11.add(dto12);
        dto12.setId("0");
        dto12.setTypeID("fam");
        dto12.setProfileImage("star.png");
        dto12.setTypeImageAsset("family");
        dto12.setFirstname("Mary");
        dto12.setLastname("Smith");
        dto12.setPhone("+1 123 0000");
        dto12.setMobile("+1 456 1234");
        dto12.setStreet("My Street");
        dto12.setCountry("USA");
        dto12.setState("Mystate");
        dto12.setCity("Mycity");
        dto12.setPostalCode("1234");
        dto12.setWebSite("");

        List<String> list12 = new ArrayList<String>();
        dto12.setPreferredMusic(list12);
        list12.add("Classic");
        list12.add("Jazz");


        ContactDTO dto13 = new ContactDTO();
        list11.add(dto13);
        dto13.setId("1");
        dto13.setTypeID("fam");
        dto13.setProfileImage("triangle.png");
        dto13.setTypeImageAsset("family");
        dto13.setFirstname("Tom");
        dto13.setLastname("Smith");
        dto13.setPhone("+1 123 0000");
        dto13.setMobile("+1 456 1222");
        dto13.setStreet("My Street");
        dto13.setCountry("USA");
        dto13.setState("Mystate");
        dto13.setCity("Mycity");
        dto13.setPostalCode("1234");
        dto13.setWebSite("");

        List<String> list13 = new ArrayList<String>();
        dto13.setPreferredMusic(list13);
        list13.add("Classic");
        list13.add("Jazz");


        ContactDTO dto14 = new ContactDTO();
        list11.add(dto14);
        dto14.setId("2");
        dto14.setTypeID("fri");
        dto14.setProfileImage("default.png");
        dto14.setTypeImageAsset("friend");
        dto14.setFirstname("Ronald");
        dto14.setLastname("Lee");
        dto14.setPhone("+1 453 2346");
        dto14.setMobile("+1 456 1666");
        dto14.setStreet("Long Street");
        dto14.setCountry("USA");
        dto14.setState("Mystate");
        dto14.setCity("Mycity");
        dto14.setPostalCode("1234");
        dto14.setWebSite("");

        List<String> list14 = new ArrayList<String>();
        dto14.setPreferredMusic(list14);
        list14.add("Rock");
        list14.add("Pop");


        ContactDTO dto15 = new ContactDTO();
        list11.add(dto15);
        dto15.setId("3");
        dto15.setTypeID("com");
        dto15.setProfileImage("painted-globe.jpg");
        dto15.setTypeImageAsset("company");
        dto15.setFirstname("");
        dto15.setLastname("Wiki Corp");
        dto15.setPhone("+1 300 34342");
        dto15.setMobile("+1 342 3554");
        dto15.setStreet("New Street");
        dto15.setCountry("Web-Land");
        dto15.setState("Web-State");
        dto15.setCity("Webcity");
        dto15.setPostalCode("1234");
        dto15.setWebSite("http://www.wikipedia.org");

        List<String> list15 = new ArrayList<String>();
        dto15.setPreferredMusic(list15);
        list15.add("Classic");
        list15.add("Jazz");


        ContactDTO dto16 = new ContactDTO();
        list11.add(dto16);
        dto16.setId("4");
        dto16.setTypeID("col");
        dto16.setProfileImage("default.png");
        dto16.setTypeImageAsset("colleague");
        dto16.setFirstname("John");
        dto16.setLastname("Miller");
        dto16.setPhone("+1 300 1111");
        dto16.setMobile("+1 456 444");
        dto16.setStreet("Some Street");
        dto16.setCountry("USA");
        dto16.setState("Mystate");
        dto16.setCity("Mycity");
        dto16.setPostalCode("1234");
        dto16.setWebSite("");

        List<String> list16 = new ArrayList<String>();
        dto16.setPreferredMusic(list16);
        list16.add("Pop");
        list16.add("Electro");


        ContactDTO dto17 = new ContactDTO();
        list11.add(dto17);
        dto17.setId("5");
        dto17.setTypeID("col");
        dto17.setProfileImage("default.png");
        dto17.setTypeImageAsset("colleague");
        dto17.setFirstname("Robert");
        dto17.setLastname("Meyer");
        dto17.setPhone("+1 300 2222");
        dto17.setMobile("+1 456 555");
        dto17.setStreet("New Street");
        dto17.setCountry("USA");
        dto17.setState("Mystate");
        dto17.setCity("Mycity");
        dto17.setPostalCode("3456");
        dto17.setWebSite("");

        List<String> list17 = new ArrayList<String>();
        dto17.setPreferredMusic(list17);
        list17.add("Pop");
        list17.add("Electro");


        ContactDTO dto18 = new ContactDTO();
        list11.add(dto18);
        dto18.setId("6");
        dto18.setTypeID("fam");
        dto18.setProfileImage("default.png");
        dto18.setTypeImageAsset("family");
        dto18.setFirstname("Bob");
        dto18.setLastname("Smith");
        dto18.setPhone("+1 123 0000");
        dto18.setMobile("+1 456 1333");
        dto18.setStreet("My Street");
        dto18.setCountry("USA");
        dto18.setState("Mystate");
        dto18.setCity("Mycity");
        dto18.setPostalCode("1234");
        dto18.setWebSite("");

        List<String> list18 = new ArrayList<String>();
        dto18.setPreferredMusic(list18);
        list18.add("Pop");
        list18.add("Electro");

        return dto;
    }

}
