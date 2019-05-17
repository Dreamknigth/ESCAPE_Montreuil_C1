package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Fer extends BlockDestructible{
	
	public Fer(int x, int y) {
		super(false, x, y, new Ressource(), 50,'F');
	}
	public Fer(Point position) {
		super(false,position, new Ressource(), 50,'F');
	}

}
