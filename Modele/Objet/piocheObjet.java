package ESCAPE_Montreuil_C1.Modele.Objet;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Inventaire.CaseInventaire;
import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.collections.ObservableList;

public class piocheObjet extends Outils{

	public piocheObjet() {
		super("P", 5, 100);
		this.nom="P";
		this.ptsattaque=5;
		this.durabilité=100;
	}

	@Override
	public int getatt() { return this.durabilité;}

	@Override
	public int getdura(){return this.ptsattaque;}

	@Override
	public String getNom() { return this.nom; }

	@Override
	public Block faculté(Monde t, int x, int y) {
		Objet b=t.getTerrain().getTableTerrain().get(y).get(x);
		ObservableList< CaseInventaire > inventaire=t.getJoueur().getInventaire().getListeInventaire();
		int placeDansSac = t.getJoueur().getInventaire().objetEstPresent(b);
		if(placeDansSac>=0 ) {
			if(inventaire.get(placeDansSac).getCaseInv().get(0).egaux( new boisBlock() ) || inventaire.get(placeDansSac).getCaseInv().get(0).egaux( new TerreBlock() )) {
				inventaire.get(placeDansSac).ajouterObjet(b);
				AirBlock a =new AirBlock();
				t.getTerrain().setTerrain(a, y, x);
				return a;
			}
		}
		return null;
	}

}
