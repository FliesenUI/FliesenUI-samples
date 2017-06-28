package generated.fliesenui.dto;

import java.util.List;

public class ContactListListDTOBuilder {
    public static ContactListListDTO construct(List<ContactListDTO> items){
        ContactListListDTO result = new ContactListListDTO();
        result.setItems(items);
        return result;
    }
}
