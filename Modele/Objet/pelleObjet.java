package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.SolBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class pelleObjet extends ArmeObjet{

	public pelleObjet() {
		super("L", 25, 100);
	}

	@Override
	public int getatt() { return this.ptsattaque;}

	@Override
	public int getdura() { return this.durabilité;}
	@Override
	public String getNom() { return this.nom; }

	@Override
	public Block faculté(Monde t, int x, int y) {
		Block b=t.getTerrain().getTableTerrain().get(y).get(x);
		if(b.egaux(new TerreBlock()) || b.egaux(new SolBlock()) || b.egaux(new boisBlock()) || b.egaux(new PierreBlock())) {
			if(b.egaux(new SolBlock())) {
				b=new TerreBlock();
			}
			Objet o = t.getJoueur().getInventaire().recherche(b);
			if(o!=null && o.getValeur().get()+1<=32) {
				o.getValeur().set( o.getValeur().get()+1 );
				t.getTerrain().setTerrain(new AirBlock(), y, x);
				return new AirBlock();
			}
		}
		return b;
	}





}
