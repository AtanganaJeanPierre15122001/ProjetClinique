package com.example.projetclinique;


import Models.Examen;
import Models.Medecin;
import Models.Patient;
import database.ExamenContract;
import database.MedecinContract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ListeExamenControler implements Initializable {

    @FXML
    private TableColumn<Examen,String > Id_Exa;

    @FXML
    private TableView<Examen> ListeExa;

    @FXML
    private TableColumn<Examen, String> Nom_Ex;

    public ObservableList<Examen> examens= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Id_Exa.setCellValueFactory(new PropertyValueFactory<>("Id_Examen"));
        Nom_Ex.setCellValueFactory(new PropertyValueFactory<>("Nom_Exa"));

        ListeExa.setEditable(true);
        ListeExa.setItems(examens);

        try {

            examens.removeAll(examens);
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery("SELECT * FROM "+ ExamenContract.TABLE_NAME+"");
            while (result1.next()){
                String Id= result1.getString(ExamenContract.ID_EXAMEN_FIELD_NAME).trim();
                String nom= result1.getString(ExamenContract.NOM_EXAMEN_FIELD_NAME).trim();

                examens.add(new Examen(Id,nom));
                /*medecins.add(new Medecin("1541","fdfdfdfdf","Kmkmkkmk","doc"));*/

            }

            /*ListeMedecin.getItems().addAll(medecins);*/

            System.out.println("lecture reussie");
        }catch (Exception e){
            e.printStackTrace();
        }




    }




}
