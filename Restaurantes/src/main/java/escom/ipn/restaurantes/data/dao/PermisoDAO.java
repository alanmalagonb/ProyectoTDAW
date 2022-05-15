package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.PermisoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alanm
 */
public class PermisoDAO implements DAO<PermisoDTO>{
    
    private static final String SQL_INSERT="{CALL insertPermiso(?,?,?)}";
    private static final String SQL_UPDATE="{CALL updatePermiso(?,?,?,?)}";
    private static final String SQL_DELETE="{CALL deletePermiso(?)}";
    private static final String SQL_READ="{CALL readPermiso(?)}";
    private static final String SQL_READ_ALL="SELECT * FROM readAllPermisoca";
    
    @Override
    public PermisoDTO get(PermisoDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PermisoDTO> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PermisoDTO save(PermisoDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PermisoDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PermisoDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PermisoDTO> getResults(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
