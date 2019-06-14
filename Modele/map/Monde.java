package ESCAPE_Montreuil_C1.Modele.map;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Personnage.Cochon;
import ESCAPE_Montreuil_C1.Modele.Personnage.EnnemiModele;
import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.Personnage.Oiseau;
import ESCAPE_Montreuil_C1.Modele.Personnage.Personnage;
import ESCAPE_Montreuil_C1.Modele.Personnage.llama;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Monde {
	//declaration
	private Terrain leTerrain;
	private Joueur leJoueur;
	private ObservableList<EnnemiModele> Ennemis;
	
	//constructeur
	public Monde() {
		MapReader mr=new MapReader();
		mr.constructeurMap();
		this.leTerrain=new Terrain(mr.getTerrain());
		this.leJoueur=new Joueur(5,23,"pseudo",this.leTerrain, 100);
		this.Ennemis = FXCollections.observableArrayList();
		
		this.Ennemis.add(new Cochon(1, 23, this.leTerrain));
		this.Ennemis.add(new Cochon(25, 22, this.leTerrain));
		this.Ennemis.add(new Cochon(40, 20, this.leTerrain));
		this.Ennemis.add(new Cochon(58, 24, this.leTerrain));
		this.Ennemis.add(new Cochon(243, 22,this.leTerrain));
		this.Ennemis.add(new llama(150, 46, this.leTerrain));
		this.Ennemis.add(new llama(217, 30, this.leTerrain));
		this.Ennemis.add(new llama(243, 38, this.leTerrain));
		this.Ennemis.add(new Oiseau(86, 19, this.leTerrain));
		this.Ennemis.add(new Oiseau(44, 11, this.leTerrain));
		this.Ennemis.add(new Oiseau(243, 38,this.leTerrain));
		
	}
	
	//methode
	public void graviterEnnemi() {
		for (int i = 0; i < this.Ennemis.size();i++) {
			if (this.Ennemis.get(i).getNom() != "Oiseau")
				this.Ennemis.get(i).seDeplacerBas();
		}
	}
	
	public void activationAttaque() {
		for (int i = 0; i < this.Ennemis.size();i++) {
			if (this.Ennemis.get(i).faireDegat(leJoueur)) {
				this.leJoueur.prendDegat(3);
			}
		}
	}

	public void deplaceEnnemi() {
		for (int i = 0; i < this.Ennemis.size();i++) {
			this.Ennemis.get(i).seDeplacer(leJoueur);
		}
	}
	
	//getter
	public Terrain getTerrain() {
		return this.leTerrain;
	}
	public Joueur getJoueur() {
		return this.leJoueur;
	}
	public ObservableList<EnnemiModele> getEnnemiList(){
		return this.Ennemis;
	}

}
