package ESCAPE_Montreuil_C1.Modele.Objet;

public class lance extends Arme{

	public lance() {
		super("lance", 25, 100);
		this.nom = "lance";
		this.ptsattaque = 25;
		this.durabilité = 100;
	}

	@Override
	public int getatt() { return this.ptsattaque;}

	@Override
	public int getdura() { return this.durabilité;}

}
