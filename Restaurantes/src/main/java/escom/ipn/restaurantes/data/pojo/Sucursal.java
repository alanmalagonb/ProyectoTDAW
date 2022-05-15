package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class Sucursal {

    private int idSucursal;
    private String nombreSucursal;
    private String telefono;
    private String calle;
    private String colonia;
    private int numeroExterior;
    private int numeroInterior;

}
