package ESCAPE_Montreuil_C1.Modele.Objet;

public class épée extends Arme{

	public épée() {
		super("épée", 50, 100);
		this.nom = "épée";
		this.ptsattaque = 50;
		this.durabilité = 100;
	}

	@Override
	public int getdura() { return this.durabilité; }
	@Override
	public String getNom() { return this.nom; }
	@Override
	public int getatt() { return this.ptsattaque; }
}
