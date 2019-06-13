package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public class lanceObjet extends ArmeObjet{

	public lanceObjet() {
		super("lance", 25, 100);
		this.nom = "L";
		this.ptsattaque = 25;
		this.durabilité = 100;
	}

	@Override
	public int getatt() { return this.ptsattaque;}

	@Override
	public int getdura() { return this.durabilité;}
	@Override
	public String getNom() { return this.nom; }

	@Override
	public Block faculté(Monde t, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
