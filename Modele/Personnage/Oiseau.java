package ESCAPE_Montreuil_C1.Modele.Personnage;

import ESCAPE_Montreuil_C1.Modele.map.Terrain;

public class Oiseau extends Ennemy{

	public Oiseau(int x, int y, Terrain leTerrain) {
		super(x, y, "Oiseau", leTerrain);
	}
	private boolean versDroite=true;

	@Override
	public void seDeplacer(Personnage p) {
		
		if (p.getX().getValue() >= 52 && p.getX().getValue() <= 120) {
			if (this.x.getValue() < p.getX().getValue()) {
				this.seDeplacerDroite();
			}
			
			if (this.y.getValue() < p.getY().getValue()){
				this.seDeplacerBas();
			}
			
			if (this.x.getValue() > p.getX().getValue()) {
				this.seDeplacerGauche();
			}
			
			if (this.y.getValue() > p.getY().getValue()) {
				this.seDeplacerHaut();
			}
		}
		
		else {
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


}
