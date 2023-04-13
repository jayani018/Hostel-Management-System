package lk.ijse.gdse62.hibernet.dao.custom;

import lk.ijse.gdse62.hibernet.dao.SQLUtil;
import lk.ijse.gdse62.hibernet.entity.Reservation;

import java.util.ArrayList;

public interface ReservationDAO extends SQLUtil<Reservation> {
    int getNotAvailableRoomCount(String room_type_id);

    String getLastId();

    ArrayList<Reservation> getAll();
}
