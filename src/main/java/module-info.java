module com.example.opt3 {

    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    exports com.example.opt3;
    exports com.example.opt3.Controller;
    opens com.example.opt3 to javafx.fxml;
    opens com.example.opt3.Controller to javafx.fxml;
}