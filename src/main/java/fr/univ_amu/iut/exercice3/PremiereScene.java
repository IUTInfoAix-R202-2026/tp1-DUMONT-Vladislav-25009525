package fr.univ_amu.iut.exercice3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Exercice 3 - Première Scene avec un Label.
 *
 * <p>Objectif : au-delà de la fenêtre vide, afficher du contenu. On construit une Scene qui
 * contient un conteneur (BorderPane) dans lequel on place un Label avec un message.
 *
 * <p>Concepts : {@link javafx.scene.Scene}, {@link javafx.scene.layout.BorderPane}, {@link
 * javafx.scene.control.Label}.
 */
public class PremiereScene extends Application {

  @Override
  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();
    Label label = new Label("Bonjour, JavaFX !");
    borderPane.setCenter(label);
    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
