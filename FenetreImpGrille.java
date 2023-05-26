import java.awt.*;
/**
 * La class FenetreImpGrille a pour but de créer une grille ainsi qu'un tableau de boolean (pour les parcours) a la suite de la lecture d'un fichier 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class FenetreImpGrille extends Fenetre {
    private boolean[][] grille;
    private Cellules[][] grilleCell;
    
    /**
     * Constructeur qui fait apelle a la class supérieur : Fenetre
     */
    public FenetreImpGrille(){   
        super();
    }
    
    /**
     * Méthode qui dans un premier temp remplie un tab de bool, puis affiche la grille grace aux cellules et enfin qui propose de choisir un algo de parcours de Labyrinthe
     * @param taille récupère la taille de notre grille 
     * @param Lentre récupère la ligne de notre entré
     * @param Centre récupère la Colone de notre entré
     * @param Lortie récupère la ligne de notre sortie
     * @param Cortie récupère la Colone de notre sortie
     * @param tabGrille tableau qui contient tous les états de toutes les cases
     */
    public void ImporterGrille(int taille, int Lentre, int Centre, int Lortie, int Cortie, int[] tabGrille){
        /* ================================================================ Déclaration des variables ============================================================================= */
        int[][] ce_double_tab = new int[taille][taille];
        this.grille = new boolean[taille][taille];
        this.grilleCell = new Cellules[taille][taille];
        //System.out.println("LA TAILLE DE LA GRRILLE VAUT : "+tabGrille.length);

         /* =============================================================== Gestion des paramètres de la fenètre ========================================================================== */
        /*Création de la fenètre  */
        this.fenetre.setSize(600, 600);
        this.fenetre.setLocation(300, 150);
        /*Mise en place du grid layout */
        GridLayout gestionnaire = new GridLayout(taille,taille);
        this.fenetre.setLayout(gestionnaire);
        /* ================================================================================================================================================================ */
            
        /* remplissage du tab 1 */
        int compteur=0;
        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++){
                ce_double_tab[j][i] = tabGrille[compteur];
                compteur++;
            }
        }
        /* ======================================================================================================================================= */
        // Gestion du remplissage des case
        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++){

                if(ce_double_tab[i][j] == 0){
                    this.grille[i][j] = false;
                } else {
                    this.grille[i][j] = true;
                }

                if((i*taille+j)==(Lentre*taille+Centre)){
                    Cellules cellules = new Cellules(i, j, Cellules.ENTREE);
                    this.grilleCell[i][j] = cellules;
                    this.fenetre.add(cellules);
                } else if((i*taille+j)==(Lortie*taille+Cortie)){
                    Cellules cellules = new Cellules(i, j, Cellules.SORTIE);
                    this.grilleCell[i][j] = cellules;
                    this.fenetre.add(cellules);
                } else if(ce_double_tab[i][j] == 1){
                    Cellules cellules = new Cellules(i, j, Cellules.MUR);
                    this.grilleCell[i][j] = cellules;
                    this.fenetre.add(cellules);
                } else{
                    Cellules cellules = new Cellules(i, j, Cellules.COULOIR);
                    this.grilleCell[i][j] = cellules;
                    this.fenetre.add(cellules);
                }
            }
        }
        this.fenetre.setVisible(true);
        ChoixAlgo Suite = new ChoixAlgo(taille, this.fenetre, this.grille, this.grilleCell);
        Suite.setUp();
    }
}
