package lk.ijse.gdse62.hibernet.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.gdse62.hibernet.bo.BOFactory;
import lk.ijse.gdse62.hibernet.bo.BOType;
import lk.ijse.gdse62.hibernet.bo.custom.LogInBO;
import lk.ijse.gdse62.hibernet.dto.UserDTO;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.RED;

public class LogInFormController implements Initializable {

    public JFXTextField txtName;
    public JFXTextField txtPassword;

    private final LogInBO logInBO= (LogInBO) BOFactory.getInstance().getBOType(BOType.LOGIN);
    public ImageView openEyeIcon;
    public ImageView closeEyeIcon;
    public ImageView pane;
    public JFXPasswordField paswrdPassword;
    public Label lblName;
    public Label lblPassword;

    public void loginOnAction(ActionEvent actionEvent) {
        String password = txtPassword.getText();
        String userName = txtName.getText();
        String pswdFildPassword = paswrdPassword.getText();
        clearAll();
        try{
            UserDTO user = logInBO.getUser(userName);
            if (password.equals(user.getPassword()) || pswdFildPassword.equals(user.getPassword())) {
                if (userName.equals(user.getUserName())) {
                    Stage stage = (Stage) pane.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostel_management_system/view/HomeForm.fxml"))));
                    stage.centerOnScreen();
                }else {
                    txtName.requestFocus();
                    txtName.setFocusColor(RED);
                    lblName.setText("Username does not match");
                }
            }else {
                txtPassword.requestFocus();
                txtPassword.setFocusColor(RED);
                paswrdPassword.requestFocus();
                paswrdPassword.setFocusColor(RED);
                lblPassword.setText("Password does not match");
            }
        }catch (Exception e){
            txtName.requestFocus();
            txtName.setFocusColor(RED);
            lblName.setText("Username does not match");
        }

    }
    public void imgOpenEye(MouseEvent mouseEvent) {
        openEyeIcon.setVisible(false);
        txtPassword.setVisible(false);
        closeEyeIcon.setVisible(true);
        paswrdPassword.setVisible(true);
        paswrdPassword.setText(txtPassword.getText());
        paswrdPassword.requestFocus();
    }
    public void imgCloseEye(MouseEvent mouseEvent) {
        openEyeIcon.setVisible(true);
        txtPassword.setVisible(true);
        openEyeIcon.setVisible(false);
        paswrdPassword.setVisible(false);
        txtPassword.setText(paswrdPassword.getText());
        txtPassword.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        openEyeIcon.setVisible(false);
        txtPassword.setVisible(false);
        closeEyeIcon.setVisible(true);
        paswrdPassword.setVisible(true);

    }
    private void clearAll(){
        lblPassword.setText("");
        lblName.setText("");
    }
}
