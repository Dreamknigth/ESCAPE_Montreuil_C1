package ESCAPE_Montreuil_C1.Modele.Personnage;


import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import com.sun.javafx.geom.Rectangle;

import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	protected IntegerProperty x,y; //coordonnee
	private Rectangle hitBox; //la hit box du perso
	
	protected String nom;
	protected IntegerProperty pv;
	private int ptAttaque;
	//private Inventaire lInventaire;
	private BooleanProperty versDroite;//etat vas permettre de definir la direction
	private IntegerProperty etat;//etat vas permettre de definir l'etat
	private int etatSaut=0;
	private int hauteurSaut=3;
	
	protected Terrain leTerrain;//terrain qui possedent une observable liste
	//TODO private objet objetMain;
	
	//Constructeur
	public Personnage(int x,int y,String nom,Terrain leTerrain) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.hitBox = new Rectangle(x,y,1,2);
		this.etat = new SimpleIntegerProperty(0); //0=rien 1=sauter 2=tomber 3=courrir
		this.versDroite = new SimpleBooleanProperty(true); //true=va a Droite false=va a gauche
		this.pv= new SimpleIntegerProperty(100);
		this.leTerrain=leTerrain;
		this.nom=nom;
	}
	public Personnage(String pseudo,Terrain leTerrain) {
		this(0,0,pseudo,leTerrain);
	}
	public Personnage(Terrain leTerrain) {
		this(" ",leTerrain);
	}
	
	
	//Methodes
	public void prendDegat(int ptDegat) {
		this.pv.set(this.pv.getValue()- ptDegat);
		if(this.pv.getValue()<=0) {
			this.pv.set(0);
			System.out.println("You're DEAD!");
		}
	}
	
	//seDeplacer
	//Rappel:
	//0=Rien 1=Saut 2=Tomber 3=Courrir
	//VersDroite=true=droite VersDroite=false=gauche
	public void seDeplacer(){
		this.etat.setValue( this.etat.getValue()%4 ); //petit verife
		if( this.etatSaut>0 ) {
			this.etatSaut++;
			this.etatSaut = this.etatSaut%(this.hauteurSaut+1); //verife apres saut
			if(this.etatSaut<this.hauteurSaut) {
				seDeplacerHaut();
			}
			case3();
		}
		else {
			if( !seDeplacerBas() ) {
				switch( this.etat.getValue() ) {
				case 0://rien
					break;
				case 1:
					this.etatSaut++;
					seDeplacerHaut();
					break;
				default:
					case3();
					break;
				}
			}
			else {
				case3();
			}
		}
	}
	
	private void case3() {
		if(this.etat.getValue()==3) {
			if(this.versDroite.getValue()) {
				seDeplacerDroite();
			}
			else {
				seDeplacerGauche();
			}
		}
	}
	
	//Gauche
	protected boolean seDeplacerGauche() { //y=i x=j
		this.versDroite.setValue(false);
		if(this.x.getValue()>=1  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) ).get( (int)(double)(this.x.getValue()-1) ).getTraversable()  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()+1) ).get( (int)(double)(this.x.getValue()-1) ).getTraversable()) {
			this.x.setValue(this.x.getValue()-1);
			return true;
		}
		this.etat.setValue(0);
		return false;
	}
	//Droite
	protected boolean seDeplacerDroite() { //y=i x=j
		this.versDroite.setValue(true);
		if(this.x.getValue()<this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) ).size()-1  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) ).get( (int)(double)(this.x.getValue()+1) ).getTraversable()  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()+1) ).get( (int)(double)(this.x.getValue()+1) ).getTraversable()) {
			this.x.setValue(this.x.get()+1);
			return true;
		}
		this.etat.setValue(0);
		return false;
	}
	//haut
	protected boolean seDeplacerHaut() {
		if(this.y.getValue()>=2 && this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()-1) ).get( (int)(double)(this.x.getValue()) ).getTraversable()) {
			this.y.setValue(this.y.get()-1);
			return true;
		}
		return false;
	}
	//bas
	public boolean seDeplacerBas() {
		if(this.y.getValue()<this.leTerrain.getTableTerrain().size()-2 && this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()+2) ).get( (int)(double)(this.x.getValue()) ).getTraversable()) {
			this.y.setValue(this.y.get()+1);
			return true;
		}
		return false;
	}
	//graviter
//	private void seDeplacerGraviter() {
//		if(this.seDeplacerBas()) {
//			this.seDeplacerGraviter();
//		}
//	}
	
	//getter
	public String getNom() {
		return this.nom;
	}
	public IntegerProperty getX() {
		return x;
	}
	public IntegerProperty getY() {
		return y;
	}
	public IntegerProperty getEtat() {
		return this.etat;
	}
	public BooleanProperty getVersDroite() {
		return this.versDroite;
	}
	public int getEtatSaut() {
		return this.etatSaut;
	}
	public IntegerProperty getPV() {
		return this.pv;
	}
	//setter
	public void setX(int a) {
		this.x.setValue(a);
	}
	public void setY(int a) {
		this.y.setValue(a);
	}
	public Rectangle getHitBox() {
		return this.hitBox;
	}
	
}