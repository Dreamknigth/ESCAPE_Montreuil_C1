package ESCAPE_Montreuil_C1.Modele.Personnage;

import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public abstract class Ennemy extends Personnage{

	public Ennemy(int x, int y, String nom, Terrain leTerrain) {
		super(x, y, nom, leTerrain);
	}
	
	public abstract void seDeplacer(Personnage p);
	
	public boolean faireDegat (Joueur j) {// a=y souris b=x souris
		if ((j.getY().getValue() == (this.y.getValue())) && (j.getX().getValue() == this.x.getValue())){
			
			return true;	
		}
		return false;
	}
}