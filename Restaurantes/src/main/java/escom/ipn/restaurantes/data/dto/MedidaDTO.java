package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Medida;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedidaDTO extends DTO {
    private Medida medida;
    
    public MedidaDTO(){
        medida = new Medida();
    }
}