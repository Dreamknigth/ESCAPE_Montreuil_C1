package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.awt.Point;
import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.block;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{
	public Joueur(int x,int y,String nom,ArrayList<ObservableList <Character>> terrain) {
		super(x,y,nom,terrain);
		this.pv=50;
	}
	public boolean seDeplacerGauche() {
		//TODO verife que le joueur peut se deplacer si il peut deplacer sinon retourner faux
		char cAGauche=terrain.get(getX()).get(getY());
		if() {}
		return true;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
}
