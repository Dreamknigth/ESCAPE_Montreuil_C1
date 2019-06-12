package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public class épéeObjet extends ArmeObjet{

	public épéeObjet() {
		super("épée", 50, 100);
		this.nom = "E";
		this.ptsattaque = 50;
		this.durabilité = 100;
	}

	@Override
	public int getdura() { return this.durabilité; }
	@Override
	public String getNom() { return this.nom; }
	@Override
	public int getatt() { return this.ptsattaque; }

	@Override
	public void faculté(Monde t, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	
}
