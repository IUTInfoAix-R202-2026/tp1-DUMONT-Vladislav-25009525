package fr.univ_amu.iut.bonus7;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Exercice 7 (bonus) - Balle rebondissante.
 *
 * <p>Objectif : découvrir les animations JavaFX. Une balle rebondit verticalement dans un panneau.
 * Quatre boutons permettent de démarrer, mettre en pause, reprendre et arrêter l'animation. Un
 * slider contrôle la vitesse en temps réel.
 *
 * <p>Concepts : {@link TranslateTransition}, {@link Animation}, {@link Slider}, binding de
 * propriétés.
 */
public class BalleRebondissante extends Application {

  @Override
  public void start(Stage primaryStage) {

    VBox vBox = new VBox();
    HBox hBox = new HBox();

    Button buttonStart = new Button("Démarrer");
    buttonStart.setId("btn-start");
    Button buttonPause = new Button("Pause");
    buttonPause.setId("btn-pause");
    Button buttonResume = new Button("Reprendre");
    buttonResume.setId("btn-resume");
    Button buttonStop = new Button("Stop");
    buttonStop.setId("btn-stop");

    hBox.getChildren().addAll(buttonPause, buttonStart, buttonResume, buttonStop);

    Circle cercle = new Circle();
    cercle.setRadius(15);
    cercle.setFill(Color.RED);
    cercle.setId("balle");

    Pane pane = new Pane();
    pane.getChildren().addAll(cercle);
    pane.setId("zone-animation");

    TranslateTransition transition = new TranslateTransition(Duration.millis(1000), cercle);
    transition.setFromY(10); // position de départ
    transition.setToY(400); // position d'arrivée
    transition.setAutoReverse(true); // revient en arrière automatiquement
    transition.setCycleCount(Animation.INDEFINITE); // boucle infinie

    Slider slider = new Slider(0.1, 5, 1);
    slider
        .valueProperty()
        .addListener(
            (observable, ancienneValeur, nouvelleValeur) -> {
              transition.setRate(nouvelleValeur.doubleValue());
            });

    slider.setId("slider-vitesse");

    buttonStart.setOnAction(
        e -> {
          transition.playFromStart();
        });
    buttonPause.setOnAction(
        e -> {
          transition.pause();
        });
    buttonResume.setOnAction(
        e -> {
          transition.play();
        });
    buttonStop.setOnAction(
        e -> {
          transition.stop();
        });

    vBox.getChildren().addAll(hBox, slider, pane);
    Scene scene = new Scene(vBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
