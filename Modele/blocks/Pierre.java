package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Pierre extends BlockDestructible{
	
	public Pierre(int x, int y) {
		super(false, x, y, new Ressource(), 50,'P');
	}
	public Pierre(Point position) {
		super(false,position, new Ressource(), 50,'P');
	}

}
