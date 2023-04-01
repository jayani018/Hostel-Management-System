package lk.ijse.gdse62.hibernet.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReservationTM {
    private String res_idl;
    private String date;
    private String student_id;
    private String room_type_id;
    private String status;
}
