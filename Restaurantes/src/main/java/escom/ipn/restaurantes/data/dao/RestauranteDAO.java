package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.RestauranteDTO;
import escom.ipn.restaurantes.storage.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RestauranteDAO extends Connector implements DAO<RestauranteDTO>{
    
    public static final String SQL_INSERT = "INSERT INTO RESTAURANTE(nombreRestaurante,logo,idDueno) VALUES (?,?,?)";
    public static final String SQL_UPDATE = "UPDATE RESTAURANTE SET nombreRestaurante=? WHERE idDueno=? AND idRestaurante=?";
    
    @Override
    public RestauranteDTO get(RestauranteDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RestauranteDTO> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RestauranteDTO save(RestauranteDTO dto) throws SQLException {
        RestauranteDTO restaurante = new RestauranteDTO();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_INSERT)){
            ps.setString(1, dto.getRestaurante().getNombreRestaurante());
            ps.setString(2, dto.getRestaurante().getLogo());
            ps.setInt(3, dto.getDueno().getIdTrabajador());
            int executed = ps.executeUpdate();            
            if(executed > 0) {
                try (ResultSet rs = ps.getResultSet()){
                    List<RestauranteDTO> results = getResults(rs);   
                    if(!results.isEmpty()){
                        restaurante = results.get(0);
                    }
                }
            }
        } 
        return restaurante;
    }

    @Override
    public void update(RestauranteDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_UPDATE)){
            ps.setString(1, dto.getRestaurante().getNombreRestaurante());
            ps.setInt(2, dto.getDueno().getIdTrabajador());
            ps.setInt(3, dto.getRestaurante().getIdRestaurante());
            ps.executeUpdate();            
        }
    }

    @Override
    public void delete(RestauranteDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RestauranteDTO> getResults(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
