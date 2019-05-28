package ESCAPE_Montreuil_C1.Modele.Objet;

public abstract class Arme extends Objet{
	
	protected int ptsattaque;
	protected int durabilité;

	public Arme(String nom, int ptatt, int dura) {
		super(nom);
		this.ptsattaque = ptatt;
		this.durabilité = dura;
	}
	
	public abstract int getatt();
	public abstract int getdura();

}
