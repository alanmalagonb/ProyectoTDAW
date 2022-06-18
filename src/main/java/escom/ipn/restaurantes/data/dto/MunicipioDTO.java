package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Estado;
import escom.ipn.restaurantes.data.pojo.Municipio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MunicipioDTO extends DTO {
    private Municipio municipio;
    private Estado estado;
    
    public MunicipioDTO(){
        municipio = new Municipio();
        estado = new Estado();
    }
}