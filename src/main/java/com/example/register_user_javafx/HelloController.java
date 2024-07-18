package com.example.register_user_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


    /**
     *  <h1>Method buttonRegister</h1>
     *
     *  <h3>Functionalities</h3>
     *<p>
     *   This method checks that the TextFields are not empty and ensures they have the correct format.
     *   It uses if-else statements and the <code>isAlphabetic()</code>, <code>isValidEmail()</code>,
     *   <code>isValidAddress()</code>, and <code>isValidZipCode()</code>, <code>areFieldsEmpty()</code>methods for validation.
     *   If the format is incorrect, it displays an error message.
     *   </p>
     * Example usage:
     *
     *       <pre>
     *           {@code
     *               private boolean isAlphabetic(String text) {
     *               return !text.matches("[a-zA-Z]+");
     *                }
     *           }
     *
     *       </pre>
     *
     *
     *  <p>* Connect and Collect data User into a user's table use a Database</p>
     */
    @FXML
    void buttonRegister() {
        if (areFieldsEmpty()) {
            showAlert("All fields must be filled.");
        } else if (!isAlphabetic(nameId.getText())) {
            showAlert("Name must contain only alphabetic characters.");
        } else if (!isAlphabetic(lastNameId.getText())) {
            showAlert("Last Name must contain only alphabetic characters.");
        }else if (!isValidEmail(emailId.getText())) {
            showAlert("Email format is incorrect.");
        } else if (!isValidPhoneNumber(phoneNumberId.getText())) {
            showAlert("Phone number format is incorrect.");
        } else if (!isValidAddress(addressId.getText())) {
            showAlert("Address format is incorrect.");
        } else if (!isValidZipCode(zipCodeId.getText())) {
            showAlert("Zip code format is incorrect.");
        }else{
            saveUserData();
        }
    }

    /**
     * <H1>Method buttonRest</H1>
     *
     *<h3>Functionalities</h3>
     *
     * <p> Collect <code>textField variables</code> into a Array. Use Of loop to clear the textFields</p>
     *
     * <per>
     *     {@code
     *
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
     *     }
     * </per>
     *
     */
    @FXML
    public void buttonReset() {
        List<TextField> textFieldsList = Arrays.asList(addressId, emailId, lastNameId, nameId, phoneNumberId, zipCodeId);
        for (TextField textField : textFieldsList) {
            textField.clear();
        }
    }

    /**
     * <H1> Method saveUserData</H1>
     *
     * <h3>Functionalities</h3>
     *
     *<p1>Create connection between my project and the database and Insert values into User's Table and display error message.</p1>
     *
     */
    private void saveUserData(){

    String query = "INSERT INTO userRegister(userName, lastName, email, phoneNumber, address, zipCode) VALUES (?,?,?,?,?,?)";
    String url = "jdbc:mysql://localhost:3306/user_register";
    String userName = "root";
    String password = "123qwe";
    try(Connection conn = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setString(1, nameId.getText());
        stmt.setString(2, lastNameId.getText());
        stmt.setString(3, emailId.getText());
        stmt.setString(4, phoneNumberId.getText());
        stmt.setString(5, addressId.getText());
        stmt.setString(6, zipCodeId.getText());
        stmt.executeUpdate();
        showAlert("User registered successfully.");

    }catch (SQLException ex){
        showAlert(ex.getMessage());
    }
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

    /**
     * <h1>Return Methods areFieldsEmpty and isFiledEmpty</h1>
     *
     *<p> The return method <code>areFieldEmpty()</code> is used to check if all the text fields are empty by using <code>isFieldEmpty()</code>. </p>
     *
     *<p> In the Return Method <code>isFieldEmpty()</code></p>
     *
     * @return 'true' if the text field is empty or contains only whitespace, and 'false' otherwise
     */
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
