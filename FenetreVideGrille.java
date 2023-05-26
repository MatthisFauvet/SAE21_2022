import java.awt.*;
/**
 * Class qui met en place une grille totalement vide et c'est donc a l'utilisateur de créer son la à partir de rien 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class FenetreVideGrille extends Fenetre{

    private int taille;

    private int[] tabCouleur;
    private boolean[][] grille;
    private Cellules[][] grilleCellules;

    private Modifications modif;

    /**
     * Comme pour fenetreRndmGrille, on réupère la taille 
     * @param taille = taille du lab a créer
     */
    public FenetreVideGrille(int taille){
        super();
        this.taille = taille;
        this.grille = new boolean[this.taille][this.taille];
        this.grilleCellules = new Cellules[this.taille][this.taille];
        this.tabCouleur = new int[] {0, 0};
    }

    /**
     * Méthode qui permet de créer un tab vide et qui ajoute les modifications
     * Modification : Ecoute les event
     * Panneau modification : fenetre qui permet de créer / modifier le Lab a notre guise
     */
    
    public void videGrille(){
        
        this.fenetre.setSize(600, 600);
        this.fenetre.setLocation(300, 150);

        GridLayout gestionnaire = new GridLayout(this.taille,this.taille);
        this.fenetre.setLayout(gestionnaire);

        PanneauModification interfacePanel = new PanneauModification(this.grille, this.taille, this.grilleCellules, this.fenetre);
        interfacePanel.SetUp();
        
        /* ======= Valeurs aléatoire pour l'entre et la sortie ========== */

        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++){
                grille[i][j] = Cellules.LIBRE;

                this.modif = new Modifications(interfacePanel, grille,this.tabCouleur);

                Cellules cellules = new Cellules(i,j, Cellules.COULOIR);
                this.fenetre.add(cellules);
                cellules.addMouseListener(modif);
                grilleCellules[i][j] = cellules;

                this.tabCouleur = modif.getGateState();
            }
        }
        this.fenetre.setVisible(true);
    }
}
