package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.awt.Point;
import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;

public class Joueur extends Personnage{
	public Joueur(int x,int y,String nom,ArrayList<ObservableList <Character>> terrain) {
		super(x,y,nom,terrain);
		this.pv=50;
	}
	public boolean seDeplacerGauche() {
		//TODO verife que le joueur peut se deplacer si il peut deplacer sinon retourner faux
		if(getX()==0) {
			return false;
		}
		char cAGauche=terrain.get(getX()-1).get(getY());
		boolean peutTraverser=true;
		switch(cAGauche) {
			case 'T':peutTraverser=false;
			break;
			case 'P':peutTraverser=false;
			break;
			case 'E':peutTraverser=false;
			break;
			default:this.position.setLocation(this.position.getX()-1,this.position.getY());
			break;
		}
		return peutTraverser;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
}
