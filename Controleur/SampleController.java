package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import ESCAPE_Montreuil_C1.Modele.MapMaker;
import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
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
	private Joueur j1;
	private MapMaker mp;

	@FXML
	private void touche(KeyEvent e) {
		KeyCode code = e.getCode();
		System.out.println("click");
		System.out.println(this.j1.getPosition().getX()+" "+this.j1.getPosition().getY());
		int vitesse=0;
		if ( (code == KeyCode.D || code == KeyCode.RIGHT) && this.j1.seDeplacerDroite()) {
			perso.setTranslateX( (perso.getTranslateX()+vitesse) );
		}
		if( (code == KeyCode.Q || code == KeyCode.LEFT) && this.j1.seDeplacerGauche()) {
			perso.setTranslateX(perso.getTranslateX()-vitesse);
		}
		if(code == KeyCode.Z || code == KeyCode.UP) {
			perso.setTranslateY(perso.getTranslateY()-vitesse);
		}
		if(code == KeyCode.S || code == KeyCode.DOWN){
				perso.setTranslateY(perso.getTranslateY()+vitesse);
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
		
		this.j1=new Joueur(0,0,"pseudo",mp.charToBlock());

		ArrayList<ObservableList <Block>> terrain=this.mp.getTerrain();

		Image A= new Image("ESCAPE_Montreuil_C1/Ressource/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/Ressource/terre.png");
		perso.setImage(new Image("ESCAPE_Montreuil_C1/Ressource/Joueur/Megamanx running.gif"));
		perso.setTranslateY(this.j1.getY()*32);
		perso.setTranslateX(this.j1.getX()*32);

		perso.setFitHeight(40);
		perso.setFitWidth(40);

		for (int i = 0; i < terrain.size(); i++) {
			for(int j=0;j<terrain.get(i).size();j++) {
				ImageView view = new ImageView() ;
				if(terrain.get(i).get(j).getNom()=='A') {
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
