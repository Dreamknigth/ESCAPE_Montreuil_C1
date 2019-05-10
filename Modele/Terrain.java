package ESCAPE_Montreuil_C1.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Terrain {
	private ObservableList<String> glbstkf;
	public Terrain() {
		this.glbstkf=FXCollections.observableArrayList();
	}
	
	public ObservableList<String> getObservableList() {
		return this.glbstkf;
	}
	
}
