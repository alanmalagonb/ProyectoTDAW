package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class Ingrediente {

    private int idIngrediente;
    private int nombreIngrediente;
    private double stockNecesario;
    private double stockActual;

}
