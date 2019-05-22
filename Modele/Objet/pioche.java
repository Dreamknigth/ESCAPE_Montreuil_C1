package ESCAPE_Montreuil_C1.Modele.Objet;

public class pioche extends Arme{

	public pioche() {
		super("pioche", 5, 100);
		this.nom = "pioche";
		this.ptsattaque = 5;
		this.durabilité = 100;
	}

	@Override
	public int getatt() { return this.durabilité;}

	@Override
	public int getdura(){return this.ptsattaque;}

}
