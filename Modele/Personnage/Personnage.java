package ESCAPE_Montreuil_C1.Modele.Personnage;

import java.awt.Point;

abstract class Personnage {
	private Point position;
	private String nom;
	private int pv;
	//private Objet[][] inventaire;
	
	public Personnage(int x,int y,String nom) {
		this.position=new Point(x,y);
		this.pv=100;
	}
	public Personnage(String pseudo) {
		this(0,0,pseudo);
	}
	public Personnage() {
		this(" ");
	}
	
	//getter
	public String getPseudo() {
		return this.nom;
	}
	public int getX() {
		return (int)this.position.getX();
	}
	public int gety() {
		return (int)this.position.getX();
	}
	
	public void seDeplacer() {
		
	}
}
