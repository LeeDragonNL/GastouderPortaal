package com.example.opt3.Controller;

import com.example.opt3.MainApplication;
import com.example.opt3.Model.ResourceLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfielMainController {
    @FXML
    public void onVerwijderButton(ActionEvent event){

    }
    @FXML
    public void onToevoegenButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Toevoegen-view.fxml");
    }
    @FXML
    public void onBekijkButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Display-all.fxml");
    }
    @FXML
    public void onBewerkButton(ActionEvent event){

    }

    public void onTerugButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Main-view.fxml");
    }
}
