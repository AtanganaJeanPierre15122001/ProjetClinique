package com.example.projetclinique;

import Models.Medecin;
import Models.Patient;
import database.ExamenContract;
import database.MedecinContract;
import database.PatientContract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientControler {
    @FXML
    private Button Enregistrer_Patient;

    @FXML
    private TableColumn<Patient, String> Ident_Pat;


    @FXML
    private Button AcceuilButt;


    @FXML
    private TableView<Patient> ListePatient;

    @FXML
    private Button Supprimer_Pat;

    @FXML
    private TableColumn<Patient, String> ident_Exa;

    @FXML
    private TableColumn<Patient, String> nom;

    @FXML
    private TableColumn<Patient, String> prenom;

    public ObservableList<Patient> patients= FXCollections.observableArrayList();


    public ObservableList<String> list= FXCollections.observableArrayList();




    @FXML
    void Acceuil(ActionEvent event) throws IOException {
        FXMLLoader pageAccueil= new FXMLLoader(MedecinControler.class.getResource("Acceuil.fxml"));
        Scene accueil= new Scene(pageAccueil.load(), 1200, 800);
        Stage stage= (Stage) AcceuilButt.getScene().getWindow();
        stage.setScene(accueil);
        stage.setTitle("ACCUEIL");
        stage.setResizable(false);
        stage.show();

    }
    @FXML
    void Enreg_Pat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("UpdateOrDeletePatient.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Patient");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    @FXML
    void actualiser(ActionEvent event) {
        try {

            patients.removeAll(patients);
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery("SELECT * FROM "+ PatientContract.TABLE_NAME+"");
            while (result1.next()){
                String Id= result1.getString(PatientContract.ID_PATIENT_FIELD_NAME).trim();
                String nom= result1.getString(PatientContract.NOM_PATIENT_FIELD_NAME).trim();
                String prenom= result1.getString(PatientContract.PRENOM_PATIENT_FIELD_NAME).trim();
                String Id_Examen = result1.getString(PatientContract.ID_PATIENT_EXAM_CATEGORY_FIELD_NAME).trim();

                patients.add(new Patient(Id,Id_Examen,nom,prenom));
                /*medecins.add(new Medecin("1541","fdfdfdfdf","Kmkmkkmk","doc"));*/

            }

            /*ListeMedecin.getItems().addAll(medecins);*/

            System.out.println("lecture reussie");
        }catch (Exception e){
            e.printStackTrace();
        }
        Ident_Pat.setCellValueFactory(new PropertyValueFactory<>("Id_Patient"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom_Patient"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom_Patient"));
        ident_Exa.setCellValueFactory(new PropertyValueFactory<>("Id_Examen"));


        ListePatient.setEditable(true);
        ListePatient.setItems(patients);
    }

    @FXML
    void lancerEnreg(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("EnregistrePatient.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Patient");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

}
