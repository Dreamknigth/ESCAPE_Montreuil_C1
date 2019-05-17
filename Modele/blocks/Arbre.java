package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Point;

public class Arbre extends BlockDestructible{

	public Arbre(Point position) {
		super(true,position,new Ressource(),20,'a');
	}
	
}
