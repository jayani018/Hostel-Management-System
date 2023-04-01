package lk.ijse.gdse62.hibernet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Room {
    @Id
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;

}
