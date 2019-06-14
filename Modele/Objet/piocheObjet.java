package ESCAPE_Montreuil_C1.Modele.Objet;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.SolBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class piocheObjet extends Outils{

	public piocheObjet() {
		super("p", 5, 100);
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
		if(b.egaux(new PierreBlock()) || b.egaux(new FerBlock())) {
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