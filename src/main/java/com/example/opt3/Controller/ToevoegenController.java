package com.example.opt3.Controller;

import com.example.opt3.Model.*;
import com.example.opt3.Model.users.Babies;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ToevoegenController implements Initializable {
    @FXML
    private Label bevestigLabel;
    @FXML
    private MFXCheckbox Bevestig;
    @FXML
    private MFXTextField Name;
    @FXML
    private MFXTextField Age;
    @FXML
    private MFXTextField Street;
    @FXML
    private MFXTextField Postcode;
    @FXML
    private MFXTextField Feeding;
    @FXML
    private MFXTextField HouseNumber;
    @FXML
    private MFXTextField GEWICHT;
    @FXML
    private MFXButton Toevoegen;
    @FXML
    public MFXButton Terug;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setPromptText("Naam...");
        Name.getValidator().constraint("Naam moet minimaal 3 tekens bevatten...", Name.textProperty().length().greaterThanOrEqualTo(3));
        Age.setPromptText("Leeftijd...");
        Street.setPromptText("Straatnaam...");
        Postcode.setPromptText("Postcode");
        Feeding.setPromptText("Voeding...");
        HouseNumber.setPromptText("Huisnummer...");
        GEWICHT.setPromptText("Gewicht");
    }

    public void onToevoegenButton(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();
        Database database = new Database();
        try {
            if (Bevestig.isSelected()) {

                Integer.parseInt(HouseNumber.getText());
                Integer.parseInt(Age.getText());
                Double.parseDouble(GEWICHT.getText());

//                Babies newBaby = new Babies(Name.getText(), Age.getText(), Street.getText(), Postcode.getText(), HouseNumber.getText(), Feeding.getText(), GEWICHT.getText());
                Babies newBabies = new Babies(Name.getText(),Integer.parseInt(Age.getText()),Street.getText(),Postcode.getText(),Integer.parseInt(HouseNumber.getText()),Feeding.getText(),Double.parseDouble(GEWICHT.getText()));
                gastouder.getPeople().add(newBabies);

                ArrayList<Gastouder> gastouderArrayLists = database.reader();
                gastouderArrayLists.add(gastouder);
                database.writer(gastouderArrayLists);

            }
            else {
                bevestigLabel.setTextFill(Color.color(1, 0, 0));
            }
        }catch (NumberFormatException e){
            System.out.println(e);

        }
    }

    public void OnTerugbutton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Profiel_Main_view.fxml");
    }
}
