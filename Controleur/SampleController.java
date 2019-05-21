package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import javafx.beans.property.IntegerProperty;
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
    private Pane monde;

    @FXML
    private Pane map;
	@FXML
	private ImageView perso;
	
	private IntegerProperty xMonde , yMonde;
	
	private Joueur j1;
	private MapReader mp;

	@FXML
	private void touche(KeyEvent e) throws InterruptedException {
		KeyCode code = e.getCode();
		System.out.println("Debug:");
		System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue());
		int vitesse=4;
		if ( (code == KeyCode.Z || code == KeyCode.UP)  ) {
			this.yMonde.subtract(1);
			j1.seDeplacerSaut();
		}
		if( (code == KeyCode.D || code == KeyCode.RIGHT) ) {
			this.xMonde.subtract(1);
			j1.seDeplacerDroite();
		}
		if(code == KeyCode.Q || code == KeyCode.LEFT) {
			this.xMonde.add(1);
			j1.seDeplacerGauche();
		}
		if(code == KeyCode.S || code == KeyCode.DOWN){
			this.yMonde.add(1);
			j1.seDeplacerGraviter();
		}
		System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue()+"\n");
	}
	
	@FXML
	void mouseClicked(MouseEvent event) {
		System.out.println("yes yes ");
	}
	
	@FXML
	void graviter(Event event) {
		j1.seDeplacerGraviter();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/**
		 * Creation de la map
		 */
		
		this.mp=new MapReader();
		this.mp.constructeurMap();
		map.setOnKeyPressed(e->{
			try {
				touche(e);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		MapReader mr = new MapReader();
		mr.constructeurMap();
		ArrayList<ObservableList <Block>> terrain=mr.getTerrain();
		this.mp.afficheTerrain();
		Image A= new Image("ESCAPE_Montreuil_C1/Ressource/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/Ressource/solpetit.jpg");
		Image t = new Image("ESCAPE_Montreuil_C1/Ressource/terre.jpg");
		Image f= new Image("ESCAPE_Montreuil_C1/Ressource/feuille.jpg");
		Image F= new Image("ESCAPE_Montreuil_C1/Ressource/tronc.jpg");
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
				map.getChildren().add(view);
				view.setTranslateX(j*view.getFitWidth());
				view.setTranslateY(i*view.getFitHeight());
				
			}
		}
		
		/**
		 * Creation du Joueur
		 */
		this.j1=new Joueur(0,0,"pseudo");
		perso.setImage(new Image("ESCAPE_Montreuil_C1/Ressource/Joueur/Megamanx running.gif"));
		this.xMonde.set(0);
		this.yMonde.set(0);
		// Deplacement Joueur
		
		j1.seDeplacerGraviter();
		
		perso.translateXProperty().bind(j1.getX().multiply(32));
		perso.translateYProperty().bind(j1.getY().multiply(32));

		monde.translateXProperty().bind(this.xMonde.multiply(-32));
		monde.translateYProperty().bind(this.yMonde.multiply(-32));

		perso.setFitHeight(40);
		perso.setFitWidth(40);

		
		
		// https://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableValue.html
		// void addListener(ChangeListener<? super T> listener)
	}
}
