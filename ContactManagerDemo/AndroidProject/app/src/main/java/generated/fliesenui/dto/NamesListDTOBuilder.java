package generated.fliesenui.dto;

import java.util.List;

public class NamesListDTOBuilder {
    public static NamesListDTO construct(List<Dto003DTO> names, String title){
        NamesListDTO result = new NamesListDTO();
        result.setNames(names);
        result.setTitle(title);
        return result;
    }
}
