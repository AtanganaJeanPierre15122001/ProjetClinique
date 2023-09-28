package com.example.projetclinique;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button Edit_Mal;

    @FXML
    private Button Edit_Pat;

    @FXML
    private Button Editmed;

    @FXML
    private Button Voir_Exa;

    @FXML
    void Edit_Maladie(ActionEvent event) throws IOException {
        FXMLLoader pageAccueil= new FXMLLoader(MedecinControler.class.getResource("ListeMaladie.fxml"));
        Scene accueil= new Scene(pageAccueil.load(), 1280, 800);
        Stage stage= (Stage) Edit_Mal.getScene().getWindow();
        stage.setScene(accueil);
        stage.setTitle("Editer Maladie");
        stage.setResizable(false);
        stage.show();


    }

    @FXML
    void Edit_Patient(ActionEvent event) throws IOException {
        FXMLLoader pageAccueil= new FXMLLoader(MedecinControler.class.getResource("ListePatient.fxml"));
        Scene accueil= new Scene(pageAccueil.load(), 1280, 800);
        Stage stage= (Stage) Edit_Pat.getScene().getWindow();
        stage.setScene(accueil);
        stage.setTitle("Editer Patient");
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Edit_medecin(ActionEvent event) throws IOException {
        FXMLLoader pageAccueil= new FXMLLoader(MedecinControler.class.getResource("ListeMedecin.fxml"));
        Scene accueil= new Scene(pageAccueil.load(), 1280, 800);
        Stage stage= (Stage) Editmed.getScene().getWindow();
        stage.setScene(accueil);
        stage.setTitle("Editer un Medecin");
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Voir_Examen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("ListeExamen.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Examen disponible");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();

    }
}