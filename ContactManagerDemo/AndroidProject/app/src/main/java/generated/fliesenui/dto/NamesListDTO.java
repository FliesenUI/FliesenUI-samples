package generated.fliesenui.dto;

import java.util.List;

public class NamesListDTO {
    private List<Dto003DTO> names;
    private String title;

    public List<Dto003DTO> getNames(){
        return names;
    }

    public void setNames(List<Dto003DTO> names){
        this.names = names;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

}
