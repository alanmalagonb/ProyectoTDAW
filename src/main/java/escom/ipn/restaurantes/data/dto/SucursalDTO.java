package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Estado;
import escom.ipn.restaurantes.data.pojo.Municipio;
import escom.ipn.restaurantes.data.pojo.Restaurante;
import escom.ipn.restaurantes.data.pojo.Sucursal;
import escom.ipn.restaurantes.data.pojo.Trabajador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalDTO extends DTO {
    private Sucursal sucursal;
    private Municipio municipio;
    private Estado estado;
    private Restaurante restaurante;
    
    public SucursalDTO(){
        sucursal = new Sucursal();
        municipio = new Municipio();
        estado = new Estado();
        restaurante = new Restaurante();
    }
}