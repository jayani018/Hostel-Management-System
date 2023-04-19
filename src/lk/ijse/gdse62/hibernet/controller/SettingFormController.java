package lk.ijse.gdse62.hibernet.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.gdse62.hibernet.bo.BOFactory;
import lk.ijse.gdse62.hibernet.bo.BOType;
import lk.ijse.gdse62.hibernet.bo.custom.SettingBO;
import lk.ijse.gdse62.hibernet.dto.UserDTO;
import lk.ijse.gdse62.hibernet.util.CheckValidation;
import lk.ijse.gdse62.hibernet.util.ValidationType;

public class SettingFormController {
    public JFXTextField txtUName;
    public JFXTextField txtReNewPassword;
    public JFXTextField txtNewPassword;
    public Label lblUserName;
    public Label lblNewPasswrd;
    public Label lblReNewPassword;

    private final SettingBO settingBO = (SettingBO) BOFactory.getInstance().getBOType(BOType.SETTING);

    public void ChangeOnAction(ActionEvent actionEvent) {
        String userName = txtUName.getText();
        String password = txtNewPassword.getText();
        String rePassword = txtReNewPassword.getText();

        lblUserName.setText(null);
        lblNewPasswrd.setText(null);
        lblReNewPassword.setText(null);

        if (CheckValidation.validation(ValidationType.USERNAME, userName)) {
            if (CheckValidation.validation(ValidationType.PASSWORD, password)) {
                if (password.equals(rePassword)) {
                    boolean isUpdated = settingBO.updateUserNameAndPassword(new UserDTO(userName, password));
                    Alert alert;
                    if (isUpdated) {
                        alert = new Alert(Alert.AlertType.INFORMATION, "Password and UserName has been successfully Update");
                        txtNewPassword.setText(null);
                        txtReNewPassword.setText(null);
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR, "Error");
                    }
                    alert.show();
                } else {
                    lblReNewPassword.setText("Is not matched");
                    txtNewPassword.requestFocus();
                    txtReNewPassword.setText(null);
                }
            } else {
                //password
                lblNewPasswrd.setText("Incorrect password");
                txtNewPassword.requestFocus();
                txtNewPassword.setText(null);
            }
        } else {
            //user name
            lblUserName.setText("Incorrect UserName");
            txtUName.requestFocus();
            txtUName.setText(null);
        }

    }

    public void RoomsOnAction(ActionEvent actionEvent) {
    }

    public void regOnAction(ActionEvent actionEvent) {
    }

    public void StudentOnAction(ActionEvent actionEvent) {
    }

    public void LogoutOnAction(ActionEvent actionEvent) {
    }

    public void PaymentsaOnAction(ActionEvent actionEvent) {
    }

    public void SettingsOnAction(ActionEvent actionEvent) {
    }
}
