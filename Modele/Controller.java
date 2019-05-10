package ESCAPE_Montreuil_C1.Modele;

//c est un exemple

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.Initializable;

public class Controller implements Initializable{
	private Terrain unTerrain;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.unTerrain = new Terrain();
	}
	
	public void ajouterListener() {
		this.unTerrain.getObservableList().addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(Change<? extends String> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					if(c.wasReplaced()) {
						//TODO
					}
					else if(c.wasAdded()) {
						//TODO
					}
					else if(c.wasRemoved()) {
						//TODO
					}
				}
			}
		});
	}

}
