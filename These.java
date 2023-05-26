/**
 * These est une class qui est utilisé par l'algo aléatoire pour parcourir un tableau
 * il faut créer un objet Thesee et lui donner une grille dans laquelle il pourra progrésser
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class These {
    public static final boolean LIBRE = false;
    public static final boolean OCCUPE = true;

    public static final boolean ARRIVE = true;
    public static final boolean CHEMIN = false;

    private int coordX;
    private int coordY;
    private int cetteTaille;

    private boolean[][] cetteGrille;

    /**
     * Constructeur
     * @param x position initiale
     * @param y position initiale
     * @param taille taille du tableau que thesee doit parcourir 
     * @param grille tableau que these devra parcourir
     */
    public These(int x, int y, int taille, boolean[][] grille){
        this.coordX = x;
        this.coordY = y;
        this.cetteGrille = grille;
        this.cetteTaille = taille;
    }


    /**
     * Cette méthode essaie de faire bouger thesee a droite, si c'est possible, thesee bouge et renvoie true, sinon false 
     */
    public boolean goRight(){
        if(coordY+1 < this.cetteTaille){
            //System.out.println("etat case droite :"+this.cetteGrille[coordX][coordY+1]+" pose :"+(coordX+1)+" "+coordY);
            if(this.cetteGrille[coordX][coordY+1] == LIBRE){
                this.coordY = this.coordY+1;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Cette méthode essaie de faire bouger thesee en bas, si c'est possible, thesee bouge et renvoie true, sinon false 
     */
    public boolean goDown(){
        if(coordX+1 < this.cetteTaille){
            if(this.cetteGrille[coordX+1][coordY] == LIBRE){
                this.coordX = this.coordX+1;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Cette méthode essaie de faire bouger thesee a gauche, si c'est possible, thesee bouge et renvoie true, sinon false 
     */
    public boolean goLeft(){
        if(coordY-1 >= 0){
            //System.out.println("etat case gauche :"+this.cetteGrille[coordX-1][coordY]+" pose :"+(coordX-1)+" "+coordY);
            if(this.cetteGrille[coordX][coordY-1] == LIBRE){
                this.coordY = this.coordY-1;
                return true;
            }
        }
        return false;
    }

    /**
     * Cette méthode essaie de faire bouger thesee en haut , si c'est possible, thesee bouge et renvoie true, sinon false 
     */
    public boolean goTop(){
        if(coordX-1 >= 0){
            //System.out.println("etat case top : "+this.cetteGrille[coordX][coordY-1] +" pose : "+coordX+" "+(coordY-1));
            if(this.cetteGrille[coordX-1][coordY] == LIBRE){
                this.coordX = this.coordX-1;
                return true;
            }
        }
        return false;
    }

    /* ======================== regarder ======================== */


    /**
     * Cette méthode renvoie true si les thesee venait a être en dehors du tab
     */
    public boolean debordementVerticaux(){
        //renvoie true s'il y a débordement sinon false
        if(coordY < 0 && coordY > this.cetteTaille){
            return true;
        }
        return LIBRE;
    }

    /**
     * Cette méthode fait regarder son bas a Thesee, thesee renvoie l'etat de la case regardé 
     */
    public boolean lookBot(){
        if(coordY+1 < this.cetteTaille){
            if(this.cetteGrille[coordX+1][coordY] == OCCUPE){
                return OCCUPE;
            }
        }
        return LIBRE;
    }

     /**
     * Cette méthode fait regarder sa gauche a Thesee, thesee renvoie l'etat de la case regardé 
     */
    public boolean lookLeft(){
        if(coordY+1 < this.cetteTaille){
            if(this.cetteGrille[coordX][coordY-1] == OCCUPE){
                return OCCUPE;
            }
        }
        return LIBRE;
    }
    
     /**
     * Cette méthode fait regarder a Thesee la case au dessus de lui, thesee renvoie l'etat de la case regardé 
     */
    public boolean lookTop(){
        if(coordY+1 < this.cetteTaille){
            if(this.cetteGrille[coordX-1][coordY] == OCCUPE){
                return OCCUPE;
            }
        }
        return LIBRE;
    }

    // Gestion Fin
    /**
     * Méthode qui regarde si thésée est arrivé a la case de fin
     * @param finalX Coordonné X de la fin
     * @param finalY Coordonné X de la fin
     */
    public boolean isArrived(int finalX, int finalY){
        // renvoie un boolean
        if(this.coordX == finalX && this.coordY == finalY){
            return ARRIVE;
        } else {
            return CHEMIN;
        }
    }

    // Miscelaneous 

    /**
     * cette méthode print la position actuelle de These
     */
    public void printPlacement(){
        System.out.println("La position en X vaut : "+coordX+" et en y : "+coordY);
    }

    /**
     * cette méthode renvoie la position actuelle de These dans un tab de int[]
     */
    public int[] getCoord(){
        int[] coordonnes = new int[2];
        coordonnes[0] = coordX; coordonnes[1]=coordY;
        return coordonnes;
    }
}
