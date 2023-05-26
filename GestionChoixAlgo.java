import javax.swing.*;
import java.awt.event.*;
/**
 * Cette class a pour but de rediriger le programme vers l'algorithme que l'utilisateur a choisit 
 * @version 1.1
 * @author Matthis Fauvet 
 */
public class GestionChoixAlgo extends JFrame implements ActionListener {
  private JFrame cetteFrame;
  private ButtonGroup ceGroupe0;
  private ButtonGroup ceGroupe1;

  private int cetteTaille;

  private JFrame frameGrille;
  private boolean[][] cetteGrille;
  private Cellules[][] cetteGrilleCell;
  /**
     * Class qui créer un objet Algo determinatif pour résoudre le Labyrinthe
     * @param uneTaille Taille de notre lab actuel 
     * @param uneFrame Fenetre actuelle récupéré pour la clore quand elle n'est plus utile 
     * @param group0 Récupération de l'algo choisit 
     * @param group1 Récupération de la visualisation choisit 
     * @param uneGrille notreLabyrinthe sous forme de tab de boolean
     * @param grilleCell notreLabyrinthe sous forme de tab de Cellules
     * @param uneFenetre On récupère la grille où est affiché le lab pour voir si on la ferme ou non (tout dépend de l'algo)
     */
  public GestionChoixAlgo(int uneTaille, JFrame uneFrame, ButtonGroup group0,  ButtonGroup group1, boolean[][] uneGrille, Cellules[][] grilleCell,JFrame uneFenetre){
    this.cetteFrame = uneFrame;
    this.ceGroupe0 = group0;
    this.ceGroupe1 = group1;

    this.cetteTaille = uneTaille;

    this.frameGrille=uneFenetre;
    this.cetteGrille = uneGrille;
    this.cetteGrilleCell=grilleCell;
  }

  /**
     * Cette méthode, en fonction des JRadioButton sélectionné ou non, va dirigé le programme vers un type d'algo et son parcours précis
     * important : Cette méthode ne se lance que si et seulement si le bouton a été préssé  
     * @param e raison de l'événement
     */
  public void actionPerformed(ActionEvent e){
    this.cetteFrame.dispose();
    if(this.ceGroupe0.getSelection().getActionCommand()=="Aalea" && this.ceGroupe1.getSelection().getActionCommand()=="Vauto")
    {
      this.frameGrille.dispose();
      AlgoAlea algorithme = new AlgoAlea(this.cetteTaille, this.cetteGrille, this.cetteGrilleCell, null);
      algorithme.auto();
    }
    else if(this.ceGroupe0.getSelection().getActionCommand()=="Adeter" && this.ceGroupe1.getSelection().getActionCommand()=="Vauto")
    {
      this.frameGrille.dispose();
      AlgoDeter algorithme = new AlgoDeter(this.cetteTaille, this.cetteGrille, this.cetteGrilleCell, null);
      algorithme.auto();
    }
    else if(this.ceGroupe0.getSelection().getActionCommand()=="Aalea" && this.ceGroupe1.getSelection().getActionCommand()=="Vman")
    {
      this.frameGrille.setLocation(500, 100);
      AlgoAlea algorithme = new AlgoAlea(this.cetteTaille, this.cetteGrille, this.cetteGrilleCell, this.frameGrille);
      algorithme.manuel();
    }
    else if(this.ceGroupe0.getSelection().getActionCommand()=="Adeter" && this.ceGroupe1.getSelection().getActionCommand()=="Vman")
    {
      this.frameGrille.setLocation(500, 100);
      AlgoDeter algorithme = new AlgoDeter(this.cetteTaille, this.cetteGrille, this.cetteGrilleCell, null);
      algorithme.manuel();
    }
  } 
}