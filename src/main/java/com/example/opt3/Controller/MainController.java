package com.example.opt3.Controller;

import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController{
    @FXML
    private MFXButton Profiel;
    @FXML
    private StackPane contentPane;

    public void onOmzetButton(ActionEvent event) throws IOException {
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Omzet-view.fxml"));
//        ResourceLoader.changeScene(event,"fxml/Omzet-view.fxml");
    }

    public void onExitButton(ActionEvent event) {
        System.exit(0);
    }

    public void onProfielButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Profiel_Main_view.fxml");
    }

    public void onUitlogButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Login-view.fxml");
    }
}
