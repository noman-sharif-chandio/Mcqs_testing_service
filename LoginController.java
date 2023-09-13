package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;


public class LoginController {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField PasswordField;
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
    Registration test=Registration.getInstance();
    @FXML
    public void loginButtonClicked(ActionEvent event){

        String email=EmailField.getText();
        String password=PasswordField.getText();
        String registeredEmail=test.getEmail();
        String registeredPassword=test.getPassword();
        if(Objects.equals(email,"") || Objects.equals(password,"")){
            NUllFields(event);
        } else if (!Objects.equals(email,"") && !Objects.equals(password,"")) {
            if (!Objects.equals(email,registeredEmail)){
                EmailNotValid(event);
            } else if (email.equals(registeredEmail)) {
              if (!Objects.equals(password,registeredPassword)){
                  PasswordDoesntMatch(event);
              }else if (password.equals(registeredPassword)){
                  try {
                      root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("McqsStyle.fxml")));
                      stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                      scene = new Scene(root);
                      stage.setScene(scene);
                      stage.setTitle("Test");
                      stage.setResizable(true);
                      stage.setFullScreen(true);
                      stage.setFullScreenExitHint("A Project By Noman Sharif Chandio\nPress ESC to EXIT");
                      stage.show();

                  }catch (Exception e){
                      e.printStackTrace();
                  }
              }
            }
        }

    }
}
