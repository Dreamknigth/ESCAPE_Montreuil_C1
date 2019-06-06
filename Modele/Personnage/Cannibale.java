package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class Cannibale extends Personnage{
	private static int i =0;
	public Cannibale(int x,int y,Terrain leTerrain) {
		super(x,y,"Cannibale",leTerrain);
	}
	private boolean versDroite=true;
	@Override
	public void seDeplacer() {
		//TODO condition + code + appel methode algo graphe
		
		if (Math.random()>0.8) {
			this.seDeplacerHaut();
		}
		
		if (this.x.getValue()<this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) )
				.size()-1  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) )
				.get( (int)(double)(this.x.getValue()+1) ).getTraversable()  &&  this.leTerrain.getTableTerrain()
				.get( (int)(double)(this.y.getValue()+1) ).get( (int)(double)(this.x.getValue()+1) ).getTraversable() && versDroite){
			
			
				this.seDeplacerDroite();
		}
	
		else if (this.x.getValue()>=1  && this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()))
				.get( (int)(double)(this.x.getValue()-1) ).getTraversable()  &&  this.leTerrain.getTableTerrain()
				.get( (int)(double)(this.y.getValue()+1) ).get( (int)(double)(this.x.getValue()-1) ).getTraversable() && !versDroite) {
				this.seDeplacerGauche();
				
				
				
		}
		else {
			versDroite=!versDroite;
		}
	}
}
