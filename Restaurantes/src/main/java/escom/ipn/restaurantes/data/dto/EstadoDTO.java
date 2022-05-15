package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Estado;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO extends DTO {
    private Estado estado;
    
    public EstadoDTO(){
       estado = new Estado();
    }
}