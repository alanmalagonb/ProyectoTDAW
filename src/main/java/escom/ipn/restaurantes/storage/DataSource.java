package escom.ipn.restaurantes.storage;

public interface DataSource<T> {
    T getConnection();
}

