package escom.ipn.restaurantes.storage;

import java.sql.Connection;

public class Connector implements DataSource<Connection>{

    @Override
    public Connection getConnection(){
        //MySQLSource connection = new MySQLSource("restaurantes","localhost","3306","root","n0m3l0");
        PostgreSQLSource connectionp = new PostgreSQLSource("restaurantes","localhost","5432","postgres","n0m3l0");
        return connectionp.getConnection();
    }
}
