package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class AirBlock extends Block {
	//constructeur
	public AirBlock() {
		super(true,"A");
	}
	
	//methode
	/**
	 * le Block air n a pas besoin de faculte car il ne se trouve pas dans l inventaire neanmoins
	 * il reste necessaire pour creer la map
	 */
	@Override
	public Block faculte(Monde t, int x, int y) {
		
		return null;
	}
}
