package lk.ijse.gdse62.hibernet.bo.custom;

import lk.ijse.gdse62.hibernet.dto.UserDTO;

public interface LogInBO {
    UserDTO getUser(String userName);
}
