/**
 * La class outils ne propose que des méthodes Static qui ont pour but de simplifier certaine action mais aussi d'éviter d'alourdir trop notre code
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class outils {
    public static final int COULOIR=0;
    public static final int MUR=1;
    public static final int ENTREE=2;
    public static final int SORTIE=3;

    protected outils(){
    }

    /**
     * Cette méthode a pour objectif de changer l'ordre des elt dans un tableau simple
     * @param un_tableau tableau de int 
     */
    public static int[] reverse(int[] un_tableau) {
        int taille = un_tableau.length;
        int[] cette_copie;
        cette_copie = new int[un_tableau.length];
        int compteur=taille;
        for(int j=0; j<cette_copie.length; j++){
            cette_copie[j]=un_tableau[compteur-1];
            compteur--;
        }
        return cette_copie;
    }

    /**
     * Cette méthode static a pour objectif de prendre deux tab de int et de n'en faire plus qu'un, de les concaténés
     * @param first_tab voici notre premier tab 
     * @param tab_to_add voici le code a ajouter 
     */
    public static int[] concatenate(int[] first_tab, int[] tab_to_add){
        int taille = first_tab.length;
        int[] tableau_temp = new int[taille+tab_to_add.length];
        int compteur = 0;
        if(first_tab != null){
            for(int i=0;i<taille;i++){
                tableau_temp[compteur]=first_tab[i];
                compteur++;
            }
        }
        if(tab_to_add != null){
            for(int i=0;i<tab_to_add.length;i++){
                tableau_temp[compteur]=tab_to_add[i];
                compteur++;
            }
        }
        return tableau_temp;
    }

    /**
     * Cette méthode permet de de print un tableau de boolea
     * @param leTableau Tableau de bollean 
     * @param saTaille sa taille
     */
    public static void PrintGrilleBool(boolean[][] leTableau, int saTaille){
        for(int i=0; i<saTaille; i++){
            for(int j=0; j<saTaille; j++){
                System.out.print(leTableau[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n ------------ \n FIN \n");
    }

    /**
     * Cette méthode permet de de print un tableau de Cellules
     * @param leTableau Tableau de Cellules 
     * @param saTaille sa taille
     */
    public static void PrintGrilleCell(Cellules[][] leTableau, int saTaille){
        for(int i=0; i<saTaille; i++){
            for(int j=0; j<saTaille; j++){
                System.out.print("Le type vaut :  "+leTableau[i][j].getType()+" | ");
            }
            System.out.print("\n");
        }
        System.out.print("\n ------------ \n FIN \n");
    }
    
    /**
     * Cette méthode permet de parcourir un tableau de cellules et renvoie les coord de la porte d'entrée et de la sortie 
     * @param leTableau Tableau de Cellules 
     * @param saTaille sa taille
     */
    public static int[] ParcoursCell(Cellules[][] leTableau, int saTaille){
        int[] ceTableau = new int[4];
        for(int i=0; i<saTaille; i++){
            for(int j=0; j<saTaille; j++){
                if(leTableau[i][j].getType() == ENTREE){
                    ceTableau[0] = leTableau[i][j].getLigne();
                    ceTableau[1] = leTableau[i][j].getColone();
                } else if(leTableau[i][j].getType() == SORTIE){
                    ceTableau[2] = leTableau[i][j].getLigne();
                    ceTableau[3] = leTableau[i][j].getColone();
                }
            }
        }
        return ceTableau;
    }

    /**
     * Cette méthode permet de transformer un tableau de int en un tableau de byte[]
     * @param leTableau Tableau de int 
     */
    public static byte[] ConvertToByte(int[] leTableau){
        byte[] taByte = new byte[leTableau.length];
        for(int i=0; i<leTableau.length; i++){
            taByte[i]=(byte) leTableau[i];
        }
        return taByte;
    }


    /**
     * Cette méthode permet de print les elts d'un tableau de int simple
     * @param leTableau Tableau de int
     * @param saTaille sa taille
     */
    public static void printInt(int[] leTableau, int saTaille) {
        for(int i=0; i<saTaille;i++){
            System.out.print("["+leTableau[i] +"] ");
        }
        System.out.print("\n");
    }


        
    /**
     * Cette méthode permet de parcourir un tableau de boolean et affiche chaque elt parcourue 
     * @param leTableau Tableau de boolean 
     * @param saTaille sa taille
     */
    public static void printBool(boolean[] leTableau, int saTaille) {
        for(int i=0; i<saTaille*saTaille;i++){
            System.out.print("["+leTableau[i] +"] ");
        }
        System.out.print("\n");
    }

    /**
     * Cette méthode permet de mettre la totalité des elt dans un tableau a double dimension dans un tableau simple
     * @param leTableau Grille de boolean 
     * @param saTaille sa taille
     */
    public static boolean[] PutToVertical(boolean[][] leTableau, int saTaille){
        boolean[] resultat = new boolean[saTaille*saTaille];
        int compteur=0;
        for(int i=0; i<saTaille; i++){
            for(int j=0; j<saTaille;j++){
                resultat[compteur] = leTableau[j][i];
                compteur++;
            }
        }
        return resultat;
    }

    /**
     * Cette méthode permet de parcourir un tableau de int et renvoie la moyenne des différentes valeur dans le tab
     * @param leTableau Tableau de Cellules 
     * @param saTaille sa taille
     */
    public static int moyenneTabint(int[] leTableau){
        int somme = 0;
        for(int valeur : leTableau){
            somme = somme + valeur;
        }
        return somme/leTableau.length;
    }
}
