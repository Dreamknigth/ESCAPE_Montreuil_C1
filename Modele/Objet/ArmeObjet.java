package ESCAPE_Montreuil_C1.Modele.Objet;

public abstract class ArmeObjet extends Objet{
	
	protected int ptsattaque;
	protected int durabilité;

	public ArmeObjet(String nom, int ptatt, int dura) {
		super(nom);
		this.ptsattaque = ptatt;
		this.durabilité = dura;
	}
	
	public abstract int getatt();
	public abstract int getdura();
	
	/*@Override
	public int getnb() {
		return this.getValeur();
	}

	@Override
	public void setnb(int i) {
		this.nb = this.nb + i;
		
	}*/
	
	
}
