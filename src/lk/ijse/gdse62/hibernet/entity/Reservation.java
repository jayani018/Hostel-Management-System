package lk.ijse.gdse62.hibernet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Reservation {
    @Id
    private String res_idl;
    private String date;
    private String student_id;
    private String room_type_id;
    private String status;

}
