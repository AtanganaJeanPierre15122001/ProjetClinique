package com.example.projetclinique;

import Models.Medecin;
import Models.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import repositories.Patient.PatientRepositoryImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class UpdateOrDeletePatient {

    Connection connection = DatabaseConnection.getConnection();
    PatientRepositoryImpl c = new PatientRepositoryImpl(connection);
    @FXML
    private TextField Id_Pat;

    @FXML
    private TextField Id_Exa;

    @FXML
    private TextField Nom_Pat;

    @FXML
    private TextField Pre_Pat;

    @FXML
    private Button VoirExamen;

    @FXML
    private Button get_Patient;

    @FXML
    private Button supprimer;

    @FXML
    private Button update;

    @FXML
    void getPatient(ActionEvent event) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sid = Id_Pat.getText();
        Patient patient = c.getPatientId(sid);
        Nom_Pat.setText(patient.getNom_Patient());
        Pre_Pat.setText(patient.getPrenom_Patient());
        Id_Exa.setText(patient.getId_Examen());

    }

    @FXML
    void Voir(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("ListeExamen.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Save Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();

    }

    @FXML
    void supprimer(ActionEvent event) {
        String Id_P=Id_Pat.getText();

        int status = c.deletePatient(Id_P);
        if (status>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Information");
            alert.setContentText("Patient Supprimé");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete");
            alert.setHeaderText("Information");
            alert.setContentText("Patient non supprimé");
            alert.showAndWait();
        }

    }

    @FXML
    void update(ActionEvent event) {
        String Id_P=Id_Pat.getText();
        String Nom_P=Nom_Pat.getText();
        String Pre_P=Pre_Pat.getText();
        String Id_E=Id_Exa.getText();
        Patient patient = new Patient(Id_P,Id_E,Nom_P,Pre_P);
        int status = c.updatePatient(patient);

        if (status>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update");
            alert.setHeaderText("Information");
            alert.setContentText("Medecin Bien mis a jour");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update");
            alert.setHeaderText("Information");
            alert.setContentText("Medecin non ajouté");
            alert.showAndWait();
        }

    }
}
