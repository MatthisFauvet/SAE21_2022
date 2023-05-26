import javax.swing.*;
import java.awt.event.*;
/**
 * La class Creer se lance si et seuelemnt si l'utilisateur décide de creéer un nouveau labyrinthe (!importer)
 * Ensuite, on doit lancer les classes suivante afin de pouvoir creér ntore Labyrinthe
 * 
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class Creer implements ActionListener {
    private String cet_event, f_option = "Nouvelle Grille";
    private JFrame cette_frame;

    /**
     * Constructeur 
     * @param frame_initial On récupère la fenetre précédente pour pouvoir la fermer un peu plus tard
     */
    public Creer(JFrame frame_initial){
        super();
        this.cette_frame=frame_initial;
    }
    /**
     * Cette méthode d'active si et seulement si l'utilisateur a cliqué sur "nouvelle grille". Elle permet de créer un objet FenetreDefSize pourprendre en main
     * la suite du programme 
     * 
     * @param e on récupère la raison de l'evenement pour comparer les possibilitées
     */
    public void actionPerformed(ActionEvent e){
        this.cet_event=e.getActionCommand();
        this.cette_frame.dispose();
        if (cet_event.equals(f_option)){
            FenetreDefSize fen = new FenetreDefSize();
            fen.MiseEnPlace();
        }        
    } 
}