import javax.swing.JFrame;

/**
 * Class qui définit un objet de type AlgoDeter, c'est notre algorithme déterminatif 
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class AlgoDeter {
    public static final int MUR = 1;
    public static final int PARCOURU = 0;

    private int[][] Parcours;
    private boolean[][] map;
    private Cellules[][] grille;
    private int[] coordGate;

    private int cetteTaille;
    private int comptErreur=0;

    private These notreThese;

    private JFrame cetteFrame;

    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param uneTaille c'est la taille du labyrinthe
     * @param tableau c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     * @param uneGrille tableau double dimension qui stock les différentes Cellules.
     * @param uneFrame c'est la fenetre qui affiche le labyrinthe 
     */
    public AlgoDeter(int uneTaille, boolean[][] tableau, Cellules[][] uneGrille, JFrame uneFrame) {
        this.cetteTaille = uneTaille;
        this.map = tableau;
        this.grille = uneGrille;
        this.cetteFrame = uneFrame;
    }

    /**
     * lance le parcours automatique de notre Algorithme si l'utilisateur la demandé
     */
    public void auto() {
        this.coordGate = outils.ParcoursCell(this.grille, this.cetteTaille);
        Parcours ceParcour = new Parcours(this.grille, this.coordGate[0], this.coordGate[1], this.cetteTaille);
    }

    /**
     * lance le parcours en mode visualisation manuelle de notre Algorithme si l'utilisateur la demandé
     */
    public void manuel(){
        this.coordGate = outils.ParcoursCell(this.grille, this.cetteTaille);
        ParcoursManuel ceParcour = new ParcoursManuel(this.grille, this.coordGate[0], this.coordGate[1], this.cetteTaille);
    }
}
