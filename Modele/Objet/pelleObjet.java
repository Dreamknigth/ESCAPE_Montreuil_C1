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
		super("L", 25);
	}

	@Override
	public String getNom() { return this.nom; }

	@Override
	public Block faculte(Monde t, int x, int y) {
		Block b=t.getTerrain().getTableTerrain().get(y).get(x); //le Block sur lequel on a cliquer
		if(b.egaux(new SolBlock())) { //si le block est du sol
			b=new TerreBlock(); //ajouter de la terre (sol = terre, mais les image sont differente pour le design)
		}
		else if(b.egaux(new TerreBlock()) || b.egaux(new boisBlock()) || b.egaux(new PierreBlock())) { //sinon si le block est de la terre du bois ou de la pierre
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
