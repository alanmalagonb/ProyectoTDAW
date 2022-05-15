package escom.ipn.restaurantes.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T>{
    T get(T dto) throws SQLException;
    List<T> getAll() throws SQLException;
    T save(T dto) throws SQLException;
    void update(T dto) throws SQLException;
    void delete(T dto) throws SQLException;
    List<T> getResults(ResultSet rs) throws SQLException;
}
