package ESCAPE_Montreuil_C1.Modele.Joueur;

import java.awt.Point;

import ESCAPE_Montreuil_C1.Modele.blocks.block;

public class Joueur{
	private Point position;
	private String pseudo;
	private int pv;
	//private Objet[] inventaire;
	
	public Joueur(int x,int y,String pseudo) {
		this.position=new Point(x,y);
		this.pv=100;
	}
	public Joueur(String pseudo) {
		this(0,0,pseudo);
	}
	public Joueur() {
		this(" ");
	}
	
	//getter
	public String getPseudo() {
		return this.pseudo;
	}
	public int getX() {
		return (int)this.position.getX();
	}
	public int gety() {
		return (int)this.position.getX();
	}
	
	//setter
	public void setPseudo(String pseudo) {
		this.pseudo=pseudo;
	}
		
}
