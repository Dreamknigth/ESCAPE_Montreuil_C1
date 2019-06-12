package ESCAPE_Montreuil_C1.Modele.Personnage;


import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	protected DoubleProperty x,y; //coordonnee
	protected String nom;
	protected int pv;
	private int ptAttaque;
	//private Inventaire lInventaire;
	private BooleanProperty versDroite;//etat vas permettre de definir la direction
	private IntegerProperty etat;//etat vas permettre de definir l'etat
	protected Terrain leTerrain;//terrain qui possedent une observable liste
	private double lePas=1.0;
	
	
	//Constructeur
	public Personnage(int x,int y,String nom,Terrain leTerrain) {
		this.x = new SimpleDoubleProperty(x);
		this.y = new SimpleDoubleProperty(y);
		this.etat = new SimpleIntegerProperty(0); //0=rien 1=sauter 2=tomber 3=courrir
		this.versDroite = new SimpleBooleanProperty(true); //true=va a Droite false=va a gauche

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
		this.pv=this.pv-ptDegat;
		if(this.pv<=0) {
			this.pv=0;
			System.out.println("You're DEAD!");
		}
	}
	
	//Gauche
	public boolean seDeplacerGauche() { //y=i x=j
		this.versDroite.setValue(false);
		if(this.x.getValue()>=1  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) ).get( (int)(double)(this.x.getValue()-lePas) ).getTraversable()  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()+1) ).get( (int)(double)(this.x.getValue()-lePas) ).getTraversable()) {
			this.x.setValue(this.x.get()-lePas);
			this.etat.set(3);
			return true;
		}
		return false;
	}
	//Droite
	public boolean seDeplacerDroite() { //y=i x=j
		this.versDroite.setValue(true);
		if(this.x.getValue()<this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) ).size()-1  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()) ).get( (int)(double)(this.x.getValue()+lePas) ).getTraversable()  &&  this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()+1) ).get( (int)(double)(this.x.getValue()+lePas) ).getTraversable()) {
			this.x.setValue(this.x.get()+lePas);
			this.etat.set(3);
			return true;
		}
		return false;
	}
	//haut
	protected boolean seDeplacerHaut() {
		if(this.y.getValue()>=2 && this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()-lePas) ).get( (int)(double)(this.x.getValue()) ).getTraversable()) {
			this.y.setValue(this.y.get()-lePas);
			this.etat.set(1);
			return true;
		}
		return false;
	}
	//bas
	public boolean seDeplacerBas() {
		if(this.y.getValue()<this.leTerrain.getTableTerrain().size()-2 && this.leTerrain.getTableTerrain().get( (int)(double)(this.y.getValue()+1+lePas) ).get( (int)(double)(this.x.getValue()) ).getTraversable()) {
			this.y.setValue(this.y.get()+lePas);
			this.etat.set(2);
			return true;
		}
		this.etat.set(0);
		return false;
	}
	//graviter
	public void seDeplacerGraviter() {
		if(this.seDeplacerBas()) {
			this.seDeplacerGraviter();
		}
	}
	
	//getter
	public String getNom() {
		return this.nom;
	}
	public DoubleProperty getX() {
		return x;
	}
	public DoubleProperty getY() {
		return y;
	}
	public IntegerProperty getEtat() {
		return this.etat;
	}
	public BooleanProperty getVersDroite() {
		return this.versDroite;
	}
	//setter
	public void setX(int a) {
		this.x.set(a);
	}
	public void setY(int a) {
		this.y.set(a);
	}
	
}