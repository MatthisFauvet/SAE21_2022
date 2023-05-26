import java.io.*;
/**
 * La class écriture a pour objectif d'écrire dans un fichier un certain nombre de bits et octets afin de sauvegarder les grilles
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Ecriture {
    private byte[] tabHeader;
    private String[] tabOffSet;
    private String filePath;

    /**
     * Méthode constructeur qui va tout écrire dans le fichier 
     * @param tabBytes Dans ce tableau sont stockés les 5 premier octets a écrire dans le fichier 
     * @param tabOctetsBinaires dans ce String, on a tous les autres bits que l'on écrira en octet dans le fichier 
     * @param chemin c'est le chemin d'accès au fichier pour pouvoir ouvrir un flux d'entrée et donc d'"crire des choses"
     */
    public Ecriture(byte[] tabBytes, String[] tabOctetsBinaires, String chemin) {
        this.tabHeader = tabBytes;
        this.tabOffSet = tabOctetsBinaires;
        this.filePath = chemin;

        FileOutputStream fichierSortie = null;
        try {
            fichierSortie = new FileOutputStream(this.filePath);
            
            // Ecriture du tableau de bytes dans le fichier
            fichierSortie.write(this.tabHeader);
            
            // Ecriture du tableau d'octets binaires dans le fichier
            for (String flags : this.tabOffSet) {
                fichierSortie.write((byte) Integer.parseInt(flags, 2));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Fermeture du fichier
            if (fichierSortie != null) {
                try {
                    fichierSortie.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
