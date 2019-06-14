package ESCAPE_Montreuil_C1.Modele.Personnage;

import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public abstract class EnnemiModele extends Personnage{
	
	// Constructeur

	public EnnemiModele(int x, int y, String nom, Terrain leTerrain) {
		super(x, y, nom, leTerrain);
	}
	
	//Méthodes
	// Les déplacements sont différents pour chaque ennemi
	
	public abstract void seDeplacer(Personnage p);
	
	/**
	 * return vrai si le ennemi se trouve aux même coordonnées que le joueur
	 * prit en paramètre
	 */
	public boolean faireDegat (Joueur j) {
		if ((j.getY().getValue() == (this.y.getValue())) && (j.getX().getValue() == this.x.getValue())){
			
			return true;	
		}
		return false;
	}
}