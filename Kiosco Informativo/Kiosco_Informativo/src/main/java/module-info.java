module org.kiosco {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens org.kiosco to javafx.fxml;
    exports org.kiosco;
    exports org.kiosco.controllers;
}