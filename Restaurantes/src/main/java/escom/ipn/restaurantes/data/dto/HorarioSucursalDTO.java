package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.HorarioSucursal;
import escom.ipn.restaurantes.data.pojo.Sucursal;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorarioSucursalDTO extends DTO {
    private HashMap<Integer,HorarioSucursal> horarioSucursal;
    private Sucursal sucursal;
    
    public HorarioSucursalDTO(){
        horarioSucursal = new HashMap<>();
        sucursal = new Sucursal();
    }
}