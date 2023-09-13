package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationController {
     Stage stage;
     Scene scene;
     Parent root;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField fatherNameField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField cnicNumberField;
    @FXML private TextField emailField;
    @FXML private TextField passwordField;
    @FXML private TextField confirmPasswordField;
    @FXML Button submitButton;
    @FXML private void NUllFields(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Null Fields");
        alert.setContentText("Fields can not be NULL");
        alert.setHeaderText("Warning alert");
        alert.show();
    }@FXML private void EmailNotValid(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Email Not Valid");
        alert.setContentText("Email isn't Valid");
        alert.setHeaderText("Warning alert");
        alert.show();
    }@FXML private void PasswordDoesntMatch(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Incorrect Password");
        alert.setContentText("Password doest not matched");
        alert.setHeaderText("Warning alert");
        alert.show();
    }
    Registration test =Registration.getInstance();
    @FXML public void handleSubmitButton(ActionEvent event){
        String FirstName= firstNameField.getText();
        String LastName= lastNameField.getText();
        String FatherName=fatherNameField.getText();
        String PhoneNumber=phoneNumberField.getText();
        String CNICNumber=cnicNumberField.getText();
        String Email=emailField.getText();
        String Password=passwordField.getText();
        String ConfirmPassword= confirmPasswordField.getText();
        if (Objects.equals(FirstName,"") || Objects.equals(LastName, "") || Objects.equals(FatherName, "") || Objects.equals(PhoneNumber, "") || Objects.equals(CNICNumber, "") || Objects.equals(Email, "") || Objects.equals(Password,"") || Objects.equals(ConfirmPassword,"")){
            NUllFields(event);
        }
        else if (!Objects.equals(FirstName,"") && !Objects.equals(LastName, "") && !Objects.equals(FatherName, "") && !Objects.equals(PhoneNumber, "") && !Objects.equals(CNICNumber, "") && !Objects.equals(Email, "") && !Objects.equals(Password,"") && !Objects.equals(ConfirmPassword,"")){
            String regex="[A-Za-z0-9_.-]+@(.+)$";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(Email);
            if (!matcher.matches()){
                EmailNotValid(event);
            }
            else if (matcher.matches()){
                if (!Objects.equals(Password,ConfirmPassword)){
                    PasswordDoesntMatch(event);
                }
                else if (Password.equals(ConfirmPassword)) {
                    try {
                        test.setFirstName(FirstName);
                        test.setLastName(LastName);
                        test.setFatherName(FatherName);
                        test.setPhoneNumber(PhoneNumber);
                        test.setCnicNumber(CNICNumber);
                        test.setEmail(Email);
                        test.setPassword(Password);
                        test.setcPassword(ConfirmPassword);
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginStyle.fxml")));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setResizable(false);
                        stage.setTitle("Login");
                        stage.setScene(scene);
                        stage.show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
