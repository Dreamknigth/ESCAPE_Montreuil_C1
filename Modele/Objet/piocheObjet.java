package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class piocheObjet extends Outils{

	public piocheObjet() {
		super("p", 5);
	}

	@Override
	public String getNom() { return this.nom; }
	
	@Override
	public Block faculte(Monde t, int x, int y) { //les commentaire sont les meme que pour la hache a l exception des block que l ont peut casser
		Block b=t.getTerrain().getTableTerrain().get(y).get(x);
		if(b.egaux(new PierreBlock()) || b.egaux(new FerBlock())) {
			Objet o = t.getJoueur().getInventaire().recherche(b);
			if(o!=null && o.getValeur().get()+1<=32) {
				o.getValeur().set( o.getValeur().get()+1 );
				t.getTerrain().setDansTerrain(new AirBlock(), y, x);
				return new AirBlock();
			}
		}
		return b;
	}
}