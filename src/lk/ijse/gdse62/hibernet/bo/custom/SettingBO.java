package lk.ijse.gdse62.hibernet.bo.custom;

import lk.ijse.gdse62.hibernet.dto.UserDTO;

public interface SettingBO {
    boolean updateUserNameAndPassword(UserDTO dto);
}
