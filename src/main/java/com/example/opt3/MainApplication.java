package com.example.opt3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("Login-view.fxml"));
        stage.setTitle("Dashboard!");
        stage.setScene(new Scene(root));
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
