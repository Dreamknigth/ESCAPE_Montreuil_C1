package ESCAPE_Montreuil_C1.Vue;

import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.Personnage.EnnemiModele;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class EnnemiVue {
	public static Image Cochon = new Image ("ESCAPE_Montreuil_C1/source/PNJ/Cochon_Mouvement.gif");
	public static Image Oiseau = new Image ("ESCAPE_Montreuil_C1/source/PNJ/oiseau.gif");
	public static Image llama = new Image ("ESCAPE_Montreuil_C1/source/PNJ/llama.gif");
	public static Image Cannibale = new Image ("ESCAPE_Montreuil_C1/source/PNJ/Cannibale.gif");
	private ArrayList<ImageView> img;
	
	public EnnemiVue() {
		this.img = new ArrayList<>();
	}
	
	public void addImgEnnemi(ObservableList<EnnemiModele> observableList) {
		for (int i = 0; i<observableList.size(); i++ ){
			if (observableList.get(i).getNom() == "Cochon") {
				this.img.add(new ImageView(Cochon));
				this.img.get(i).setFitHeight(80);
				this.img.get(i).setFitWidth(64);
				}
			else if (observableList.get(i).getNom() == "Oiseau") {
				this.img.add(new ImageView(Oiseau));
				this.img.get(i).setFitWidth(64);
				this.img.get(i).setFitHeight(64);
			}
			else if (observableList.get(i).getNom() == "llama") {
				this.img.add(new ImageView(llama));
				this.img.get(i).setFitHeight(80);
				this.img.get(i).setFitWidth(64);
			}
			else if (observableList.get(i).getNom() == "Cannibale") {
				this.img.add(new ImageView(Cannibale));
				this.img.get(i).setFitHeight(80);
				this.img.get(i).setFitWidth(64);
			}
		}
		
	}
	
	public ArrayList<ImageView> getImageList(){
		return img;
	}
}
