package generated.fliesenui.dto;

import java.util.List;

public class ContactListDTOBuilder {
    public static ContactListDTO construct(List<ContactDTO> items){
        ContactListDTO result = new ContactListDTO();
        result.setItems(items);
        return result;
    }
}
