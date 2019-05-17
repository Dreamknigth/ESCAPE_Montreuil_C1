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
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{


	@FXML
	private Pane pane;
	@FXML
	private ImageView perso;
	private MapMaker mp;

	@FXML
	private void touche(KeyEvent e) {
		KeyCode code = e.getCode();
		if (code == KeyCode.D || code == KeyCode.RIGHT) {
				perso.setTranslateX(perso.getTranslateX()+5);
		}
		else if(code == KeyCode.Q || code == KeyCode.LEFT) {
				perso.setTranslateX(perso.getTranslateX()-5);
		}
		else if(code == KeyCode.Z || code == KeyCode.UP) {
			perso.setTranslateY(perso.getTranslateY()-10);
		}
		else if(code == KeyCode.S || code == KeyCode.DOWN){
				perso.setTranslateY(perso.getTranslateY()+10);
			}
		}
	
	@FXML
	void mouseClicked(MouseEvent event) {
		System.out.println("yes yes ");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.mp=new MapMaker();
		this.mp.constructeurMap();
		pane.setOnKeyPressed(e->touche(e));
		this.mp.afficheTerrain();

		ArrayList<ObservableList <Character>> terrain=this.mp.getTerrain();





		Image A= new Image("ESCAPE_Montreuil_C1/Ressource/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/Ressource/terre.jpg");
		
		perso.setImage(new Image("ESCAPE_Montreuil_C1/Ressource/Joueur/Megamanx running.gif"));
		perso.setTranslateY(40*2.55);
		perso.setTranslateX(32);

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


			}
		}
	}










}
