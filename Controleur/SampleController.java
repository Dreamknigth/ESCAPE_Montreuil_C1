package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class SampleController {


    @FXML
    private Pane pane;
    
    private MapMaker mp;

	@FXML
	void testbtn(ActionEvent event) throws InterruptedException {
		
		/*ArrayList<Image> map = new ArrayList<Image>();
		Image img = new Image("application/air.jpg");
		Image img2 = new Image("application/terre.png");
		//Image img1 = new Image("application/gif.gif");
		for(int i = 0; i< 50; i++) {
			map.add(img);
		}
		for(int i = 0; i< 50; i++) {
			map.add(img2);
		}
		
		int ligne =0;
		int colonne=0;

	    for (int i = 1; i < map.size(); i++) {
	    	ImageView view = new ImageView(map.get(i)) ;
	    	view.setFitHeight(32);
	    	view.setFitWidth(32);
	    	if(map.size()%i==0) {
	    		ligne++;
	    		colonne=0;
	    	}
	    		colonne++;
	    		view.setTranslateX(colonne*32);
	    		view.setTranslateY(ligne*32);
	    	pane.getChildren().add(view);
	    	
	    	
	    	System.out.println(i);
	    	
	    }
	 
	*/ mp=new MapMaker();
		System.out.println(mp.getTerrain());
	}	

}
