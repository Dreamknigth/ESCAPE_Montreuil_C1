package ESCAPE_Montreuil_C1.Modele.Inventaire;


import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
	
	private ObservableList<Objet> ob ;
	
	public Inventaire(){
		this.ob = FXCollections.observableArrayList();
	}
}
