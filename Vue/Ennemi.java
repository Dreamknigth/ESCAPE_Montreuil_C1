package ESCAPE_Montreuil_C1.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ennemi extends ImageView {
	private static Image Cannibale = new Image ("ESCAPE_Montreuil_C1/source/Joueur_gif/Megamanxrunning_droite.gif");
	
	public Ennemi () {
		super (Cannibale);
	}
}
