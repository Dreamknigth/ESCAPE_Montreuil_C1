package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Terre extends BlockDestructible{

	public Terre(int x,int y,Ressource drop,int solidite,char nom) {
		super(true, x, y,drop,10,'T');
	}
	
}
