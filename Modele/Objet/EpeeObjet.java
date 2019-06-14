package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;

import ESCAPE_Montreuil_C1.Modele.map.Monde;


public class EpeeObjet extends ArmeObjet{
	//constructeur
	public EpeeObjet() {
		super("e", 50);

		this.ptsattaque = 50;
	}
	
	//methode
	@Override
	public Block faculte(Monde t, int x, int y) {
		for(int i=0 ;i<t.getEnnemiList().size();i++) {
			if(t.getEnnemiList().get(i).getHitBox().contains(x, y)){// on verifie la presence d un ennemi
				t.getEnnemiList().get(i).prendDegat(10);			// on attaque
			}
		}
		
		return t.getTerrain().getBlockTerrain(y, x);
	}
	
	//getter
	@Override
	public String getNom() { return this.nom; }
}
