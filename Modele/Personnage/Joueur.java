package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.awt.Point;
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
	public boolean seDeplacerGauche() { //x=j y=i
		//TODO verife que le joueur peut se deplacer si il peut deplacer sinon retourner faux
		if( getX()==0 || !this.terrain.get( getY() ).get( getX()-1 ).getTraversable() ) {
			return false;
		}
		else {
			this.position.setLocation( getY(),getX()-1 );
			System.out.println("gauche x="+getX()+"y="+getY());
			return true;
		}
	}
	//Droite
	public boolean seDeplacerDroite() { //x=j y=i
		//TODO verife que le joueur peut se deplacer si il peut deplacer sinon retourner faux
		if( getX()==this.terrain.get( getY() ).size()-1 || !this.terrain.get( getY() ).get( getX()+1 ).getTraversable() ) {
			return false;
		}
		else {
			this.position.setLocation( getY(),getX()+1 );
			System.out.println("droite");
			return true;
		}
	}
	
	
	//setter
	public void setNom(String nom) {
		this.nom=nom;
	}
}
