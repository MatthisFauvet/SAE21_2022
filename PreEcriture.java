import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Cette class a pour objectif de préparer tout ce qui va être écrit dans notre fichier
 * 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class PreEcriture {
    private int cetteTaille;
    private String path;
    private int octetRemaining;

    private boolean[][] cetteGrille;
    private Cellules[][] grilleCellules;

    private int[] resultat;
    private String[] tabTemp;
    private byte[] resultatByte;

    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param uneGrille Grille de bollean pour les murs  
     * @param uneGrilleCell grille de Cellules qui contient les Cellules (pour entré et sortie seuelemtn)
     * @param uneTaille tailles des grilles 
     */
    public PreEcriture(boolean[][] uneGrille, Cellules[][] uneGrilleCell , int uneTaille){
        this.cetteTaille = uneTaille;
        this.cetteGrille = uneGrille;
        this.grilleCellules = uneGrilleCell;

        /* ======================================== Confection du header ============================================== */

        this.resultat = new int[5];
        this.resultatByte = new byte[5];
        int[] tabEntrortie = new int[4];

        tabEntrortie=outils.ParcoursCell(this.grilleCellules, this.cetteTaille);

        this.resultat[0]=this.cetteTaille;
        this.resultat[1]=tabEntrortie[0];
        this.resultat[2]=tabEntrortie[1];
        this.resultat[3]=tabEntrortie[2];
        this.resultat[4]=tabEntrortie[3];
        this.resultatByte = outils.ConvertToByte(this.resultat);

        /* ====================================== Confection de l'Offset ============================================ */

        if((this.cetteTaille*this.cetteTaille)%8 == 0){ //définit les tailles s'il y a besoin d'un octet en plus ou pas
            this.tabTemp = new String[(this.cetteTaille*this.cetteTaille)/8];
            this.octetRemaining = this.cetteTaille*this.cetteTaille;
        } else if((this.cetteTaille*this.cetteTaille)%8 > 0){
            this.tabTemp = new String[(this.cetteTaille*this.cetteTaille)/8+1];
            this.octetRemaining = (this.cetteTaille*this.cetteTaille)+(this.cetteTaille*this.cetteTaille)%8;
        }
        
        String tempString = "";
        boolean[] tabHorizontal = new boolean[this.cetteTaille*this.cetteTaille];
        tabHorizontal = outils.PutToVertical(this.cetteGrille, this.cetteTaille);

        // Transformation du tableau de boolean en un tableau de chaine de String qui stock des nombre sous formes de byte 
        int compteur1=0; 
        int decompte=0;
        for(boolean cetteIteration : tabHorizontal){
            if(this.octetRemaining<8){
                break;
            }
            if(cetteIteration==Cellules.LIBRE){
                tempString = tempString + "0";
            } else if(cetteIteration==Cellules.OCCUPE){
                tempString = tempString + "1";
            }
            if(tempString.length()==8){
                tabTemp[compteur1] = tempString;
                tempString="";
                compteur1++;
                this.octetRemaining = this.octetRemaining - 8;
            }
            decompte++;
        }

        if(decompte != tabHorizontal.length){
            while(decompte != tabHorizontal.length){
            if(tabHorizontal[decompte]==Cellules.LIBRE){
                tempString=tempString+"0";
            }else if(tabHorizontal[decompte]==Cellules.OCCUPE){
                tempString=tempString+"1";
            }
            decompte++;
            } while(tempString.length() < 8){
                tempString=tempString+"0";
            } 
            this.tabTemp[compteur1] = tempString;
        }
        
        for(int i=0; i<tabTemp.length; i++){
            System.out.println(tabTemp[i]+" ");
        }

        this.path = this.CreateFichier();
        Ecriture stylo = new Ecriture(this.resultatByte, this.tabTemp, this.path);
    }
    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param unPerso On rentre 
     * @param grille c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     * @param coord tableau double dimension qui stock les différentes Cellules.
     */
    public String CreateFichier() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers .lab", "lab");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File fichier = chooser.getSelectedFile();
            String nomFichier = fichier.getName();
            if (!nomFichier.endsWith(".lab")) {
                fichier = new File(fichier.getAbsolutePath() + ".lab");
            }
            return fichier.getAbsolutePath();
        }
        return null;
    }    
}
