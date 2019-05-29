package ESCAPE_Montreuil_C1.Modele.Inventaire;


import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
	
	private ObservableList<Objet> ob ;
	
	public Inventaire(){
		this.ob = FXCollections.observableArrayList();
	}
	
	public void InAdd(Objet e) {
		this.ob.add(e);
	}
	
	public Objet getObjet(String e) {
		int i = 0;
		while ((i < this.ob.size() && !this.ob.get(i).getNom().equals(e))){	
			i++;
		}
		return this.ob.get(i);
	}
	
	public int getnbObjet(Objet e) {
		int nb = 0;
		for (int i=0; i < this.ob.size(); i++) {
			if (this.ob.get(i).equals(e)) {
				nb = nb+this.ob.get(i).getnb();
			}
		}
		return nb;
	}
}
