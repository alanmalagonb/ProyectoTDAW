package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.RestauranteDTO;
import escom.ipn.restaurantes.data.dto.TrabajadorDTO;
import escom.ipn.restaurantes.storage.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO extends Connector implements DAO<RestauranteDTO>{
    
    public static final String SQL_READ_BY_OWNER = "SELECT * FROM RESTAURANTE WHERE iddueno=?";
    public static final String SQL_READ = "SELECT * FROM RESTAURANTE WHERE idrestaurante=?";
    public static final String SQL_INSERT = "INSERT INTO RESTAURANTE(nombreRestaurante,logo,iddueno) VALUES (?, ?,(SELECT trabajador.idtrabajador as iddueno FROM TRABAJADOR where trabajador.email=?))";
    public static final String SQL_UPDATE = "UPDATE RESTAURANTE SET nombreRestaurante=? WHERE iddueno=? AND idrestaurante=?";
    
    @Override
    public RestauranteDTO get(RestauranteDTO dto) throws SQLException {
        RestauranteDTO restaurante = new RestauranteDTO();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_READ)){
            ps.setInt(1, dto.getDueno().getIdTrabajador());    
            try (ResultSet rs = ps.executeQuery()){
                List<RestauranteDTO> results = getResults(rs);   
                if(!results.isEmpty()){
                    restaurante = results.get(0);
                }
            }
        }    
        return restaurante;
    }
    
    public RestauranteDTO getByOwner(TrabajadorDTO dto) throws SQLException {
        RestauranteDTO restaurante = new RestauranteDTO();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_READ_BY_OWNER)){
            ps.setInt(1, dto.getTrabajador().getIdTrabajador());    
            try (ResultSet rs = ps.executeQuery()){
                List<RestauranteDTO> results = getResults(rs);   
                if(!results.isEmpty()){
                    restaurante = results.get(0);
                }
            }
        }    
        return restaurante;
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
            ps.setString(3, dto.getDueno().getEmail());
            int executed = ps.executeUpdate();            
            if(executed > 0) {
                TrabajadorDTO tdto = new TrabajadorDTO();
                tdto.getTrabajador().setIdTrabajador(dto.getDueno().getIdTrabajador());
                return getByOwner(tdto);
            }
        } 
        return restaurante;
    }

    @Override
    public void update(RestauranteDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_UPDATE)){
            System.out.println(dto);
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
       List<RestauranteDTO> resultado = new ArrayList<>();
        while (rs.next()) {
            RestauranteDTO dto = new RestauranteDTO();
            dto.getDueno().setIdTrabajador(rs.getInt("iddueno"));
            dto.getRestaurante().setIdRestaurante(rs.getInt("idrestaurante"));
            dto.getRestaurante().setNombreRestaurante(rs.getString("nombrerestaurante"));
            resultado.add(dto);
        }
        return resultado;
    }
}
