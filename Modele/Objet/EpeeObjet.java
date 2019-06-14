package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;

import ESCAPE_Montreuil_C1.Modele.map.Monde;


public class EpeeObjet extends ArmeObjet{

	public EpeeObjet() {
		super("e", 50, 100);

		this.ptsattaque = 50;
		this.durabilité = 100;
	}

	@Override
	public int getdura() { return this.durabilité; }
	@Override
	public String getNom() { return this.nom; }
	@Override
	public int getatt() { return this.ptsattaque; }

	@Override
	public Block faculté(Monde t, int x, int y) {
		for(int i=0 ;i<t.getEnnemiList().size();i++) {
			if(t.getEnnemiList().get(i).getHitBox().contains(x, y)){
				System.out.println(t.getEnnemiList().get(i).getPV());
				t.getEnnemiList().get(i).prendDegat(10);
				System.out.println(t.getEnnemiList().get(i).getPV());
			}
		}
		
		return t.getTerrain().getBlockTerrain(y, x);
	}

	
}
