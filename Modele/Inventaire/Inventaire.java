package ESCAPE_Montreuil_C1.Modele.Inventaire;


import ESCAPE_Montreuil_C1.Modele.Objet.Fer;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.Terre;
import ESCAPE_Montreuil_C1.Modele.Objet.bois;
import ESCAPE_Montreuil_C1.Modele.Objet.hache;
import ESCAPE_Montreuil_C1.Modele.Objet.lance;
import ESCAPE_Montreuil_C1.Modele.Objet.pioche;
import ESCAPE_Montreuil_C1.Modele.Objet.épée;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
	
	private ObservableList<Objet> ob ;
	
	public Inventaire(){
		this.ob = FXCollections.observableArrayList();
		this.ob.add(new Terre());
		this.ob.add(new bois());
		this.ob.add(new Fer());
		/*this.ob.add(new pioche());
		this.ob.add(new hache());
		this.ob.add(new lance());
		this.ob.add(new épée());*/
	}
	public ObservableList<Objet> getListeInventaire () {
		return this.ob;
	}
}