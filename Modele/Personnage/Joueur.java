package ESCAPE_Montreuil_C1.Modele.Personnage;



import ESCAPE_Montreuil_C1.Modele.Crafting.Craft;
import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{ //Rappel: i=y x=j
	private Objet objet_Dans_La_Main;
	private Inventaire lInventaire;
	private Craft craftJoueur;
	
	//constructeur
	public Joueur(int x,int y,String nom,Terrain leTerrain, int pv) {
		super(x,y,nom,leTerrain);
		this.objet_Dans_La_Main=new AirBlock();
		this.lInventaire= new Inventaire();
		this.craftJoueur = new Craft( this.lInventaire );
		this.pv = new SimpleIntegerProperty(pv);
	}
	
	//methode
	
	//getter
	public Craft getCraft() {
		return this.craftJoueur;
	}
	
	//setter
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setObjetDansLaMain(Objet b) {
		this.objet_Dans_La_Main=b;
	}
	public Objet getObjetDansLaMain() {
		return this.objet_Dans_La_Main;
	}
	
	public boolean modifPossible(int a, int b) {// a=y souris b=x souris
		if ( ((a == (this.y.getValue())+2) || (a == (this.y.getValue())+1) || (a == (this.y.getValue())) || (a == (this.y.getValue())-1)) && 
				((b == this.x.getValue())|| (b == this.x.getValue()+1) || (b == this.x.getValue()-1)) ) {
			
			return true;
			
		}
		return false;
	}

	public Inventaire getInventaire() {
		return this.lInventaire;
	}

	
}


