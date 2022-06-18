package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolDTO extends DTO{
    private Rol rol;
    
    public RolDTO() {
        rol = new Rol();
    }
}
