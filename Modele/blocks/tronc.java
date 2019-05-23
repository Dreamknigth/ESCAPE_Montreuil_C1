package ESCAPE_Montreuil_C1.Modele.blocks;

import ESCAPE_Montreuil_C1.Modele.Objet.Ressource;
import ESCAPE_Montreuil_C1.Modele.Objet.Terre;

public class tronc extends BlockDestructible{
	
	private Terre t;

	public tronc() {
		super(true, 10, 'F');
		this.t = new Terre();
	}
}
