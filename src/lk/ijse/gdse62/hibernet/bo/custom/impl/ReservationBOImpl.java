package lk.ijse.gdse62.hibernet.bo.custom.impl;

import lk.ijse.gdse62.hibernet.bo.custom.ReservationBO;
import lk.ijse.gdse62.hibernet.dao.DAOFactory;
import lk.ijse.gdse62.hibernet.dao.DAOType;
import lk.ijse.gdse62.hibernet.dao.custom.ReservationDAO;
import lk.ijse.gdse62.hibernet.dao.custom.RoomDAO;
import lk.ijse.gdse62.hibernet.dao.custom.StudentDAO;
import lk.ijse.gdse62.hibernet.dto.CustomDTO;
import lk.ijse.gdse62.hibernet.dto.ReservationDTO;
import lk.ijse.gdse62.hibernet.dto.RoomDTO;
import lk.ijse.gdse62.hibernet.entity.Reservation;
import lk.ijse.gdse62.hibernet.entity.Room;
import lk.ijse.gdse62.hibernet.entity.Student;

import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    private RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAOType(DAOType.ROOM);
    private ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAOType(DAOType.RESERVATION);
    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAOType(DAOType.STUDENT);


    public RoomDTO getRoom(String room_type_id) {
        Room room = roomDAO.get(room_type_id);
        return new RoomDTO(
                room.getRoom_type_id(),
                room.getType(),
                room.getKey_money(),
                room.getQty()
        );
    }

    public int getNotAvailableRoomCount(String room_type_id) {
        return reservationDAO.getNotAvailableRoomCount(room_type_id);
    }


    public boolean saveRegistration(ReservationDTO dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        return reservationDAO.save(
                new Reservation(
                        dto.getRes_id(),
                        dto.getDate(),
                        student,
                        room,
                        dto.getStatus()
                )
        );
    }


    public boolean deleteRegistration(ReservationDTO dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        return reservationDAO.delete(
                new Reservation(
                        dto.getRes_id(),
                        dto.getDate(),
                        student,
                        room,
                        dto.getStatus()
                )
        );
    }

    public boolean updateRegistration(ReservationDTO dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        return reservationDAO.update(
                new Reservation(
                        dto.getRes_id(),
                        dto.getDate(),
                        student,
                        room,
                        dto.getStatus()
                )
        );
    }


    public ArrayList<ReservationDTO> getAll() {
        Student student;
        Room room;
        ArrayList<Reservation> arrayList = reservationDAO.getAll();
        ArrayList<ReservationDTO> dtos = new ArrayList<>();
        for (Reservation reservation : arrayList) {
            student = reservation.getStudent();
            room = reservation.getRoom();
            dtos.add(
                    new ReservationDTO(
                            reservation.getRes_idl(),
                            reservation.getDate(),
                            student.getStudent_id(),
                            room.getRoom_type_id(),
                            reservation.getStatus()
                    )
            );
        }
        return dtos;
    }



    public String getLastId() {
        return reservationDAO.getLastId();
    }

    @Override
    public ArrayList<CustomDTO> getAllPendingPaymentStudent() {
        return null;
    }
}
