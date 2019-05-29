package ESCAPE_Montreuil_C1.Modele.Objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Objet {
	
	protected String nom;
	private IntegerProperty valeur;
	protected int nb;
	
	public Objet(String nom, int nb) {
		this.nom = nom;
		valeur  = new SimpleIntegerProperty(0);
		this.nb = nb;
	}
	
	public IntegerProperty getValeur() {
		return this.valeur;
	}

	
	public String getNom() {
		return this.nom;
	}
	
	public int getnb() {
		return this.nb;
	}
	public void setnb(int i) {
		this.nb=i;
	}
	
	
	

}
