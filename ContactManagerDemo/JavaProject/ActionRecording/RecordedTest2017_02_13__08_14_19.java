package com.bright_side_it.fluidemo.contactmanager.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generated.fliesenui.core.FLUIReplyDTO;
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

public class RecordedTest2017_02_13__08_14_19{

    private FLUIScreenManager screenManager = FLUIScreenManager.createSimpleInstance();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void setupPresenters(){
        screenManager.setDetailsLargePresenter(/* TODO: Add presenter */);
        screenManager.setDetailsSmallPresenter(/* TODO: Add presenter */);
        screenManager.setOverviewLargePresenter(/* TODO: Add presenter */);
        screenManager.setOverviewSmallPresenter(/* TODO: Add presenter */);
    }

    @Test
    public void testMain(){
        setupPresenters();
        testStep001(); //: overviewLarge: onLoaded
        testStep002(); //: overviewLarge: widgetButtonSearchButtonClicked
        testStep003(); //: overviewLarge: widgetButtonSearchButtonClicked
    }

    private void testStep001(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnLoadedRequest("DEFAULT", createStep1DTO1_ClientProperties());
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null);
        realResult.setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignored recorded actions
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep1Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignored recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep002(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "ary");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null);
        realResult.setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignored recorded actions
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep2Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignored recorded actions
        String expectedResultJSON = gson.toJson(expectedReply.getReplyDTO());
        assertEquals(expectedResultJSON, realResultJSON);

    }

    private void testStep003(){
        OverviewLargeRequest request = OverviewLargeRequest.createOnSearchButtonClickedRequest("DEFAULT", "");
        FLUIReplyDTO realResult = screenManager.onScreenRequest(request, null, null);
        realResult.setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignored recorded actions
        String realResultJSON = gson.toJson(realResult);

        OverviewLargeReply expectedReply = new OverviewLargeReply(false, StringLanguage.DEFAULT);
        expectedReply.setContactsDTO(createReplyParamForStep3Action1());

        expectedReply.getReplyDTO().setRecordedActions(new ArrayList<FLUIReplyAction>()); //: ignored recorded actions
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
        list2.add(Classic);
        list2.add(Jazz);


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
        list3.add(Classic);
        list3.add(Jazz);


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
        list4.add(Rock);
        list4.add(Pop);


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
        list5.add(Classic);
        list5.add(Jazz);


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
        list6.add(Pop);
        list6.add(Electro);


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
        list7.add(Pop);
        list7.add(Electro);


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
        list8.add(Pop);
        list8.add(Electro);

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
        list10.add(Classic);
        list10.add(Jazz);

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
        list12.add(Classic);
        list12.add(Jazz);


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
        list13.add(Classic);
        list13.add(Jazz);


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
        list14.add(Rock);
        list14.add(Pop);


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
        list15.add(Classic);
        list15.add(Jazz);


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
        list16.add(Pop);
        list16.add(Electro);


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
        list17.add(Pop);
        list17.add(Electro);


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
        list18.add(Pop);
        list18.add(Electro);

        return dto;
    }

}
