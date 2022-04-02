import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Jouer au morpion
        Scanner sc = new Scanner(System.in);

        // Initialisation du jeu
        System.out.print("Bienvenue dans le jeu du morpion !\n");
        System.out.print("Veuillez entrer le nom du joueur 1 : ");
        String nomJoueur1 = sc.nextLine();
        System.out.print("Veuillez entrer le nom du joueur 2 : ");
        String nomJoueur2 = sc.nextLine();
        System.out.print("\n");


        System.out.printf("%s, vous avez le symbole X.\n", nomJoueur1);
        System.out.printf("%s, vous avez le symbole O.\n", nomJoueur2);
        System.out.print("\n");


        // Initialisation du plateau
        Morpion morpion = new Morpion(nomJoueur1, nomJoueur2);
        Personnage[] joueurs = morpion.getJoueurs();
        Personnage joueur1 = joueurs[0];
        Personnage joueur2 = joueurs[1];

        // Initialisation du jeu
        morpion.afficher();
        Resultat resultat = morpion.etreFini();
        while (!resultat.getFini()){

            // Choix du joueur 1
            System.out.printf("%s, choisissez une case  x : ", nomJoueur1);
            int xJoueur1 = sc.nextInt();
            System.out.printf("%s, choisissez une case  y : ", nomJoueur1);
            int yJoueur1 = sc.nextInt();

            boolean aJouer = false;
            resultat = PersonnageJoue(morpion, joueur1, aJouer, xJoueur1, yJoueur1);
            if (resultat.getFini()) break;


            // Choix du joueur 2
            System.out.printf("%s, choisissez une case  x : ", nomJoueur2);
            int xJoueur2 = sc.nextInt();
            System.out.printf("%s, choisissez une case  y : ", nomJoueur2);
            int yJoueur2 = sc.nextInt();

            aJouer = false;
            resultat = PersonnageJoue(morpion, joueur2, aJouer, xJoueur2, yJoueur2);
            if (resultat.getFini()) break;
        }

        if (resultat.getPersoGagnant() == null){
            System.out.print("Match nul !\n");
        }else if(resultat.getPersoGagnant() == joueur1){
            System.out.printf("%s a gagné !\n", nomJoueur1);
        }else if (resultat.getPersoGagnant() == joueur2){
            System.out.printf("%s a gagné !\n", nomJoueur2);
        }


    }

    private static Resultat PersonnageJoue(Morpion morpion, Personnage joueur2, boolean aJouer, int xJoueur2, int yJoueur2) {
        Resultat resultat;
        while (!aJouer){
            try{
                morpion.jouer(xJoueur2,yJoueur2, joueur2);
                aJouer = true;
            }catch (CoupImpossibleException e){
                System.out.print(e.getMessage());
                System.out.print("\n");
                Scanner sc = new Scanner(System.in);
                System.out.println("Donner une autre case x : ");
                xJoueur2 = sc.nextInt();
                System.out.println("Donner une autre case y : ");
                yJoueur2 = sc.nextInt();
            }
        }
        morpion.afficher();
        resultat = morpion.etreFini();
        return resultat;
    }
}
