package com.example.opt3.Controller;

import com.example.opt3.Model.Babies;
import com.example.opt3.Model.Gastouder;
import com.example.opt3.Model.Gebruiker;
import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXStepperToggle;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.NumberUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ToevoegenController implements Initializable {
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
        MFXStepperToggle step1 = new MFXStepperToggle();
        if(Bevestig.isSelected()) {
            Babies newBaby = new Babies(Name.getText(),Age.getText(),Street.getText(),Postcode.getText(),HouseNumber.getText(),Feeding.getText(),GEWICHT.getText());
            Gebruiker.people.add(newBaby);
            ResourceLoader.changeScene(event, "Display-all-view.fxml");
        }
        else{

        }
    }

    public void OnTerugbutton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Profiel_Main_view.fxml");
    }


}
