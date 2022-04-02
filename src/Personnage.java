public class Personnage {
    private final String nom;
    private final char symbole;

    public Personnage(String nom, char symbole) {
        this.nom = nom;
        this.symbole = symbole;
    }

  @Override
  public String toString() {
    return "Personnage{" +
            "nom='" + nom + '\'' +
            '}';
  }

  public char getSymbole() {
    return this.symbole;
  }
}
