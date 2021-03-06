package escom.ipn.restaurantes.data.dao;

import static escom.ipn.restaurantes.data.dao.RestauranteDAO.SQL_READ;
import escom.ipn.restaurantes.data.dto.RestauranteDTO;
import escom.ipn.restaurantes.data.dto.SucursalDTO;
import escom.ipn.restaurantes.storage.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO extends Connector implements DAO<SucursalDTO>{
    
    private static final String SQL_INSERT="INSERT INTO sucursal (nombresucursal, telefono, calle, colonia, numeroexterior, numerointerior, idmunicipio, idestado, idrestaurante) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_READ_ALL="SELECT * FROM SUCURSAL  INNER JOIN ESTADO on sucursal.idestado = estado.idestado inner join municipio on sucursal.idmunicipio = municipio.idmunicipio";
    private static final String SQL_READ_ALL_BY_ID="SELECT * FROM SUCURSAL INNER JOIN ESTADO on sucursal.idestado = estado.idestado inner join municipio on sucursal.idmunicipio = municipio.idmunicipio where idrestaurante=?";
    private static final String SQL_READ="SELECT * FROM sucursal INNER JOIN ESTADO on sucursal.idestado = estado.idestado inner join municipio on sucursal.idmunicipio = municipio.idmunicipio where idsucursal=?";
    private static final String SQL_DELETE="DELETE FROM SUCURSAL WHERE idSucursal=?";
    private static final String SQL_UPDATE="UPDATE SUCURSAL SET nombresucursal=?,numeroexterior=?,numerointerior=?,telefono=?,calle=?,colonia=?,idestado=?,idmunicipio=? WHERE idSucursal=?";
    private static final String SQL_COUNT_ALL="SELECT COUNT(idsucursal) WHERE idrestaurante=?";
    
    @Override
    public SucursalDTO get(SucursalDTO dto) throws SQLException {
        SucursalDTO sucursal = new SucursalDTO();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_READ)){
            ps.setInt(1, dto.getSucursal().getIdSucursal());    
            try (ResultSet rs = ps.executeQuery()){
                List<SucursalDTO> results = getResults(rs);   
                if(!results.isEmpty()){
                    sucursal = results.get(0);
                }
            }
        }    
        return sucursal;
    }

    @Override
    public List<SucursalDTO> getAll() throws SQLException {
        List<SucursalDTO> sucursales = new ArrayList<>();
        try(Connection connection = getConnection(); Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_READ_ALL)){
            sucursales = getResults(rs);
        }
        return sucursales;
    }
    
    public List<SucursalDTO> getAllByIdRestaurante(RestauranteDTO dto) throws SQLException {
        List<SucursalDTO> sucursales = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL_BY_ID)){
            ps.setInt(1, dto.getRestaurante().getIdRestaurante());
            
                try (ResultSet rs = ps.executeQuery()){
                    List<SucursalDTO> results = getResults(rs);   
                    sucursales = results;
                }
            
        }
        return sucursales;
    }

    @Override
    public SucursalDTO save(SucursalDTO dto) throws SQLException {
        SucursalDTO sucursal = new SucursalDTO();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_INSERT)){
            ps.setString(1, dto.getSucursal().getNombreSucursal());
            ps.setString(2, dto.getSucursal().getTelefono());
            ps.setString(3, dto.getSucursal().getCalle());
            ps.setString(4, dto.getSucursal().getColonia());
            ps.setInt(5, dto.getSucursal().getNumeroExterior());
            ps.setInt(6, dto.getSucursal().getNumeroInterior());
            ps.setInt(7, dto.getMunicipio().getIdMunicipio());
            ps.setInt(8, dto.getEstado().getIdEstado());
            ps.setInt(9, dto.getRestaurante().getIdRestaurante());
            int executed = ps.executeUpdate();            
            if(executed > 0) {
                return sucursal;
            }
        } 
        return sucursal;
    }

    @Override
    public void update(SucursalDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_UPDATE)){
            ps.setString(1, dto.getSucursal().getNombreSucursal());
            ps.setInt(2, dto.getSucursal().getNumeroExterior());
            ps.setInt(3, dto.getSucursal().getNumeroInterior());
            ps.setString(4,  dto.getSucursal().getTelefono());
            ps.setString(5, dto.getSucursal().getCalle());
            ps.setString(6, dto.getSucursal().getColonia());
            ps.setInt(7, dto.getEstado().getIdEstado());
            ps.setInt(8, dto.getMunicipio().getIdMunicipio());
            ps.setInt(9, dto.getSucursal().getIdSucursal());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(SucursalDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_DELETE)){
            ps.setInt(1, dto.getSucursal().getIdSucursal());
            ps.executeUpdate();            
        } 
    }

    @Override
    public List<SucursalDTO> getResults(ResultSet rs) throws SQLException {
        List<SucursalDTO> resultado = new ArrayList<>();
        while (rs.next()) {
            SucursalDTO dto = new SucursalDTO();
                dto.getSucursal().setIdSucursal(rs.getInt("idsucursal"));
                dto.getSucursal().setNombreSucursal(rs.getString("nombresucursal"));
                dto.getSucursal().setCalle(rs.getString("calle"));
                dto.getSucursal().setColonia(rs.getString("colonia"));
                dto.getSucursal().setNumeroExterior(rs.getInt("numeroexterior"));
                dto.getSucursal().setNumeroInterior(rs.getInt("numerointerior"));
                dto.getSucursal().setTelefono(rs.getString("telefono"));
                dto.getEstado().setIdEstado(rs.getInt("idestado"));
                dto.getEstado().setNombreEstado(rs.getString("nombreestado"));
                dto.getMunicipio().setIdMunicipio(rs.getInt("idmunicipio"));
                dto.getMunicipio().setNombreMunicipio(rs.getString("nombremunicipio"));
            resultado.add(dto);
        }
        return resultado;}
    
}
