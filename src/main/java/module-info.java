module com.example.mycryptowallet2_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mycryptowallet2_0 to javafx.fxml;
    exports com.example.mycryptowallet2_0;
}