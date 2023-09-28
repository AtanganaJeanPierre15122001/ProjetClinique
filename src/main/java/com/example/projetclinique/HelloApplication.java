package com.example.projetclinique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Acceuil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);

       /* scene.getStylesheets().add(getClass().getResource("Boostrap3.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("Darktheme.css").toExternalForm());*/
        stage.setTitle("Liste Medecin");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}