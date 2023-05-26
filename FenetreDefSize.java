import javax.swing.*;

import java.awt.*;
/**
 * La class FenetreDefSize ouvre une instance graphique, une JFrame qui est la pour que l'utilisateur rentre les informations sur la grille qu'il souhaite faire
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class FenetreDefSize extends Fenetre{
    /**
     * Constructeur qui apelle toutes différentes var de Fenetre via super();
     */
    public FenetreDefSize(){
        super();
    } 
    /**
     * La méthode MiseEnPlace ne prend pas d'argument, simplement, elle ajoute différents éléments a la fenetre puis l'affiche en true, 
     * par ailleurs, dans le bas de cette méthode, nous pouvons voir qu'un actionListener relié a ChoixEtTaille est posés sur les bourons 
     */
    public void MiseEnPlace(){       
        /*============================== ---------------  Fenetre --------------- ==============================*/ 
        
        GridLayout gestionnaire = new GridLayout(2,1);
        this.fenetre.setLayout(gestionnaire);
        
        /*============================== ---------------  premier panneau --------------- ==============================*/
        
        JPanel ce_panneau =  new JPanel();
        ce_panneau.setBackground(Color.CYAN);

        JLabel ce_text = new JLabel("Donnez la taille de la grille");

        ce_panneau.add(ce_text);

        /* ============================== --------------- deuxième panneau --------------- ==============================*/

        JPanel ce_panneau2 = new JPanel();
        ce_panneau2.setBackground(Color.CYAN);

        ce_panneau2.setLayout(gestionnaire);

        /*----------------- Panneau 3 -----------------*/
        JPanel ce_panneau3 = new JPanel();
        ce_panneau3.setBackground(Color.CYAN);


        JTextField ce_champ = new JTextField();
        ce_champ.setPreferredSize(new Dimension(50, 30));
        
        JButton ce_boutton = new JButton("créer");
        ce_panneau3.add(ce_champ);
        ce_panneau3.add(ce_boutton);

        /*----------------- Panneau 4 - les radios boutons  -----------------*/
        JPanel ce_panneau4 = new JPanel();
        ce_panneau4.setBackground(Color.CYAN);

        JRadioButton radio1 = new JRadioButton("Grille randomisée");
        JRadioButton radio2 = new JRadioButton("Grille vide");

        radio1.setSelected(true);

        radio1.setBackground(Color.CYAN);
        radio2.setBackground(Color.CYAN);

        radio1.setActionCommand("Grille randomisée");
        radio2.setActionCommand("Grille vide");

        ButtonGroup group = new ButtonGroup();  
        group.add(radio1);
        group.add(radio2);  
        
        ce_panneau4.add(radio1);
        ce_panneau4.add(radio2);

        /*  ----------------- Global -----------------  */
        ce_panneau2.add(ce_panneau3);
        ce_panneau2.add(ce_panneau4);

        /*----------------- event -----------------*/
        ChoixEtTaille b_taille = new ChoixEtTaille(this.fenetre, ce_champ, group);
        ce_boutton.addActionListener(b_taille);

        /*----------------- reste -----------------*/
        this.fenetre.add(ce_panneau, BorderLayout.CENTER);
        this.fenetre.add(ce_panneau2);

        this.fenetre.setVisible(true);
    }
}