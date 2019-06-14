package ESCAPE_Montreuil_C1.Modele.Objet;


import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Objet {
	
	protected String nom;
	protected IntegerProperty ValeurObjet;
	
	
	public Objet(String nom2) {
		this.nom = nom2;
		this.ValeurObjet= new SimpleIntegerProperty(0);
		
	}

	
	public String getNom() {
		return this.nom;
	}
	
	public IntegerProperty getValeur() {
		return this.ValeurObjet;
	}
	
	
	public boolean egaux(Objet o){
		return (this.nom==o.getNom());
	}
	

	public abstract Block faculté(Monde t, int x, int y); 
}
