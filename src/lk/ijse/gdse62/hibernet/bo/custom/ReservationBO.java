package lk.ijse.gdse62.hibernet.bo.custom;

import lk.ijse.gdse62.hibernet.bo.SuperBO;
import lk.ijse.gdse62.hibernet.dto.ReservationDTO;
import lk.ijse.gdse62.hibernet.dto.RoomDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    RoomDTO getRoom(String room_type_id);

    int getNotAvailableRoomCount(String room_type_id);

    boolean saveRegistration(ReservationDTO dto);

    boolean deleteRegistration(ReservationDTO dto);

    boolean updateRegistration(ReservationDTO dto);

    ArrayList<ReservationDTO> getAll();

    String getLastId();
}
