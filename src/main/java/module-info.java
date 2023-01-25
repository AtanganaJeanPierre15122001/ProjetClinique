module com.example.projetclinique {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetclinique to javafx.fxml;
    exports com.example.projetclinique;
}