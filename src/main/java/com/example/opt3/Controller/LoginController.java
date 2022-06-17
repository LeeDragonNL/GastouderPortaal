package com.example.opt3.Controller;

import com.example.opt3.MainApplication;
import com.example.opt3.Model.Gebruiker;
import com.example.opt3.Model.Login;
import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label tryAgain;
    @FXML
    private MFXPasswordField password;
    @FXML
    private MFXTextField username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setPromptText("Username...");
        password.setPromptText("Wachtwoord...");


        tryAgain.setText("Incorrect. controleer uw gebruikersnaam en wachtwoord");
    }
    public void onRegisterenButton(ActionEvent event) {

    }

    public void onLoginButton(ActionEvent event) throws IOException {
        Login login = new Login();
        if (login.loginCheck(username.getText(),password.getText())){

            ResourceLoader.changeScene(event,"Main-view.fxml");
        }
        else {

            System.out.println("not welcome");
        }
    }


}
