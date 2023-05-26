import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * La class importer implémente un Action Listener pour lancer les prochaine partie du programme :
 * permet das un premier temps de laisser l'utilisateur aller chercher le fichier qu'il souhaite importer (FileImport)
 * Ensuite, le programme va lire ce fichier (Lecture)
 * Et enfin, il va générer une grille en se basant sur le contenur du fichier
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class Importer implements ActionListener {
    String cette_option;
    String cet_event;
    String ce_chemin;
    JFrame cette_frame;
    Lecture cette_lecture;
    FenetreImpGrille cette_fenetre;
    int valeur0, valeur1, valeur2, valeur3, valeur4;
  
    /**
     * Constructeur qui prend en paramètre la fenetre précédente
     * @param une_frame on récupère la premiere fenetre pour la fermer un peu plus tard 
     */
    public Importer(JFrame une_frame){
        this.cette_option="Importer Grille";
        this.cette_frame = une_frame;
    }


        /**
     * Si l'utilisateur décide d'importer un grille, alors on choisit un fichier, on le lit, on créer un fenetre en se basant dessus.
     * @param e on prend l'évènement en param afin de le traiter
     */

    public void actionPerformed(ActionEvent e){
        this.cet_event=e.getActionCommand();
        if(cet_event.equals(this.cette_option)){
            //System.out.println("Importation de la grille");

            /*cherche le chemin du fichier */
            FileImport un_test = new FileImport();
            this.ce_chemin = un_test.Parcours();

            if(this.ce_chemin == ""){
            JOptionPane.showMessageDialog(null, "Aucun fichier n'a été importé, le programme va se clore a la suite de cette fenetre", "Erreur d'importation", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            }

            /*lecture du fichier  */
            this.cette_lecture = new Lecture(this.ce_chemin);

            this.valeur0=this.cette_lecture.GetHeader(0);
            this.valeur1=this.cette_lecture.GetHeader(1);
            this.valeur2=this.cette_lecture.GetHeader(2);
            this.valeur3=this.cette_lecture.GetHeader(3);
            this.valeur4=this.cette_lecture.GetHeader(4);

            /*Fermeture de la première fenètre */
            cette_frame.dispose();

            /* Ouverture de la nouvelle */

            this.cette_fenetre = new FenetreImpGrille();

            cette_fenetre.ImporterGrille(this.valeur0, this.valeur1, this.valeur2, this.valeur3, this.valeur4, this.cette_lecture.GetOffset());
        }
    }
}