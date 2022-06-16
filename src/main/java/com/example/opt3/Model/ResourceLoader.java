package com.example.opt3.Model;

import com.example.opt3.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourceLoader {


    public static void changeScene(ActionEvent event, String url) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(url));

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
