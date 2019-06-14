package ESCAPE_Montreuil_C1.Modele.Personnage;

import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public abstract class Ennemy extends Personnage{

	public Ennemy(int x, int y, String nom, Terrain leTerrain) {
		super(x, y, nom, leTerrain);
	}
	
	public abstract void seDeplacer(Personnage p);

}
