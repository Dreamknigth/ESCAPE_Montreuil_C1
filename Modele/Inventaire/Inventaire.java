package ESCAPE_Montreuil_C1.Modele.Inventaire;


import ESCAPE_Montreuil_C1.Modele.Objet.Air;
import ESCAPE_Montreuil_C1.Modele.Objet.Fer;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.Terre;
import ESCAPE_Montreuil_C1.Modele.Objet.bois;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList<Objet> ob ;
	private Terrain a;
	
	public Inventaire() {
		MapReader mr=new MapReader();
		mr.constructeurMap();
		this.a=new Terrain(mr.getTerrain());
		this.ob = FXCollections.observableArrayList();
		this.ob.add(new Air());
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

	public Objet chercher(String a) {
		int i =0;
		while(i<this.ob.size()) {
			if(this.ob.get(i).getNom()!=null && this.ob.get(i).getNom().equals(a)) {
				System.out.println("recherche " + a);
				return this.ob.get(i);
			}
			i++;
		}
		return null;
	}
	public boolean minerPossible(Block b) {
		Objet o =transforme_Block_en_Objet(b);
		if(o!=null && o.getValeur().get()+1<=200000000) {
			o.getValeur().set(o.getValeur().get()+1);
			System.out.println("minerPossible "+o.getNom());
			return true;
		}
		return false;
	}

	public boolean creerPossible(Block b) {
		Objet o = transforme_Block_en_Objet(b);
		if(o!=null && o.getValeur().get()-1>=-30) {
			o.getValeur().set(o.getValeur().get()-1);
			System.out.println("creerPossible "+o.getNom());
			return true;
		}
		return false;
	}
	
	public Objet transforme_Block_en_Objet(Block b) {
		if(b.getNom()=='A') {
			return this.ob.get(0);
		}
		else if(b.getNom()=='t' || b.getNom()=='T') {
				return this.ob.get(1);
		}
		else if(b.getNom()=='f' || b.getNom()=='F'|| b.getNom()=='B') {
			return this.ob.get(2);
		}
		return null;
		
	}






}




