package ESCAPE_Montreuil_C1.Modele.map;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;

public class Terrain {
	private ArrayList<ObservableList <Block>> tableTerrain;
	
	//Constructeur
	public Terrain(ArrayList<ObservableList <Block>> leTerrain) {
		this.tableTerrain=leTerrain;
	}
	
	//getter
	public ArrayList<ObservableList <Block>> getTableTerrain() {
		return this.tableTerrain;
	}
}
