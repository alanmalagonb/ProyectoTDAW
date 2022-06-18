package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Permiso;
import escom.ipn.restaurantes.data.pojo.Rol;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermisoDTO extends DTO {
    private Rol rol;
    private List<Permiso> permiso;
    
    public PermisoDTO(){
        rol = new Rol();
        permiso = new ArrayList<>();
    }
}