package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.bois;

public class feuille extends BlockDestructible {
	
	private bois b;

	public feuille() {
		super(true, 10, 'f');
		this.b = new bois();
	}

}
