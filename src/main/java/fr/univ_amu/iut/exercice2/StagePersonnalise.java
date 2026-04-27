package fr.univ_amu.iut.exercice2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Exercice 2 - Stage personnalisé.
 *
 * <p>Objectif : personnaliser la fenêtre (titre, dimensions, redimensionnement, style de
 * décoration).
 *
 * <p>Concepts : propriétés de {@link Stage}, {@link javafx.stage.StageStyle}.
 */
public class StagePersonnalise extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Ma fenêtre personnalisée");
    primaryStage.setWidth(500);
    primaryStage.setHeight(300);
    primaryStage.setResizable(false);
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
