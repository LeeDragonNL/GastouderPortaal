package com.example.opt3.Controller;

import com.example.opt3.Model.Database;
import com.example.opt3.Model.users.Babies;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.DoubleFilter;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

public class DisplayAllController implements Initializable {

    @FXML
    private MFXTableView<Babies> table = new MFXTableView<>();
    @FXML
    private MFXTableColumn<Babies> nameColumn;
    @FXML
    private MFXTableColumn<Babies> ageColumn;
    @FXML
    private MFXTableColumn<Babies> voedingColumn;
    @FXML
    private MFXTableColumn<Babies> gewichtColumn;

    private ObservableList<Babies> people;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.autosizeColumnsOnInitialization();

        nameColumn = new MFXTableColumn<>("NAME",true, Comparator.comparing(Babies::getNaam));
        ageColumn = new MFXTableColumn<>("LEEFTIJD",true, Comparator.comparing(Babies::getLeeftijd));
        voedingColumn = new MFXTableColumn<>("VOEDING",true, Comparator.comparing(Babies::getVoeding));
        gewichtColumn = new MFXTableColumn<>("GEWICHT",true, Comparator.comparing(Babies::getGewicht));

        nameColumn.setRowCellFactory(gebruiker -> new MFXTableRowCell<>(Babies::getNaam));
        ageColumn.setRowCellFactory(gebruiker -> new MFXTableRowCell<>(Babies::getLeeftijd));
        voedingColumn.setRowCellFactory(gebruiker -> new MFXTableRowCell<>(Babies::getVoeding));
        gewichtColumn.setRowCellFactory(gebruiker -> new MFXTableRowCell<>(Babies::getGewicht));

        table.getTableColumns().addAll(nameColumn,ageColumn,voedingColumn,gewichtColumn);
        table.getFilters().addAll(

                new StringFilter<>("Naam", Babies::getNaam),
                new IntegerFilter<>("leeftijd", Babies::getLeeftijd),
                new StringFilter<>("voeding", Babies::getVoeding),
                new DoubleFilter<>("Gewicht", Babies::getGewicht)
        );
    }

    public void onDisplayButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();

        this.people = FXCollections.observableArrayList();
        this.people.addAll(gastouder.getPeople());

        table.setItems(people);
        table.update();


    }

    public void onVerwijderButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();
        Database database = new Database();

        this.people = FXCollections.observableArrayList();
        this.people.addAll(gastouder.getPeople());
        gastouder.getPeople().remove(table.getItems().removeAll(table.getSelectionModel().getSelectedValues()));

        ArrayList<Gastouder> gastouderArrayList = new ArrayList<>();
        gastouderArrayList.add(gastouder);
        database.writer(gastouderArrayList);

    }

    public void onBewerkButton(ActionEvent event) {

    }
}
