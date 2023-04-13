package lk.ijse.gdse62.hibernet.dao.custom.impl;

import lk.ijse.gdse62.hibernet.dao.custom.UserDAO;
import lk.ijse.gdse62.hibernet.entity.Student;
import lk.ijse.gdse62.hibernet.entity.User;
import lk.ijse.gdse62.hibernet.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
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
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public ArrayList<Student> getAllStudent() {
        return null;
    }
    @Override
    public User get(String userName) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = (User) session.get(User.class,userName);
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return null;
        }
    }
}
