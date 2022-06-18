package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.DiaSemana;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaSemanaDTO extends DTO{
    
    private DiaSemana diaSemana;
    
    public DiaSemanaDTO(){
        diaSemana = new DiaSemana();
    }
}
