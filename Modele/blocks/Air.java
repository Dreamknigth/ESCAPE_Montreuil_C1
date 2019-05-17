package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Air extends Block {

	public Air(boolean estTraversable,int x,int y) {
		super(estTraversable,new Point(x,y),'A');
	}
	public Air(boolean estTraversable,Point position) {
		super(estTraversable,position,'A');
	}
}
