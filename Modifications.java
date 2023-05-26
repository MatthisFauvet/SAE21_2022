import java.awt.event.*;
/**
 * La class relai n'est réellement qu'une transition en fonctions des cliques effectué sur la grille et le traitement de ces cliques 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Modifications implements MouseListener {
    private PanneauModification unPanel;
    private boolean[][] cetteGrille;
    private int[] ceTab;
    private ModificationsTab change;

    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param panneauModification On récupère ce tableau pour avoir les valeurs des JButtons
     * @param grilleTab On récupère la grille de boolean afin de la traiter dans la prochaine class
     * @param unTab on récupère un tableau qui contient les valeurs Entree et sortie (si les cases sont posé ou non)
     */
    public Modifications(PanneauModification panneauModification, boolean[][] grilleTab, int[] unTab){
        this.unPanel = panneauModification;
        this.cetteGrille = grilleTab;
        this.ceTab = unTab;
    }
    /**
     * Lorque qu'une cellule est clique, alors on lance la modification du tableau de boolean
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        this.change = new ModificationsTab(this.unPanel, this.cetteGrille, this.ceTab, e);
    }


    /**
     * Cette méthode permet de renvoyer le tableau des entré et sortie afin de le mettre continuellement a jour.
     */
    public int[] getGateState(){
        return this.ceTab;
    }
    
    // Les méthodes suivantes ne sont pas utilisées dans cet exemple, donc nous les laissons vides
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}

}
    
