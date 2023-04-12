package lk.ijse.gdse62.hibernet.dao.custom.impl;

import lk.ijse.gdse62.hibernet.dao.custom.StudentDAO;
import lk.ijse.gdse62.hibernet.entity.Student;
import lk.ijse.gdse62.hibernet.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    public boolean save(Student entity) {
        Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean delete(Student entity) {
        Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean update(Student entity) {
        Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public ArrayList<Student> getAllStudent() {
        Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            NativeQuery nativeQuery = session.createSQLQuery("SELECT * FROM Student");
            nativeQuery.addEntity(Student.class);
            List<Student> studentList=nativeQuery.list();
            transaction.commit();
            session.close();
            return (ArrayList<Student>) studentList;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return null;
        }
    }
}
