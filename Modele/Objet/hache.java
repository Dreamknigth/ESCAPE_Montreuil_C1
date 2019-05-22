package ESCAPE_Montreuil_C1.Modele.Objet;

public class hache extends Arme{
	
	public hache() {
		super("hache", 5, 100);
		this.nom = "hache";
		this.ptsattaque = 5;
		this.durabilité = 100;
}

	@Override
	public int getatt() { return this.durabilité;}

	@Override
	public int getdura(){return this.ptsattaque;}

}
