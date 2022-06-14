module com.example.opt3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;


    exports com.example.opt3;
    exports com.example.opt3.Controller;
    opens com.example.opt3 to javafx.fxml;
    opens com.example.opt3.Controller to javafx.fxml;
}