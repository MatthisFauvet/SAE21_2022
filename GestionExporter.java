import java.awt.event.*;
import javax.swing.*;
/**
 * Cette class inclus un ActionListener, elle a pour but de rediriger le programme si l'utilisateur veut ou non sauvegarder sa grille
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class GestionExporter implements ActionListener{

    private String Reponses1="Sauvegarder", Reponses2="Passer";
    private String cet_event;
    private boolean[][] cetteGrille;
    private Cellules[][] grilleCellules;
    private int cetteTaille;

    private JFrame frameGrille;
    private JFrame frameModif;
    private JFrame framePopup;

    /**
     * Constructeur 
     * @param uneGrille on récupère une grille de boolean  
     * @param uneGrilleCell on récupère une grille de cellules
     * @param uneTaille on récupère la taille de notre Lab
     * @param frameG première fenetre qui est celle de la grille
     * @param frameM Deuxième fenetre qui est celle de la Modifications
     * @param frameP troisième fenetre qui est la Pop-Up 
     */
    public GestionExporter(boolean[][] uneGrille, Cellules[][] uneGrilleCell , int uneTaille, JFrame frameG, JFrame frameM, JFrame frameP){
        this.cetteGrille=uneGrille;
        this.cetteTaille=uneTaille;
        this.grilleCellules=uneGrilleCell;

        this.frameGrille = frameG;
        this.frameModif = frameM;
        this.framePopup = frameP;
    }

    /**
     * Lorsque l'on appui sur le bouton Sauvegarer, alors le programme va lancer la procédure d'écriture puis va lancer le choix des algoritme, 
     * Si l'on clique sur le bouton "passer", alors on ne sauvegarder pas la grille et on passe a la résolutions 
     * @param e event qui permet de choisir la suite su programme
     */
    public void actionPerformed(ActionEvent e){
        this.cet_event=e.getActionCommand();
        if (cet_event.equals(this.Reponses1)){
            this.frameModif.dispose();
            this.framePopup.dispose();
            PreEcriture precriture = new PreEcriture(this.cetteGrille, this.grilleCellules, this.cetteTaille);
            ChoixAlgo suite = new ChoixAlgo(this.cetteTaille, this.frameGrille ,this.cetteGrille, this.grilleCellules);
            suite.setUp();
        }
        else if (cet_event.equals(this.Reponses2)){
            this.frameModif.dispose();
            this.framePopup.dispose();
            ChoixAlgo suite = new ChoixAlgo(this.cetteTaille, this.frameGrille, this.cetteGrille, this.grilleCellules);
            suite.setUp();
        }    
    }
}