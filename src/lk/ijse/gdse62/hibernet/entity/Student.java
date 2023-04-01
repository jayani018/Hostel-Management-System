package lk.ijse.gdse62.hibernet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
}
