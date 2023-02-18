module com.example.projetclinique {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projetclinique to javafx.fxml;
    opens Models;
    exports com.example.projetclinique;
}