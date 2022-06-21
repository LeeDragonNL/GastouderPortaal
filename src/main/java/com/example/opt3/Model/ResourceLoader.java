package com.example.opt3.Model;

import com.example.opt3.MainApplication;
import javafx.beans.binding.BooleanExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResourceLoader {


    public static void changeScene(ActionEvent event, String url) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource(url));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public static Parent test (ActionEvent event, String url) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(url));

        Parent root = loader.load();
        return root;

    }

    public static Boolean isDouble(String str){
        try {

            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isInt(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
