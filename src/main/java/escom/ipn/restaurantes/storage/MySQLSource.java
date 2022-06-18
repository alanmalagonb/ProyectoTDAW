package escom.ipn.restaurantes.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLSource implements DataSource<Connection>{
    
    private Connection connection;
    
    public static final Logger LOGGER = Logger.getLogger(MySQLSource.class.getName());
    
    public MySQLSource(String database, String ip, String port, String username, String password){
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Connection getConnection() {
        return connection;
    }
    
}

