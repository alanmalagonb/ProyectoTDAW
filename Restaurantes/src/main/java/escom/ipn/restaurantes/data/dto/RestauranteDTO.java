package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Restaurante;
import escom.ipn.restaurantes.data.pojo.Trabajador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteDTO extends DTO {
    private Restaurante restaurante;
    private Trabajador dueno;
    
    public RestauranteDTO(){
        restaurante = new Restaurante();
        dueno = new Trabajador();
    }
}