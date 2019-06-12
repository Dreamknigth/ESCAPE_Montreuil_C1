package ESCAPE_Montreuil_C1.Modele.Objet;

import javax.swing.text.html.BlockView;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

abstract class RessourceObjet extends Objet{
	//private Block leTas;
	//private int nombre;
	public RessourceObjet(String nom) {
		super(nom);
		
	}

	abstract public Block faculté(Monde t, int x, int y) ;

	

	/*public boolean creerPossible(Objet o) {
	}*/

	/*@Override
	public Block faculté(Monde t,int x,int y) {
		System.out.println(this.getClass());
		Objet o =t.getJoueur().getObjetDansLaMain();
		if(o.getValeur().get()>0) {
			o.getValeur().set(o.getValeur().get()-1);
			t.getTerrain().setTerrain(new TerreBlock(), y, x);
		}
		return new TerreBlock();
		
	}*/


}
