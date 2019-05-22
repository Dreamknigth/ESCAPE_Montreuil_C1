package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Ressource;

abstract class BlockDestructible extends Block{
	protected int solidite;
	protected Ressource drop; //ce que l'objet donne
	public BlockDestructible(boolean estTraversable,Ressource drop,int solidite, char nom) {
		super(estTraversable, nom);
		this.solidite = solidite;
		this.drop = drop;
	}
}
