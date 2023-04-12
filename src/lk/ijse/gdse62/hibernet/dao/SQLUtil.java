package lk.ijse.gdse62.hibernet.dao;

import lk.ijse.gdse62.hibernet.entity.Student;

import java.util.ArrayList;

public interface SQLUtil<T> extends SuperDAO {
    boolean save(T entity);
    boolean delete(T entity);
    boolean update(T entity);

    ArrayList<Student> getAllStudent();
}
