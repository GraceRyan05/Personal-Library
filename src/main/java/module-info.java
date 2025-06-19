module com.example.personal_library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.example.personal_library to javafx.fxml;
    exports com.example.personal_library;
}