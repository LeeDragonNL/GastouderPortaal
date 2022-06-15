package com.example.opt3.Controller;

import com.example.opt3.Model.Babies;
import com.example.opt3.Model.Gebruiker;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ToevoegenController {

    @FXML
    public MFXTextField Name;
    @FXML
    public MFXTextField Age;
    @FXML
    public MFXTextField Street;
    @FXML
    public MFXTextField Postcode;
    @FXML
    public MFXTextField Feeding;
    @FXML
    public MFXTextField HouseNumber;
    @FXML
    public MFXTextField GEWICHT;
    @FXML
    public MFXButton Toevoegen;
    @FXML
    public MFXButton Terug;


    public void onToevoegenButton(ActionEvent event) {
        Babies newBaby = new Babies(Name.getText(),Age.getText(),Street.getText(),Postcode.getText(),Feeding.getText(),HouseNumber.getText(),GEWICHT.getText());
        Gebruiker.people.add(newBaby);
    }

    public void OnTerugbutton(ActionEvent event) {
    }
}
