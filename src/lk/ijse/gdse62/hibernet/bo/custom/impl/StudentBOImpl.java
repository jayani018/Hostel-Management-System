package lk.ijse.gdse62.hibernet.bo.custom.impl;

import lk.ijse.gdse62.hibernet.bo.custom.StudentBO;
import lk.ijse.gdse62.hibernet.dao.DAOFactory;
import lk.ijse.gdse62.hibernet.dao.DAOType;
import lk.ijse.gdse62.hibernet.dao.custom.StudentDAO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;
import lk.ijse.gdse62.hibernet.entity.Student;

public class StudentBOImpl implements StudentBO {
    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAOType(DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) {
        return studentDAO.save(
                new Student(
                        dto.getStudent_id(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact_no(),
                        dto.getDob(),
                        dto.getGender()
                )
        );
    }
    public boolean deleteStudent(StudentDTO dto){
        return studentDAO.delete(
                new Student(
                        dto.getStudent_id(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact_no(),
                        dto.getDob(),
                        dto.getGender()
                )
        );
    }
}
