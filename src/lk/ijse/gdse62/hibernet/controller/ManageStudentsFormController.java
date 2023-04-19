package lk.ijse.gdse62.hibernet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse62.hibernet.bo.BOFactory;
import lk.ijse.gdse62.hibernet.bo.BOType;
import lk.ijse.gdse62.hibernet.bo.custom.StudentBO;
import lk.ijse.gdse62.hibernet.dto.StudentDTO;
import lk.ijse.gdse62.hibernet.util.CheckValidation;
import lk.ijse.gdse62.hibernet.util.ValidationType;
import lk.ijse.gdse62.hibernet.view.tm.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageStudentsFormController implements Initializable  {
    public JFXTextField StudentID;
    public JFXTextField IDno;
    public JFXTextField StudentName;
    public JFXTextField Gender;
    public TextField search;
    public TableView<StudentTM> Table;
   // public TableColumn tblSID;
//    public TableColumn tblName;
//    public TableColumn tblAddress;
//    public TableColumn tblContact;
//    public TableColumn tblID;
//    public TableColumn tblGender;
//    public TableColumn tblUniName;
//    public TableColumn tbleBID;
    public JFXTextField UniName;
    public JFXTextField BID;
    public JFXTextField ContactNO;
    public JFXTextField Address;
    public AnchorPane pane;

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

    public DatePicker DOB;
    public JFXComboBox CmbGender;
    public Label lblName1;
    public Label lblContact;
    public Label lblDate;

    private final StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBOType(BOType.STUDENT);
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

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
        studentId = StudentID.getText();
        name = StudentName.getText();
        address = Address.getText();
        contact = ContactNO.getText();
        dob = DOB.getValue();
        gender = (String) CmbGender.getValue();

        lblContact.setText(null);
        lblDate.setText(null);
        lblName1.setText(null);

        if (CheckValidation.validation(ValidationType.NAME, name)) {
            if (CheckValidation.validation(ValidationType.CONTACT, contact)) {
                boolean isAdded = studentBO.updateStudent(new StudentDTO(studentId, name, address, contact, dob, gender));
                Alert alert;
                if (isAdded) {
                    alert = new Alert(Alert.AlertType.INFORMATION, "Room has been successfully Update");
                    clearAll();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR, "Error");
                }
                alert.show();
                StudentTM selectedCustomer = (StudentTM) Table.getSelectionModel().getSelectedItem();
//        selectedCustomer.setStudent_id(studentId);
                selectedCustomer.setName(name);
                selectedCustomer.setAddress(address);
                selectedCustomer.setDob(dob);
                selectedCustomer.setContact_no(contact);
                selectedCustomer.setGender(gender);
                Table.refresh();
            } else {
                //contact
                lblContact.setText("Incorrect number");
                ContactNO.requestFocus();
            }
        } else {
            //name
            lblName1.setText("Incorrect name");
            StudentName.requestFocus();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        studentId = StudentID.getText();
        name = StudentName.getText();
        address = Address.getText();
        contact = ContactNO.getText();
        dob = DOB.getValue();
        gender = (String) CmbGender.getValue();

        lblContact.setText(null);
        lblDate.setText(null);
        lblName1.setText(null);

        if (CheckValidation.validation(ValidationType.NAME, name)) {
            if (CheckValidation.validation(ValidationType.CONTACT, contact)) {
                boolean isAdded = studentBO.deleteStudent(new StudentDTO(studentId, name, address, contact, dob, gender));
                Alert alert;
                if (isAdded) {
                    Table.getItems().remove(Table.getSelectionModel().getSelectedItem());
                    Table.getSelectionModel().clearSelection();
                    alert = new Alert(Alert.AlertType.INFORMATION, "Room has been successfully Deleted");
                    clearAll();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR, "Error");
                }
                alert.show();
            } else {
                //contact
                lblContact.setText("Incorrect number");
                ContactNO.requestFocus();
            }
        } else {
            //name
            lblName1.setText("Incorrect name");
            StudentName.requestFocus();
        }
    }

    public void AddOnAction(ActionEvent actionEvent) {
        studentId = StudentID.getText();
        name = StudentName.getText();
        address = Address.getText();
        contact = ContactNO.getText();
        dob = DOB.getValue();
        gender = (String) CmbGender.getValue();

        lblContact.setText(null);
        lblDate.setText(null);
        lblName1.setText(null);

        if (CheckValidation.validation(ValidationType.NAME, name)) {
            if (CheckValidation.validation(ValidationType.CONTACT, contact)) {
                boolean isAdded = studentBO.saveStudent(new StudentDTO(studentId, name, address, contact, DOB, gender));
                Alert alert;
                if (isAdded) {
                    Table.getItems().add(new StudentTM(studentId, name, address, contact, DOB, gender));
                    alert = new Alert(Alert.AlertType.INFORMATION, "Room has been successfully Added");
                    clearAll();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR, "Error");
                }
                alert.show();
            } else {
                //contact
                lblContact.setText("Incorrect number");
                ContactNO.requestFocus();
            }
        } else {
            //name
            lblName1.setText("Incorrect name");
            StudentName.requestFocus();
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        CmbGender.getItems().addAll(new String[]{"Male", "Female"});

        Table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Student ID"));
        Table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        Table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        Table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Contact No"));
        Table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Gender"));
        Table.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("BID"));
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                StudentID.setText(newValue.getStudent_id());
                StudentName.setText(newValue.getName());
                Address.setText(newValue.getAddress());
                ContactNO.setText(newValue.getContact_no());
                CmbGender.setValue(newValue.getGender());
                DOB.setValue(newValue.getDob());
            }
        });
        loadAll();
    }
    private void clearAll() {
        StudentID.setText(null);
        StudentName.setText(null);
        Address.setText(null);
        ContactNO.setText(null);
        DOB.setValue(null);
        CmbGender.setValue("");
    }
    private void loadAll() {
        Table.getItems().clear();
        ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();
        for (StudentDTO studentDTOs : allStudent) {
            Table.getItems().add(
                    new StudentTM(
                            studentDTOs.getStudent_id(),
                            studentDTOs.getName(),
                            studentDTOs.getAddress(),
                            studentDTOs.getContact_no(),
                            studentDTOs.getDob(),
                            studentDTOs.getGender()
                    )
            );
        }

    }

//    public TableColumn<?, ?> getTblSID() {
//        return tblSID;
//    }

//    public void setTblSID(TableColumn<?, ?> tblSID) {
//        this.tblSID = tblSID;
//    }
}
