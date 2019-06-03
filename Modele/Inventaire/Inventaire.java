package ESCAPE_Montreuil_C1.Modele.Inventaire;


import ESCAPE_Montreuil_C1.Modele.Objet.Air;
import ESCAPE_Montreuil_C1.Modele.Objet.Fer;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.Terre;
import ESCAPE_Montreuil_C1.Modele.Objet.bois;
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

	public String transforme_Char_En_String(char a){
		if(a=='A') {
			return "Air";
		}
		else if(a=='f'){
			return "bois";
		}
		else if (a== 'F') {
			return "bois";
		}
		else if (a == 't'){
			return "Terre";
		}
		else if (a == 'T') {
			return "Terre";
		}
		return null;

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
	public boolean minerPossible(Objet o) {
		if(o!=null && o.getValeur().get()+1<=10) {
			o.getValeur().set(o.getValeur().get()+1);
			System.out.println("minerPossible "+o.getNom());
			return true;
		}
		return false;
	}

	public boolean creerPossible(Objet o) {
		if(o!=null && o.getValeur().get()-1>=0) {
			o.getValeur().set(o.getValeur().get()-1);
			System.out.println("creerPossible "+o.getNom());
			return true;
		}
		return false;
	}






}




