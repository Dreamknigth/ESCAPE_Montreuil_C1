package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{ //Rappel: i=y x=j
	
	private Inventaire lInventaire;
	
	//constructeur
	public Joueur(int x,int y,String nom,Terrain leTerrain, int pv) {
		super(x,y,nom,leTerrain);
		this.pv = new SimpleIntegerProperty(pv);
		this.lInventaire = new Inventaire();
	}
	
	//methode
	
	//setter
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public boolean modifPossible(int a, int b) {// a=y souris b=x souris
		if ( ((a == (this.y.getValue())+2) || (a == (this.y.getValue())+1) || (a == (this.y.getValue())) || (a == (this.y.getValue())-1)) && 
				((b == this.x.getValue())|| (b == this.x.getValue()+1) || (b == this.x.getValue()-1)) ) {
			
			return true;
			
		}
		return false;
	}

}
