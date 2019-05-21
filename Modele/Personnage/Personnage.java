package ESCAPE_Montreuil_C1.Modele.Personnage;


import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	protected IntegerProperty x,y; //coordonnee
	protected String nom;
	protected int pv;
	private int ptAttaque;
	//private Block[][] inventaire;
	protected Terrain leTerrain;//terrain qui possedent une observable liste
	
	
	//Constructeur
	public Personnage(int x,int y,String nom) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);

		this.pv=100;
		this.leTerrain=new Terrain();
	}
	public Personnage(String pseudo) {
		this(0,0,pseudo);
	}
	public Personnage() {
		this(" ");
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
	public void seDeplacerGauche() { //y=i x=j
		if(this.x.getValue()>=1 && this.leTerrain.getTerrain().get( this.y.getValue() ).get( this.x.getValue()-1 ).getTraversable()) {
			this.x.setValue(this.x.get()-1);
		}
	}
	//Droite
	public void seDeplacerDroite() { //y=i x=j
		if(this.x.getValue()<this.leTerrain.getTerrain().get( this.y.getValue() ).size()-1 &&  this.leTerrain.getTerrain().get( this.y.getValue() ).get( this.x.getValue()+1 ).getTraversable()) {
			this.x.setValue(this.x.get()+1);
		}
	}
	//haut
	protected void seDeplacerHaut() {
		if(this.y.getValue()>=1 && this.leTerrain.getTerrain().get( this.y.getValue()-1 ).get( this.x.getValue() ).getTraversable()) {
			this.y.setValue(this.y.get()-1);
		}
	}
	//bas
	protected boolean seDeplacerBas() {
		if(this.y.getValue()<this.leTerrain.getTerrain().size()-1 && this.leTerrain.getTerrain().get( this.y.getValue()+1 ).get( this.x.getValue() ).getTraversable()) {
			this.y.setValue(this.y.get()+1);
			return true;
		}
		return false;
	}
	
	
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
	
	public void setX(int a) {
		this.x.set(a);
	}
	public void setY(int a) {
		this.y.set(a);
	}
}
