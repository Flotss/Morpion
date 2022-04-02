public class Resultat {
  private final boolean fini;
  private final Personnage PersoGagnant;

  public Resultat(boolean fini, Personnage PersoGagnant) {
    this.fini = fini;
    this.PersoGagnant = PersoGagnant;
  }

  public boolean getFini() {
    return this.fini;
  }

  public Personnage getPersoGagnant() {
    return this.PersoGagnant;
  }
}
