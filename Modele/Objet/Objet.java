package ESCAPE_Montreuil_C1.Modele.Objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Objet {
	
	protected String nom;
	private IntegerProperty valeur;
	
	public Objet(String nom) {
		this.nom = nom;
		valeur  = new SimpleIntegerProperty(0);
	}
	
	public IntegerProperty getValeur() {
		return this.valeur;
	}

	
	public String getNom() {
		return this.nom;
	}
	
	
	

}
