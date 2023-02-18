package com.example.projetclinique;

import Models.Medecin;
import database.MedecinContract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MedecinControler {

    @FXML
    private Button Editer_Medecin;

    @FXML
    private Button Enregistrer_Medecin;


    @FXML
    private Label Id_medecin;

    @FXML
    private TableView<Medecin> ListeMedecin;

    @FXML
   private TableColumn<Medecin, String> nom;

    @FXML
    private TableColumn<Medecin, String> prenom;

    @FXML
    private TableColumn<Medecin, String> ident;


    @FXML
    private TableColumn<Medecin, String> titre;


    public ObservableList<Medecin> medecins= FXCollections.observableArrayList();

    @FXML
    private Label Nom_Medecin;

    @FXML
    private Label Prenom_Medecin;

    @FXML
    private Button Supprimer_Medecin;

    @FXML
    private Label Titre_Medecin;

    @FXML
    private AnchorPane rootPane;


    public TableColumn<Medecin, String> getNom() {
        return this.nom;
    }

    public TableColumn<Medecin, String> getPrenom() {
        return this.prenom;
    }


    /*public void initialize(URL url, ResourceBundle resourceBundle) {
        nom.setCellValueFactory(new PropertyValueFactory<Medecin, String>("Nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Medecin, String >("Prenom"));
        ListeMedecin.setEditable(true);
        ListeMedecin.setItems(medecins);

    }*/

    @FXML
    void Edit_Med(ActionEvent event) {

    }
   @FXML
    void lancerEnreg(ActionEvent event) throws IOException{
        /*AnchorPane pane = FXMLLoader.load(getClass().getResource("EnregitreMedecin.fxml"));
        rootPane.getChildren().setAll(pane);*/
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("EnregitreMedecin.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Save Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    @FXML
    void Enreg_Med(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("UpdateMedecin.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();

    }

    @FXML
    void Sup_Med(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MedecinControler.class.getResource("UpdateMedecin.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();

    }

    @FXML
    void actualiser(ActionEvent event){

        try {

            medecins.removeAll(medecins);
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery("SELECT * FROM "+MedecinContract.TABLE_NAME+"");
            while (result1.next()){
                String Id= result1.getString(MedecinContract.ID_MEDECIN_FIELD_NAME).trim();
                String nom= result1.getString(MedecinContract.NOM_MEDECIN_FIELD_NAME).trim();
                String prenom= result1.getString(MedecinContract.PRENOM_MEDECIN_FIELD_NAME).trim();
                String titre= result1.getString(MedecinContract.TITRE_MEDECIN_FIELD_NAME).trim();

                medecins.add(new Medecin(Id,nom,prenom,titre));
                /*medecins.add(new Medecin("1541","fdfdfdfdf","Kmkmkkmk","doc"));*/

            }

            /*ListeMedecin.getItems().addAll(medecins);*/

            System.out.println("lecture reussie");
        }catch (Exception e){
            e.printStackTrace();
        }
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom_Medecin"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom_Medecin"));
        ident.setCellValueFactory(new PropertyValueFactory<>("Id_Medecin"));
        titre.setCellValueFactory(new PropertyValueFactory<>("Titre_Medecin"));

        ListeMedecin.setEditable(true);
        ListeMedecin.setItems(medecins);

    }



}
