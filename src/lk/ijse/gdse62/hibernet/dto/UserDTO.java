package lk.ijse.gdse62.hibernet.dto;

import javafx.beans.NamedArg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDTO {
    private String userName;
    private String password;

}
