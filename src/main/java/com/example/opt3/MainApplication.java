package com.example.opt3;

import com.example.opt3.Controller.ScreenController;
import com.example.opt3.Model.ResourceLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dashboard!");
        stage.setScene(scene);
        stage.show();
    }

//    FXMLLoader loader = new FXMLLoader(ResourceLoader.loadURL("Main-view.fxml"));
//        loader.setControllerFactory(c -> new MainController(primaryStage));
//    Parent root = loader.load();
//    Scene scene = new Scene(root);
//        scene.setFill(Color.TRANSPARENT);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("MaterialFX Demo");
//        primaryStage.show();

    public static void main(String[] args) {
        launch();
    }
}
