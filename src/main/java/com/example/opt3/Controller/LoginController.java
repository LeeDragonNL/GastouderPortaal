package com.example.opt3.Controller;

import com.example.opt3.Model.Gebruiker;
import com.example.opt3.Model.Login;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {
    @FXML
    public MFXPasswordField password;
    @FXML
    public MFXTextField username;

    public void onRegisterenButton(ActionEvent event) {

    }

    public void onLoginButton(ActionEvent event) {
        Login login = new Login();
        if (login.loginCheck(username.getText(),password.getText())){
            System.out.println("welkom");
        }
        else {
            System.out.println("not welcome");
        }
    }
}
