package lk.ijse.gdse62.hibernet.dto;

import javafx.scene.control.DatePicker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;

    public StudentDTO(String id, String name, String address, String contact, DatePicker dob, String gender) {

    }
}