package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class feuilleBlock extends BlockDestructible {
	
	public feuilleBlock() {
		super(true, 10, "f");
		new boisBlock();
	}

	@Override
	public Block faculté(Monde t, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
