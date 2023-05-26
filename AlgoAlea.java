import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class pour créer les différent parcours de l'algo Aleatoire
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class AlgoAlea {
    private boolean[][] map;
    private Cellules[][] grille;

    private int cetteTaille;
    private int comptErreur=0;
    private int[] coordGate;

    private These notreThese;

    private JFrame cetteFrame;

    /**
     * Class qui créer un objet Algo Aleatoire pour résoudre les labyrinthe 
     * @param uneTaille c'est la taille du labyrinthe
     * @param tableau c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     * @param uneGrille tableau double dimension qui stock les différentes Cellules.
     * @param uneFrame c'est la fenetre qui affiche le labyrinthe 
     */
    public AlgoAlea(int uneTaille, boolean[][] tableau, Cellules[][] uneGrille, JFrame uneFrame) {
        this.map = tableau;
        this.grille = uneGrille;
        this.cetteFrame = uneFrame;
        this.cetteTaille = uneTaille;
    }

    /* ==================================== AUtomatique ==================================== */

    /**
     * la méthode auto() permet de parcourir 100 fois le labyrinthe puis de print la moyenne de coup de résolutions
     * (en combien de coup a été résolue le lab)
     */
    public void auto() {
        //outils.PrintGrilleBool(this.map,this.cetteTaille);
        //outils.PrintGrilleCell(this.grille, this.cetteTaille);

        int decompte = 0;
        int[] tabRes = new int[100];

        Random ran = new Random();
        int nxt=0;

        while(decompte < 100){
            int compteur = 0;

            this.coordGate = outils.ParcoursCell(this.grille, this.cetteTaille);
            this.notreThese = new These(coordGate[0], coordGate[1], this.cetteTaille, this.map);

            while(this.notreThese.isArrived(coordGate[2], coordGate[3]) != These.ARRIVE){
                nxt = ran.nextInt(4);
                if(nxt == 0){
                    this.notreThese.goRight();
                } else if(nxt == 1){
                    this.notreThese.goDown();
                } else if(nxt == 2){
                    this.notreThese.goLeft();
                } else {
                    this.notreThese.goTop();
                }

                compteur+=1;
                estInfini(compteur);
            }
            tabRes[decompte] = compteur;
            decompte++;
        }
        JOptionPane.showMessageDialog(null, "Nous avons une moyenne de : "+outils.moyenneTabint(tabRes)+" pour ce labyrinthe", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /* ==================================== Manuelle ==================================== */

    /**
     * la class manuel propose une vision / utilisation manuel de notre algo tout en proposant de voir ses actions étape par étape
     */
    public void manuel() {
        this.coordGate = outils.ParcoursCell(this.grille, this.cetteTaille);
        this.notreThese = new These(coordGate[0], coordGate[1], this.cetteTaille, this.map);

        Attente attendre = new Attente(this.notreThese, this.grille, this.coordGate);
        this.cetteFrame.addKeyListener(attendre);
    }
    

    /* ==================================== INFINI ==================================== */

    /**
     * Dans un cas ou l'algo réalise un trop grand nombre de fois des actions, on peut conjecturer que le lab n'est juste pas finissable.
     * @param unCompteur c'est le nombre total de coup/déplacement tenté pour arrivé a la fin
     */
    public void estInfini(int unCompteur){
        if(unCompteur > 20000){
            this.comptErreur++;
        }
        if(this.comptErreur > 3){
            JOptionPane.showMessageDialog(null, "Le labyrinthe est trop probablement non-finissable", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
