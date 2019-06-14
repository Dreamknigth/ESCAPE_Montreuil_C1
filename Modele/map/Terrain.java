package ESCAPE_Montreuil_C1.Modele.map;

import java.util.ArrayList;
import java.util.List;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;
import javafx.scene.Node;

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
	public Block getBlockTerrain(int i,int j) {
		return this.tableTerrain.get(i).get(j);
	}
	//setter
	public void setDansTerrain(Block b, int i, int j) {
		b.setID(this.tableTerrain.get(i).get(j).getID()); //Le block est modifier mais l'id reste le même
		this.tableTerrain.get(i).set( j, b);
	}
}
