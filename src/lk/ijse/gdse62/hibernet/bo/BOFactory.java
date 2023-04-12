package lk.ijse.gdse62.hibernet.bo;

import lk.ijse.gdse62.hibernet.bo.custom.UserBO;
import lk.ijse.gdse62.hibernet.bo.custom.impl.ReservationBOImpl;
import lk.ijse.gdse62.hibernet.bo.custom.impl.RoomBOImpl;
import lk.ijse.gdse62.hibernet.bo.custom.impl.StudentBOImpl;
import lk.ijse.gdse62.hibernet.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    private static BOFactory getInstance(){
        return boFactory==null ? boFactory = new BOFactory() :boFactory;
    }

    public SuperBO getBOType(BOType boType){
        switch (boType){
            case USER:
                return (SuperBO) new UserBOImpl();
            case STUDENT:
                return (SuperBO) new StudentBOImpl();
            case ROOM:
                return  new RoomBOImpl();
            case RESERVATION:
                return (SuperBO) new ReservationBOImpl();
            default:
                return null;

        }
    }
}

