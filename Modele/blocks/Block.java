package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public abstract class Block {
	protected boolean traversable;
	protected int x;
	protected int y;
	private char nom;
	//constructeur
	public Block(boolean traversable,int x,int y,char nom) {
		this.traversable=traversable;
		this.x=x;
		this.y=y;
	}
	
	//getter
	public boolean getTraversable() {
		return this.traversable;
	}
	public char getNom() {
		return this.nom;
	}
}
