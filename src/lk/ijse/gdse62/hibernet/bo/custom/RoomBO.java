package lk.ijse.gdse62.hibernet.bo.custom;

import lk.ijse.gdse62.hibernet.bo.SuperBO;
import lk.ijse.gdse62.hibernet.dto.RoomDTO;

import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto);
    boolean deleteRoom(RoomDTO dto);
    boolean updateRoom(RoomDTO dto);

    ArrayList<RoomDTO> loadAll();
}
