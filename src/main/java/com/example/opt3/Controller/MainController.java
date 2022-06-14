package com.example.opt3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController{
    private Stage stage;
    private Scene scene;

    @FXML
    public void onOmzetButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Omzet-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void onProfielButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Profiel_Main_view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onExitButton(ActionEvent event) throws IOException {
        System.exit(0);

    }


}
