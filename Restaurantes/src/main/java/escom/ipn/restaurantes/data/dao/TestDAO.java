package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.RolDTO;
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
        try {
            dao.getAll().forEach(System.out::println);
            //dao.save(dto);
            //dao.delete(dto);
            System.out.println(dao.get(dto));
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
