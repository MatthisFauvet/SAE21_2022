/**
 * Class pour modifier l'affichage 
 * @version 1.1
 * @author Matthis Fauvet 
 */

public class Affichage {
    private Cellules cetteCellules;
    private PanneauModification cePanel;
    
    private boolean cetEtat;

    private int[] caseEntrortie;

    /** Constructeur de la class affichage
     * @param  uneCellules premet de récupérer la cellules a afficher
     * @param unPanel panneau de modification pour récupérer les valeurs demandés 
     * @param tabEntre tableau qui permet de savoir si un entré est déjà placé 
     * @param unEtat variable qui permet de savoir si un case est un mu ou un couloir
     */
    public Affichage(Cellules uneCellules, PanneauModification unPanel, int[] tabEntre, boolean unEtat){
        //permet la distribution des différents attributs
        this.cetteCellules = uneCellules;
        this.cePanel = unPanel;
        this.cetEtat = unEtat;
        this.caseEntrortie = tabEntre;

        repaint();
    }

    /**
     * Renvoie l'etat des cellules entre et sortie, si oui ou non elles sont posé ou pas 
     */
    public int[] getGateState(){
        return this.caseEntrortie;
    }

    /**
     * La fonctions repaint permet de changer les Cellules pour leur mettres leurs bonne couleurs. 
     */
    public void repaint(){
        // Accéder aux boutons radios de l'objet Options
        boolean radio1Selected = this.cePanel.GetButtonBW().isSelected(); // MUR / COULOIR
        boolean radio2Selected = this.cePanel.GetButtonE().isSelected(); // ENTREE 
        boolean radio3Selected = this.cePanel.GetButtonS().isSelected(); //SORTIE

        if(radio2Selected==true && this.caseEntrortie[0]==0){
            this.cetEtat=Cellules.LIBRE;
            this.cetteCellules.setType(Cellules.ENTREE);
            this.cetteCellules.peindre(Cellules.ENTREE);
            this.caseEntrortie[0]=1;
        } else if(radio3Selected==true && this.caseEntrortie[1]==0){
            this.cetEtat=Cellules.LIBRE;
            this.cetteCellules.setType(Cellules.SORTIE);
            this.cetteCellules.peindre(Cellules.SORTIE);
            this.caseEntrortie[1]=1;
        }  else if(this.cetEtat == Cellules.LIBRE && radio1Selected==true){
            if(this.cetteCellules.getType()==Cellules.ENTREE){
                this.caseEntrortie[0]=0;
            } else if(this.cetteCellules.getType()==Cellules.SORTIE){
                this.caseEntrortie[1]=0;
            }
            this.cetteCellules.setType(Cellules.COULOIR);
            this.cetteCellules.peindre(Cellules.COULOIR);
        } else if(this.cetEtat == Cellules.OCCUPE && radio1Selected==true){
            this.cetteCellules.setType(Cellules.MUR);
            this.cetteCellules.peindre(Cellules.MUR);
        }
    }
}
