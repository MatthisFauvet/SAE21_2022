import javax.swing.*;
import java.awt.*;
/**
 * La class choix Algo hérite de Fenetre, cette classe ouvre une fenetre et invite l'utilisateur a choisir un algo et une visualisation
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class ChoixAlgo extends Fenetre {
    private JFrame frameGrille;
    private boolean[][] ceTableau;
    private Cellules[][] cetteGrille;
    private int cetteTaille;

    /**
     * Constructeur 
     * @param uneTaille Taille du lab
     * @param fenGrille Notre fenetre graphique pour la gérer
     * @param uneGrille Labyrinthe de boolean pour le parcourir 
     * @param uneGrilleCell Labyrinthe de Cellules pour le parcourir 
     */
    public ChoixAlgo(int uneTaille, JFrame fenGrille, boolean[][] uneGrille, Cellules[][] uneGrilleCell){
        super();
        this.fenetre.setVisible(true);
        this.fenetre.setTitle("Algorithmes et visualisation");
        this.fenetre.setLocation(1000, 200);

        this.ceTableau = uneGrille;
        this.cetteGrille = uneGrilleCell;
        this.frameGrille = fenGrille;
        this.cetteTaille = uneTaille;
        
        GridLayout gestionnaire = new GridLayout(6, 1);
        this.fenetre.setLayout(gestionnaire);
    }

    /**
     * la méthode void setup permet de mettre la fenetre en place et d'ajouter tous les différents élément dessus
     */
    public void setUp(){
        /* ============================= TEXT PRESENTATION =========================*/

        JLabel unText = new JLabel(" Etape 2 : Choix de l'Algorithme et de la Visualisation");
        JPanel unPanel =  new JPanel();
        unPanel.setBackground(Color.CYAN);
        unPanel.add(unText, BorderLayout.CENTER);
        JPanel unPanel2 = new JPanel();
        unPanel2.setBackground(Color.CYAN);
        unPanel2.setLayout(new BoxLayout(unPanel2, BoxLayout.Y_AXIS));
        unPanel2.add(Box.createVerticalGlue());
        unPanel2.add(unPanel);
        unPanel2.add(Box.createVerticalGlue());
        this.fenetre.add(unPanel2, BorderLayout.CENTER);
        
        /*============================ Choix de l'algo ============================*/

        JLabel text0 = new JLabel("Choix de l'Algorithme");
        JPanel cePanel0 = new JPanel();
        cePanel0.setBackground(Color.CYAN);
        cePanel0.add(text0, BorderLayout.CENTER);
        JPanel cePanel1 = new JPanel();
        cePanel1.setBackground(Color.CYAN);
        cePanel1.setLayout(new BoxLayout(cePanel1, BoxLayout.Y_AXIS));
        cePanel1.add(Box.createVerticalGlue());
        cePanel1.add(cePanel0);
        cePanel1.add(Box.createVerticalGlue());
        this.fenetre.add(cePanel1, BorderLayout.CENTER);

        /* ===== -_- ===== */

        JPanel unPanel3 = new JPanel();
        JPanel unPanel4 = new JPanel(); 

        JRadioButton radioAA = new JRadioButton("Algorithme Aléatoire");
        JRadioButton radioAD = new JRadioButton("Algorithme Déterminatif");
        
        radioAA.setActionCommand("Aalea");
        radioAD.setActionCommand("Adeter");   

        radioAA.setBackground(Color.CYAN);
        radioAA.setSelected(true);
        radioAD.setBackground(Color.CYAN);
        
        ButtonGroup group = new ButtonGroup();  
        group.add(radioAA);group.add(radioAD);

        unPanel4.add(radioAA);
        unPanel4.add(radioAD);
        unPanel3.setBackground(Color.CYAN);
        unPanel3.setLayout(new BoxLayout(unPanel3, BoxLayout.Y_AXIS));
        unPanel3.add(Box.createVerticalGlue());
        unPanel3.add(unPanel4);
        unPanel3.add(Box.createVerticalGlue());
        unPanel3.setBackground(Color.CYAN);
        unPanel4.setBackground(Color.CYAN);
        this.fenetre.add(unPanel3, BorderLayout.CENTER); 

        /* ===== */

        JLabel text1 = new JLabel(" Choix de la visualisation");
        JPanel cePanel2 = new JPanel();
        cePanel2.setBackground(Color.CYAN);
        cePanel2.add(text1, BorderLayout.CENTER);
        JPanel cePanel3 = new JPanel();
        cePanel3.setBackground(Color.CYAN);
        cePanel3.setLayout(new BoxLayout(cePanel3, BoxLayout.Y_AXIS));
        cePanel3.add(Box.createVerticalGlue());
        cePanel3.add(cePanel2);
        cePanel3.add(Box.createVerticalGlue());
        this.fenetre.add(cePanel3, BorderLayout.CENTER);

       /*============================ Choix de la vue ============================*/
       JPanel unPanel5 = new JPanel();
       JPanel unPanel6 = new JPanel(); 

       JRadioButton radioVA = new JRadioButton("Visualisation Automatique");
       JRadioButton radioVD = new JRadioButton("Visualisation Manuelle");

       radioVA.setActionCommand("Vauto");
       radioVD.setActionCommand("Vman");

       radioVA.setBackground(Color.CYAN);
       radioVA.setSelected(true);
       radioVD.setBackground(Color.CYAN);
       
       ButtonGroup groupe = new ButtonGroup();  
       groupe.add(radioVA);groupe.add(radioVD);

       unPanel6.add(radioVA);
       unPanel6.add(radioVD);

       unPanel5.setBackground(Color.CYAN);
       unPanel5.setLayout(new BoxLayout(unPanel5, BoxLayout.Y_AXIS));
       unPanel5.add(Box.createVerticalGlue());
       unPanel5.add(unPanel6);
       unPanel5.add(Box.createVerticalGlue());
       unPanel5.setBackground(Color.CYAN);
       unPanel6.setBackground(Color.CYAN);
       this.fenetre.add(unPanel5, BorderLayout.CENTER); 

       /*Création du dernier panneau */
       JPanel unPanel10 = new JPanel();
       JButton unButton0 = new JButton("Suivant");
       JPanel unPanel11 = new JPanel();
       unPanel11.add(unButton0, BorderLayout.CENTER);
       unPanel10.setBackground(Color.CYAN);
       unPanel11.setBackground(Color.CYAN);
       unPanel10.setBackground(Color.CYAN);
       unPanel10.setLayout(new BoxLayout(unPanel10, BoxLayout.Y_AXIS));
       unPanel10.add(Box.createVerticalGlue());
       unPanel10.add(unPanel11);
       unPanel10.add(Box.createVerticalGlue());
       this.fenetre.add(unPanel10, BorderLayout.CENTER);
        
        /* Evenement */

        this.fenetre.setVisible(true);

        GestionChoixAlgo gestion = new GestionChoixAlgo(this.cetteTaille, this.fenetre, group, groupe, this.ceTableau, this.cetteGrille ,this.frameGrille);
        unButton0.addActionListener(gestion);
    }
}
