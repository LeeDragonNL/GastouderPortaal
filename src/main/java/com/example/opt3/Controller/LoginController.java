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

    private static final PseudoClass INVALID_PSEUDO_CLASS = PseudoClass.getPseudoClass("invalid");
    private static final String[] upperChar = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    private static final String[] lowerChar = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
    private static final String[] digits = "0 1 2 3 4 5 6 7 8 9".split(" ");
    private static final String[] specialCharacters = "! @ # & ( ) – [ { } ]: ; ' , ? / * ~ $ ^ + = < > -".split(" ");

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
