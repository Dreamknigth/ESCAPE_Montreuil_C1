package ESCAPE_Montreuil_C1.Modele.Crafting;

import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.hache;
import ESCAPE_Montreuil_C1.Modele.Objet.lance;
import ESCAPE_Montreuil_C1.Modele.Objet.pioche;

public class Craft {
	
	public void craftingépée (Objet o, Inventaire in) {
		if (in.getnbObjet(in.getObjet("Fer")) > 0 && in.getnbObjet(in.getObjet("bois")) > 0) {
			lance ep = new lance();
			ep.setnb(1);
			in.getObjet("Fer").setnb(-10);
			in.getObjet("bois").setnb(-10);
			in.InAdd(ep);
			System.out.println(ep.getNom());
		}
		else {
			System.out.println("Error");
		}
	}
	
	public void craftinghache (Objet o, Inventaire in) {
		if (in.getnbObjet(in.getObjet("Fer")) > 0 && in.getnbObjet(in.getObjet("bois")) > 0) {
			hache hc = new hache();
			hc.setnb(1);
			in.getObjet("Fer").setnb(-10);
			in.getObjet("bois").setnb(-10);
			in.InAdd(hc);
			System.out.println(hc.getNom());
		}
		else {
			System.out.println("Error");
		}
	}
	
	public void craftinglance (Objet o, Inventaire in) {
		if (in.getnbObjet(in.getObjet("Fer")) > 0 && in.getnbObjet(in.getObjet("bois")) > 0) {
			lance lc = new lance();
			lc.setnb(1);
			in.getObjet("Fer").setnb(-10);
			in.getObjet("bois").setnb(-10);
			in.InAdd(lc);
			System.out.println(lc.getNom());
		}
		else {
			System.out.println("Error");
		}
	}
	
	public void craftingpioche (Objet o, Inventaire in) {
		if (in.getnbObjet(in.getObjet("Fer")) > 0 && in.getnbObjet(in.getObjet("bois")) > 0) {
			pioche pc = new pioche();
			pc.setnb(1);
			in.getObjet("Fer").setnb(-10);
			in.getObjet("bois").setnb(-10);
			in.InAdd(pc);
			System.out.println(pc.getNom());
		}
		else {
			System.out.println("Error");
		}
	}

}
