package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Platillo;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstruccionRecetaDTO extends DTO {
    private Platillo platillo;
    private List<String> instrucciones;
    
    public InstruccionRecetaDTO(){
        platillo = new Platillo();
        instrucciones = new ArrayList<>();
    }
}