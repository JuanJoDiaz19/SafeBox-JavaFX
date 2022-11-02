module com.example.seguimiento13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seguimiento13 to javafx.fxml;
    exports com.example.seguimiento13;
    exports com.example.seguimiento13.control;
    opens com.example.seguimiento13.control to javafx.fxml;
}