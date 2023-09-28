package com.example.projetclinique;

import Models.Medecin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import repositories.Medecin.MedecinRepositoryImpl;

import java.sql.Connection;

public class EnregistreMedecinControler {

    @FXML
    private TextField Id_Med;

    @FXML
    private TextField Nom_Med;

    @FXML
    private TextField Pre_Med;

    @FXML
    private TextField Titre_Med;

    @FXML
    private Button Valider;

    @FXML
    private Button annuler;

    Connection connection = DatabaseConnection.getConnection();

    MedecinRepositoryImpl c =new MedecinRepositoryImpl(connection);
    @FXML
    void Annulation(ActionEvent event) {
        Id_Med.clear();
        Nom_Med.clear();
        Pre_Med.clear();
        Titre_Med.clear();

    }



    @FXML
    void Valider(ActionEvent event) {
        String Id_M=Id_Med.getText();
        String Nom_M=Nom_Med.getText();
        String Pre_M=Pre_Med.getText();
        String Titre_M=Titre_Med.getText();
        Medecin medecin= new Medecin(Id_M,Nom_M,Pre_M,Titre_M);
        int status = c.saveMedecin(medecin);
        Alert alert;
        if (status==1){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Enregistrement");
            alert.setHeaderText("Information");
            alert.setContentText("Medecin Bien ajoute");
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
