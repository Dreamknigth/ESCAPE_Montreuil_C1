package ESCAPE_Montreuil_C1.Modele.map;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class Monde {
	private Terrain leTerrain;
	private Joueur leJoueur;
	
	//constructeur
	public Monde() {
		MapReader mr=new MapReader();
		mr.constructeurMap();
		this.leTerrain=new Terrain(mr.getTerrain());
		this.leJoueur=new Joueur(0,0,"pseudo",this.leTerrain);
	}
	
	//methode
	
	//getter
	public Terrain getTerrain() {
		return this.leTerrain;
	}
	public Joueur getJoueur() {
		return this.leJoueur;
	}
}
