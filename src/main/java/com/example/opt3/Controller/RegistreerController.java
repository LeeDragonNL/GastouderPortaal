package com.example.opt3.Controller;

import com.example.opt3.Model.Database;
import com.example.opt3.Model.ExistenceCheck;
import com.example.opt3.Model.users.Gastouder;
import com.example.opt3.Model.ResourceLoader;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.validation.Constraint;
import io.github.palexdev.materialfx.validation.Severity;
import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class RegistreerController implements Initializable {

    @FXML
    private Label tryAgain;
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
    private MFXTextField username;
    @FXML
    private MFXPasswordField password;
    @FXML
    private MFXCheckbox Bevestig;

    private static final PseudoClass INVALID_PSEUDO_CLASS = PseudoClass.getPseudoClass("invalid");
    private static final String[] upperChar = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    private static final String[] lowerChar = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
    private static final String[] digits = "0 1 2 3 4 5 6 7 8 9".split(" ");
    private static final String[] specialCharacters = "! @ # & ( ) – [ { } ]: ; ' , ? / * ~ $ ^ + = < > -".split(" ");

    private final String[] bedrijfen = {"Gastouder"};
    private final String[] kinderen = {"Babies"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        soortBedrijf.getItems().addAll(bedrijfen);
        soortKinderen.getItems().addAll(kinderen);

        username.setTextLimit(10);

        Constraint lengthConstraint = Constraint.Builder.build()
                .setSeverity(Severity.ERROR)
                .setMessage("Wachtwoord moet minstens 8 tekens bevatten")
                .setCondition(password.textProperty().length().greaterThanOrEqualTo(8))
                .get();

        Constraint digitConstraint = Constraint.Builder.build()
                .setSeverity(Severity.ERROR)
                .setMessage("Wachtwoord moet minsten 1 cijfer bevatten")
                .setCondition(Bindings.createBooleanBinding(
                        () -> containsAny(password.getText(), "", digits),
                        password.textProperty()
                ))
                .get();

        Constraint charactersConstraint = Constraint.Builder.build()
                .setSeverity(Severity.ERROR)
                .setMessage("Wachtwoord moet minimaal 1 kleine letter en 1 hoofdletter hebben")
                .setCondition(Bindings.createBooleanBinding(
                        () -> containsAny(password.getText(), "", upperChar) && containsAny(password.getText(), "", lowerChar),
                        password.textProperty()
                ))
                .get();

        Constraint specialCharactersConstraint = Constraint.Builder.build()
                .setSeverity(Severity.ERROR)
                .setMessage("Wachtwoord moet 1 speciale teken bevatten")
                .setCondition(Bindings.createBooleanBinding(
                        () -> containsAny(password.getText(), "", specialCharacters),
                        password.textProperty()
                ))
                .get();

        password.getValidator()
                .constraint(digitConstraint)
                .constraint(charactersConstraint)
                .constraint(specialCharactersConstraint)
                .constraint(lengthConstraint);

        password.getValidator().validProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                tryAgain.setVisible(false);
                password.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, false);
            }
        });

        password.delegateFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue && !newValue) {
                List<Constraint> constraints = password.validate();
                if (!constraints.isEmpty()) {
                    password.pseudoClassStateChanged(INVALID_PSEUDO_CLASS, true);
                    tryAgain.setText(constraints.get(0).getMessage());
                    tryAgain.setVisible(true);
                }
            }
        });
    }

    public static boolean containsAny(String str, String split, String... words) {
        List<String> inputStringList = Arrays.asList(str.split(split));
        List<String> wordsList = Arrays.asList(words);
        return wordsList.stream().anyMatch(inputStringList::contains);
    }

    public void onTerugButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/Login-view.fxml");
    }

    public void onRegistrerenButton(ActionEvent event) {
        ExistenceCheck existenceCheck = new ExistenceCheck();
        if (Bevestig.isSelected()) {
            try {
                int hs = Integer.parseInt(Huinummer.getText());
                double loon = Double.parseDouble(Loon.getText());

                if (!existenceCheck.checkIfExist(username.getText())) {

                    Gastouder newGastouder = new Gastouder(Bedrijfnaam.getText(), Straatnaam.getText(), Postcode.getText(), hs, loon, username.getText(), password.getText());
                    Database database = new Database();

                    ArrayList<Gastouder> gebruikers = database.reader();

                    gebruikers.add(newGastouder);
                    database.writer(gebruikers);

                    ResourceLoader.changeScene(event, "fxml/Login-view.fxml");
                }

            } catch (NumberFormatException | IOException e) {
                System.out.println("probleempje");
            }
        }
    }
}
