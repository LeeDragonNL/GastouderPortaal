package com.example.opt3.Controller;

import com.example.opt3.Model.LoginCheck;
import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setPromptText("Username...");
        password.setPromptText("Wachtwoord...");

    }
    public void onRegisterenButton(ActionEvent event) throws IOException {
            ResourceLoader.changeScene(event,"fxml/Registeer-view.fxml");
    }

    public void onLoginButton(ActionEvent event) throws IOException {
        LoginCheck loginCheck = new LoginCheck();
        if (loginCheck.Login(username.getText(),password.getText()) != null){
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setUserData(loginCheck.gastouders);

            ResourceLoader.changeScene(event,"fxml/Main-view.fxml");
        }
        else {
            tryAgain.setText("Incorrect. controleer uw gebruikersnaam en wachtwoord");
        }
    }
}
