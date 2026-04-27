package fr.univ_amu.iut.exercice6;

import fr.univ_amu.iut.exercice5.Compteur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {

  @Override
  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();
    HBox hBox = new HBox();

    Button buttonRouge = new Button("Rouge");
    buttonRouge.setId("btn-rouge");

    Button buttonVert = new Button("Vert");
    buttonVert.setId("btn-vert");

    Button buttonBleu = new Button("Bleu");
    buttonBleu.setId("btn-bleu");

    hBox.getChildren().addAll(buttonRouge, buttonVert, buttonBleu);
    borderPane.setTop(hBox);

    Pane pane = new Pane();
    pane.setId("zone");
    pane.setMinWidth(300);
    pane.setMinHeight(200);
    pane.setStyle("-fx-background-color: red;");
    borderPane.setCenter(pane);

    Label labelCompteur = new Label("Rouge: 0  Vert: 0  Bleu: 0");
    labelCompteur.setId("compteurs");

    borderPane.setBottom(labelCompteur);

    Compteur compteur_rouge = new Compteur();
    Compteur compteur_vert = new Compteur();
    Compteur compteur_bleu = new Compteur();

    buttonRouge.setOnAction(
        e -> {
          compteur_rouge.incrementer();
          labelCompteur.setText(
              "Rouge: "
                  + compteur_rouge.getValeur()
                  + " Vert: "
                  + compteur_vert.getValeur()
                  + " Bleu: "
                  + compteur_bleu.getValeur());
          pane.setStyle("-fx-background-color: red;");
        });
    buttonVert.setOnAction(
        e -> {
          compteur_vert.incrementer();
          labelCompteur.setText(
              "Rouge: "
                  + compteur_rouge.getValeur()
                  + " Vert: "
                  + compteur_vert.getValeur()
                  + " Bleu: "
                  + compteur_bleu.getValeur());
          pane.setStyle("-fx-background-color: green;");
        });
    buttonBleu.setOnAction(
        e -> {
          compteur_bleu.incrementer();
          labelCompteur.setText(
              "Rouge: "
                  + compteur_rouge.getValeur()
                  + " Vert: "
                  + compteur_vert.getValeur()
                  + " Bleu: "
                  + compteur_bleu.getValeur());
          pane.setStyle("-fx-background-color: blue;");
        });

    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
