package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{
	//constructeur
	public Joueur(int x,int y,String nom,ArrayList<ObservableList <Block>> terrain) {
		super(x,y,nom,terrain);
		this.pv=50;
	}
	
	//methode
	//Gauche
	public void seDeplacerGauche() { //x=j y=i
		this.x.set(this.x.get()-1);
	}
	//Droite
	public void seDeplacerDroite() { //x=j y=i
		this.x.set(this.x.get()+1);
	}
	
	
	//setter
	public void setNom(String nom) {
		this.nom=nom;
	}

	public void seDeplacerBas() {
		this.y.set(this.y.get()+1);	
	}	
	public void seDeplacerHaut() {
		this.y.set(this.y.get()-2);	
	}
}
