package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{ //Rappel: i=y x=j
	
	private Inventaire lInventaire;
	
	//constructeur
	public Joueur(int x,int y,String nom,Terrain leTerrain) {
		super(x,y,nom,leTerrain);
		this.lInventaire = new Inventaire();
	}
	
	//methode
	//saut
	public void seDeplacerSaut() {
		int i=0;
		int hauteurSaut=2;
		this.seDeplacerHaut();
		while(i<=hauteurSaut) {
			i++;
		}
	}
	//setter
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public boolean modifPossible(int a, int b) {// a=y souris b=x souris
		if ( ((a == (this.y.getValue())+2) || (a == (this.y.getValue())+1) || (a == (this.y.getValue())) || (a == (this.y.getValue())-1)) && 
				((b == this.x.getValue())|| (b == this.x.getValue()+1) || (b == this.x.getValue()-1)) ) {
			System.out.println("OUI");
			
			return true;
			
		}
		return false;
	}
}
