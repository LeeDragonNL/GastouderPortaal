package com.example.opt3.Controller;

import com.example.opt3.MainApplication;
import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public MFXButton Profiel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onOmzetButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Omzet-view");
    }

    public void onExitButton(ActionEvent event) {
        System.exit(0);
    }

    public void onProfielButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Profiel_Main_view.fxml");
    }

    public void onUitlogButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Login-view.fxml");
    }
}
