package escom.ipn.restaurantes.data.pojo;

import lombok.Data;

@Data
public class Trabajador {

    private int idTrabajador;
    private String nombreTrabajador;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private java.sql.Date fechaNacimiento;
    private String email;
    private String password;
    private String calle;
    private String colonia;
    private int numeroExterior;
    private String telefono;
    private int numeroInterior;

}
