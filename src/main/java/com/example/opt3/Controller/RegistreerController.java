package com.example.opt3.Controller;

import com.example.opt3.Model.Creator;
import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistreerController implements Initializable {
    @FXML
    private MFXComboBox<String> soortBedrijf;
    @FXML
    private MFXTextField Bedrijfnaam;
    @FXML
    private MFXTextField Straatnaam;
    @FXML
    private MFXTextField Huinummer;
    @FXML
    private MFXTextField Loon;
    @FXML
    private MFXComboBox<String> soortKinderen;
    @FXML
    private MFXTextField Postcode;
    @FXML
    private MFXTextField Gebruikersnaam;
    @FXML
    private MFXPasswordField Wachtwoord;
    @FXML
    private MFXCheckbox Bevestig;

    private final String[] bedrijfen = {"Gastouder"};
    private final String[] kinderen = {"Babies"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        soortBedrijf.getItems().addAll(bedrijfen);
        soortKinderen.getItems().addAll(kinderen);
    }

    public void onTerugButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"Login-view");
    }

    public void onRegistrerenButton(ActionEvent event) {
        Creator creator = new Creator();
        if (Bevestig.isSelected()) {
            try {
                int hs = Integer.parseInt(Huinummer.getText());
                double loon = Double.parseDouble(Loon.getText());
                creator.createGastouder(Bedrijfnaam.getText(), Straatnaam.getText(), Postcode.getText(), hs, loon, Gebruikersnaam.getText(), Wachtwoord.getText());
                ResourceLoader.changeScene(event, "Login-view.fxml");

            } catch (NumberFormatException | IOException e) {
                System.out.println("probleempje");
            }
        }

    }

}
