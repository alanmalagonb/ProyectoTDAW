package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Estado;
import escom.ipn.restaurantes.data.pojo.Municipio;
import escom.ipn.restaurantes.data.pojo.Rol;
import escom.ipn.restaurantes.data.pojo.Sucursal;
import escom.ipn.restaurantes.data.pojo.Trabajador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrabajadorDTO extends DTO {
    private Trabajador trabajador;
    private Rol rol;
    private Municipio municipio;
    private Estado estado;
    private Sucursal sucursal;
    
    public TrabajadorDTO(){
        trabajador = new Trabajador();
        rol = new Rol();
        municipio = new Municipio();
        estado = new Estado();
        sucursal = new Sucursal();
    }
}