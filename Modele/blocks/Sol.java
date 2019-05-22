package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Terre;

public class Sol extends BlockDestructible{

	public Sol() {
		super(false, new Terre(), 10, 't');
	}

}
