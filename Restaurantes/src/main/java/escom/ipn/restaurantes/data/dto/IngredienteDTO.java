package escom.ipn.restaurantes.data.dto;

import escom.ipn.restaurantes.data.pojo.Ingrediente;
import escom.ipn.restaurantes.data.pojo.Medida;
import escom.ipn.restaurantes.data.pojo.Restaurante;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alanm
 */
@Getter
@Setter
public class IngredienteDTO extends DTO {
    private Ingrediente ingrediente;
    private Medida medida;
    private Restaurante restaurante;
    
    public IngredienteDTO(){
        ingrediente = new Ingrediente();
        medida = new Medida();
        restaurante = new Restaurante();
    }
}