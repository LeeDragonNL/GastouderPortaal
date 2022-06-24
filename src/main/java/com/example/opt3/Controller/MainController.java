package com.example.opt3.Controller;

import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class MainController{

    @FXML
    private StackPane contentPane;

    public void onOmzetButton(ActionEvent event) throws IOException {
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Overzicht-view.fxml"));
//        ResourceLoader.changeScene(event,"fxml/OverzichtController.fxml");
    }

    public void onExitButton(ActionEvent event) {
        System.exit(0);
    }

    public void onProfielButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Profiel-Main-view.fxml");
    }

    public void onUitlogButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Login-view.fxml");
    }

    public void onWerkenButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Werken-Main-view.fxml");
    }
}
