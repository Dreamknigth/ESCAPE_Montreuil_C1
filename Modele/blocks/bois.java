package ESCAPE_Montreuil_C1.Modele.blocks;

public abstract class bois extends BlockDestructible {

	public bois(boolean estTraversable, Ressource drop, int solidite, char nom) {
		super(estTraversable, drop, solidite, nom);
	}

}
