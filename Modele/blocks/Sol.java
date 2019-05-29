package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.TBlock;

public class Sol extends BlockDestructible{
	
	private TBlock  t;

	public Sol() {
		super(false, 10, 't');
		this.t = new TBlock(); 
	}

}
