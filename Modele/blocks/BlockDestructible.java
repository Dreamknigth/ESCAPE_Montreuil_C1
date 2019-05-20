package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

abstract class BlockDestructible extends Block{
	private int solidite;
	private Ressource drop; //ce que l'objet donne
	public BlockDestructible(boolean estTraversable,Ressource drop,int solidite,char nom) {
		super(estTraversable,nom);
		this.drop=drop;
		this.solidite=solidite;
	}

}
