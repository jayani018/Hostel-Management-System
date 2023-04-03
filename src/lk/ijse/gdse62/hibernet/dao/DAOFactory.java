package lk.ijse.gdse62.hibernet.dao;

import lk.ijse.gdse62.hibernet.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.gdse62.hibernet.dao.custom.impl.RoomDAOImpl;
import lk.ijse.gdse62.hibernet.dao.custom.impl.StudentDAOImpl;
import lk.ijse.gdse62.hibernet.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public SuperDAO getDAOType(DAOType daoType){
        switch (daoType){
            case ROOM:
                return (SuperDAO) new RoomDAOImpl();
            case STUDENT:
                return (SuperDAO) new StudentDAOImpl();
            case RESERVATION:
                return (SuperDAO) new ReservationDAOImpl();
            case USER:
                return (SuperDAO) new UserDAOImpl();
            default:
                return null;
        }
    }
}
