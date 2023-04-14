package lk.ijse.gdse62.hibernet.bo.custom.impl;

import lk.ijse.gdse62.hibernet.dao.DAOFactory;
import lk.ijse.gdse62.hibernet.dao.DAOType;
import lk.ijse.gdse62.hibernet.dao.custom.UserDAO;
import lk.ijse.gdse62.hibernet.dto.UserDTO;
import lk.ijse.gdse62.hibernet.entity.User;

public class SettingBOImpl {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAOType(DAOType.USER);

    public boolean updateUserNamePassword(UserDTO userDTO){
        return userDAO.save(new User(userDTO.getUserName(), userDTO.getPassword()));
    }
}
