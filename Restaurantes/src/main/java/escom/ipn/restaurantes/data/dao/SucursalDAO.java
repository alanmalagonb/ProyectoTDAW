package escom.ipn.restaurantes.data.dao;

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
    
    private static final String SQL_INSERT="";
    private static final String SQL_READ_ALL="SELECT * FROM SUCURSAL";
    private static final String SQL_DELETE="DELETE FROM SUCURSAL WHERE idSucursal=?";
    private static final String SQL_UPDATE="UPDATE FROM SUCURSAL SET =?,=?,=?,=?,=?,=? WHERE idSucursal=?";
    
    @Override
    public SucursalDTO get(SucursalDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SucursalDTO> getAll() throws SQLException {
        List<SucursalDTO> sucursales = new ArrayList<>();
        try(Connection connection = getConnection(); Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_READ_ALL)){
            sucursales.addAll(getResults(rs));
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
            ps.setInt(4, dto.getSucursal().getNumeroExterior());
            ps.setInt(5, dto.getSucursal().getNumeroInterior());
            ps.setInt(6, dto.getMunicipio().getIdMunicipio());
            ps.setInt(7, dto.getEstado().getIdEstado());
            ps.setInt(8, dto.getRestaurante().getIdRestaurante());
            int executed = ps.executeUpdate();            
            if(executed > 0) {
                try (ResultSet rs = ps.getResultSet()){
                    List<SucursalDTO> results = getResults(rs);   
                    if(!results.isEmpty()){
                        sucursal = results.get(0);
                    }
                }
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
            /*
                TO DO GET RS.get
            */
            resultado.add(dto);
        }
        return resultado;}
    
}
