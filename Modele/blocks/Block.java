package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public abstract class Block {
	protected boolean traversable;
	private Point position;
	private char nom;
	//constructeur
	public Block(boolean traversable,Point position) {
		this.traversable=traversable;
		this.position=position;
		this.nom='A';
	}
	public Block(boolean traversable,int x,int y) {
		this(traversable,new Point(x,y));
	}
	
	//getter
	public boolean getTraversable() {
		return this.traversable;
	}
	public char getNom() {
		return this.nom;
	}
}
