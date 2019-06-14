package ESCAPE_Montreuil_C1.Vue;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Player extends VBox {
	//déclaration
	
	private IntegerProperty etat;
	private Label pvJoueur;
	private ImageView imagePlayer;
	private BooleanProperty versDroite;
	//R=Rien S=Saut T=Tomber C=Courrir
	//D=Droite G=Gauche
	private ImageView Imageperso; 
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
		this.Imageperso=new ImageView(this.persoRD);
		this.pvJoueur=new Label();
		this.getChildren().add(this.pvJoueur);
		this.getChildren().add(Imageperso);
		this.pvJoueur.setMinHeight(-this.pvJoueur.getHeight()-20);
		
		
		this.etat = new SimpleIntegerProperty(0);
		this.versDroite = new SimpleBooleanProperty(true);
		
		//Je n'ai pas le temps de faire les differentes images donc je met RD
		this.persoTD=this.persoRD;
		this.persoRG=this.persoRD;
		this.persoSG=this.persoRD;
		this.persoTG=this.persoRD;
	}
	
	//setter
	public void setCadre(boolean versDroite,int etat) {
		etat=etat%4;
		if(versDroite) {
			switch(etat) {
			case 0:this.Imageperso.setImage(persoRD);
			break;
			case 1:this.Imageperso.setImage(persoSD);
			break;
			case 2:this.Imageperso.setImage(persoTD);
			break;
			case 3:this.Imageperso.setImage(persoCD);
			break;
			default:this.Imageperso.setImage(persoRD);
			break;
			}
		}
		else {
			switch(etat) {
			case 0:this.Imageperso.setImage(persoRG);
			break;
			case 1:this.Imageperso.setImage(persoSG);
			break;
			case 2:this.Imageperso.setImage(persoTG);
			break;
			case 3:this.Imageperso.setImage(persoCG);
			break;
			default:this.Imageperso.setImage(persoRG);
			break;
			}
		}
	}
	//getter
	public ImageView getImagePerso() {
		return this.Imageperso;
	}
	public Label getPv() {
		return this.pvJoueur;
	}
}
