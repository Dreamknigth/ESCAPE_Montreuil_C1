package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class SolBlock extends BlockDestructible{
	

	public SolBlock() {
		super(false, 10, "t");
		new TerreBlock(); 
	}

	@Override
	public Block faculté(Monde t, int x, int y) {
		System.out.println(this.getClass());
		Objet o =t.getJoueur().getObjetDansLaMain();
		if(o.getValeur().get()>0) {
			o.getValeur().set(o.getValeur().get()-1);
			t.getTerrain().setTerrain(new TerreBlock(), y, x);
			return new TerreBlock();
		}
		return null;
	}

}
