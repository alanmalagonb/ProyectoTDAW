package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.RolDTO;
import escom.ipn.restaurantes.data.dto.TrabajadorDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alanm
 */
public class TestDAO {
    public static void main(String[] args){
        RolDAO dao = new RolDAO();
        RolDTO dto = new RolDTO();
        dto.getRol().setNombreRol("Limpieza");
        dto.getRol().setIdRol(4);
        TrabajadorDAO daot = new TrabajadorDAO();
        TrabajadorDTO dtot = new TrabajadorDTO();
        dtot.getTrabajador().setNombreTrabajador("Alan");
        dtot.getTrabajador().setApellidoMaterno("Baeza");
        dtot.getTrabajador().setApellidoPaterno("Malagon");
        dtot.getTrabajador().setEmail("alanamb134s@gmail.com");
        dtot.getTrabajador().setPassword("password");
        dtot.getRol().setIdRol(1);
        try {
            //dao.getAll().forEach(System.out::println);
            //dao.save(dto);
            //dao.delete(dto);
            //System.out.println(dao.get(dto));
            daot.register(dtot);
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
