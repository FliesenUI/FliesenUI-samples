package generated.fliesenui.dto;

public class ContactTypeDTOBuilder {
    public static ContactTypeDTO construct(String id, String label, String imageAssetID){
        ContactTypeDTO result = new ContactTypeDTO();
        result.setId(id);
        result.setLabel(label);
        result.setImageAssetID(imageAssetID);
        return result;
    }
}
