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

	private ObservableList< ObservableList<Objet> > sac ;
	private int limiteNbTasSac=10;	//le nombre de tas d'objet dans le sac
	private int limiteNbObjetSac=20;//le nombre d'objet dans une partie du sac
	
	public Inventaire() {
		/*MapReader mr=new MapReader();
		mr.constructeurMap();
		*/this.sac = FXCollections.observableArrayList();
		//this.ob.add(new AirBlock());
	}
	public ObservableList< ObservableList<Objet> > getListeInventaire () {
		return this.sac;
	}
	
	public boolean ajouterBlock(Block leBlock) {
		if(blockEstPresent(leBlock)<=0) {
			if(this.sac.get( blockEstPresent(leBlock) ).size()<this.limiteNbObjetSac) {
				this.sac.get( blockEstPresent(leBlock) ).add(leBlock);
				return true;
			}
			else {
				throw new Error("Vous ne pouvez pas avoir plus de "+this.sac.get( blockEstPresent(leBlock) ).get(0).getNom() );
			}
		}
		else {
			if(this.sac.size() < limiteNbTasSac) {
				this.sac.add( FXCollections.observableArrayList() );
				this.sac.get( this.sac.size()-1 ).add(leBlock);
				return true;
			}
			else {
				throw new Error("Different objet comble votre inventaire");
			}
		}
	}
	
	public int blockEstPresent(Block leBlock) {
		for(int i=0;i<this.sac.size();i++) {
			if (leBlock.egaux(this.sac.get(i).get(0))) {
				return i;
			}
		}
		return -1;
	}
	public boolean supprimerBlock(Block exampleASupr) {
		if( blockEstPresent(exampleASupr)>=0 ) {
			this.sac.get( blockEstPresent(exampleASupr) ).remove(0);
			return true;
		}
		return false;
	}
	
	/*public Objet chercher(Objet unObjet) {
		if (unObjet.getNom().equals("T") || unObjet.getNom().equals("t")) {
			return this.sac.get(0);
		}
		if (unObjet.getNom().equals("B") || unObjet.getNom().equals("Bois") || unObjet.getNom().equals("F") || unObjet.getNom().equals("f")) {
			return this.sac.get(1);
		}
		if (unObjet.getNom().equals("p")) {
			return this.sac.get(2);
		}
		return new AirBlock();
		
	}*/




}




