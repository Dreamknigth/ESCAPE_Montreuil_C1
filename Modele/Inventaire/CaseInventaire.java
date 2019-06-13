package ESCAPE_Montreuil_C1.Modele.Inventaire;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CaseInventaire {// case inventaire peut etre vu comme un Rengement(meuble permettant d'organiser)
	private ObservableList<Objet> caseInv;
	private int limiteNbObjetSac=20;//le nombre d'objet dans une partie du sac
	//constructeur
	public CaseInventaire(ObservableList<Objet> caseInv) {
		this.caseInv = caseInv;
	}
	public CaseInventaire() {
		this.caseInv=FXCollections.observableArrayList();
	}
	//methode
	public boolean ajouterObjet(Objet unObjet) {
		if(this.caseInv.size()<this.limiteNbObjetSac) {
			this.caseInv.add(unObjet);
			return true;
		}
		return false;
	}
	
	public Objet typeDeRengement() {
		return this.caseInv.get(0);
	}
	public int tailleRengement() {
		return this.caseInv.size();
	}

	public ObservableList<Objet> getCaseInv() {
		return caseInv;
	}

	public void setCaseInv(ObservableList<Objet> caseInv) {
		this.caseInv = caseInv;
	}
	
}
