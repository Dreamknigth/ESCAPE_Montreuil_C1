package ESCAPE_Montreuil_C1.Modele.Crafting;

import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.Objet.EpeeObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.hacheObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.pelleObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.piocheObjet;
import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;

public class Craft {
	private Inventaire lInventaire;
	public Craft(Inventaire inv) {
		this.lInventaire=inv;
	}


	public void craftingEpee() {
		if(this.lInventaire.recherche( new EpeeObjet() ).getValeur().getValue()==0) {
			if (this.lInventaire.recherche( new FerBlock() ).getValeur().getValue() >=5 && this.lInventaire.recherche( new boisBlock() ).getValeur().get() >=3) {
				Objet ep = this.lInventaire.recherche(new EpeeObjet());
				ep.getValeur().set( ep.getValeur().getValue()+1 );
				this.lInventaire.recherche( new FerBlock() ).getValeur().set( this.lInventaire.recherche( new FerBlock() ).getValeur().getValue()-5 );
				this.lInventaire.recherche( new boisBlock() ).getValeur().set(this.lInventaire.recherche( new boisBlock() ).getValeur().getValue()-3);
			}
		}
	}

	public void craftingHache () {
		if(this.lInventaire.recherche( new hacheObjet() ).getValeur().getValue()==0) {
			if (this.lInventaire.recherche( new PierreBlock() ).getValeur().getValue() >=3 && this.lInventaire.recherche( new boisBlock() ).getValeur().get() >=2) {
				Objet ep = this.lInventaire.recherche(new hacheObjet());
				ep.getValeur().set( ep.getValeur().getValue()+1 );
				this.lInventaire.recherche( new PierreBlock() ).getValeur().set( this.lInventaire.recherche( new PierreBlock() ).getValeur().getValue()-3 );
				this.lInventaire.recherche( new boisBlock() ).getValeur().set(this.lInventaire.recherche( new boisBlock() ).getValeur().getValue()-2);		}
		}
	}

	public void craftingPelle () {
		if(this.lInventaire.recherche( new pelleObjet() ).getValeur().getValue()==0) {

			System.out.println("okle debug");
			Objet ep = this.lInventaire.recherche(new pelleObjet());
			System.out.println(this.lInventaire.recherche(ep).getValeur().getValue());
			ep.getValeur().set( ep.getValeur().getValue()+1 );
		}
	}

	public void craftingPioche () {
		if(this.lInventaire.recherche( new piocheObjet() ).getValeur().getValue()==0) {

			if (this.lInventaire.recherche( new FerBlock() ).getValeur().getValue() >=3 && this.lInventaire.recherche( new boisBlock() ).getValeur().get() >=2) {
				Objet ep = this.lInventaire.recherche(new piocheObjet());
				ep.getValeur().set( ep.getValeur().getValue()+1 );
				this.lInventaire.recherche( new FerBlock() ).getValeur().set( this.lInventaire.recherche( new FerBlock() ).getValeur().getValue()-3 );
				this.lInventaire.recherche( new boisBlock() ).getValeur().set(this.lInventaire.recherche( new boisBlock() ).getValeur().getValue()-2);
			}
		}
	}

}
