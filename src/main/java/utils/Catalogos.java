package utils;

import escom.ipn.restaurantes.data.dto.SucursalDTO;
import escom.ipn.restaurantes.storage.Connector;
import escom.ipn.restaurantes.storage.PostgreSQLSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alanm
 */
public class Catalogos {
    private static HashMap<Integer,String> estados = new HashMap<>();
    private static HashMap<Integer,String> municipios = new HashMap<>();
    
    private static final String SQL_READ_ESTADOS = "SELECT * FROM ESTADO";
    private static final String SQL_READ_MUNICIPIOS = "SELECT * FROM municipio";
    
    public static Connection getConnection(){
        PostgreSQLSource connectionp = new PostgreSQLSource("restaurantes","localhost","5432","postgres","n0m3l0");
        return connectionp.getConnection();
    }
    
    static {
        try(Connection connection = getConnection(); Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_READ_ESTADOS)){
            while (rs.next()) 
                estados.put(rs.getInt("idestado"), rs.getString("nombreestado"));
        } catch (SQLException ex) {
            Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(Connection connection = getConnection(); Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_READ_MUNICIPIOS)){
            while (rs.next()) 
                municipios.put(rs.getInt("idmunicipio"), rs.getString("nombremunicipio"));
        } catch (SQLException ex) {
            Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static HashMap<Integer, String> getEstados() {
        return estados;
    }

    public static HashMap<Integer, String> getMunicipios() {
        return municipios;
    }
    
    
}
