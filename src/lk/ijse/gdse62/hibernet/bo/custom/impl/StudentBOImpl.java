package lk.ijse.gdse62.hibernet.bo.custom.impl;

import lk.ijse.gdse62.hibernet.bo.custom.StudentBO;
import lk.ijse.gdse62.hibernet.dao.DAOFactory;
import lk.ijse.gdse62.hibernet.dao.DAOType;
import lk.ijse.gdse62.hibernet.dao.custom.StudentDAO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;
import lk.ijse.gdse62.hibernet.entity.Student;

import java.util.ArrayList;

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
    public boolean updateStudent(StudentDTO dto){
        return studentDAO.update(
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
    public ArrayList<StudentDTO> getAllStudent(){
        ArrayList<Student> allStudent = studentDAO.getAllStudent();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : allStudent) {
            studentDTOS.add(
                    new StudentDTO(
                            s.getStudent_id(),
                            s.getName(),
                            s.getAddress(),
                            s.getContact_no(),
                            s.getDob(),
                            s.getGender()
                    )
            );
        }
        return studentDTOS;
    }
}
