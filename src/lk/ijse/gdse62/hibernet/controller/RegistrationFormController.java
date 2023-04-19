package lk.ijse.gdse62.hibernet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse62.hibernet.bo.BOFactory;
import lk.ijse.gdse62.hibernet.bo.BOType;
import lk.ijse.gdse62.hibernet.bo.custom.ReservationBO;
import lk.ijse.gdse62.hibernet.bo.custom.StudentBO;
import lk.ijse.gdse62.hibernet.dto.ReservationDTO;
import lk.ijse.gdse62.hibernet.dto.RoomDTO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;
import lk.ijse.gdse62.hibernet.view.tm.ReservationTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {
    public JFXTextField RegID;
    public JFXTextField RegNo;
    public JFXTextField Status;
    public TextField search;

    @FXML
    private TableView<ReservationTM> Table;
    @FXML
    private TableColumn<?, ?> tblRID;

    @FXML
    private TableColumn<?, ?> tblSID;

    @FXML
    private TableColumn<?, ?> tblRNo;

    @FXML
    private TableColumn<?, ?> tblDate;

    @FXML
    private TableColumn<?, ?> tblstatus;

    public JFXComboBox<String> CombRoomNo;
    public AnchorPane navPane;
    public AnchorPane pane;

    public JFXDatePicker DpDate;

    public JFXComboBox<String> cmbStatus;
    public Label lblDate;
    public Label lblAvailableRoomQTY;
    public JFXComboBox<String> cmbStudentID;
    public TextField studentId;

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getInstance().getBOType(BOType.RESERVATION);
    private final StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBOType(BOType.STUDENT);


    private String res_id;
    private String student_id;
    private LocalDate date;
    private String status;
    private String room_no;

    public void RoomsOnAction(ActionEvent actionEvent) {
    }

    public void regOnAction(ActionEvent actionEvent) {
    }

    public void StudentOnAction(ActionEvent actionEvent) {
    }

    public void LogoutOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        res_id = RegID.getText();
        student_id = studentId.getText();
        date = DpDate.getValue();
        status = cmbStatus.getValue();
        room_no = CombRoomNo.getValue();
        lblDate.setText(null);
        boolean isAdded = reservationBO.saveRegistration(new ReservationDTO(res_id, date, student_id, room_no, status));
        boolean isDeleted = reservationBO.deleteRegistration(new ReservationDTO(res_id, date, student_id, room_no, status));
        boolean isUpdated = reservationBO.updateRegistration(new ReservationDTO(res_id, date, student_id, room_no, status));
        Alert alert;
        if (isUpdated) {
            alert = new Alert(Alert.AlertType.INFORMATION, "Registration has been successfully updated");
            clearAll();
            RegID.setText(generateNewId());
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Error");
        }
        alert.show();

        ReservationTM tm = (ReservationTM) Table.getSelectionModel().getSelectedItem();
        tm.setRes_idl(res_id);
        tm.setStudent_id(student_id);
        tm.setDate(date);
        tm.setStatus(status);
        tm.setRoom_type_id(room_no);
        Table.refresh();
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        res_id = RegID.getText();
        student_id = studentId.getText();
        date = DpDate.getValue();
        status = cmbStatus.getValue();
        room_no = CombRoomNo.getValue();
        lblDate.setText(null);
        boolean isAdded = reservationBO.saveRegistration(new ReservationDTO(res_id, date, student_id, room_no, status));
        boolean isDeleted = reservationBO.deleteRegistration(new ReservationDTO(res_id, date, student_id, room_no, status));
        Alert alert;
        if (isDeleted) {
            Table.getItems().remove(Table.getSelectionModel().getSelectedItem());
            Table.getSelectionModel().clearSelection();
            alert = new Alert(Alert.AlertType.INFORMATION, "Registration has been successfully deleted");
            clearAll();
            RegID.setText(generateNewId());
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Error");
        }
        alert.show();
    }

    public void AddOnAction(ActionEvent actionEvent) {
        res_id = RegID.getText();
        student_id = studentId.getText();
        date = DpDate.getValue();
        status = cmbStatus.getValue();
        room_no = CombRoomNo.getValue();
        lblDate.setText(null);

        boolean isAdded = reservationBO.saveRegistration(new ReservationDTO(res_id, date, student_id, room_no, status));
        Alert alert;
        if (isAdded) {
            Table.getItems().add(new ReservationTM(res_id, date, student_id, room_no, status));
            alert = new Alert(Alert.AlertType.INFORMATION, "Registration has been successful");
            clearAll();
            RegID.setText(generateNewId());
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Error");
        }
        alert.show();
    }

    public void AddStudentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/lk/ijse/hostel_management_system/view/AddStudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CombRoomNo.getItems().addAll(new String[]{"RM-1324", "RM-5467", "RM-7896", "RM-0093"});
        cmbStatus.getItems().addAll(new String[]{"Paid", "Pending payment"});

        ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();

        for (StudentDTO student : allStudent) {
            cmbStudentID.getItems().addAll(student.getStudent_id());
        }
        RegID.setText(generateNewId());

        Table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("res_idl"));
        Table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        Table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        Table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        Table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RegID.setText(newValue.getRes_idl());
                DpDate.setValue(newValue.getDate());
                studentId.setText(newValue.getStudent_id());
                CombRoomNo.setValue(newValue.getRoom_type_id());
                cmbStatus.setValue(newValue.getStatus());
            }
        });
        loadAll();

    }
    private void clearAll() {
        RegID.setText(null);
        DpDate.setValue(null);
        studentId.setText(null);
        CombRoomNo.setValue("");
        cmbStatus.setValue("");
    }
    private void loadAll() {
        Table.getItems().clear();
        ArrayList<ReservationDTO> allStudent = reservationBO.getAll();
        for (ReservationDTO resv : allStudent) {
            Table.getItems().add(
                    new ReservationTM(
                            resv.getRes_id(),
                            resv.getDate(),
                            resv.getStudent_id(),
                            resv.getRoom_type_id(),
                            resv.getStatus()
                    )
            );
        }
}

    public void cmbRoomTypeIDOnAction(ActionEvent event) {
        String value = CombRoomNo.getValue();
        RoomDTO room = reservationBO.getRoom(value);
        int notAvailableRoomCount = reservationBO.getNotAvailableRoomCount(value);
        lblAvailableRoomQTY.setText(String.valueOf(room.getQty() - notAvailableRoomCount));
    }

    public void cmbStudentIDOnAction(ActionEvent event) {
        studentId.setText(cmbStudentID.getValue());
    }
    public String generateNewId() {
        String oldId = reservationBO.getLastId();
        System.out.println(oldId);
        if (oldId != null) {
            int newCustomerId = Integer.parseInt(oldId.replace("R00-", "")) + 1;
            return String.format("R00-%03d", newCustomerId);
        } else {
            return "R00-001";
        }
    }
}
