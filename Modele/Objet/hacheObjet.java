package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.SolBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
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
		Block b=t.getTerrain().getTableTerrain().get(y).get(x);
		if( !b.egaux(new AirBlock()) ) {
			if(b.egaux(new boisBlock()) || b.egaux(new FerBlock())) {
				Objet o = t.getJoueur().getInventaire().recherche(b);
				if(o!=null && o.getValeur().get()+1<=32){
					o.getValeur().set( o.getValeur().get()+1 );
					t.getTerrain().setTerrain(new AirBlock(), y, x);
					return new AirBlock();
				}
			}
		}
		else {
			for(int i=0 ;i<t.getEnnemiList().size();i++) {
				if(t.getEnnemiList().get(i).getHitBox().contains(x, y)){
					t.getEnnemiList().get(i).prendDegat(10);
				}
			}
		}
		return b;
	}

}
