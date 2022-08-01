module com.example.mycryptowallet2_0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;



    opens com.example.mycryptowallet2_0 to javafx.fxml;
    exports com.example.mycryptowallet2_0;
    exports com.example.mycryptowallet2_0.FML_CONTROLLERS;
    opens com.example.mycryptowallet2_0.FML_CONTROLLERS to javafx.fxml;
}