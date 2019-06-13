package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public class hacheObjet extends Outils{
	
	public hacheObjet() {
		super("H", 5, 100);
		this.nom = "H";
		this.ptsattaque = 5;
		this.durabilité = 100;
}

	@Override
	public int getatt() { return this.durabilité;}
	
	@Override
	public String getNom() { return this.nom; }

	@Override
	public int getdura(){return this.ptsattaque;}

	

	@Override
	public Block faculté(Monde t, int x, int y) {
		return null;
	}

}
