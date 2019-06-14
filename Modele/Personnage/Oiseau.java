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
				this.x.set(this.x.getValue()+1);
			}
			
			if (this.y.getValue() < p.getY().getValue()) {
				this.y.set(this.y.getValue()+1);
			}
			
			if (this.x.getValue() > p.getX().getValue()) {
				this.x.set(this.x.getValue()-1);
			}
			
			if (this.y.getValue() > p.getY().getValue()) {
				this.y.set(this.y.getValue()-1);
			}
		}
	}


}
