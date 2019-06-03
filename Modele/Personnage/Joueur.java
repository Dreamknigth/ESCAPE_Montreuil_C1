package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{ //Rappel: i=y x=j
	//constructeur
	public Joueur(int x,int y,String nom, Terrain t) {
		super(x,y,nom,t);
		this.pv=50;
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
	
	public boolean modifPossible(int a, int b) {	
		
		if (((a == (this.y.get())+1) || (a == (this.y.get())) || (a == (this.y.get())-1)) && 
				((b == this.x.getValue())|| (b == this.x.getValue()+1) || (b == this.x.getValue()-1))) {
			return true;
			
		}
		return false;
	}
}
