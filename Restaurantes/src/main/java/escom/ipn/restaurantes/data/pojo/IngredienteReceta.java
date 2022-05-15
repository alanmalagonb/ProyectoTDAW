package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class IngredienteReceta {
    private int idIngrediente;
    private String nombreIngrediente;
    private double cantidad;
    private Medida medida;
}
