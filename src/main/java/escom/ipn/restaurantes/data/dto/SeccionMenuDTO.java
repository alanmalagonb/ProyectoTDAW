package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.SeccionMenu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeccionMenuDTO extends DTO {
    private SeccionMenu seccionMenu;
    
    public SeccionMenuDTO(){
        seccionMenu = new SeccionMenu();
    }
}