package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Terre;

public class Sol extends BlockDestructible{
	
	private Terre  t;

	public Sol() {
		super(false, 10, 't');
		this.t = new Terre(); 
	}

}
