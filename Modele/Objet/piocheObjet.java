package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public class piocheObjet extends Outils{

	public piocheObjet() {
		super("P", 5, 100);
		this.nom="P";
		this.ptsattaque=5;
		this.durabilité=100;
	}

	@Override
	public int getatt() { return this.durabilité;}

	@Override
	public int getdura(){return this.ptsattaque;}

	@Override
	public String getNom() { return this.nom; }

	@Override
	public Block faculté(Monde t, int x, int y) {
		Block b=t.getTerrain().getTableTerrain().get(y).get(x);
		System.out.println(b.getNom());
		Objet o = t.getJoueur().getInventaire().chercher(b);
		if(o!=null && o.getValeur().get()+1<=20) {
			o.getValeur().set(o.getValeur().get()+1);
			t.getTerrain().setTerrain(new AirBlock(), y, x);
			return new AirBlock();
		}
		return null;
	}



}
