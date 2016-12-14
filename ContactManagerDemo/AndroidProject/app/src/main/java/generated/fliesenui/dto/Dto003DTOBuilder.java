package generated.fliesenui.dto;

public class Dto003DTOBuilder {
    public static Dto003DTO construct(String id, String firstName, String lastName, String comment){
        Dto003DTO result = new Dto003DTO();
        result.setId(id);
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setComment(comment);
        return result;
    }
}
