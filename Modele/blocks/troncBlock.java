package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class troncBlock extends BlockDestructible{
	

	public troncBlock() {
		super(true, 10, "F");
	}

	@Override
	public Block faculté(Monde t, int x, int y) {
		System.out.println(this.getClass());
		Objet o =t.getJoueur().getObjetDansLaMain();
		if(o.getValeur().get()>0) {
			o.getValeur().set(o.getValeur().get()-1);
			t.getTerrain().setTerrain(new TerreBlock(), y, x);
			return new boisBlock();
		}
		return null;
	}
}
