package lk.ijse.gdse62.hibernet.bo.custom.impl;

import lk.ijse.gdse62.hibernet.bo.custom.RoomBO;
import lk.ijse.gdse62.hibernet.dao.DAOFactory;
import lk.ijse.gdse62.hibernet.dao.DAOType;
import lk.ijse.gdse62.hibernet.dao.custom.RoomDAO;
import lk.ijse.gdse62.hibernet.dto.RoomDTO;
import lk.ijse.gdse62.hibernet.entity.Room;

public class RoomBOImpl implements RoomBO {
    private RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAOType(DAOType.ROOM);

    @Override
    public boolean saveRoom(RoomDTO dto) {
        return roomDAO.save(
                new Room(
                        dto.getRoom_type_id(),
                        dto.getType(),
                        dto.getKey_money(),
                        dto.getQty()
                )
        );
    }
}
