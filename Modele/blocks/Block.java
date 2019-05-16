package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public abstract class Block {
	protected boolean traversable;
	private Point position;
	public Block(boolean traversable,Point position) {
		this.traversable=traversable;
		this.position=position;
	}
	public Block(boolean traversable,int x,int y) {
		this(traversable,new Point(x,y));
	}
}
