import java.awt.event.*;
import javax.swing.*;
/**
 * Cette classe est utilisé pendant la modification de grille. En effet, grace a ses ActionListener, cette class a pour objectif de soit passer 
 * a l'écriture ou bien aux algorithmes. ou encore, si l'utilisateur appuie sur quitter, alors le programme entier prend fin.
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class GestionModif implements ActionListener{
    private String Reponses1="Quitter", Reponses2="Suivant";
    private String cet_event;
    private boolean[][] cetteGrille;
    private Cellules[][] grilleCellules;
    private int cetteTaille;

    private JFrame cetteFrameGrille;
    private JFrame cetteFrameModif;

    /**
     * Constructeur
     * On récupère toutes les donnés que l'on a traité ou modifié pour les utiliser plus tard 
     * @param uneGrille importation d'une grille de boolean
     * @param uneGrilleCell importation d'une grille de cellules
     * @param uneTaille on récupère la taille du Lab 
     * @param frameGrille On récupère la fenetre ou apparaissait le Labyrinthe graphiquement
     * @param frameModif Fenetre ou l'on choisissait les différentes options de dessin ou de suite.
     */
    public GestionModif(boolean[][] uneGrille, Cellules[][] uneGrilleCell, int uneTaille, JFrame frameGrille, JFrame frameModif){
        this.cetteGrille=uneGrille;
        this.cetteTaille=uneTaille;
        this.grilleCellules=uneGrilleCell;

        this.cetteFrameGrille = frameGrille;
        this.cetteFrameModif = frameModif;
    }
    /**
     * Cette méthode redirige les actions du programme
     * @param e
     */
    public void actionPerformed(ActionEvent e){
        this.cet_event=e.getActionCommand();
        if (cet_event.equals(this.Reponses1)){
            System.exit(1);
        }
        else if (cet_event.equals(this.Reponses2)){
            Exporter newExport = new Exporter(this.cetteGrille, this.grilleCellules, this.cetteTaille, this.cetteFrameGrille, this.cetteFrameModif);
            //outils.PrintGrilleBool(this.cetteGrille, this.cetteTaille);
        }    
    }
}