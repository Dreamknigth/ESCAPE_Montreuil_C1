package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Ressource;
import ESCAPE_Montreuil_C1.Modele.Objet.TBlock;

public class tronc extends BlockDestructible{
	
	private TBlock t;

	public tronc() {
		super(true, 10, 'F');
		this.t = new TBlock();
	}
}
