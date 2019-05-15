package ESCAPE_Montreuil_C1.Modele;

import ESCAPE_Montreuil_C1.Modele.Joueur.Joueur;

public class main {

	public static void main(String[] args) {
		 
		MapMaker m = new MapMaker();
		
		Joueur j1 = new Joueur(0, 0, "J");
		
		m.constructeurMap();
//		m.afficheTerrain();
	}
}