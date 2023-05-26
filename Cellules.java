import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
/**
 * La class Cellules permet de créer un objet Cellules qui est un JComponent, seulement, on lui donnne de attributs en plus, comme des couleurs
 * ou des coordonnées afin de bien la placer pour faire un Labyrinthe
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Cellules extends JComponent{
    public static final int COULOIR=0;
    public static final int MUR=1;
    public static final int ENTREE=2;
    public static final int SORTIE=3;

    public static final int DESSUS=10;
    public static final int VUE=11;

    public static final boolean LIBRE = false;
    public static final boolean OCCUPE = true;

    private Color backgroundColor;

    private int cetteLigne;
    private int cetteColone;
    private int ceType;

    /**
     * Contructeur
     * @param uneLigne On donne une la ligne dans la quelle la Cellules apparait
     * @param uneColone On donne une la colone dans la quelle la Cellules apparait
     * @param type On donne un type (entrée, sortie, couloir, mur) a cette cellules pour pourvoir modifier la grille
     */
    public Cellules(int uneLigne, int uneColone, int type){
        super();
        this.cetteLigne=uneLigne;
        this.cetteColone=uneColone;

        this.ceType = type;

        peindre(ceType);
    }

    /**
     * Méthode qui premte d'accéder a la ligne
     */
    public int getLigne(){
        return this.cetteLigne;
    }

    /**
     * Méthode qui premte de renvoyer la colone de la cellule
     */
    public int getColone(){
        return this.cetteColone;
    }

    /**
     * Méthode qui premte de renvoyer le type de la cellule
     */
    public int getType(){
        return this.ceType;
    }

    /**
     * Méthode qui permet de changer le type d'une cellules Mur -> Couloir
     * @param newType (int) Nouveau type de la cellules
     */
    public void setType(int newType){
        if(newType==COULOIR){
            this.ceType = COULOIR;
        } else if(newType==MUR){
            this.ceType = MUR;
        } else if(newType==ENTREE){
            this.ceType = ENTREE;
        } else if(newType==SORTIE){
            this.ceType = SORTIE;
        }
    }

    /**
     * Méthode qui permet d'attribuer une nouvelle couleur a la Cellule en fonction de son type
     * @param peinture (int) On rentre la nouvelle peinture
     */
    public void peindre(int peinture){
        if(peinture==COULOIR){
            backgroundColor = Color.WHITE;
        } else if(peinture==MUR){
            backgroundColor = Color.BLACK;
        } else if(peinture==ENTREE){
            backgroundColor = Color.BLUE;
        } else if(peinture==SORTIE){
            backgroundColor = Color.RED;
        } else if(peinture==VUE){
            backgroundColor = Color.YELLOW;
        } else if(peinture==DESSUS){
            backgroundColor = Color.ORANGE;
        }

        repaint();
    }

    /**
     * Méthode qui est appelé automatiquement lors d'un apelle de la classe Cellule
     * Cette méthode à pour but de repeindre notre Cellule 
     * @param g objet graphique 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}