package com.example.register_user_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class HelloController {

    @FXML
    private TextField addressId;

    @FXML
    private TextField emailId;

    @FXML
    private Button idRegister;

    @FXML
    private Button idReset;

    @FXML
    private TextField lastNameId;

    @FXML
    private TextField nameId;

    @FXML
    private TextField phoneNumberId;

    @FXML
    private TextField zipCodeId;

    @FXML
    void buttonRegister(ActionEvent event) {


    }

    @FXML
    void buttonReset(ActionEvent event) {
        List<TextField> textFieldsList = Arrays.asList(addressId, emailId, lastNameId, nameId, phoneNumberId, zipCodeId);
        for(TextField textField : textFieldsList) {
            textField.clear();
        }
    }

}
