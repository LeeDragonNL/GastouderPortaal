package com.example.opt3.Controller;

import com.example.opt3.Model.Invoer;
import com.example.opt3.Model.users.Babies;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.DoubleFilter;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class OmzetController implements Initializable {
    @FXML
    private MFXTableColumn<Invoer> uurColumn;
    @FXML
    private MFXTableColumn<Invoer> kindColumn;
    @FXML
    private MFXTableColumn<Invoer> datumColumn;
    @FXML
    private MFXTableView<Invoer> table;
    @FXML
    private Label uren;
    @FXML
    private Label verdient;
    @FXML
    private Label dagen;
    @FXML
    private MFXButton display;
    @FXML
    private MFXListView geschiedenis;
    private ObservableList<Invoer> invoers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.autosizeColumnsOnInitialization();

        uurColumn = new MFXTableColumn<>("UUR",true, Comparator.comparing(Invoer::getUur));
        kindColumn = new MFXTableColumn<>("KINDEREN",true, Comparator.comparing(Invoer::getAantalKinderen));
        datumColumn = new MFXTableColumn<>("DATUM",true, Comparator.comparing(Invoer::getDatum));

        uurColumn.setRowCellFactory(gastouder -> new MFXTableRowCell<>(Invoer::getUur));
        kindColumn.setRowCellFactory(gastouder -> new MFXTableRowCell<>(Invoer::getAantalKinderen));
        datumColumn.setRowCellFactory(gastouder -> new MFXTableRowCell<>(Invoer::getDatum));

        table.getTableColumns().addAll(uurColumn,kindColumn,datumColumn);
        table.getFilters().addAll(
                new IntegerFilter<>("aantal uren", Invoer::getAantalKinderen),
                new IntegerFilter<>("aantal kinderen", Invoer::getAantalKinderen),
                new IntegerFilter<>("datum", Invoer::getAantalKinderen)
        );
    }
    @FXML
    public void onDisplayButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();

        uren.setText(String.valueOf(gastouder.getOmzet().getTotaleUren()));
        verdient.setText(String.valueOf(gastouder.getOmzet().getTotaleOmzet()));
        dagen.setText(String.valueOf(gastouder.getInvoers().size()));

        this.invoers = FXCollections.observableArrayList();
        this.invoers.addAll(gastouder.getInvoers());

        table.setItems(invoers);
        table.update();

    }
    @FXML
    public void onClearButton(ActionEvent event) {
        table.getItems().clear();
    }


}
