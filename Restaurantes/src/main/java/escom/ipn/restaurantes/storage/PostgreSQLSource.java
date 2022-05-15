package escom.ipn.restaurantes.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLSource implements DataSource<Connection>{
    
    private Connection connection;
    
    public static final Logger LOGGER = Logger.getLogger(PostgreSQLSource.class.getName());
    
    public PostgreSQLSource(String database, String ip, String port, String user, String password){
        String url = "jdbc:postgresql://" + ip + ":" + port + "/" + database;
        String driver = "org.postgresql.Driver";
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,props);
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
