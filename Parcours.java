import javax.swing.JOptionPane;
/**
 * Cette class est une class de parcour de labyrinthe qui se base sur la récurence afin de trouve la sortie le plus vite possible 
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class Parcours {
    private int taille;
    private int ceCompteur = 0;
    private Cellules[][] labyrinthe;

    /**
     * Constructeur
     * @param tableau importation du tableau a parcourir 
     * @param X position Actuelle en X de l'algo
     * @param Y  position Actuelle en Y de l'algo
     * @param len taille max du labyrinthe 
     */
    public Parcours(Cellules[][] tableau, int X, int Y, int len){
        this.taille = len;
        this.labyrinthe = tableau;

        this.Parcourir(X, Y);
    }
    /**
     * Méthode récursive qui fonctionne ainsi :
     * A chaque fois que l'on va sur une case , on essaie d'aller en bas, sinon a droite, sinon en haut ou alors sinon a gauche 
     * si on ne oeut plus aller nulle part, alors on revient a la case précédente en essayant les chemins que l'on avait pas encore essayé
     * a chaque fois que l'on passe sur une case, on la rend non-accessible 
     * 
     * @param coordX position Actuelle en X de l'algo
     * @param coordY position Actuelle en Y de l'algo
     */
    public boolean Parcourir(int coordX, int coordY){

        boolean done = false;

        if(estValide(coordX, coordY)) {

            if (this.labyrinthe[coordX][coordY].getType() == Cellules.SORTIE){
                JOptionPane.showMessageDialog(null, "Nous avons trouvé un chemin en "+(this.ceCompteur)+" coups pour ce labyrinthe", "Information", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                this.labyrinthe[coordX][coordY].setType(Cellules.MUR);
                //Appels récursifs
                if(done != true){
                    done = Parcourir(coordX + 1, coordY);
                    done = Parcourir(coordX, coordY + 1);
                    done = Parcourir(coordX - 1, coordY);
                    done = Parcourir(coordX, coordY - 1);
                }
            }                 
        }
        return done;
    }

    /**
     * cette méthode permet de renvoyer true si la prochaine case est valable sinon false. 
     * @param pos_x On rentre 
     * @param pos_y c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     */
    private boolean estValide(int pos_x, int pos_y) {
        this.ceCompteur++;
        boolean result = false;
        //Si la case passée en paramètre est dans les dimensions du labyrinthe
        if (pos_x >= 0 && pos_x < this.taille && pos_y >= 0 && pos_y < this.taille){
            //Et si la case est un espace vide
            if (this.labyrinthe[pos_x][pos_y].getType() == Cellules.COULOIR || this.labyrinthe[pos_x][pos_y].getType() == Cellules.ENTREE || this.labyrinthe[pos_x][pos_y].getType() == Cellules.SORTIE){
                result = true;
            }
        }
        return result;

    } //Fin estValide()
}
