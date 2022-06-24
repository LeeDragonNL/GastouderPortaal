package com.example.opt3.Controller;

import com.example.opt3.Model.*;
import com.example.opt3.Model.users.Babies;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.validation.Constraint;
import io.github.palexdev.materialfx.validation.Severity;
import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
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
import java.util.List;
import java.util.ResourceBundle;

import static com.example.opt3.Controller.RegistreerController.containsAny;

public class ToevoegenController implements Initializable {
    @FXML
    private Label leeftijdLabel;
    @FXML
    private Label gewichtLabel;
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

    private static final PseudoClass INVALID_PSEUDO_CLASS = PseudoClass.getPseudoClass("invalid");
    private static final String[] digits = "0 1 2 3 4 5 6 7 8 9".split(" ");

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

        Age.setTextLimit(2);
        GEWICHT.setTextLimit(4);
        Postcode.setTextLimit(6);


        Constraint digitConstraint1 = Constraint.Builder.build()
                .setSeverity(Severity.ERROR)
                .setMessage("leeftijd moet uit cijfers bestaan")
                .setCondition(Bindings.createBooleanBinding(
                        () -> containsAny(Age.getText(), "", digits),
                        Age.textProperty()
                ))
                .get();

        Constraint digitConstraint2 = Constraint.Builder.build()
                .setSeverity(Severity.ERROR)
                .setMessage("leeftijd moet uit cijfers bestaan")
                .setCondition(Bindings.createBooleanBinding(
                        () -> containsAny(GEWICHT.getText(), "", digits),
                        GEWICHT.textProperty()
                ))
                .get();

        Age.getValidator().constraint(digitConstraint1);

        Age.getValidator().validProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                leeftijdLabel.setVisible(false);
                Age.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, false);
            }
        });

        Age.delegateFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue && !newValue) {
                List<Constraint> constraints = Age.validate();
                if (!constraints.isEmpty()) {
                    Age.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, true);
                    Age.setText(constraints.get(0).getMessage());
                    leeftijdLabel.setVisible(true);
                }
            }
        });

        GEWICHT.getValidator().constraint(digitConstraint2);

        GEWICHT.getValidator().validProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                gewichtLabel.setVisible(false);
                GEWICHT.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, false);
            }
        });

        GEWICHT.delegateFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue && !newValue) {
                List<Constraint> constraints = GEWICHT.validate();
                if (!constraints.isEmpty()) {
                    GEWICHT.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, true);
                    GEWICHT.setText(constraints.get(0).getMessage());
                    gewichtLabel.setVisible(true);
                }
            }
        });
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

                Babies newBabies = new Babies(Name.getText(),Integer.parseInt(Age.getText()),Street.getText(),Postcode.getText(),Integer.parseInt(HouseNumber.getText()),Feeding.getText(),Double.parseDouble(GEWICHT.getText()));
                gastouder.getPeople().add(newBabies);

                ArrayList<Gastouder> gastouderArrayLists = new ArrayList<>();
                gastouderArrayLists.add(gastouder);
                database.writer(gastouderArrayLists);

                ResourceLoader.changeScene(event,"fxml/Profiel-Main-view.fxml");

            }
            else {
                bevestigLabel.setTextFill(Color.color(1, 0, 0));
            }
        }catch (NumberFormatException | IOException e){
            System.out.println(e);

        }
    }
}
