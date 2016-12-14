package generated.fliesenui.dto;

public class NameAndIconItemDTOBuilder {
    public static NameAndIconItemDTO construct(String id, String firstName, String lastName, String comment, String typeImageAssetID, String imageStreamID, String imageURL, String imageAssetIDVector, String imageStreamIDVector, String imageURLVector){
        NameAndIconItemDTO result = new NameAndIconItemDTO();
        result.setId(id);
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setComment(comment);
        result.setTypeImageAssetID(typeImageAssetID);
        result.setImageStreamID(imageStreamID);
        result.setImageURL(imageURL);
        result.setImageAssetIDVector(imageAssetIDVector);
        result.setImageStreamIDVector(imageStreamIDVector);
        result.setImageURLVector(imageURLVector);
        return result;
    }
}
