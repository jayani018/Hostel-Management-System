package lk.ijse.gdse62.hibernet.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse62.hibernet.bo.BOFactory;
import lk.ijse.gdse62.hibernet.bo.BOType;
import lk.ijse.gdse62.hibernet.bo.custom.PaymentDetailsBO;
import lk.ijse.gdse62.hibernet.dto.CustomDTO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;
import lk.ijse.gdse62.hibernet.view.tm.StudentTM;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentsDetailsFormController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField search;

    @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> tblSID;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblAddress;

    @FXML
    private TableColumn<?, ?> tblContact;

    @FXML
    private TableColumn<?, ?> tblGender;

    @FXML
    private TableColumn<?, ?> tbleBID;

    private final PaymentDetailsBO paymentDetailsBO = (PaymentDetailsBO) BOFactory.getInstance().getBOType(BOType.PAYMENT_DETAILS);

    public void RoomsOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void regOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void StudentOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void LogoutOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void PaymentsaOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void SettingsOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void SearchOnAction(javafx.event.ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        Table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        Table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        Table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        Table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bid"));
        Table.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
        loadAll();

    }
    private void loadAll() {
        Table.getItems().clear();
        ArrayList<CustomDTO> allStudent = paymentDetailsBO.getAllPendingPaymentStudent();
        for (CustomDTO custom : allStudent) {
            Table.getItems().add(
                    new StudentTM(
                            custom.getStudent_id(),
                            custom.getName(),
                            custom.getAddress(),
                            custom.getContact_no(),
                            custom.getDob(),
                            custom.getGender()
                    )
            );
        }
    }
}
