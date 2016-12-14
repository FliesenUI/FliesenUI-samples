package generated.fliesenui.dto;

import java.util.List;

public class NameAndIconListDTO {
    private List<NameAndIconItemDTO> items;
    private String title;

    public List<NameAndIconItemDTO> getItems(){
        return items;
    }

    public void setItems(List<NameAndIconItemDTO> items){
        this.items = items;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

}
