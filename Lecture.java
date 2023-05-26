import java.io.InputStream;
import java.io.*;
import java.io.IOException;
/**
 * La class Attente inclu un KeyListener, cette classe a pour objectif d'attendre une entré sur la touche espace du clavier
 * pour regarder le parcours qu'emprunte l'algorithme 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Lecture {
    private String ce_chemin;
    private int data;

    /* ===========================================================================================================================================================================
     * 
     *                                                                          CONSTRUCTEUR
     * 
     * ===========================================================================================================================================================================
     */

    public Lecture(String un_chemin)
    {
        this.ce_chemin = un_chemin;
    }

    /* ===========================================================================================================================================================================
     * 
     *                                                                          GET_HEADER
     * 
     * ===========================================================================================================================================================================
     */



    public int GetHeader(int n){  
        try {
            /* Ouverture du flux */
            InputStream fis = new FileInputStream(this.ce_chemin);

            for(int i=-1; i<n; i++){
                this.data = fis.read();
            }
            try{
                fis.close();
            }
            catch(IOException e){
                System.out.println("Erreur de fermeture");
                return 0;
            }
    
            return this.data;
            
        } catch (IOException e) {
            System.err.println("Erreur relevé");
            return 0;
        }
    }

    /* ===========================================================================================================================================================================
     * 
     *                                                                          GET_OFFSET
     * 
     * ===========================================================================================================================================================================
     */

    public int[] GetOffset(){
        //Renvoie le paylodad. Dans notre cas tous les états de nos cases.
        // Renvoie le payload dans un tableau ou chaque elt du tableau en est un du payload. 

        try{
            /* Ouverture d'un flux */
            InputStream fis = new FileInputStream(this.ce_chemin);
            
            int cetteTaille=fis.available();/*cette_taille prend une aproximation de la taille du flux */

            int ceCompteur = 0, temp;
            int [] ceTableau = new int[cetteTaille-4]; /*-5 pour le header mais +1 pour le -1 de fin de fichier. */
            int [] ceTableauTemp = new int[8]; /*C'est le tab qui va stocker les différents octets */
            int[] ceResultat = new int[0];; /*Tableau qui va être renvoyé et qui va contenir tous les bits dans le non ordre */

            /*On skip les 5 premiers octets */
            for(int i=0;i<5;i++){
                this.data = fis.read();
            }

            /* ============================= Création tu tableau avec les différents octets en int ========================================== */

            while(data != -1){
                this.data = fis.read();
                
                ceTableau[ceCompteur]=this.data;
                ceCompteur=ceCompteur+1;
            }
            
            /* ========================================================================================== */
            
            // Utilisation du tableau différent pour créer un tableau avec tout les 
            // octets mais dans le bon sens grace a ma superbe classe Outils ;)

            //System.out.println("la taille du tableau vaut : "+ceTableau.length);
            for(int m=0; m<ceTableau.length; m++){
                temp = ceTableau[m];
                for(int n=0; n<8; n++){ //repetition 8 fois pour traiter les 8 bits
                    ceTableauTemp[n] = temp&1;
                    //System.out.print(ceTableauTemp[n]+" ");
                    temp = temp >> 1;
                }
                //outils.printInt(outils.reverse(ce_tableau_temp), 8);
    
                ceResultat = outils.concatenate(ceResultat, outils.reverse(ceTableauTemp));     
            }

            /*for(int i=0; i<ceResultat.length; i++){
                System.out.print("le resultats vaut : "+ceResultat[i] +"\n");
            }*/

            /* =================================== Fermeture fichier ==================================== */

            try{
                fis.close();
            } catch(IOException e){
                System.out.println("erreur lors de la fermeture");
                return null;
            }
            return ceResultat; 
        }
        catch(IOException e){
            System.out.println("erreur d'ouverture");
            return null;
        }
    }
}
