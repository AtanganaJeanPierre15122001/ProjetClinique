package com.example.projetclinique;

import Models.Medecin;
import Models.Patient;
import database.ExamenContract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import repositories.Patient.PatientRepositoryImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EnregistrePatientControler implements Initializable {

    @FXML
    private ComboBox<String> Id_Exa;

    @FXML
    private TextField Id_Pat;

    @FXML
    private TextField Nom_Pat;

    @FXML
    private TextField Pre_Pat;

    @FXML
    private Button VoirExamen;


    @FXML
    private Button Valider;

    @FXML
    private Button annuler;

    public ObservableList<String> comboId= FXCollections.observableArrayList();

    Connection connection = DatabaseConnection.getConnection();

    PatientRepositoryImpl c = new PatientRepositoryImpl(connection);






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + ExamenContract.ID_EXAMEN_FIELD_NAME +" FROM "+ExamenContract.TABLE_NAME+" ");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                String ID = resultSet.getString(ExamenContract.ID_EXAMEN_FIELD_NAME);
                comboId.add(ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Id_Exa.setItems(comboId);

    }

    @FXML
    void Annulation(ActionEvent event) {
        Id_Pat.clear();
        Nom_Pat.clear();
        Pre_Pat.clear();
        Id_Exa.cancelEdit();

    }


    @FXML
    void Voir(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("ListeExamen.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Liste des examens");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();

    }


    @FXML
    void Valider(ActionEvent event) {
        String Id_P=Id_Pat.getText();
        String Nom_P=Nom_Pat.getText();
        String Pre_P=Pre_Pat.getText();
        String Id_E=Id_Exa.getValue();
        Patient patient = new Patient(Id_P,Id_E,Nom_P,Pre_P);
        int status = c.savePatient(patient);
        Alert alert;
        if (status==1){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Enregistrement");
            alert.setHeaderText("Information");
            alert.setContentText("Patient Bien ajoute");
            alert.showAndWait();
        }else if (status==-1){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Enregistrement");
            alert.setHeaderText("Information");
            alert.setContentText("Remplissez tout les champs!");
            alert.showAndWait();
        } else if (status==2) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Enregistrement");
            alert.setHeaderText("Information");
            alert.setContentText("identifiant deja present veuillez le changer!");
            alert.showAndWait();
        }

    }

}
