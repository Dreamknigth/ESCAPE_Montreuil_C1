package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.map.Monde;

public class SolBlock extends BlockDestructible{
	

	public SolBlock() {
		super(false, 10, "t");
		new TerreBlock(); 
	}

	@Override
	public Block faculté(Monde t, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
