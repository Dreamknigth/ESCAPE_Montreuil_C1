package ESCAPE_Montreuil_C1.Modele.map;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.Personnage.Personnage;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Monde {
	private Terrain leTerrain;
	private Joueur leJoueur;
	private ObservableList<Personnage> Ennemi;
	
	//constructeur
	public Monde() {
		MapReader mr=new MapReader();
		mr.constructeurMap();
		this.leTerrain=new Terrain(mr.getTerrain());
		this.leJoueur=new Joueur(5,23,"pseudo",this.leTerrain);
		this.Ennemi = FXCollections.observableArrayList();
	}
	
	//methode
	
	//getter
	public Terrain getTerrain() {
		return this.leTerrain;
	}
	public Joueur getJoueur() {
		return this.leJoueur;
	}
	public ObservableList<Personnage> getEnnemiList(){
		return this.Ennemi;
	}
	
	public void graviterEnnemi() {
		for (int i = 0; i < this.Ennemi.size()-1;i++) {
			this.Ennemi.get(i).seDeplacerBas();
		}
	}
	public void DepEnnemi() {
		for (int i = 0; i < this.Ennemi.size()-1;i++) {
			this.Ennemi.get(i).seDeplacer();
		}
	}
}
