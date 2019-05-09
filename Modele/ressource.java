package ESCAPE_Montreuil_C1.Modele;

public class ressource extends block {
	public int resistance;
	public ressource (int resistance, boolean estDestructible, boolean estTraversable) {
		super(estDestructible, estTraversable);
		this.resistance=resistance;
	}

	

}
