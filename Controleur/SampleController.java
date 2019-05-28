package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.glass.ui.Application.EventHandler;

import ESCAPE_Montreuil_C1.Modele.Monde;
import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;
import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{
	
	private Monde monde;
	private Player lePlayer;

//	@FXML
//	private ImageView cadre;
	@FXML
	private Pane map;
	@FXML
	private Pane vue;
	@FXML
	private ImageView RessourceBois;
	@FXML
	private ImageView RessourceFer;
	@FXML
	private ImageView RessourceTerre;
	@FXML
	private ImageView RessourceElixir;
	@FXML
    private HBox inventaire;

	@FXML
	private void touche(KeyEvent e) throws InterruptedException {
		KeyCode code = e.getCode();
		//System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue());
		if ( (code == KeyCode.Z || code == KeyCode.UP)  ) {
			this.monde.getJoueur().seDeplacerSaut();
		}
		if( (code == KeyCode.D || code == KeyCode.RIGHT) ) {
			this.monde.getJoueur().seDeplacerDroite();
		}
		if(code == KeyCode.Q || code == KeyCode.LEFT) {
			this.monde.getJoueur().seDeplacerGauche();
			System.out.println("debug");
		}
		if(code == KeyCode.S || code == KeyCode.DOWN){
			this.monde.getJoueur().seDeplacerGraviter();
		}
		System.out.println(this.monde.getJoueur().getEtat().getValue()+" "+this.monde.getJoueur().getVersDroite().getValue());
		System.out.println(this.monde.getJoueur().getY().getValue()+" "+this.monde.getJoueur().getX().getValue()+"\n");
	}
	
	@FXML
	void mouseClicked(MouseEvent event) {
		System.out.println("yes yes ");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Declaration et Initialisation 
		this.monde=new Monde();
		creerVueTerrain();
		this.lePlayer=new Player();
		this.map.getChildren().add(this.lePlayer);
		//bind les positions du player(imageview) avec les positions du joueur
		this.lePlayer.translateXProperty().bind(this.monde.getJoueur().getX().multiply(32));
		this.lePlayer.translateYProperty().bind(this.monde.getJoueur().getY().multiply(32));
		this.lePlayer.setFitHeight(50);
		this.lePlayer.setFitWidth(50);
		//bind les positions de la vue avec les positions du joueur
		this.map.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32).add(512));
		this.map.translateYProperty().bind(this.monde.getJoueur().getY().multiply(-16));
		//mettre un listener sur les variables etat et versDroite du Joueur
		this.monde.getJoueur().getEtat().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {
				lePlayer.setCadre( monde.getJoueur().getVersDroite().getValue(), monde.getJoueur().getEtat().getValue() );
			}
		});
		this.monde.getJoueur().getVersDroite().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable,Boolean oldValue, Boolean newValue) {
				lePlayer.setCadre( monde.getJoueur().getVersDroite().getValue(), monde.getJoueur().getEtat().getValue() );
			}
		});
		vue.setOnKeyPressed(e->{
		try {
			touche(e);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		});
		
		System.out.println("le debug de la vie!");
		System.out.println("test "+this.monde.getJoueur().getNom());
	
		//j=new Player();
//		cadre.setImage(new Image("ESCAPE_Montreuil_C1/source/Joueur/Megamanx running.gif"));
//		cadre.setFitHeight(40);
//		cadre.setFitWidth(40);
//		cadre.translateXProperty().bind( j1.getX() );
//		cadre.translateYProperty().bind( j1.getX() );
		System.out.println("le debug de la mort!");
		
		
		
		/**
		 * Deplacement Joueur
		 */
		
		//monde.getJoueur().seDeplacerGraviter();

		
		// https://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableValue.html
		// void addListener(ChangeListener<? super T> listener)
	}
	public void creerVueTerrain() {
		
		Image A= new Image("ESCAPE_Montreuil_C1/source/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg");
		Image t = new Image("ESCAPE_Montreuil_C1/source/terre.jpg");
		Image f= new Image("ESCAPE_Montreuil_C1/source/feuille.jpg");
		Image F= new Image("ESCAPE_Montreuil_C1/source/tronc.jpg");
		
		for (int i = 0; i < this.monde.getTerrain().size(); i++) {
			for(int j=0;j<this.monde.getTerrain().get(i).size();j++) {
				ImageView view = new ImageView() ;
				if(this.monde.getTerrain().get(i).get(j).getNom()=='A') {
					view.setImage(A);
				}
				else if(this.monde.getTerrain().get(i).get(j).getNom()=='f'){
					view.setImage(f);
				}
				else if (this.monde.getTerrain().get(i).get(j).getNom() == 'F') {
					view.setImage(F);
				}
				else if (this.monde.getTerrain().get(i).get(j).getNom() == 't'){
					view.setImage(t);
				}
				else if (this.monde.getTerrain().get(i).get(j).getNom() == 'T') {
					view.setImage(T);
				}
				
				view.setFitHeight(32);
				view.setFitWidth(32);
				vue.getChildren().add(view);
				view.setTranslateX(j*view.getFitWidth());
				view.setTranslateY(i*view.getFitHeight());
				
			}
		}
	}
}
