package lk.ijse.gdse62.hibernet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String res_id;
    private String date;
    private String student_id;
    private String room_type_id;
    private String status;

}
