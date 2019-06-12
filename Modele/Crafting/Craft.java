package ESCAPE_Montreuil_C1.Modele.Crafting;

import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.hacheObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.lanceObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.piocheObjet;

public class Craft {
	
	public void craftingépée (Objet o, Inventaire in) {
		if (in.getnbObjet(in.getObjet("Fer")) > 0 && in.getnbObjet(in.getObjet("bois")) > 0) {
			lanceObjet ep = new lanceObjet();
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
			hacheObjet hc = new hacheObjet();
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
			lanceObjet lc = new lanceObjet();
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
			piocheObjet pc = new piocheObjet();
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
