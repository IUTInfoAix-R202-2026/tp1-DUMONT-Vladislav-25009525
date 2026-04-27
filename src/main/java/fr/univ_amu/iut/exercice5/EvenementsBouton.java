package fr.univ_amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Exercice 5 - Réagir à un clic.
 *
 * <p>Objectif : afficher un bouton "Clique-moi" et un label qui affiche le nombre de clics. Chaque
 * clic incrémente le compteur.
 *
 * <p>L'intérêt pédagogique est de voir qu'un même effet peut s'écrire avec trois styles différents
 * d'écouteur (voir les commentaires dans {@link #start(Stage)}).
 */
public class EvenementsBouton extends Application {

  @Override
  public void start(Stage primaryStage) {
    VBox vBox = new VBox();
    Compteur compteur = new Compteur();
    Label labelCompteur = new Label("0 clics");
    labelCompteur.setId("compteur");
    Button bouton = new Button("Clique-moi");
    bouton.setId("bouton-clique-moi");
    bouton.setOnAction(
        e -> {
          compteur.incrementer();
          labelCompteur.setText(compteur.getValeur() + " clics");
        });
    vBox.getChildren().addAll(bouton, labelCompteur);
    Scene scene = new Scene(vBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
