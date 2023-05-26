import javax.swing.*;
/**
 * La class fenetre est une classe qui a simplement pour but de créer une Fenetre, puis attendre que des class hérite d'elle afin d'utiliser sa JFrame
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Fenetre{
    protected JFrame fenetre;

    /**
     * Contructeur
     */
    public Fenetre() {
        this.fenetre = new JFrame("Creation du programme");
        this.fenetre.setSize(400, 500);
        this.fenetre.setLocationRelativeTo(null); // centre la fenêtre sur l'écran

        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Cette méthode a pour but de fermer la fenetre quand on le demande 
     */
    public void closeFrame() {
        this.fenetre.dispose();
    }  
}