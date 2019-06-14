package ESCAPE_Montreuil_C1.Modele.Objet;

public abstract class ArmeObjet extends Objet{
	
	/**
	 * A l heure actuel cette classe na pas grand interet mais 
	 * en terme de conception on souhaite la garder afin de bien differencier
	 * les differents objets
	 */
	
	//declaration
	protected int ptsattaque;
	
	//constructeur
	public ArmeObjet(String nom, int ptatt) {
		super(nom);
		this.ptsattaque = ptatt;
	}
	
}
