package ESCAPE_Montreuil_C1.Modele;

import ESCAPE_Montreuil_C1.Modele.map.MapReader;

public class Essai {
	public static void main (String [] args) {
		MapReader mpc = new MapReader();
		mpc.constructeurMap();
		
		System.out.println("\nAffichage:");
		mpc.afficheTerrain();
	}
}
