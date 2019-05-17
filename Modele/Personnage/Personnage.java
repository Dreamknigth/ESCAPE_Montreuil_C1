package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.awt.Point;
import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import javafx.collections.ObservableList;

abstract class Personnage {
	protected Point position;
	protected String nom;
	protected int pv;
	private int ptAttaque;
	//private Block[][] inventaire;
	protected ArrayList<ObservableList <Block>> terrain;
	
	//Constructeur
	public Personnage(int x,int y,String nom,ArrayList<ObservableList <Block>> terrain) {
		this.position=new Point(x,y);
		this.pv=100;
		this.terrain=terrain;
	}
	public Personnage(String pseudo,ArrayList<ObservableList <Block>> terrain) {
		this(0,0,pseudo,terrain);
	}
	public Personnage(ArrayList<ObservableList <Block>> terrain) {
		this(" ",terrain);
	}
	
	//Methodes
	public void prendDegat(int ptDegat) {
		this.pv=this.pv-ptDegat;
		if(this.pv<=0) {
			this.pv=0;
			System.out.println("You're DEAD!");
		}
	}
	
	//getter
	public String getNom() {
		return this.nom;
	}
	public int getX() {
		return (int)this.position.getX();
	}
	public int getY() {
		return (int)this.position.getY();
	}
	public Point getPosition() {
		return this.position;
	}
}
