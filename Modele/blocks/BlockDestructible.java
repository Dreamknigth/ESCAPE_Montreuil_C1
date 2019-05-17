package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

abstract class BlockDestructible extends Block{
	private int solidite;
	private Ressource drop; //ce que l'objet donne
	public BlockDestructible(boolean estTraversable,int x,int y,Ressource drop,int solidite,char nom) {
		super(estTraversable,x,y,nom);
		this.drop=drop;
		this.solidite=solidite;
	}

}
