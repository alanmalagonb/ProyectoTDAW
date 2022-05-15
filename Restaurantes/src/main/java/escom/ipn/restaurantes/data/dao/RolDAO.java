package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.storage.Connector;
import escom.ipn.restaurantes.data.dto.RolDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
    try-with-resources

    try(Connection con = getConnection()) {
        // ...
    }

    es equivalente a
    
    Connection con = null;
    try {
        con = getConnection();
        //...
    } finally {
        con.close();
    }
*/

public class RolDAO extends Connector implements DAO<RolDTO>{
    
    private static final String SQL_INSERT="CALL insertRol(?)";
    private static final String SQL_UPDATE="CALL updateRol(?,?)";
    private static final String SQL_DELETE="CALL deleteRol(?)";
    private static final String SQL_READ="SELECT * FROM readRol(?)";
    private static final String SQL_READ_ALL="SELECT * FROM readAllRol";
    
    @Override
    public RolDTO get(RolDTO dto) throws SQLException {
        RolDTO rol = new RolDTO();
        try (Connection connection = getConnection(); CallableStatement cs = connection.prepareCall(SQL_READ)){
            cs.setInt(1, dto.getRol().getIdRol());
            boolean executed = cs.execute();            
            if(executed) {
                try (ResultSet rs = cs.getResultSet()){
                    List<RolDTO> results = getResults(rs);   
                    if(!results.isEmpty()){
                        rol = results.get(0);
                    }
                }
            } 
        }             
        return rol;     
    }
    
    @Override
    public List<RolDTO> getAll() throws SQLException{
        List<RolDTO> rols = new ArrayList<>();
        try(Connection connection = getConnection(); Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_READ_ALL)){
            rols.addAll(getResults(rs));
        }
        return rols;   
    }

    @Override
    public void update(RolDTO dto) throws SQLException{
        try (Connection connection = getConnection(); CallableStatement cs = connection.prepareCall(SQL_UPDATE)){
            cs.setInt(1, dto.getRol().getIdRol());
            cs.setString(2, dto.getRol().getNombreRol());
            cs.executeUpdate();            
        }             
    }

    @Override
    public void delete(RolDTO dto) throws SQLException{
        try (Connection connection = getConnection(); CallableStatement cs = connection.prepareCall(SQL_DELETE)){
            cs.setInt(1, dto.getRol().getIdRol());
            cs.executeUpdate();            
        }    
    }

    @Override
    public List<RolDTO> getResults(ResultSet rs) throws SQLException{
        List<RolDTO> resultado = new ArrayList();
        while (rs.next()) {
            RolDTO dto = new RolDTO();
            dto.getRol().setIdRol(rs.getInt("idRol"));
            dto.getRol().setNombreRol(rs.getString("nombreRol"));
            resultado.add(dto);
        }
        return resultado;
    }

    @Override
    public RolDTO save(RolDTO dto) throws SQLException {
        RolDTO rol = new RolDTO();
        try (Connection connection = getConnection(); CallableStatement cs = connection.prepareCall(SQL_INSERT)){
            cs.setString(1, dto.getRol().getNombreRol());
            boolean executed = cs.execute();            
            if(executed) {
                try (ResultSet rs = cs.getResultSet()){
                    List<RolDTO> results = getResults(rs);   
                    if(!results.isEmpty()){
                        rol = results.get(0);
                    }
                }
            }
        } 
        return rol;
    }
    
}
