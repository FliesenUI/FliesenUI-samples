package generated.fliesenui.dto;

public class ContactDTOBuilder {
    public static ContactDTO construct(String id, String typeID, String profileImage, String typeImageAsset, String firstname, String lastname, String phone, String mobile, String street, String country, String state, String city, String postalCode, String webSite){
        ContactDTO result = new ContactDTO();
        result.setId(id);
        result.setTypeID(typeID);
        result.setProfileImage(profileImage);
        result.setTypeImageAsset(typeImageAsset);
        result.setFirstname(firstname);
        result.setLastname(lastname);
        result.setPhone(phone);
        result.setMobile(mobile);
        result.setStreet(street);
        result.setCountry(country);
        result.setState(state);
        result.setCity(city);
        result.setPostalCode(postalCode);
        result.setWebSite(webSite);
        return result;
    }
}
