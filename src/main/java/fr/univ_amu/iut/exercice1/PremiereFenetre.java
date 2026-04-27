package fr.univ_amu.iut.exercice1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Exercice 1 - Première fenêtre JavaFX.
 *
 * <p>Objectif : créer l'application JavaFX la plus simple possible - une fenêtre vide qui apparaît
 * à l'écran et se ferme quand on clique sur la croix.
 *
 * <p>Concepts : {@link Application}, {@link Stage}, cycle de lancement.
 */
public class PremiereFenetre extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
