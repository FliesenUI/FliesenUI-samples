package generated.fliesenui.dto;

import java.util.List;

public class NameAndIconListDTOBuilder {
    public static NameAndIconListDTO construct(List<NameAndIconItemDTO> items, String title){
        NameAndIconListDTO result = new NameAndIconListDTO();
        result.setItems(items);
        result.setTitle(title);
        return result;
    }
}
