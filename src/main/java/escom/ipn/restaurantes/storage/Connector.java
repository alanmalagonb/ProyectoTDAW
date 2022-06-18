package escom.ipn.restaurantes.storage;

import java.sql.Connection;

public class Connector implements DataSource<Connection>{

    @Override
    public Connection getConnection(){
        //MySQLSource connection = new MySQLSource("restaurantes","localhost","3306","root","n0m3l0");
        PostgreSQLSource connectionp = new PostgreSQLSource("d3d50dc89srr3j",
                "ec2-23-23-182-238.compute-1.amazonaws.com",
                "5432",
                "rfunwxtbklkqzx",
                "8f4b0b21abbef83e67e07554fd8ecc9f508f23ceba78d30cb8094c0b3bd848d3");
        return connectionp.getConnection();
    }
}
