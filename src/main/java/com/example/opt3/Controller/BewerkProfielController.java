package com.example.opt3.Controller;

import com.example.opt3.Model.users.Babies;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class BewerkProfielController {
    @FXML
    private MFXListView<Babies> list;
    @FXML
    private MFXTextField naam;
    @FXML
    private MFXTextField leeftijd;
    @FXML
    private MFXTextField straat;
    @FXML
    private MFXTextField postcode;
    @FXML
    private MFXTextField huisnummer;
    @FXML
    private MFXTextField voeding;
    @FXML
    private MFXTextField gewicht;
    private ObservableList<Babies> people;


    public void onLoadlistButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();

        this.people = FXCollections.observableArrayList();
        this.people.addAll(gastouder.getPeople());

        StringConverter<Babies> converter = FunctionalStringConverter.to(Babies -> (Babies == null) ? "" : Babies.getNaam());

        list.setItems(people);
        list.setConverter(converter);


    }

    public void onConfirmButton(ActionEvent event) {
    }
}
