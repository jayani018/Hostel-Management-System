package lk.ijse.gdse62.hibernet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;

}