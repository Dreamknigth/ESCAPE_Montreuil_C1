package ESCAPE_Montreuil_C1.Modele.Objet;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;

import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
import ESCAPE_Montreuil_C1.Modele.map.Monde;



public class hacheObjet extends Outils{

	public hacheObjet() {
		super("H", 5);

	}

	@Override
	public String getNom() { return this.nom; }
/**
 * une hache a la capacite de creuser et
 * d'attaquer
 */
	@Override
	public Block faculte(Monde t, int x, int y) {
		Block b=t.getTerrain().getTableTerrain().get(y).get(x);
		if( !b.egaux(new AirBlock()) ) { // si l'objet selectionner n'est pas de l'aire
			if(b.egaux(new boisBlock()) || b.egaux(new FerBlock())) { // si c'est du bois ou du fer
																		// on creuse
				Objet o = t.getJoueur().getInventaire().recherche(b);
				if(o!=null && o.getValeur().get()+1<=32){
					o.getValeur().set( o.getValeur().get()+1 );
					t.getTerrain().setDansTerrain(new AirBlock(), y, x);
					return new AirBlock();
				}
			}
		}
		else {// sinon (c'est de l air )
			
			for(int i=0 ;i<t.getEnnemiList().size();i++) {
				if(t.getEnnemiList().get(i).getHitBox().contains(x, y)){ //on verifie la presence d un ennemi 
					t.getEnnemiList().get(i).prendDegat(10);// on attaque
				}
			}
		}
		return b;
	}

}
