package com.example.opt3.Controller;

import com.example.opt3.Model.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXStepperToggle;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.NumberUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

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
//        Age.getValidator().constraint("Moet een cijfer zijn", Age.textProperty().)
        Street.setPromptText("Straatnaam...");

        Postcode.setPromptText("Postcode");

        Feeding.setPromptText("Voeding...");

        HouseNumber.setPromptText("Huisnummer...");

        GEWICHT.setPromptText("Gewicht");


    }

    public void onToevoegenButton(ActionEvent event) throws IOException {
        Database database = new Database();

        if(Bevestig.isSelected()) {
            Babies newBaby = new Babies(Name.getText(),Age.getText(),Street.getText(),Postcode.getText(),HouseNumber.getText(),Feeding.getText(),GEWICHT.getText());
            Gebruiker.people.add(newBaby);
            ArrayList<Babies> babies = database.reader("Babies.json");
            babies.add(newBaby);
            database.writer(babies, "Babies.json");

            ResourceLoader.changeScene(event, "Display-all-view.fxml");
        }
        else{
            bevestigLabel.setTextFill(Color.color(1,0,0));
        }
    }

    public void OnTerugbutton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Profiel_Main_view.fxml");
    }


}
