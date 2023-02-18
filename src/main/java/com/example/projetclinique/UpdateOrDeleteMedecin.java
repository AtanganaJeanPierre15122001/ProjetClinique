package com.example.projetclinique;
import Models.Medecin;
import database.MedecinContract;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import repositories.Medecin.MedecinRepositoryImpl;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class UpdateOrDeleteMedecin implements Initializable {

    public void initialize(URL location, ResourceBundle resources){

    }
    @FXML
    private TextField Id_Med;

    @FXML
    private TextField Nom_Med;

    @FXML
    private TextField Pre_Med;

    @FXML
    private TextField Titre_Med;

    @FXML
    private Button supprimer;

    @FXML
    private Button get_Medecin;


    @FXML
    private Button update;
    Connection connection = DatabaseConnection.getConnection();
    MedecinRepositoryImpl c = new MedecinRepositoryImpl(connection);
    @FXML
    void supprimer(ActionEvent event) {
        String Id_M=Id_Med.getText();

        int status = c.deleteMedecin(Id_M);
        if (status>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Information");
            alert.setContentText("Medecin Supprimé");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete");
            alert.setHeaderText("Information");
            alert.setContentText("Medecin non supprimé");
            alert.showAndWait();
        }

    }

    @FXML
    void update(ActionEvent event) {
        String Id_M=Id_Med.getText();
        String Nom_M=Nom_Med.getText();
        String Pre_M=Pre_Med.getText();
        String Titre_M=Titre_Med.getText();
        Medecin medecin= new Medecin(Id_M,Nom_M,Pre_M,Titre_M);
        int status = c.updateMedecin(medecin);
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
    @FXML
    void getMedecin(ActionEvent event) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sid = Id_Med.getText();
        Medecin medecin = c.getMedecinId(sid);
        Nom_Med.setText(medecin.getNom_Medecin());
        Pre_Med.setText(medecin.getPrenom_Medecin());
        Titre_Med.setText(medecin.getTitre_Medecin());


    }



}
