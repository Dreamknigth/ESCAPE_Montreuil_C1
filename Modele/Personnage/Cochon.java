package ESCAPE_Montreuil_C1.Modele.Personnage;

import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public class Cochon extends Ennemy{

	public Cochon(int x, int y, Terrain leTerrain) {
		super(x, y, "Cochon", leTerrain);
			
	}
	private boolean versDroite=true;


	@Override
	public void seDeplacer(Personnage p) {
		
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
