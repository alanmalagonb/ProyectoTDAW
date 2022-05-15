package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.IngredienteReceta;
import escom.ipn.restaurantes.data.pojo.Platillo;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteRecetaDTO extends DTO {
    private Platillo platillo;
    private List<IngredienteReceta> ingredientesReceta = new ArrayList<>();
    
    public IngredienteRecetaDTO(){
        platillo = new Platillo();
        ingredientesReceta = new ArrayList<>();
    }
}