package lk.ijse.gdse62.hibernet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoomDTO {
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;

}
