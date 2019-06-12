package ESCAPE_Montreuil_C1.Modele.blocks;


public abstract class BlockDestructible extends Block{
	protected int solidite;
	public BlockDestructible(boolean estTraversable,int solidite, String nom) {
		super(estTraversable, nom);
		this.solidite = solidite;
	}
}
