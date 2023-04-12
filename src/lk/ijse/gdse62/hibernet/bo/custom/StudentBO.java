package lk.ijse.gdse62.hibernet.bo.custom;

import lk.ijse.gdse62.hibernet.bo.SuperBO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto);
    boolean deleteStudent(StudentDTO dto);
    boolean updateStudent(StudentDTO dto);
}
