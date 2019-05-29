package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Terre extends BlockDestructible{
	
	private ESCAPE_Montreuil_C1.Modele.Objet.TBlock t;

	public Terre() {
		super(false,10,'T');
		this.t = new ESCAPE_Montreuil_C1.Modele.Objet.TBlock();
	}
	
}
