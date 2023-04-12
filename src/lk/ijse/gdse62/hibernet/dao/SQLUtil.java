package lk.ijse.gdse62.hibernet.dao;

public interface SQLUtil<T> extends SuperDAO {
    boolean save(T entity);
    boolean delete(T entity);
    boolean update(T entity);
}
