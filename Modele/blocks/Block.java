package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public abstract class Block extends Objet {
	//declaration
	protected boolean traversable;
	private String nom;
	private String ID;
	
	//constructeur
	public Block(boolean traversable,String nom) {
		super(nom);
		this.traversable=traversable;
		this.nom=nom;
	}
	
	//methode
	abstract public Block faculte(Monde t, int x, int y) ;
	
	//getter
	public boolean getTraversable() {
		return this.traversable;
	}
	public String getNom() {
		return this.nom;
	}
	public String getID () {
		return this.ID;
	}
	//setter
	public void setID (String NewID) {
		this.ID = NewID;
	}
}
