package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class HorarioSucursal {

    private String diaSemana;
    private java.sql.Time abierto;
    private java.sql.Time cerrado;

}
