package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Ressource;

public abstract class BlockDestructible extends Block{
	protected int solidite;
	public BlockDestructible(boolean estTraversable,int solidite, char nom) {
		super(estTraversable, nom);
		this.solidite = solidite;
	}
}
