package lk.ijse.gdse62.hibernet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class HomeFormController {
    public AnchorPane MainPane;
    public AnchorPane dashPane;
    public AnchorPane pane;
    public AnchorPane navPane;

    public void RoomsOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/gdse62/hibernet/view/ManageRoomsForm.fxml"));
       navPane.getChildren().clear();
        navPane.getChildren().add(parent);

    }

    public void regOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/gdse62/hibernet/view/RegistrationForm.fxml"));
        navPane.getChildren().clear();
        navPane.getChildren().add(parent);
    }

    public void StudentOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/gdse62/hibernet/view/ManageStudentsForm.fxml"));
        navPane.getChildren().clear();
        navPane.getChildren().add(parent);
    }

    public void LogoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) navPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/gdse62/hibernet/view/LogInForm.fxml"))));
        stage.show();
    }

}
