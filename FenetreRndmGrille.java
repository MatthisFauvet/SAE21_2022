import java.awt.*;
import java.util.Random;
/**
 * La class FenetreRndmGrille a pour but de créer une grille aléatoirement ainsi qu'un tableau de boolean (pour les parcours) (généré aléatoirement également)
 * A la suite de cela, on invite l'utilisateur a modifier la Lab s'il ne le satisfait pas 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class FenetreRndmGrille extends Fenetre{
    public static final int RANDOM=1;

    private int taille;
    private int ValeurEntre;
    private int ValeurSortie;

    private int[] tabCouleur;
    private boolean[][] grille;
    private Cellules[][] grilleCellules;

    private Modifications modif;
    /**
     * Constructeur qui prend en paramètre la taille donné par l'utilisateur afin de créer un lab de toute piece en se basant sur le random et sa taille
     * @param taille int qui représente le nomre max de ligne et colone du tableau
     */
    public FenetreRndmGrille(int taille){
        super();
        this.taille = taille;
        this.grille = new boolean[this.taille][this.taille];
        this.grilleCellules = new Cellules[this.taille][this.taille];
        this.tabCouleur = new int[] {1, 1};
    }
    /**
     * randomGrille est la méthode qui permet de lancer la création et la modifications du lab 
     * Modification : Ecoute les event
     * Panneau modification : fenetre qui permet de créer / modifier le Lab a notre guise
     */
    public void randomGrille(){
        
        this.fenetre.setSize(600, 600);
        this.fenetre.setLocation(300, 150);

        GridLayout gestionnaire = new GridLayout(this.taille,this.taille);
        this.fenetre.setLayout(gestionnaire);

        PanneauModification interfacePanel = new PanneauModification(this.grille, this.taille, this.grilleCellules, this.fenetre);
        interfacePanel.SetUp();
        
        /* ======= Valeurs aléatoire pour l'entre et la sortie ========== */

        Random rand = new Random();
        ValeurEntre = rand.nextInt(this.taille*this.taille);
        ValeurSortie = rand.nextInt(this.taille*this.taille);
        
        if(ValeurEntre == ValeurSortie){
            while(ValeurEntre == ValeurSortie){
                ValeurSortie = rand.nextInt(this.taille*this.taille);
            }
        }

        int compteur=0;

        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++){
                int nombreAleatoire = rand.nextInt(2); // génère un nombre entre 0 et 2

                if(nombreAleatoire == 0){
                    grille[i][j] = Cellules.LIBRE; //false
                } else {
                    grille[i][j] = Cellules.OCCUPE; //true
                }

                this.modif = new Modifications(interfacePanel, grille,this.tabCouleur);

                if(compteur == ValeurEntre)
                {
                    Cellules cellules = new Cellules(i,j, Cellules.ENTREE);
                    this.fenetre.add(cellules);
                    cellules.addMouseListener(modif);
                    grilleCellules[i][j] = cellules;
                    grille[i][j] = Cellules.LIBRE;
                }
                else if(compteur == ValeurSortie)
                {
                    Cellules cellules = new Cellules(i, j, Cellules.SORTIE);
                    this.fenetre.add(cellules);
                    cellules.addMouseListener(modif);
                    grilleCellules[i][j] = cellules;
                    grille[i][j] = Cellules.LIBRE;
                }
                else if(grille[i][j] == Cellules.LIBRE)
                {
                    Cellules cellules = new Cellules(i, j, Cellules.COULOIR);
                    this.fenetre.add(cellules);
                    cellules.addMouseListener(modif);
                    grilleCellules[i][j] = cellules;
                }
                else
                {
                    Cellules cellules = new Cellules(i, j, Cellules.MUR);
                    this.fenetre.add(cellules);
                    cellules.addMouseListener(modif);
                    grilleCellules[i][j] = cellules;
                }

                this.tabCouleur = modif.getGateState();
                compteur++;
            }
        }
        this.fenetre.setVisible(true);
    }
}
