package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public abstract class Block extends Objet {
	protected boolean traversable;
	private String nom;
	//constructeur
	public Block(boolean traversable,String nom) {
		super(nom);
		this.traversable=traversable;
		this.nom=nom;
	}
	
	//getter
	public boolean getTraversable() {
		return this.traversable;
	}
	public String getNom() {
		return this.nom;
	}
	
	abstract public Block faculté(Monde t, int x, int y) ;
	
}
