package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.TrabajadorDTO;
import escom.ipn.restaurantes.storage.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alanm
 */
public class TrabajadorDAO extends Connector implements DAO<TrabajadorDTO>{

    private static final String SQL_INSERT="CALL insertRol(?)";
    private static final String SQL_UPDATE="CALL updateRol(?,?)";
    private static final String SQL_DELETE="CALL deleteRol(?)";
    private static final String SQL_READ="SELECT * FROM readRol(?)";
    private static final String SQL_READ_ALL="SELECT * FROM readAllRol";
    private static final String SQL_REGISTER="INSERT INTO TRABAJADOR";
    
    
    
    public TrabajadorDTO register(TrabajadorDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_REGISTER)){
             ps.setString(1, dto.getTrabajador().getNombreTrabajador());
             ps.setString(2, dto.getTrabajador().getApellidoMaterno());
             ps.setString(3, dto.getTrabajador().getApellidoPaterno());
             ps.setString(4, dto.getTrabajador().getEmail());
             ps.setString(5, dto.getTrabajador().getPassword());
             ps.setInt(6, dto.getRol().getIdRol());
            int executed = ps.executeUpdate();
            if(executed > 0){
                return get(dto);
            }
        } 
        return null; 
    }
    
    @Override
    public TrabajadorDTO get(TrabajadorDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TrabajadorDTO> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TrabajadorDTO save(TrabajadorDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TrabajadorDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TrabajadorDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TrabajadorDTO> getResults(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
