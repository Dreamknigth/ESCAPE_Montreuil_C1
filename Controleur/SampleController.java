package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.glass.ui.Application.EventHandler;

import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
	private ImageView cadre;
	private Player j;
	private Joueur j1;

	@FXML
	private void touche(KeyEvent e) {
		KeyCode code = e.getCode();
		System.out.println("Debug:");
		System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue());
		int vitesse=4;
		if ( (code == KeyCode.Z || code == KeyCode.UP)  ) {
			j1.seDeplacerSaut();
		}
		if( (code == KeyCode.D || code == KeyCode.RIGHT) ) {
			j1.seDeplacerDroite();
		}
		if(code == KeyCode.Q || code == KeyCode.LEFT) {
			j1.seDeplacerGauche();
		}
		if(code == KeyCode.S || code == KeyCode.DOWN){
			j1.seDeplacerGraviter();
		}
		System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue()+"\n");
	}
	
	@FXML
	void mouseClicked(MouseEvent event) {
		System.out.println("yes yes ");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.j1=new Joueur(0,0,"pseudo");
		
		MapReader mr = new MapReader();
		mr.constructeurMap();
		ArrayList<ObservableList <Block>> terrain=mr.getTerrain();

		Image A= new Image("ESCAPE_Montreuil_C1/source/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg");
		Image t = new Image("ESCAPE_Montreuil_C1/source/terre.jpg");
		Image f= new Image("ESCAPE_Montreuil_C1/source/feuille.jpg");
		Image F= new Image("ESCAPE_Montreuil_C1/source/tronc.jpg");
		
		System.out.println("le debug de la vie!");
		cadre.translateXProperty().bind( j1.getX() );
		cadre.translateYProperty().bind( j1.getX() );
		this.j=new Player( this.j1, this.cadre);
		//j=new Player();
//		cadre.setImage(new Image("ESCAPE_Montreuil_C1/source/Joueur/Megamanx running.gif"));
//		cadre.setFitHeight(40);
//		cadre.setFitWidth(40);
//		cadre.translateXProperty().bind( j1.getX() );
//		cadre.translateYProperty().bind( j1.getX() );
		System.out.println("le debug de la mort!");
		
		

		

		
		for (int i = 0; i < terrain.size(); i++) {
			for(int j=0;j<terrain.get(i).size();j++) {
				ImageView view = new ImageView() ;
				if(terrain.get(i).get(j).getNom()=='A') {
					view.setImage(A);
				}
				else if(terrain.get(i).get(j).getNom()=='f'){
					view.setImage(f);
				}
				else if (terrain.get(i).get(j).getNom() == 'F') {
					view.setImage(F);
				}
				else if (terrain.get(i).get(j).getNom() == 't'){
					view.setImage(t);
				}
				else if (terrain.get(i).get(j).getNom() == 'T') {
					view.setImage(T);
				}
				view.setFitHeight(32);
				view.setFitWidth(32);
				pane.getChildren().add(view);
				view.setTranslateX(j*view.getFitWidth());
				view.setTranslateY(i*view.getFitHeight());

			}
		}
		// https://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableValue.html
		// void addListener(ChangeListener<? super T> listener)
	}
}
