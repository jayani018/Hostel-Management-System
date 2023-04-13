package lk.ijse.gdse62.hibernet.dao.custom.impl;

import lk.ijse.gdse62.hibernet.dao.custom.ReservationDAO;
import lk.ijse.gdse62.hibernet.entity.Reservation;
import lk.ijse.gdse62.hibernet.entity.Student;
import lk.ijse.gdse62.hibernet.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO{

    @Override
    public boolean save(Reservation entity){
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
    public boolean delete(Reservation entity){
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
    public boolean update(Reservation entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("UPDATE Reservation SET room.room_type_id=:room_type_id, status=:status WHERE res_idl=:res_id");
            query.setParameter("room_type_id", entity.getRoom().getRoom_type_id());
            query.setParameter("status", entity.getStatus());
            query.setParameter("res_id", entity.getRes_idl());
            boolean isAdded = query.executeUpdate() > 0;
            transaction.commit();
            session.close();
            return isAdded;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Student> getAllStudent() {
        return null;
    }

    @Override
    public int getNotAvailableRoomCount(String room_type_id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("SELECT COUNT(*) FROM Reservation r WHERE r.room.room_type_id=:room_type_id");
            query.setParameter("room_type_id", room_type_id);
            Long count = (Long) query.uniqueResult();
            transaction.commit();
            session.close();
            return Math.toIntExact(count);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String getLastId() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        String sqlQuery = "SELECT r.res_idl FROM Reservation AS r ORDER BY res_idl DESC";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        if (list.size() > 0) {
            return (String) list.get(0);
        }
        return null;
    }

    @Override
    public ArrayList<Reservation> getAll() {
        Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            NativeQuery nativeQuery = session.createSQLQuery("SELECT * FROM reservation");
            nativeQuery.addEntity(Reservation.class);
            List<Reservation> reservationList=nativeQuery.list();
            transaction.commit();
            session.close();
            return (ArrayList<Reservation>) reservationList;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return null;
        }
    }
}
