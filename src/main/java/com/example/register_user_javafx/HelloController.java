package com.example.register_user_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField addressId;

    @FXML
    private TextField emailId;

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

        if (areFieldsEmpty()) {
            showAlert("All fields must be filled.");
        } else if (isAlphabetic(nameId.getText())) {
            showAlert("Name must contain only alphabetic characters.");
        } else if (isAlphabetic(lastNameId.getText())) {
            showAlert("Last Name must contain only alphabetic characters.");
        }else if (!isValidEmail(emailId.getText())) {
            showAlert("Email format is incorrect.");
        } else if (!isValidPhoneNumber(phoneNumberId.getText())) {
            showAlert("Phone number format is incorrect.");
        } else if (!isValidAddress(addressId.getText())) {
            showAlert("Address format is incorrect.");
        } else if (!isValidZipCode(zipCodeId.getText())) {
            showAlert("Zip code format is incorrect.");
        }
    }

    @FXML
    void buttonReset(ActionEvent event) {
        List<TextField> textFieldsList = Arrays.asList(addressId, emailId, lastNameId, nameId, phoneNumberId, zipCodeId);
        for (TextField textField : textFieldsList) {
            textField.clear();
        }
    }

    private void restrictToDigits(TextField textField) {
        Pattern validPattern = Pattern.compile("\\d*");

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (validPattern.matcher(newText).matches()) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }

    private boolean isAlphabetic(String text) {
        return !text.matches("[a-zA-Z]+");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Here we assume a valid phone number format is 10 digits (you can adjust the regex as needed)
        String phoneRegex = "^\\d{10}$";
        return phoneNumber.matches(phoneRegex);
    }

    private boolean isValidAddress(String address) {
        // Assuming a valid address can contain letters, digits, spaces, and common punctuation marks
        String addressRegex = "^[a-zA-Z0-9\\s,.'-]{3,}$";
        return address.matches(addressRegex);
    }

    private boolean isValidZipCode(String zipCode) {
        // Assuming a valid zip code can contain letters and digits, and is between 5 and 10 characters long
        String zipCodeRegex = "^[a-zA-Z0-9]{5,10}$";
        return zipCode.matches(zipCodeRegex);
    }

    private boolean areFieldsEmpty() {
        return isFieldEmpty(nameId) || isFieldEmpty(emailId) || isFieldEmpty(phoneNumberId) ||
                isFieldEmpty(addressId) || isFieldEmpty(zipCodeId);
    }

    private boolean isFieldEmpty(TextField textField) {
        return textField.getText() == null || textField.getText().trim().isEmpty();
    }

    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
