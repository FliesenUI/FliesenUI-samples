package generated.fliesenui.dto;

import java.util.List;

public class ContactTypeListDTOBuilder {
    public static ContactTypeListDTO construct(List<ContactTypeDTO> items){
        ContactTypeListDTO result = new ContactTypeListDTO();
        result.setItems(items);
        return result;
    }
}
