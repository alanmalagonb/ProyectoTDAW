package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class HorarioLaboral {
    
    private String diaSemana;
    private java.sql.Time entrada;
    private java.sql.Time salida;

}
