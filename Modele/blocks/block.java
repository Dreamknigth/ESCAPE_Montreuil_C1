package ESCAPE_Montreuil_C1.Modele.blocks;

import java.awt.Image;

public abstract class block {
	
	protected boolean estDestructible;
	protected boolean estTraversable;
	protected String nom;
	protected int resistance;
	protected Image img;
	public block (boolean estDestructible,boolean estTraversable, String nom, int resistance) {
		 this.estDestructible= estDestructible;
		 this.estTraversable= estTraversable;
		 this.nom = nom;
		 this.resistance = resistance;
	 }
	
	
	
	 
}
