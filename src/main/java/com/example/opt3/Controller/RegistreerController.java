package com.example.opt3.Controller;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

public class RegistreerController{
    public MFXComboBox soortBedrijf;
    public MFXTextField Bedrijfnaam;
    public MFXTextField Straatnaam;
    public MFXTextField Huinummer;
    public MFXTextField Loon;
    public MFXComboBox soortKinderen;
    public MFXTextField Postcode;
    public MFXTextField Gebruikersnaam;
    public MFXPasswordField Wachtwoord;
    public MFXCheckbox Bevestig;

    public void onTerugButton(ActionEvent event) {
    }

    public void onRegistrerenButton(ActionEvent event) {
    }
}
