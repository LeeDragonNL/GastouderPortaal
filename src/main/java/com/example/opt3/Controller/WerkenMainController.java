package com.example.opt3.Controller;

import com.example.opt3.Model.ResourceLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class WerkenMainController {

    @FXML
    private StackPane contentPane;

    public void onWerkdagButton(ActionEvent event) throws IOException {
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Werkdag-view.fxml"));

    }

    public void onOmzetButton(ActionEvent event) throws IOException {
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Omzet-view.fxml"));
    }

    public void onTerugButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Main-view.fxml");
    }
}
