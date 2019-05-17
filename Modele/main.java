package ESCAPE_Montreuil_C1.Modele;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;

public class main {

	public static void main(String[] args) {
		 
		MapMaker m = new MapMaker();
		m.constructeurMap();
		ArrayList<ObservableList <Block>> terrain=m.charToBlock();
		Joueur j1 = new Joueur(0,0,"nom",terrain);
		
		m.constructeurMap();
//		m.afficheTerrain();
	}
}