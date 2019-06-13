package ESCAPE_Montreuil_C1.Modele.Inventaire;


import java.beans.FeatureDescriptor;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;

import ESCAPE_Montreuil_C1.Modele.Objet.hacheObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.lanceObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.piocheObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.épéeObjet;
import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList< CaseInventaire > sac ;
	private int limiteNbTasSac=10;	//le nombre de tas d'objet dans le sac
	
	
	public Inventaire() {
		/*MapReader mr=new MapReader();
		mr.constructeurMap();
		*/this.sac = FXCollections.observableArrayList();
		//Pas le temps de tous coder donc on spawn avec une pioche
		CaseInventaire Rpioche = new CaseInventaire(); //Rengement pioche
		Rpioche.ajouterObjet( new piocheObjet() );
		this.sac.add(Rpioche);
		//this.ob.add(new AirBlock());
	}
	public ObservableList< CaseInventaire > getListeInventaire () {
		return this.sac;
	}
	
	public boolean ajouterObjet(Objet unObjet) {
		if(objetEstPresent(unObjet)<=0) {
			if(!this.sac.get( objetEstPresent(unObjet) ).ajouterObjet(unObjet)) {
				if(this.sac.size() < limiteNbTasSac) {
					CaseInventaire caseInv = new CaseInventaire();
					caseInv.ajouterObjet(unObjet);
					this.sac.add( caseInv );
					return true;
				}
				else {
					throw new Error("Different objet comble votre inventaire");
				}
			}
		}
		return false;
	}
	
	public int objetEstPresent(Objet unObjet) {
		for(int i=0;i<this.sac.size();i++) {
			if(this.sac.get(i).typeDeRengement().egaux(unObjet)) {
				return i;
			}
		}
		return -1;
	}
	public boolean supprimerBlock(Block exampleASupr) {
		if( objetEstPresent(exampleASupr)>=0 ) {
			this.sac.get( objetEstPresent(exampleASupr) ).getCaseInv().remove(0);
		}
		return false;
	}
	
	

	public int nbObjet(Objet unObjet) {
		if(objetEstPresent(unObjet)>=0) {
			return this.sac.get( objetEstPresent(unObjet) ).tailleRengement();
		}
		return -1;
	}
}





