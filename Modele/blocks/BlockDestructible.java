package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

abstract class BlockDestructible extends Block{
	private int solidite;
	private Ressource drop; //ce que l'objet donne
	public BlockDestructible(boolean estTraversable,Point position,Ressource drop,int solidite) {
		super(estTraversable,position);
		this.solidite=solidite;
		this.drop=drop;
	}
	public BlockDestructible(boolean estTraversable,int x,int y,Ressource drop,int solidite) {
		this(estTraversable,new Point(x,y),drop,solidite);
	}

}
