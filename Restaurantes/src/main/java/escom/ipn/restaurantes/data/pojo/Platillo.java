package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class Platillo {

    private int idPlatillo;
    private int nombrePlatillo;
    private double precio;
    private String descripcionPlatillo;
    private String imagen;
    private int tiempoPreparacion;
    private double porcion;
    private double calorias;

}
