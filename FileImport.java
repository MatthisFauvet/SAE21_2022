import javax.swing.*;
import java.io.File;
/**
 * La classe FlieImport a pour but d'aller chercher un fichier a ouvrir sur l'ordinateur via un JFileChooser
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class FileImport {
    private String ce_chemin;

    /**
     * Constructeur ou l'on établit seulement 
     */
    public FileImport(){
        this.ce_chemin = "";
    }

    /**
     * méthode qui va permettre d'ouvrir un explorateur de fichier afin de choisir un fichier.
     * Cette fonction renvoir le chemin d'accès de ce fichier.
     */
    public String Parcours(){
        JFileChooser fileChooser = new JFileChooser();

        try {
            int option = fileChooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                this.ce_chemin = selectedFile.getAbsolutePath();
            } else {
                System.out.println("Aucun fichier sélectionné");
            }
        } catch (Exception e) {
            System.out.println("Voici l'eereur rencontrée: " + e.getMessage());
            this.ce_chemin = "";
        }

        return this.ce_chemin;
    }
}
