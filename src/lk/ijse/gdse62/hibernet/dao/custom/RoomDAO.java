package lk.ijse.gdse62.hibernet.dao.custom;

import lk.ijse.gdse62.hibernet.dao.SQLUtil;
import lk.ijse.gdse62.hibernet.entity.Room;

import java.util.ArrayList;

public interface RoomDAO extends SQLUtil<Room> {
    Room get(String room_type_id);
    ArrayList<Room> getAll();
}
