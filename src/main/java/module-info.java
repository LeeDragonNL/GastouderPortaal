module com.example.opt3 {

    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    opens com.example.opt3 to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.opt3;
    opens com.example.opt3.Controller to javafx.fxml;
    exports com.example.opt3.Controller;
    opens com.example.opt3.Model to javafx.fxml;
    exports com.example.opt3.Model;
    exports com.example.opt3.Model.users;
    opens com.example.opt3.Model.users to javafx.fxml;

}