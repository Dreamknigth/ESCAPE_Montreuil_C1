package ESCAPE_Montreuil_C1.Modele.Objet;

public abstract class Objet {
	
	protected String nom;
	protected int nb;
	
	public Objet(String nom, int nb) {
		this.nom = nom;
		this.nb = nb;
	}
	
	public abstract int getnb();
	public abstract String getNom();
	public abstract void setnb(int i);
	
	
	

}
