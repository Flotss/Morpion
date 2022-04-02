public class Morpion {
  private char[][] morpion;

  private Personnage joueur1;
  private Personnage joueur2;


  public Morpion(String joueur1, String joueur2) {
    this.morpion = new char[3][3];
    this.joueur1 = new Personnage(joueur1, 'X');
    this.joueur2 = new Personnage(joueur2, 'O');

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.morpion[i][j] = ' ';
      }
    }
  }


  public void jouer(int x, int y, Personnage joueur) throws CoupImpossibleException {
    if (x < 0 || x > 2 || y < 0 || y > 2) {
      throw new CoupImpossibleException("Les coordonnées sont incorrectes");
    }

    if (this.morpion[x][y] == ' ') {
      this.morpion[x][y] = joueur.getSymbole();
    }else {
      throw new CoupImpossibleException("Il y a déjà un symbole à cet endroit");
    }
  }


  public void afficher() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j < 3) {
          System.out.print(this.morpion[i][j] + " | ");
        } else {
          System.out.print(this.morpion[i][j]);
        }
      }
      System.out.println("\n-----------");
    }
  }

  public Resultat etreFini() {
    Resultat res = new Resultat(false, null);

    // Ligne horizontale
    for (int i = 0; i < 3; i++) {
      if (this.morpion[i][0] == this.morpion[i][1] && this.morpion[i][1] == this.morpion[i][2] && this.morpion[i][0] != ' ') {
        res = new Resultat(true, this.gagnant(i, 0));
      }
    }

    // Ligne verticale
    for (int i = 0; i < 3; i++) {
      if (this.morpion[0][i] == this.morpion[1][i] && this.morpion[1][i] == this.morpion[2][i] && this.morpion[0][i] != ' ') {
        res = new Resultat(true, this.gagnant(0, i));
      }
    }


    // Diagonale
    if (this.morpion[0][0] == this.morpion[1][1] && this.morpion[0][0] == this.morpion[2][2] && this.morpion[0][0] != ' ') {
      res = new Resultat(true, this.gagnant(0, 0));
    }
    if (this.morpion[0][2] == this.morpion[1][1] && this.morpion[0][2] == this.morpion[2][0] && this.morpion[0][2] != ' ') {
      res = new Resultat(true, this.gagnant(0, 2));
    }

    // Egalité
    if (!res.getFini()) {
      boolean fini = true;
      int i = 0;
      while (i < 3 && fini) {
        int j = 0;
        while (j < 3 && fini) {
          if (this.morpion[i][j] == ' ') {
            fini = false;
          }
          j++;
        }
        i++;
      }
      if (fini) {
        res = new Resultat(true, null);
      }
    }


    return res;
  }

  public Personnage gagnant(int x, int y) {
    Personnage gagnant = null;
    if (this.morpion[x][y] == 'X') {
      gagnant = this.joueur1;
    }else if (this.morpion[x][y] == 'O') {
      gagnant = this.joueur2;
    }
    return gagnant;
  }

  public Personnage[] getJoueurs() {
    return new Personnage[] {this.joueur1, this.joueur2};
  }

  public char getCase(int i, int y) {
    return this.morpion[i][y];
  }
}
