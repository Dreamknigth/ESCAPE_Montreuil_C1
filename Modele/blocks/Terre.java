package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Terre extends Block{

	public Terre(boolean traversable, int x, int y) {
		super(traversable, x, y);
	}

	public Terre(boolean traversable, Point position) {
		super(traversable, position);
	}
	
}
