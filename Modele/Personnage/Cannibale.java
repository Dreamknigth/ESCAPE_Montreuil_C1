package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class Cannibale extends Ennemy{
	public Cannibale(int x,int y,Terrain leTerrain) {
		super(x,y,"Cannibale",leTerrain);
	}

	@Override
	public void seDeplacer(Personnage p) {
		// TODO Auto-generated method stub
		
	}
	
}
