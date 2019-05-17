package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Terre extends BlockDestructible{

	public Terre(int x,int y) {
		super(false, x, y,new Ressource(),10,'T');
	}
	
}
