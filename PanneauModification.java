import java.awt.*;
import javax.swing.*;
/**
 * Cette class hérité de Fenetre met en place une  fenetre qui est un panneau avec plusieur options pour modifier le tableau/ la grille
 * ainsi que pour passer a la suite du programme 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class PanneauModification extends Fenetre {
    public JRadioButton radio1;
    public JRadioButton radio2;
    public JRadioButton radio3;

    private boolean[][] cetteGrille;
    private Cellules[][] grilleCellules;
    private int cetteTaille;

    private JFrame frameGrille;
    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param uneGrille Labyrinthe de boolean
     * @param uneTaille taille du labyrinthe 
     * @param uneGrilleCell grille de Cellules
     * @param uneFrame fenetre précédente
     */
    public PanneauModification(boolean[][] uneGrille, int uneTaille, Cellules[][] uneGrilleCell, JFrame uneFrame){
        super();
        this.fenetre.setSize(400, 600);
        this.fenetre.setLocation(920, 150);
        this.grilleCellules = uneGrilleCell;
        this.cetteGrille=uneGrille;
        this.cetteTaille=uneTaille;
        this.frameGrille = uneFrame;

        this.frameGrille = uneFrame;
    }
    /**
     * Cette méthode a pour objectif d'ajouté différents élément a fenetre pour tout modifier
     */
    public void SetUp(){
        GridLayout gestionnaire = new GridLayout(4,1);
        this.fenetre.setLayout(gestionnaire);

        /* Création du premier panneau */
        JLabel un_d_text = new JLabel(" Etape 1 : création du labyrinthe");
        JPanel un_Panel =  new JPanel();
        un_Panel.setBackground(Color.CYAN);
        un_Panel.add(un_d_text, BorderLayout.CENTER);
        JPanel un_Panel2 = new JPanel();
        un_Panel2.setBackground(Color.CYAN);
        un_Panel2.setLayout(new BoxLayout(un_Panel2, BoxLayout.Y_AXIS));
        un_Panel2.add(Box.createVerticalGlue());
        un_Panel2.add(un_Panel);
        un_Panel2.add(Box.createVerticalGlue());
        this.fenetre.add(un_Panel2, BorderLayout.CENTER);

        /*Création du deuxième panneau */
        JPanel un_Panel3 = new JPanel();
        JButton un_Button1 = new JButton("Suivant");
        JPanel un_Panel4 = new JPanel();
        un_Panel4.add(un_Button1);
        un_Panel3.setBackground(Color.CYAN);
        un_Panel4.setBackground(Color.CYAN);
        un_Panel3.setBackground(Color.CYAN);
        un_Panel3.setLayout(new BoxLayout(un_Panel3, BoxLayout.Y_AXIS));
        un_Panel3.add(Box.createVerticalGlue());
        un_Panel3.add(un_Panel4);
        un_Panel3.add(Box.createVerticalGlue());
        this.fenetre.add(un_Panel3, BorderLayout.CENTER);

        /*============================ Nouveau panneau grille choix  ============================*/
        JPanel un_Panel10 = new JPanel();
        JPanel un_Panel11 = new JPanel();       
        radio1 = new JRadioButton("Construire ou Effacer");
        radio2 = new JRadioButton("Entrée");
        radio3 = new JRadioButton("Sortie");
        radio1.setBackground(Color.CYAN);
        radio2.setBackground(Color.CYAN);
        radio3.setBackground(Color.CYAN);
        radio1.setSelected(true);
        ButtonGroup group = new ButtonGroup();  
        group.add(radio1);group.add(radio2); group.add(radio3);
        un_Panel11.add(radio1);
        un_Panel11.add(radio2);
        un_Panel11.add(radio3);
        un_Panel10.setBackground(Color.CYAN);
        un_Panel10.setLayout(new BoxLayout(un_Panel10, BoxLayout.Y_AXIS));
        un_Panel10.add(Box.createVerticalGlue());
        un_Panel10.add(un_Panel11);
        un_Panel10.add(Box.createVerticalGlue());
        un_Panel10.setBackground(Color.CYAN);
        un_Panel11.setBackground(Color.CYAN);
        this.fenetre.add(un_Panel10, BorderLayout.CENTER);

        /*Création du deuxième panneau */
        JPanel un_Panel5 = new JPanel();
        JButton un_Button2 = new JButton("Quitter");
        JPanel un_Panel6 = new JPanel();
        un_Panel6.add(un_Button2, BorderLayout.CENTER);
        un_Panel5.setBackground(Color.CYAN);
        un_Panel6.setBackground(Color.CYAN);
        un_Panel5.setBackground(Color.CYAN);
        un_Panel5.setLayout(new BoxLayout(un_Panel5, BoxLayout.Y_AXIS));
        un_Panel5.add(Box.createVerticalGlue());
        un_Panel5.add(un_Panel6);
        un_Panel5.add(Box.createVerticalGlue());
        this.fenetre.add(un_Panel5, BorderLayout.CENTER);
        
        /* Evenement */
        GestionModif cesOptions = new GestionModif(this.cetteGrille, this.grilleCellules, this.cetteTaille, this.frameGrille, this.fenetre);
        un_Button1.addActionListener(cesOptions);
        un_Button2.addActionListener(cesOptions);

        this.fenetre.setVisible(true);
    }
    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param unPerso On rentre 
     * @param grille c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     * @param coord tableau double dimension qui stock les différentes Cellules.
     */
    public JRadioButton GetButtonBW() {
        return radio1;
    }
    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param unPerso On rentre 
     * @param grille c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     * @param coord tableau double dimension qui stock les différentes Cellules.
     */
    public JRadioButton GetButtonE() {
        return radio2;
    }
    /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param unPerso On rentre 
     * @param grille c'est la grille de true et false qui permet de savoir si une cellules est un mur ou un couloir
     * @param coord tableau double dimension qui stock les différentes Cellules.
     */
    public JRadioButton GetButtonS() {
        return radio3;
    }
}
