import javax.swing.*;
import java.awt.event.*;
/**
 * Choix et taille est une méthode qui se repose sur un action Listener, son but est de récupérer la taille de la grille
 * que souhaite créer l'utilisateur, également, ChoixEtTaille récupère le type de grille
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class ChoixEtTaille extends JFrame implements ActionListener {
  private JFrame cette_frame;
  private JTextField ce_tfield;
  private ButtonGroup ce_group;

    /**
     * Méthode constructeur
     * @param une_frame prend en argument la fenetre précédente pour la fermer
     * @param un_tfield un_tfield représente un champ de text dans le quel on récuperera la taille saisie 
     * @param group on récupère un group de boutton pour en extraire les valeurs des différents boutons
     */
  public ChoixEtTaille(JFrame une_frame, JTextField un_tfield, ButtonGroup group){
    this.cette_frame = une_frame;
    this.ce_tfield = un_tfield;
    this.ce_group = group;
  }

    /**
     * Cette méthode va créer et éxécuter un objet FenetreRndmGrille ou FenetreVideGrille en fonction des choix de l'utilisateur et
     * si et seulement si l'utilisateur a appuyer sur un boutons 
     * @param e On rentre 
     */
  public void actionPerformed(ActionEvent e){
    this.cette_frame.dispose();

    String valleur_taille = this.ce_tfield.getText();

    if(this.ce_group.getSelection().getActionCommand()=="Grille randomisée"){
      FenetreRndmGrille cette_fenetre = new FenetreRndmGrille(Integer.parseInt(valleur_taille));
      cette_fenetre.randomGrille();
    }
    
    else if(this.ce_group.getSelection().getActionCommand()=="Grille vide"){
      FenetreVideGrille cette_fenetre = new FenetreVideGrille(Integer.parseInt(valleur_taille));
      cette_fenetre.videGrille();
    }
  } 
}