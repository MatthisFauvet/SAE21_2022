import java.awt.*;
import javax.swing.*;
/**
 * La class Exporter est un héritage de Fenetre, cette classe ouvre simplement une interface graphique invitant l'utilisateur a sauvegarder ou non sa grille
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Exporter extends Fenetre{
    private boolean[][] cetteGrille;
    private Cellules[][] grilleCellules;
    private int cetteTaille;

    private JFrame fenetreGrille;
    private JFrame fenetreModif;

    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param uneGrille On prend tous les prochain attributs, il ne sont récupérés que pour pouvoir être transmit
     * @param uneGrilleCell 
     * @param uneTaille 
     * @param fenetreG 
     * @param fenetreM
     */
    public Exporter(boolean[][] uneGrille, Cellules[][] uneGrilleCell, int uneTaille, JFrame fenetreG, JFrame fenetreM){
        this.cetteGrille = uneGrille;
        this.grilleCellules = uneGrilleCell;
        this.cetteTaille = uneTaille;

        this.fenetreGrille = fenetreG;
        this.fenetreModif = fenetreM;

        this.fenetre.setSize(500,100);
        this.fenetre.setTitle("Voulez vous enregistrer votre grille ?");

        JPanel cePanel = new JPanel();
        FlowLayout gestionnaire2 = new FlowLayout(FlowLayout.CENTER);
        cePanel.setLayout(gestionnaire2);
        cePanel.setBackground(Color.CYAN);

        JButton unButton0 = new JButton("Sauvegarder");
        JButton unButton1 = new JButton("Passer");

        cePanel.add(unButton0);
        cePanel.add(unButton1);

        GestionExporter cesOptions = new GestionExporter(this.cetteGrille, this.grilleCellules, this.cetteTaille, this.fenetreGrille, this.fenetreModif, this.fenetre);
        unButton0.addActionListener(cesOptions);
        unButton1.addActionListener(cesOptions);

        this.fenetre.add(cePanel);
        this.fenetre.setVisible(true);
    }
}