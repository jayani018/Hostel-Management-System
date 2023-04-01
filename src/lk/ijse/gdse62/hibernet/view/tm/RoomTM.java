package lk.ijse.gdse62.hibernet.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoomTM {
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;
}
