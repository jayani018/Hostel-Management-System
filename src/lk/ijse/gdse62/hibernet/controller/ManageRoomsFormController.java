package lk.ijse.gdse62.hibernet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse62.hibernet.bo.BOFactory;
import lk.ijse.gdse62.hibernet.bo.BOType;
import lk.ijse.gdse62.hibernet.bo.custom.RoomBO;
import lk.ijse.gdse62.hibernet.dto.RoomDTO;
import lk.ijse.gdse62.hibernet.util.CheckValidation;
import lk.ijse.gdse62.hibernet.util.ValidationType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageRoomsFormController {
    public JFXTextField RoomNo;
    public JFXTextField KeyMoney;
    public JFXTextField Roomtype;
    public JFXTextField RoomsQTY;
    public TextField search;
    public TableView Table;
    public AnchorPane pane;
    public AnchorPane navPane;
    public JFXComboBox cmbRoomNo;
    public Label lblKeyMoney;
    public Label lblQTY;
    public Label lblRoomType;
    public Label lblKeyMoneyRM_1324;
    public Label lblKeyMoneyRM_5467;
    public Label lblKeyMoneyRM_7896;
    public Label lblKeyMoneyRM_0093;
    public Label lblQTYRM_5467;
    public Label lblQTYRM_7896;
    public Label lblQTYRM_1324;
    public Label lblQTYRM_0093;

    @FXML

    private RoomDTO roomDTO;
    String id, type;
    double keyMoney;
    int qty;

    private final RoomBO roomBO = (RoomBO) BOFactory.getInstance().getBOType(BOType.ROOM);

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        id = (String) cmbRoomNo.getValue();
        type = lblRoomType.getText();
        keyMoney = Double.parseDouble(KeyMoney.getText());
        qty = Integer.parseInt(RoomsQTY.getText());
        roomDTO = new RoomDTO(id, type, keyMoney, qty);

        lblKeyMoney.setText(null);
        lblQTY.setText(null);

        if (CheckValidation.validation(ValidationType.MONEY, String.valueOf(keyMoney))) {
            if (CheckValidation.validation(ValidationType.QTY, String.valueOf(qty))) {
                boolean isUpdated = roomBO.updateRoom(roomDTO);
                Alert alert;
                if (isUpdated) {
                    alert = new Alert(Alert.AlertType.INFORMATION, "Room has been successfully updated");
                    clearAll();
                    loadAll();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR, "Error");
                }
                alert.show();
            } else {
                //qty
                lblQTY.setText("Incorrect QTY");
                RoomsQTY.requestFocus();
            }
        } else {
            //money
            lblKeyMoney.setText("Incorrect type");
            KeyMoney.requestFocus();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        id = (String) cmbRoomNo.getValue();
        type = Roomtype.getText();
        keyMoney = Double.parseDouble(KeyMoney.getText());
        qty = Integer.parseInt(RoomsQTY.getText());
        roomDTO = new RoomDTO(id, type, keyMoney, qty);

        lblKeyMoney.setText(null);
        lblQTY.setText(null);

        if (CheckValidation.validation(ValidationType.MONEY, String.valueOf(keyMoney))) {
            if (CheckValidation.validation(ValidationType.QTY, String.valueOf(qty))) {
                boolean isDeleted = roomBO.deleteRoom(roomDTO);
                Alert alert;
                if (isDeleted) {
                    alert = new Alert(Alert.AlertType.INFORMATION, "Room has been successfully deleted");
                    clearAll();
                    loadAll();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR, "Error");
                }
                alert.show();
            } else {
                //qty
                lblQTY.setText("Incorrect QTY");
                RoomsQTY.requestFocus();
            }
        } else {
            //money
            lblKeyMoney.setText("Incorrect type");
            KeyMoney.requestFocus();
        }
    }

    public void AddOnAction(ActionEvent actionEvent) {
        id = (String) cmbRoomNo.getValue();
        type = Roomtype.getText();
        keyMoney = Double.parseDouble(KeyMoney.getText());
        qty = Integer.parseInt(RoomsQTY.getText());
        roomDTO = new RoomDTO(id, type, keyMoney, qty);

        lblKeyMoney.setText(null);
        lblQTY.setText(null);

        if (CheckValidation.validation(ValidationType.MONEY, String.valueOf(keyMoney))) {
            if (CheckValidation.validation(ValidationType.QTY, String.valueOf(qty))) {
                boolean isAdded = roomBO.saveRoom(roomDTO);
                Alert alert;
                if (isAdded) {
                    alert = new Alert(Alert.AlertType.INFORMATION, "Room has been successfully added");
                    clearAll();
                    loadAll();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR, "Error");
                }
                alert.show();
            } else {
                //qty
                lblQTY.setText("Incorrect QTY");
                RoomsQTY.requestFocus();
            }
        } else {
            //money
            lblKeyMoney.setText("Incorrect type");
            KeyMoney.requestFocus();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        cmbRoomNo.getItems().addAll(new String[]{"RM-1324", "RM-5467", "RM-7896", "RM-0093"});
        loadAll();
    }

    public void RoomsOnAction(ActionEvent actionEvent) {
    }

    public void regOnAction(ActionEvent actionEvent) {
    }

    public void StudentOnAction(ActionEvent actionEvent) {
    }

    public void LogoutOnAction(ActionEvent actionEvent) {
    }

    public void RM_5467OnAction(MouseEvent mouseEvent) {
        cmbRoomNo.setValue("RM-5467");
        lblRoomType.setText("Non-AC / Food");
        KeyMoney.setText(lblKeyMoneyRM_5467.getText());
        RoomsQTY.setText(lblQTYRM_5467.getText());
    }

    public void RM_7896OnAction(MouseEvent mouseEvent) {
        cmbRoomNo.setValue("RM-7896");
        lblRoomType.setText("AC");
        KeyMoney.setText(lblKeyMoneyRM_7896.getText());
        RoomsQTY.setText(lblQTYRM_7896.getText());
    }

    public void RM_0093OnAction(MouseEvent mouseEvent) {
        cmbRoomNo.setValue("RM-0093");
        lblRoomType.setText("AC / Food");
        KeyMoney.setText(lblKeyMoneyRM_0093.getText());
        RoomsQTY.setText(lblQTYRM_0093.getText());
    }

    public void RM_1324OnAction(MouseEvent mouseEvent) {
        cmbRoomNo.setValue("RM-1324");
        lblRoomType.setText("Non-AC");
        KeyMoney.setText(lblKeyMoneyRM_1324.getText());
        RoomsQTY.setText(lblQTYRM_1324.getText());
    }

    public void cmbRoomNoOnAction(ActionEvent event) {
        String value = (String) cmbRoomNo.getValue();
        switch (value) {
            case "RM-1324":
                lblRoomType.setText("Non-AC");
                break;
            case "RM-5467":
                lblRoomType.setText("Non-AC / Food");
                break;
            case "RM-7896":
                lblRoomType.setText("AC");
                break;
            case "RM-0093":
                lblRoomType.setText("AC / Food");
                break;
        }
    }
    private void clearAll() {
        cmbRoomNo.setValue("");
        lblRoomType.setText(null);
        KeyMoney.setText(null);
        RoomsQTY.setText(null);
    }
    private void loadAll() {
        ArrayList<RoomDTO> roomDTOS = roomBO.loadAll();
        for (RoomDTO r : roomDTOS) {
            switch (r.getRoom_type_id()) {
                case "RM-1324":
                    lblKeyMoneyRM_1324.setText(String.valueOf(r.getKey_money()));
                    lblQTYRM_1324.setText(String.valueOf(r.getQty()));
                    break;
                case "RM-5467":
                    lblKeyMoneyRM_0093.setText(String.valueOf(r.getKey_money()));
                    lblQTYRM_0093.setText(String.valueOf(r.getQty()));
                    break;
                case "RM-7896":
                    lblKeyMoneyRM_5467.setText(String.valueOf(r.getKey_money()));
                    lblQTYRM_5467.setText(String.valueOf(r.getQty()));
                    break;
                case "RM-0093":
                    lblKeyMoneyRM_7896.setText(String.valueOf(r.getKey_money()));
                    lblQTYRM_7896.setText(String.valueOf(r.getQty()));
                    break;
            }
        }
    }
}
