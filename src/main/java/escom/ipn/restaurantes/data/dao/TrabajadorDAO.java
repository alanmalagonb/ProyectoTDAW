package escom.ipn.restaurantes.data.dao;

import escom.ipn.restaurantes.data.dto.RestauranteDTO;
import escom.ipn.restaurantes.data.dto.SucursalDTO;
import escom.ipn.restaurantes.data.dto.TrabajadorDTO;
import escom.ipn.restaurantes.storage.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO extends Connector implements DAO<TrabajadorDTO>{

    private static final String SQL_UPDATE="UPDATE TRABAJADOR SET nombretrabajador=?,apellidopaterno=?,apellidomaterno=?,fechanacimiento=?,email=?,password=?,calle=?,colonia=?,numeroexterior=?,telefono=?,numerointerior=?,idmunicipio=?,idestado=? inner join rol on trabajador.idrol=rol.idrol WHERE idTrabajador=?";
        private static final String SQL_UPDATE_W="UPDATE TRABAJADOR SET idsucursal=?,idrol=? where email=?";

    private static final String SQL_READ="SELECT trabajador.*,sucursal.nombresucursal,rol.nombrerol FROM TRABAJADOR inner join sucursal on trabajador.idsucursal=sucursal.idsucursal inner join restaurante on sucursal.idrestaurante=restaurante.idrestaurante inner join rol on trabajador.idrol=rol.idrol where trabajador.email=?";
    private static final String SQL_REGISTER="INSERT INTO TRABAJADOR (nombretrabajador,apellidopaterno,apellidomaterno,email,password,idRol) VALUES (?,?,?,?,?,?)";
    private static final String SQL_EMPLEAR="UPDATE TRABAJADOR set idSucursal=?,idRol=? WHERE idTrabajador=(SELECT idTrabajador FROM trabajador WHERE email=?)";
    private static final String SQL_READ_ALL="SELECT trabajador.*,sucursal.nombresucursal,rol.nombrerol FROM TRABAJADOR inner join sucursal on trabajador.idsucursal=sucursal.idsucursal inner join rol on trabajador.idrol=rol.idrol";
    private static final String SQL_READ_ALL_SUCURSAL="SELECT trabajador.*,sucursal.nombresucursal,rol.nombrerol FROM TRABAJADOR inner join sucursal on trabajador.idsucursal=sucursal.idsucursal inner join restaurante on sucursal.idrestaurante=restaurante.idrestaurante inner join rol on trabajador.idrol=rol.idrol where restaurante.idRestaurante = ?";
    private static final String SQL_DESEEMPLEAR="UPDATE TRABAJADOR set idSucursal= NULL,idRol=2 WHERE idTrabajador=(SELECT idTrabajador FROM trabajador WHERE email=?)";
    
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
    
    public TrabajadorDTO login(TrabajadorDTO dto) throws SQLException {
        TrabajadorDTO trabajador = get(dto);
        if(trabajador.getTrabajador().getPassword().equals(dto.getTrabajador().getPassword())){
            return trabajador;
        }
        return null;
    }
    
    public void emplearSucursal(TrabajadorDTO dto) throws SQLException{
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_EMPLEAR)){
             ps.setInt(1, dto.getSucursal().getIdSucursal());
             ps.setInt(2, dto.getRol().getIdRol());
             ps.setString(3, dto.getTrabajador().getEmail());
             ps.executeUpdate();
        } 
    }
    
    public void updateWorker(TrabajadorDTO dto) throws SQLException{
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_W)){
            ps.setInt(1, dto.getSucursal().getIdSucursal());
            ps.setInt(2, dto.getRol().getIdRol());
            ps.setString(3, dto.getTrabajador().getEmail());
            ps.executeUpdate();            
        }
    }
    
    public List<TrabajadorDTO> getAllFromRestaurante(RestauranteDTO dto) throws SQLException{
        List<TrabajadorDTO> trabajadores = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL_SUCURSAL)){
            ps.setInt(1, dto.getRestaurante().getIdRestaurante());
            try(ResultSet rs = ps.executeQuery()){
                trabajadores.addAll(getResults(rs));
            }
        }
        return trabajadores;  
    }
    
    @Override
    public TrabajadorDTO get(TrabajadorDTO dto) throws SQLException {
        TrabajadorDTO trabajador = new TrabajadorDTO();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_READ)){
            ps.setString(1, dto.getTrabajador().getEmail());    
            try (ResultSet rs = ps.executeQuery()){
                List<TrabajadorDTO> results = getResults(rs);   
                if(!results.isEmpty()){
                    trabajador = results.get(0);
                }
            }
        }             
        return trabajador; 
    }

    @Override
    public List<TrabajadorDTO> getAll() throws SQLException {
        List<TrabajadorDTO> trabajadores = new ArrayList<>();
        try(Connection connection = getConnection(); Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_READ_ALL)){
            trabajadores = getResults(rs);
        }
        return trabajadores;  
    }

    @Override
    public TrabajadorDTO save(TrabajadorDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TrabajadorDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_UPDATE)){
            ps.setString(1, dto.getTrabajador().getNombreTrabajador());
            ps.setString(2, dto.getTrabajador().getApellidoMaterno());
            ps.setString(3, dto.getTrabajador().getApellidoPaterno());
            ps.setDate(4, dto.getTrabajador().getFechaNacimiento());
            ps.setString(5, dto.getTrabajador().getEmail());
            ps.setString(6, dto.getTrabajador().getPassword());
            ps.setString(7, dto.getTrabajador().getCalle());
            ps.setString(8, dto.getTrabajador().getColonia());
            ps.setInt(9, dto.getTrabajador().getNumeroExterior());
            ps.setString(10, dto.getTrabajador().getTelefono());
            ps.setInt(11, dto.getTrabajador().getNumeroInterior());
            ps.setInt(12, dto.getMunicipio().getIdMunicipio());
            ps.setInt(13, dto.getEstado().getIdEstado());
            ps.setInt(14, dto.getTrabajador().getIdTrabajador());
            ps.executeUpdate();            
        }
    }

    @Override
    public void delete(TrabajadorDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TrabajadorDTO> getResults(ResultSet rs) throws SQLException {
        List<TrabajadorDTO> resultado = new ArrayList<>();
        while (rs.next()) {
            TrabajadorDTO dto = new TrabajadorDTO();
            dto.getTrabajador().setApellidoMaterno(rs.getString("apellidomaterno"));
            dto.getTrabajador().setApellidoPaterno(rs.getString("apellidopaterno"));
            dto.getTrabajador().setEmail(rs.getString("email"));
            dto.getTrabajador().setIdTrabajador(rs.getInt("idtrabajador"));
            dto.getTrabajador().setPassword(rs.getString("password"));
            dto.getTrabajador().setNombreTrabajador(rs.getString("nombretrabajador"));
            dto.getRol().setIdRol(rs.getInt("idrol"));
            dto.getRol().setNombreRol(rs.getString("nombreRol"));
            dto.getSucursal().setIdSucursal(rs.getInt("idsucursal"));
            dto.getSucursal().setNombreSucursal(rs.getString("nombresucursal"));
            resultado.add(dto);
        }
        return resultado;
    }

    public void deseemplar(TrabajadorDTO dto) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SQL_DESEEMPLEAR)){
             ps.setString(1, dto.getTrabajador().getEmail());
             ps.executeUpdate();
        } 
    }
        
}
