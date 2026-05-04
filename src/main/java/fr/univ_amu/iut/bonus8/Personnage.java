package fr.univ_amu.iut.bonus8;

import javafx.scene.Group;

/**
 * Classe de base pour les personnages du jeu.
 *
 * <p>Un personnage est un {@link Group} de formes géométriques qui peut se déplacer dans les 4
 * directions sur un plateau de jeu. Chaque déplacement avance de {@link #LARGEUR_PERSONNAGE} pixels
 * (une case de la grille 20×20).
 */
public class Personnage extends Group {

  protected static final double LARGEUR_MOITIE_PERSONNAGE = 10;
  protected static final double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
  protected String direction;

  public void directionGauche() {
    if (getLayoutX() >= LARGEUR_PERSONNAGE) {
      setLayoutX(getLayoutX() - LARGEUR_PERSONNAGE);
    }
    if (!direction.equals("gauche")) {
      direction = "gauche";
    }
  }

  public void directionDroite(double largeurJeu) {
    if (getLayoutX() < largeurJeu - LARGEUR_PERSONNAGE) {
      setLayoutX(getLayoutX() + LARGEUR_PERSONNAGE);
    }
    if (!direction.equals("droite")) {
      direction = "droite";
    }
  }

  public void directionBas(double hauteurJeu) {
    if (getLayoutY() < hauteurJeu - LARGEUR_PERSONNAGE) {
      setLayoutY(getLayoutY() + LARGEUR_PERSONNAGE);
    }
    if (!direction.equals("bas")) {
      direction = "bas";
    }
  }

  public void directionHaut() {
    if (getLayoutY() >= LARGEUR_PERSONNAGE) {
      setLayoutY(getLayoutY() - LARGEUR_PERSONNAGE);
    }
    if (!direction.equals("haut")) {
      direction = "haut";
    }
  }

  /**
   * Détecte une collision entre ce personnage et un autre.
   *
   * @param autre l'autre personnage
   * @return true si les deux personnages se chevauchent
   */
  public boolean collision(Personnage autre) {
    return getBoundsInParent().contains(autre.getBoundsInParent())
        || autre.getBoundsInParent().contains(getBoundsInParent());
  }
}
