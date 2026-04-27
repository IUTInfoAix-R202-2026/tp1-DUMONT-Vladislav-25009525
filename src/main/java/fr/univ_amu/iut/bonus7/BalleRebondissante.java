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
    // TODO exercice 7 : animer une balle rebondissante.
    //
    // 1. Créer un VBox comme conteneur racine.
    //
    // 2. Créer un HBox avec 4 boutons :
    //    - "Démarrer" (id: btn-start)  → appelle transition.playFromStart()
    //    - "Pause"    (id: btn-pause)  → appelle transition.pause()
    //    - "Reprendre"(id: btn-resume) → appelle transition.play()
    //    - "Stop"     (id: btn-stop)   → appelle transition.stop()
    //
    // 3. Créer un Slider (id: slider-vitesse) avec min=0.1, max=5, valeur=1.
    //    Ajouter un listener sur sa propriété value pour ajuster
    //    transition.setRate(newValue).
    //
    // 4. Créer un Circle (id: balle) de rayon 15, couleur rouge.
    //    Le placer dans un Pane (id: zone-animation).
    //
    // 5. Créer un TranslateTransition :
    //    - durée 1000ms
    //    - noeud = le cercle
    //    - fromY = 10, toY = 400
    //    - autoReverse = true
    //    - cycleCount = INDEFINITE
    //
    // 6. Assembler : HBox + Slider + Pane dans le VBox.
    //    Créer une Scene, l'attacher au Stage, afficher.

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

    Slider slider = new Slider();
    slider
        .valueProperty()
        .addListener(
            (observable, ancienneValeur, nouvelleValeur) -> {
              transition.setRate(nouvelleValeur.doubleValue());
            });

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
