package com.example.opt3.Controller;

import com.example.opt3.Model.Database;
import com.example.opt3.Model.Invoer;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.utils.ColorUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WerkDagController implements Initializable {
    @FXML
    private Label SuccesvolWerk;
    @FXML
    private Label bevestiglabel;
    @FXML
    private MFXCheckbox Bevestig;
    @FXML
    private MFXComboBox<Integer> Kinderen;
    @FXML
    private MFXComboBox<Integer> Uren;

    private final Integer[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Uren.getItems().addAll(numbers);
        Kinderen.getItems().addAll(numbers);
    }

    public void onWerkenButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();
        Database database = new Database();

        if (Bevestig.isSelected()){
            Invoer invoer = new Invoer(Uren.getValue(), Kinderen.getValue());
            gastouder.getInvoers().add(invoer);

            ArrayList<Gastouder> gastouderArrayLists = new ArrayList<>();
            gastouderArrayLists.add(gastouder);

            SuccesvolWerk.setText("LEKKER GEWERKT");
            SuccesvolWerk.setTextFill(ColorUtils.getRandomColor());

            gastouder.getOmzet().setTotaleUren(gastouder.getOmzet().getTotaleUren() + Uren.getValue());
            gastouder.getOmzet().setTotaleOmzet(gastouder.getOmzet().getTotaleOmzet() + (Kinderen.getValue() * Uren.getValue() * gastouder.getOmzet().getLoon()));
            database.writer(gastouderArrayLists);
        }
        else {
            bevestiglabel.setTextFill(Color.color(1, 0, 0));
        }
    }
}
