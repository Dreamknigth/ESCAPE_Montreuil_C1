package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class feuilleBlock extends Block {
	//constructeur
	public feuilleBlock() {
		super(true, "f");
		new boisBlock();
	}
	
	//methode
	@Override
	public Block faculte(Monde t, int x, int y) {
		return null;
	}

}
