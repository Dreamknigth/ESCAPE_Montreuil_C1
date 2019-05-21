package ESCAPE_Montreuil_C1.Modele.map;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;

public class Terrain {
	private ArrayList<ObservableList <Block>> terrain;
	
	//Constructeur
	public Terrain() {
		MapReader mr=new MapReader();
		mr.constructeurMap();
		this.terrain=mr.getTerrain();
	}
	
	//getter
	public ArrayList<ObservableList <Block>> getTerrain() {
		return this.terrain;
	}
}
