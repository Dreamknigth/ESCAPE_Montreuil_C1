package ESCAPE_Montreuil_C1.Modele;

public class Essai {
	public static void main (String [] args) {
		MapMaker mpc = new MapMaker();
		mpc.constructeurMap();
		
		System.out.println("\nAffichage:");
		mpc.afficheTerrain();
	}
}
