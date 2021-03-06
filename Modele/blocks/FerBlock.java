package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class FerBlock extends Block{
	public FerBlock() {
		super(false,"I");
	}
	@Override
	public Block faculte(Monde t,int x,int y) {
		Objet o =t.getJoueur().getObjetDansLaMain(); // on recupere l'objet sur lequel on clique
		if(o.getValeur().get()>0) {					 // si l objet est present dans l inventaire (valeur superieur a 0)
			o.getValeur().set(o.getValeur().get()-1);// on soustrait 1
			t.getTerrain().setDansTerrain(new FerBlock(), y, x);// on le place dans la map
			return new FerBlock();
		}
		return null;
		
	}
}
