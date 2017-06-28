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
import generated.fliesenui.dto.ContactListListDTO;
import generated.fliesenui.dto.ContactTypeDTO;
import generated.fliesenui.dto.ContactTypeListDTO;
import generated.fliesenui.dto.ContactTypeListListDTO;
import generated.fliesenui.screen.DetailsLargeRequest;
import generated.fliesenui.screen.DetailsLargeReply;
import generated.fliesenui.screen.DetailsSmallRequest;
import generated.fliesenui.screen.DetailsSmallReply;
import generated.fliesenui.screen.OverviewLargeRequest;
import generated.fliesenui.screen.OverviewLargeReply;
import generated.fliesenui.screen.OverviewSmallRequest;
import generated.fliesenui.screen.OverviewSmallReply;

/* TODO: Add imports for presenters */

public class RecordedTest2017_06_26__08_18_08{

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
        testStep002(); //: overviewLarge: onLoaded
        testStep003(); //: overviewLarge: widgetButtonSearchButtonClicked
        testStep004(); //: overviewLarge: widgetButtonSearchButtonClicked
        testStep005(); //: overviewLarge: onContactsTableRowClicked
        testStep006(); //: detailsLarge: onLoaded
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
        OverviewLargeRequest request = OverviewLargeRequest.createOnLoadedRequest("DEFAULT", createStep2DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep2Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep003(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "smi");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep3Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep004(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep4Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep005(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnContactsTableRowClickedRequest("DEFAULT", "0");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.openScreenDetailsLarge(createReplyParamForStep5Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep006(){
        DetailsLargeRequest request = DetailsLargeRequest.createOnLoadedRequest("DEFAULT", createStep6DTO1_ClientProperties(), createStep6DTO2Contact());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null, true);
        String realResultJSON = gson.toJson(realResult);

        DetailsLargeReply expectedReply = new DetailsLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setProfileImageFileUploadVisible(true);
        expectedReply.setTypesDTO(createReplyParamForStep6Action2());
        expectedReply.setTypeSelectBoxSelectedID("fam");
        expectedReply.setPreferredMusicContentLabelText("Classic, Jazz");

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignore recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private FLUIClientPropertiesDTO createStep1DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/602.1 (KHTML, like Gecko) JavaFX/8.0 Safari/602.1");
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

    private FLUIClientPropertiesDTO createStep2DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/602.1 (KHTML, like Gecko) JavaFX/8.0 Safari/602.1");
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

    private FLUIClientPropertiesDTO createStep6DTO1_ClientProperties(){
        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();
        result.setUserAgent("Mozilla/5.0 (Windows NT 6.3) AppleWebKit/602.1 (KHTML, like Gecko) JavaFX/8.0 Safari/602.1");
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

    private ContactDTO createStep6DTO2Contact(){
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
        dto10.setId("2");
        dto10.setTypeID("fri");
        dto10.setProfileImage("default.png");
        dto10.setTypeImageAsset("friend");
        dto10.setFirstname("Ronald");
        dto10.setLastname("Lee");
        dto10.setPhone("+1 453 2346");
        dto10.setMobile("+1 456 1666");
        dto10.setStreet("Long Street");
        dto10.setCountry("USA");
        dto10.setState("Mystate");
        dto10.setCity("Mycity");
        dto10.setPostalCode("1234");
        dto10.setWebSite("");

        List<String> list12 = new ArrayList<String>();
        dto10.setPreferredMusic(list12);
        list12.add("Rock");
        list12.add("Pop");


        ContactDTO dto11 = new ContactDTO();
        list9.add(dto11);
        dto11.setId("3");
        dto11.setTypeID("com");
        dto11.setProfileImage("painted-globe.jpg");
        dto11.setTypeImageAsset("company");
        dto11.setFirstname("");
        dto11.setLastname("Wiki Corp");
        dto11.setPhone("+1 300 34342");
        dto11.setMobile("+1 342 3554");
        dto11.setStreet("New Street");
        dto11.setCountry("Web-Land");
        dto11.setState("Web-State");
        dto11.setCity("Webcity");
        dto11.setPostalCode("1234");
        dto11.setWebSite("http://www.wikipedia.org");

        List<String> list13 = new ArrayList<String>();
        dto11.setPreferredMusic(list13);
        list13.add("Classic");
        list13.add("Jazz");


        ContactDTO dto12 = new ContactDTO();
        list9.add(dto12);
        dto12.setId("4");
        dto12.setTypeID("col");
        dto12.setProfileImage("default.png");
        dto12.setTypeImageAsset("colleague");
        dto12.setFirstname("John");
        dto12.setLastname("Miller");
        dto12.setPhone("+1 300 1111");
        dto12.setMobile("+1 456 444");
        dto12.setStreet("Some Street");
        dto12.setCountry("USA");
        dto12.setState("Mystate");
        dto12.setCity("Mycity");
        dto12.setPostalCode("1234");
        dto12.setWebSite("");

        List<String> list14 = new ArrayList<String>();
        dto12.setPreferredMusic(list14);
        list14.add("Pop");
        list14.add("Electro");


        ContactDTO dto13 = new ContactDTO();
        list9.add(dto13);
        dto13.setId("5");
        dto13.setTypeID("col");
        dto13.setProfileImage("default.png");
        dto13.setTypeImageAsset("colleague");
        dto13.setFirstname("Robert");
        dto13.setLastname("Meyer");
        dto13.setPhone("+1 300 2222");
        dto13.setMobile("+1 456 555");
        dto13.setStreet("New Street");
        dto13.setCountry("USA");
        dto13.setState("Mystate");
        dto13.setCity("Mycity");
        dto13.setPostalCode("3456");
        dto13.setWebSite("");

        List<String> list15 = new ArrayList<String>();
        dto13.setPreferredMusic(list15);
        list15.add("Pop");
        list15.add("Electro");


        ContactDTO dto14 = new ContactDTO();
        list9.add(dto14);
        dto14.setId("6");
        dto14.setTypeID("fam");
        dto14.setProfileImage("default.png");
        dto14.setTypeImageAsset("family");
        dto14.setFirstname("Bob");
        dto14.setLastname("Smith");
        dto14.setPhone("+1 123 0000");
        dto14.setMobile("+1 456 1333");
        dto14.setStreet("My Street");
        dto14.setCountry("USA");
        dto14.setState("Mystate");
        dto14.setCity("Mycity");
        dto14.setPostalCode("1234");
        dto14.setWebSite("");

        List<String> list16 = new ArrayList<String>();
        dto14.setPreferredMusic(list16);
        list16.add("Pop");
        list16.add("Electro");

        return dto;
    }

    private ContactListDTO createReplyParamForStep3Action1(){
        ContactListDTO dto = new ContactListDTO();

        List<ContactDTO> list17 = new ArrayList<ContactDTO>();
        dto.setItems(list17);

        ContactDTO dto15 = new ContactDTO();
        list17.add(dto15);
        dto15.setId("0");
        dto15.setTypeID("fam");
        dto15.setProfileImage("star.png");
        dto15.setTypeImageAsset("family");
        dto15.setFirstname("Mary");
        dto15.setLastname("Smith");
        dto15.setPhone("+1 123 0000");
        dto15.setMobile("+1 456 1234");
        dto15.setStreet("My Street");
        dto15.setCountry("USA");
        dto15.setState("Mystate");
        dto15.setCity("Mycity");
        dto15.setPostalCode("1234");
        dto15.setWebSite("");

        List<String> list18 = new ArrayList<String>();
        dto15.setPreferredMusic(list18);
        list18.add("Classic");
        list18.add("Jazz");


        ContactDTO dto16 = new ContactDTO();
        list17.add(dto16);
        dto16.setId("1");
        dto16.setTypeID("fam");
        dto16.setProfileImage("triangle.png");
        dto16.setTypeImageAsset("family");
        dto16.setFirstname("Tom");
        dto16.setLastname("Smith");
        dto16.setPhone("+1 123 0000");
        dto16.setMobile("+1 456 1222");
        dto16.setStreet("My Street");
        dto16.setCountry("USA");
        dto16.setState("Mystate");
        dto16.setCity("Mycity");
        dto16.setPostalCode("1234");
        dto16.setWebSite("");

        List<String> list19 = new ArrayList<String>();
        dto16.setPreferredMusic(list19);
        list19.add("Classic");
        list19.add("Jazz");


        ContactDTO dto17 = new ContactDTO();
        list17.add(dto17);
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

    private ContactListDTO createReplyParamForStep4Action1(){
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
        dto20.setId("2");
        dto20.setTypeID("fri");
        dto20.setProfileImage("default.png");
        dto20.setTypeImageAsset("friend");
        dto20.setFirstname("Ronald");
        dto20.setLastname("Lee");
        dto20.setPhone("+1 453 2346");
        dto20.setMobile("+1 456 1666");
        dto20.setStreet("Long Street");
        dto20.setCountry("USA");
        dto20.setState("Mystate");
        dto20.setCity("Mycity");
        dto20.setPostalCode("1234");
        dto20.setWebSite("");

        List<String> list24 = new ArrayList<String>();
        dto20.setPreferredMusic(list24);
        list24.add("Rock");
        list24.add("Pop");


        ContactDTO dto21 = new ContactDTO();
        list21.add(dto21);
        dto21.setId("3");
        dto21.setTypeID("com");
        dto21.setProfileImage("painted-globe.jpg");
        dto21.setTypeImageAsset("company");
        dto21.setFirstname("");
        dto21.setLastname("Wiki Corp");
        dto21.setPhone("+1 300 34342");
        dto21.setMobile("+1 342 3554");
        dto21.setStreet("New Street");
        dto21.setCountry("Web-Land");
        dto21.setState("Web-State");
        dto21.setCity("Webcity");
        dto21.setPostalCode("1234");
        dto21.setWebSite("http://www.wikipedia.org");

        List<String> list25 = new ArrayList<String>();
        dto21.setPreferredMusic(list25);
        list25.add("Classic");
        list25.add("Jazz");


        ContactDTO dto22 = new ContactDTO();
        list21.add(dto22);
        dto22.setId("4");
        dto22.setTypeID("col");
        dto22.setProfileImage("default.png");
        dto22.setTypeImageAsset("colleague");
        dto22.setFirstname("John");
        dto22.setLastname("Miller");
        dto22.setPhone("+1 300 1111");
        dto22.setMobile("+1 456 444");
        dto22.setStreet("Some Street");
        dto22.setCountry("USA");
        dto22.setState("Mystate");
        dto22.setCity("Mycity");
        dto22.setPostalCode("1234");
        dto22.setWebSite("");

        List<String> list26 = new ArrayList<String>();
        dto22.setPreferredMusic(list26);
        list26.add("Pop");
        list26.add("Electro");


        ContactDTO dto23 = new ContactDTO();
        list21.add(dto23);
        dto23.setId("5");
        dto23.setTypeID("col");
        dto23.setProfileImage("default.png");
        dto23.setTypeImageAsset("colleague");
        dto23.setFirstname("Robert");
        dto23.setLastname("Meyer");
        dto23.setPhone("+1 300 2222");
        dto23.setMobile("+1 456 555");
        dto23.setStreet("New Street");
        dto23.setCountry("USA");
        dto23.setState("Mystate");
        dto23.setCity("Mycity");
        dto23.setPostalCode("3456");
        dto23.setWebSite("");

        List<String> list27 = new ArrayList<String>();
        dto23.setPreferredMusic(list27);
        list27.add("Pop");
        list27.add("Electro");


        ContactDTO dto24 = new ContactDTO();
        list21.add(dto24);
        dto24.setId("6");
        dto24.setTypeID("fam");
        dto24.setProfileImage("default.png");
        dto24.setTypeImageAsset("family");
        dto24.setFirstname("Bob");
        dto24.setLastname("Smith");
        dto24.setPhone("+1 123 0000");
        dto24.setMobile("+1 456 1333");
        dto24.setStreet("My Street");
        dto24.setCountry("USA");
        dto24.setState("Mystate");
        dto24.setCity("Mycity");
        dto24.setPostalCode("1234");
        dto24.setWebSite("");

        List<String> list28 = new ArrayList<String>();
        dto24.setPreferredMusic(list28);
        list28.add("Pop");
        list28.add("Electro");

        return dto;
    }

    private ContactDTO createReplyParamForStep5Action1(){
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

        List<String> list29 = new ArrayList<String>();
        dto.setPreferredMusic(list29);
        list29.add("Classic");
        list29.add("Jazz");
        return dto;
    }

    private ContactTypeListDTO createReplyParamForStep6Action2(){
        ContactTypeListDTO dto = new ContactTypeListDTO();

        List<ContactTypeDTO> list30 = new ArrayList<ContactTypeDTO>();
        dto.setItems(list30);

        ContactTypeDTO dto25 = new ContactTypeDTO();
        list30.add(dto25);
        dto25.setId("col");
        dto25.setLabel("Colleague");
        dto25.setImageAssetID("colleague");


        ContactTypeDTO dto26 = new ContactTypeDTO();
        list30.add(dto26);
        dto26.setId("com");
        dto26.setLabel("Company");
        dto26.setImageAssetID("company");


        ContactTypeDTO dto27 = new ContactTypeDTO();
        list30.add(dto27);
        dto27.setId("fam");
        dto27.setLabel("Family");
        dto27.setImageAssetID("family");


        ContactTypeDTO dto28 = new ContactTypeDTO();
        list30.add(dto28);
        dto28.setId("fri");
        dto28.setLabel("Friend");
        dto28.setImageAssetID("friend");

        return dto;
    }

}
