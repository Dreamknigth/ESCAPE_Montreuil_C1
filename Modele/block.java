package ESCAPE_Montreuil_C1.Modele;


public abstract class block {
	protected boolean estDestructible,estTraversable;
	public block (boolean estDestructible,boolean estTraversable) {
		 this.estDestructible= estDestructible;
		 this.estTraversable= estTraversable;
	 }
	
	 
}
