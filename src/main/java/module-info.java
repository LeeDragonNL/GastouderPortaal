module com.example.opt3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires MaterialFX;

    opens com.example.opt3 to javafx.fxml;
    exports com.example.opt3;
    exports com.example.opt3.Controller;
    opens com.example.opt3.Controller to javafx.fxml;
}