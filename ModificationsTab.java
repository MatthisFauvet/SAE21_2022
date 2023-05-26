import java.awt.event.MouseEvent;
/**
 * Le principe de cette classe est de, sous certaines conditions, modifier le tableau de boolean afin d'ensuite modifier l'affichage graphique
 * pour regarder le parcours qu'emprunte l'algorithme 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class ModificationsTab {

    private boolean[][] cetteGrille;
    private MouseEvent cetEvent;
    private int[] tabEtat;

    private int cetteLigne;
    private int cetteColone;
    private Affichage rafraichir;
    private PanneauModification cePanel;

    // -------------------------------------------------------------------------------------------------------------------------------------------------
    
    /**
     * Dans cette classe, on récupère la valeur de notre tableau en fontion de la ligne et de la colone de la cellule cliqué, ensuite, on modifie notre tableau de boolean
     * en metant a true si false et inversement dans le but de changer les mur en couloir etc.
     * @param panneauModification permet de transferrer cette interface afin de récupérer l'etat des radio boutons 
     * @param grilleTab c'est la grille de true et false
     * @param unTab tableau simple qui contient les valeurs des entrés et des sorties
     * @param unEvent permet de récupérer la grille cliqué
     */
    public ModificationsTab(PanneauModification panneauModification, boolean[][] grilleTab, int[] unTab, MouseEvent unEvent){
        this.cetteGrille = grilleTab;
        this.cetEvent = unEvent;

        this.cePanel = panneauModification;
        
        Cellules notreCellule = (Cellules) cetEvent.getSource();
        this.cetteLigne = notreCellule.getLigne();
        this.cetteColone = notreCellule.getColone();

        this.tabEtat = unTab;
        
        /* ========================================= */

        boolean radio1Selected = this.cePanel.GetButtonBW().isSelected(); 
        boolean radio2Selected = this.cePanel.GetButtonE().isSelected(); // ENTREE 
        boolean radio3Selected = this.cePanel.GetButtonS().isSelected(); //SORTIE
        
        /* ========================================= */
        
        //System.out.println("Etat de la case avant cliqué : "+this.cetteGrille[this.cetteLigne][this.cetteColone]);
        if(this.cetteGrille[this.cetteLigne][this.cetteColone] == Cellules.OCCUPE){
            this.cetteGrille[this.cetteLigne][this.cetteColone] = Cellules.LIBRE;
        } else {
            if(notreCellule.getType()==Cellules.ENTREE || notreCellule.getType()==Cellules.SORTIE){
                this.cetteGrille[this.cetteLigne][this.cetteColone] = Cellules.LIBRE;
            } else if (radio1Selected==true) {
                this.cetteGrille[this.cetteLigne][this.cetteColone] = Cellules.OCCUPE;
            }
        }

        this.rafraichir = new Affichage(notreCellule, panneauModification, unTab, this.cetteGrille[this.cetteLigne][this.cetteColone]);
    }
}
