import javax.swing.*;
import java.awt.*;
/**
 * FenetreInit est la toute première class a hérité de feneètre, elle a pour objectif de récupérer l'informations si l'utilisateur
 * souhaite importer ou creer un grills 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class FenetreInit extends Fenetre
{
    /**
     * Constructeur qui fait apelle a la class hérité : Fenetre 
     */
    public FenetreInit(){   
        super();
    }
    /**
     * La méthode Initialisation a seulement pout but de créer une petite fenetre qui demande ce qu'il veut faire a l'utilisateur, 
     * cette décision est écouter par un ActionListener
     */
    public void Initialisation(){        
        GridLayout gestionnaire = new GridLayout(2,1);
        this.fenetre.setLayout(gestionnaire);

        /* Création du premier panneau */

        JLabel un_text = new JLabel("Que voulez vous faire ?");

        JPanel un_Panel =  new JPanel();
        un_Panel.setBackground(Color.CYAN);

        un_Panel.add(un_text, BorderLayout.CENTER);

        JPanel un_Panel2 = new JPanel(null);
        un_Panel2.setBackground(Color.CYAN);
        un_Panel2.setLayout(new BoxLayout(un_Panel2, BoxLayout.Y_AXIS));
        un_Panel2.add(Box.createVerticalGlue());
        un_Panel2.add(un_Panel);
        un_Panel2.add(Box.createVerticalGlue());

        /*Création du deuxième panneau */
        JPanel un_Panel3 = new JPanel();
        FlowLayout gestionnaire2 = new FlowLayout(FlowLayout.CENTER);
        un_Panel3.setLayout(gestionnaire2);
        un_Panel3.setBackground(Color.CYAN);
        JButton un_Button0 = new JButton("Nouvelle Grille");
        JButton un_Button1 = new JButton("Importer Grille");
        
        un_Panel3.add(un_Button0);
        un_Panel3.add(un_Button1);

        /*Gestion des événements  */

        Creer salut = new Creer(fenetre);
        un_Button0.addActionListener(salut);

        Importer bImporter = new Importer(this.fenetre);
        un_Button1.addActionListener(bImporter);

        /*Ajouts des elts à la fenètre */

        this.fenetre.add(un_Panel2, BorderLayout.CENTER);
        this.fenetre.add(un_Panel3);

        this.fenetre.setVisible(true);
    }
    
}
