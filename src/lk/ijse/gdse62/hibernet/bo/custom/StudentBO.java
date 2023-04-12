package lk.ijse.gdse62.hibernet.bo.custom;

import lk.ijse.gdse62.hibernet.bo.SuperBO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto);
    boolean deleteStudent(StudentDTO dto);
    boolean updateStudent(StudentDTO dto);
    ArrayList<StudentDTO> getAllStudent();
}
