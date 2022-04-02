import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MorpionTest {
  @Test
  public void test01_jouer_OK() throws Exception {
    Morpion morpion = new Morpion("joueur1", "joueur2");
    Personnage [] joueurs = morpion.getJoueurs();
    Personnage joueur1 = joueurs[0];

    morpion.jouer(0, 0, joueur1);
    assertEquals('X', morpion.getCase(0, 0));
  }

  @Test
  public void test02_jouer_coordonneIncorrect() {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage [] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];
    try {
      m.jouer(3, 3, joueur1);
    } catch (CoupImpossibleException e) {
      assertEquals("Les coordonnées sont incorrectes", e.getMessage());
    }
  }

  @Test
  public void test03_jouer_casePleine() {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage [] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];
    try {
      m.jouer(0, 0, joueur1);
    } catch (CoupImpossibleException e) {
      assertEquals("Il y a déjà un symbole à cet endroit", e.getMessage());
    }
  }

  @Test
  public void test04_etreFinie_gagnant_horizontal() throws Exception {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage [] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];

    // Joueur 1
    m.jouer(0, 0, joueur1);
    m.jouer(0, 1, joueur1);
    m.jouer(0, 2, joueur1);


    Resultat resultat = m.etreFini();
    assertTrue(resultat.getFini());
    assertEquals(resultat.getPersoGagnant(), joueur1);
  }

  @Test
  public void test05_etreFinie_gagnant_vertical() throws Exception {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage[] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];

    // Joueur 1
    m.jouer(0, 0, joueur1);
    m.jouer(1, 0, joueur1);
    m.jouer(2, 0, joueur1);

    Resultat resultat = m.etreFini();
    assertTrue(resultat.getFini());
    assertEquals(resultat.getPersoGagnant(), joueur1);
  }

  @Test
  public void test06_etreFinie_gagnant_diagonal() throws Exception {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage[] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];

    // Joueur 1
    m.jouer(0, 0, joueur1);
    m.jouer(1, 1, joueur1);
    m.jouer(2, 2, joueur1);

    Resultat resultat = m.etreFini();
    assertTrue(resultat.getFini());
    assertEquals(resultat.getPersoGagnant(), joueur1);
  }



  @Test
  public void test07_EtreFini_egalite() throws Exception {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage [] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];
    Personnage joueur2 = joueurs[1];
    // Joueur 1

    m.jouer(0, 1, joueur1);
    m.jouer(0, 2, joueur1);
    m.jouer(1, 0, joueur1);
    m.jouer(1, 1, joueur1);
    m.jouer(2, 2, joueur1);

    // Joueur 2
    m.jouer(0, 0, joueur2);
    m.jouer(1, 2, joueur2);
    m.jouer(2, 0, joueur2);
    m.jouer(2, 1, joueur2);

    Resultat resultat = m.etreFini();
    assertTrue(resultat.getFini());
    assertNull(resultat.getPersoGagnant());
  }

  @Test
  public void test08_EtreFini_pasFini() {
    Morpion m = new Morpion("joueur1", "joueur2");
    Resultat resultat = m.etreFini();
    assertFalse(resultat.getFini());
    assertNull(resultat.getPersoGagnant());
  }

  @Test
  public void test09_gagnant_OK() throws Exception {
    Morpion m = new Morpion("joueur1", "joueur2");
    Personnage [] joueurs = m.getJoueurs();
    Personnage joueur1 = joueurs[0];
    Personnage joueur2 = joueurs[1];
    m.jouer(0,0,joueur1);
    m.jouer(1,1, joueur2);
    assertEquals(joueur1, m.gagnant(0,0));
    assertEquals(joueur2, m.gagnant(1,1));
  }


}
