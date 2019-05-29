package ESCAPE_Montreuil_C1.Vue;

import java.awt.Point;

import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
	private IntegerProperty etat;
	private BooleanProperty versDroite;
	//R=Rien S=Saut T=Tomber C=Courrir
	//D=Droite G=Gauche
	
	private static Image persoRD=new Image("ESCAPE_Montreuil_C1/source/Joueur_gif/Joueur_Rien_Droite.gif");//perso pas de mouvement
	private static Image persoCD=new Image("ESCAPE_Montreuil_C1/source/Joueur_gif/Joueur_Courrir_Droite.gif");//perso Droite
	private static Image persoSD=new Image("ESCAPE_Montreuil_C1/source/Joueur_gif/Joueur_Saut_Droite.gif");//perso definir la gif quand il saute
	private Image persoTD;//perso definir la gif quand il tombe
	
	private Image persoRG;
	private static Image persoCG=new Image("ESCAPE_Montreuil_C1/source/Joueur_gif/Joueur_Courrir_Gauche.gif");//perso Gauche
	private Image persoSG;
	private Image persoTG;
	
	//constructeur
	public Player(){
		super(new Image("ESCAPE_Montreuil_C1/source/Joueur_gif/Joueur_Rien_Droite.gif"));
		this.etat = new SimpleIntegerProperty(0);
		this.versDroite = new SimpleBooleanProperty(true);
		//debug
		this.persoTD=this.persoRD;
		this.persoRG=this.persoRD;
		this.persoSG=this.persoRD;
		this.persoTG=this.persoRD;
	}
	//TODO bind le player avec une variable a ajouter dans le modele.joueur qui definis sont état 
	
	//setter
	private void setCadre() {
		if(this.versDroite.getValue()) {
			switch(this.etat.getValue()) {
			case 0:this.setImage(persoRD);
			break;
			case 1:this.setImage(persoCD);
			break;
			case 2:this.setImage(persoSD);
			break;
			case 3:this.setImage(persoTD);
			break;
			default:this.setImage(persoRD);
			break;
			}
		}
		else {
			switch(this.etat.getValue()) {
			case 0:this.setImage(persoRG);
			break;
			case 1:this.setImage(persoCG);
			break;
			case 2:this.setImage(persoSG);
			break;
			case 3:this.setImage(persoTG);
			break;
			default:this.setImage(persoRG);
			break;
			}
		}
	}
	//getter
	public IntegerProperty getEtat() {
		return this.etat;
	}
	public BooleanProperty getVersDroite() {
		return this.versDroite;
	}
}
