package com.example.opt3.Controller;

import com.example.opt3.Model.Database;
import com.example.opt3.Model.ResourceLoader;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.ColorUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserEditController implements Initializable {
    @FXML
    private MFXCheckbox bevestig;
    @FXML
    private Label bevestiglabel;
    @FXML
    private MFXTextField bedrijfnaam;
    @FXML
    private MFXTextField straat;
    @FXML
    private MFXTextField postcode;
    @FXML
    private MFXTextField huisnummer;
    @FXML
    private MFXTextField username;
    @FXML
    private MFXPasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void onFillDataButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();

        bedrijfnaam.setText(gastouder.getName());
        straat.setText(gastouder.getAdres().getStraatnaam());
        postcode.setText(gastouder.getAdres().getPostcode());
        huisnummer.setText(String.valueOf(gastouder.getAdres().getHuisnummer()));
        username.setText(gastouder.getLogin().getUsername());
        password.setText(gastouder.getLogin().getPassword());

    }

    @FXML
    public void onConfirmButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();
        Database database = new Database();

        if (bevestig.isSelected()) {
            gastouder.setName(bedrijfnaam.getText());
            gastouder.getAdres().setStraatnaam(straat.getText());
            gastouder.getAdres().setPostcode(postcode.getText());
            gastouder.getAdres().setHuisnummer(Integer.parseInt(huisnummer.getText()));
            gastouder.getLogin().setUsername(username.getText());
            gastouder.getLogin().setPassword(password.getText());

            ArrayList<Gastouder> gastouderArrayList = new ArrayList<>();
            gastouderArrayList.add(gastouder);
            database.writer(gastouderArrayList);
            ResourceLoader.changeScene(event,"fxml/Main-view.fxml");
        }
        else {
            bevestiglabel.setTextFill(ColorUtils.getRandomColor());
        }
    }
}
