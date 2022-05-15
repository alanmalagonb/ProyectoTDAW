package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.DiaSemana;
import escom.ipn.restaurantes.data.pojo.HorarioLaboral;
import escom.ipn.restaurantes.data.pojo.Trabajador;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorarioLaboralDTO extends DTO {
    private HashMap<Integer,HorarioLaboral> horarioLaboral;
    private Trabajador trabajador;
    
    public HorarioLaboralDTO(){
        horarioLaboral = new HashMap<>();
        trabajador = new Trabajador();
    }
}
