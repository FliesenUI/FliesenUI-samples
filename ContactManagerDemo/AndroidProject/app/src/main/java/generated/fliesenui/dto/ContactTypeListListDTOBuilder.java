package generated.fliesenui.dto;

import java.util.List;

public class ContactTypeListListDTOBuilder {
    public static ContactTypeListListDTO construct(List<ContactTypeListDTO> items){
        ContactTypeListListDTO result = new ContactTypeListListDTO();
        result.setItems(items);
        return result;
    }
}
