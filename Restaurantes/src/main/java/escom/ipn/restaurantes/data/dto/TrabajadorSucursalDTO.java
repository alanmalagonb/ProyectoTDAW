package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Sucursal;
import escom.ipn.restaurantes.data.pojo.Trabajador;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrabajadorSucursalDTO extends DTO {
    private Sucursal sucursal;
    private List<Trabajador> trabajadores;
    
    public TrabajadorSucursalDTO(){
        sucursal = new Sucursal();
        trabajadores = new ArrayList<>();
    }
}