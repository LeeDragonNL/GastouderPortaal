package com.example.opt3.Controller;


import com.example.opt3.Model.ResourceLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;


import java.io.IOException;

public class ProfielMainController {

    public StackPane contentPane;

    @FXML
    public void onToevoegenButton(ActionEvent event) throws IOException {
//        ResourceLoader.changeScene(event,);
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Toevoegen-view.fxml"));
    }
    @FXML
    public void onBekijkButton(ActionEvent event) throws IOException {
//        ResourceLoader.changeScene(event,);
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Display-all-view.fxml"));
    }
    @FXML
    public void onBewerkButton(ActionEvent event) throws IOException {
        contentPane.getChildren().setAll(ResourceLoader.test(event,"fxml/Bewerk-Profiel-view.fxml"));

    }

    public void onTerugButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Main-view.fxml");
    }
}
