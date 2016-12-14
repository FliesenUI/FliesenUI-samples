package generated.fliesenui.dto;

import java.util.List;

public class Dto001DTOBuilder {
    public static Dto001DTO construct(long myNumber001, long myNumber002, String myText001, String myText002, boolean myFlag, List<String> namesList, Dto002DTO myDTO002, List<Dto003DTO> myDTO003List){
        Dto001DTO result = new Dto001DTO();
        result.setMyNumber001(myNumber001);
        result.setMyNumber002(myNumber002);
        result.setMyText001(myText001);
        result.setMyText002(myText002);
        result.setMyFlag(myFlag);
        result.setNamesList(namesList);
        result.setMyDTO002(myDTO002);
        result.setMyDTO003List(myDTO003List);
        return result;
    }
}
