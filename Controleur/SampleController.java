package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ESCAPE_Montreuil_C1.Modele.MapMaker;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class SampleController implements Initializable{


    @FXML
    private Pane pane;
    @FXML
    private ImageView perso;
    private MapMaker mp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.mp=new MapMaker();
		this.mp.constructeurMap();
		this.mp.afficheTerrain();
		ArrayList<ObservableList <Character>> terrain=this.mp.getTerrain();
		 
		Image A= new Image("ESCAPE_Montreuil_C1/Ressource/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/Ressource/terre.png");
		perso.setImage(new Image("ESCAPE_Montreuil_C1/Ressource/Joueur/Megamanx running.gif"));
	    perso.setTranslateY(40*2.55);
    	perso.setFitHeight(40);
    	perso.setFitWidth(40);
	    
		for (int i = 0; i < terrain.size(); i++) {
	    	for(int j=0;j<terrain.get(i).size();j++) {
	    		ImageView view = new ImageView() ;
	    		if(terrain.get(i).get(j).equals('A')) {
	    			view.setImage(A);
	    		}
	    		else {
	    			view.setImage(T);
	    		}
		    	view.setFitHeight(20);
		    	view.setFitWidth(20);
		    	pane.getChildren().add(view);
		    	view.setTranslateX(j*view.getFitWidth());
		    	view.setTranslateY(i*view.getFitHeight());
		    	

		    	System.out.println(i);
	    	}
	    }
	 
		System.out.println(mp.getTerrain());
	}
	@FXML
    public void handle(KeyEvent key) {
        if (key.getCode().equals(KeyCode.RIGHT)) {
            perso.setX(32*2);
        }
    }
	
	/*public Image imageDe(String s) {
		if(s.equals"A")
			return new Image()
		
	}*/

}
