package ESCAPE_Montreuil_C1.Modele.Objet;

public class Ressource extends Objet{

	public Ressource(String nom) {
		super(nom);
	}

	@Override
	public int getnb() {
		return this.nb;
	}

	@Override
	public void setnb(int i) {
		this.nb = this.nb + i;
		
	}
	
	@Override
	public String getNom() { 
		return this.nom;
		}
	
	

}
