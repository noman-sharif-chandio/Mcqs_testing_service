package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("RegistrationStyle.fxml"));
        Scene scene= new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
    }
}
