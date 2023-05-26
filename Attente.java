import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

/**
 * La class Attente inclu un KeyListener, cette classe a pour objectif d'attendre une entré sur la touche espace du clavier
 * pour regarder le parcours qu'emprunte l'algorithme 
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class Attente implements KeyListener {
    public static final boolean FINI = true;
    public static final boolean ENCOURS = false;

    private Random rand;
    private int number;
    private int compteur;

    private These notreThese;
    private Cellules[][] grilleCellules;
    private int[] coordGate; 
    
    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param unPerso On rentre un objet de type These qui est l'objet qui va parcourir notre labyrinthe
     * @param grille grille C'est la grille qui va être parcourue comme le labyrinthe
     * @param coord Ce sont les coordonnées des portes d'entrées et de sortie 
     */
    public Attente(These unPerso, Cellules[][] grille, int[] coord){
        this.notreThese = unPerso;
        this.grilleCellules = grille;
        this.compteur=0;
        this.rand = new Random();
        this.coordGate = coord;
    }

    /**
     * Méthode qui a chaque fois que la barre "espace" est cliqué on parcours notre tableau dans une directions aléatoire
     * @param e On rentre 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.grilleCellules[notreThese.getCoord()[0]][notreThese.getCoord()[1]].peindre(Cellules.VUE);

            this.number = this.rand.nextInt(4);
            if(this.number == 0){
                this.notreThese.goRight();
            } else if(this.number == 1){
                this.notreThese.goDown();
            } else if(this.number == 2){
                this.notreThese.goLeft();
            } else {
                this.notreThese.goTop();
            }
    
            this.grilleCellules[notreThese.getCoord()[0]][notreThese.getCoord()[1]].peindre(Cellules.DESSUS);
    
            this.compteur++;

            if(this.notreThese.isArrived(this.coordGate[2], this.coordGate[3]) == These.ARRIVE){
                JOptionPane.showMessageDialog(null, "Labyrinthe treminé en "+this.compteur+" coups !", "Information", JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Ne rien faire ici
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Ne rien faire ici
    }

    public void checked(){
        System.out.println("true");
    }
}
