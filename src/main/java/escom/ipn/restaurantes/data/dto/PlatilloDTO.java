package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Medida;
import escom.ipn.restaurantes.data.pojo.Platillo;
import escom.ipn.restaurantes.data.pojo.Restaurante;
import escom.ipn.restaurantes.data.pojo.SeccionMenu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatilloDTO extends DTO {
    private Platillo platillo;
    private Medida medida;
    private SeccionMenu seccionMenu;
    private Restaurante restaurante;
    
    public PlatilloDTO(){
        platillo = new Platillo();
        medida = new Medida();
        seccionMenu = new SeccionMenu();
        restaurante = new Restaurante();
    }
}