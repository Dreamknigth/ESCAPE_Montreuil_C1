package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{ //Rappel: i=y x=j
	//constructeur
	public Joueur(int x,int y,String nom,Terrain leTerrain) {
		super(x,y,nom,leTerrain);
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
}
