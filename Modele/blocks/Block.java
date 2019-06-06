package ESCAPE_Montreuil_C1.Modele.blocks;

public abstract class Block {
	protected boolean traversable;
	private char nom;
	private String ID;
	//constructeur
	public Block(boolean traversable,char nom) {
		this.traversable=traversable;
		this.nom=nom;
	}
	
	//getter
	public boolean getTraversable() {
		return this.traversable;
	}
	public char getNom() {
		return this.nom;
	}
	
	public String getID () {
		return this.ID;
	}
	public void setID (String NewID) {
		this.ID = NewID;
	}
}
