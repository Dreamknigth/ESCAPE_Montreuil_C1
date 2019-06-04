package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.ui.Application.EventHandler;

import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javax.naming.NamingException;
import ESCAPE_Montreuil_C1.Modele.blocks.Air;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{
	
	private Timeline gameLoop=new Timeline();
	
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
			this.monde.getJoueur().seDeplacerBas();
		}
	}
	
	@FXML
	void mouseClicked(MouseEvent event) {
		
		int x =(int)event.getX()/32;
		int y =(int)event.getY()/32;
		System.out.println(x+";"+y);
		if (this.monde.getJoueur().modifPossible(y, x)) {
			Air a = new Air();
			Image i = new Image("ESCAPE_Montreuil_C1/source/air.jpg");
				ImageView l = (ImageView) vue.lookup('#'+""+y+'9'+x);
				l.setImage(i);
				this.monde.getTerrain().setTerrain(a, y, x);
		}
		
		
	}

	private void initGameLoop() {
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kfGraviter = new KeyFrame(Duration.seconds(0.400),(ev ->{
			this.monde.getJoueur().seDeplacerBas();
		}));
		gameLoop.getKeyFrames().add(kfGraviter);
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Declaration et Initialisation 
		this.monde=new Monde();
		creerVueTerrain();
		this.lePlayer=new Player();
		this.vue.getChildren().add(this.lePlayer);
		//bind les positions du player(imageview) avec les positions du joueur
		this.lePlayer.translateXProperty().bind(this.monde.getJoueur().getX().multiply(32));
		this.lePlayer.translateYProperty().bind(this.monde.getJoueur().getY().multiply(32));
		this.lePlayer.setFitHeight(64);
		this.lePlayer.setFitWidth(32);
		//bind les positions de la vue avec les positions du joueur
		this.vue.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32).add(512));
		this.vue.translateYProperty().bind(this.monde.getJoueur().getY().multiply(-16));
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
			e1.printStackTrace();
		}
		});
		
		System.out.println("le debug de la vie!");
		System.out.println("test "+this.monde.getJoueur().getNom());
	
		System.out.println("le debug de la mort!");
		//monde.getJoueur().seDeplacerGraviter();
		// https://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableValue.html
		// void addListener(ChangeListener<? super T> listener)
		
		//Init du jeu
		initGameLoop();
		//Lancer leanimationJeu JEU!
		gameLoop.play();
	}
	
	public void creerVueTerrain() {
		
		Image A= new Image("ESCAPE_Montreuil_C1/source/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg");
		Image t = new Image("ESCAPE_Montreuil_C1/source/terre.jpg");
		Image f= new Image("ESCAPE_Montreuil_C1/source/feuille.jpg");
		Image F= new Image("ESCAPE_Montreuil_C1/source/tronc.jpg");
		
		for (int i = 0; i < this.monde.getTerrain().getTableTerrain().size(); i++) {
			for(int j=0;j<this.monde.getTerrain().getTableTerrain().get(i).size();j++) {
				ImageView view = new ImageView() ;
				if(this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom()=='A') {
					view.setImage(A);
				}
				else if(this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom()=='f'){
					view.setImage(f);
				}
				else if (this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom() == 'F') {
					view.setImage(F);
				}
				else if (this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom() == 't'){
					view.setImage(t);
				}
				else if (this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom() == 'T') {
					view.setImage(T);
				}
				
				view.setFitHeight(32);
				view.setFitWidth(32);
				String s = i+"9"+j;
				view.setId(s);
				vue.getChildren().add(view);
				view.setTranslateX(j*view.getFitWidth());
				view.setTranslateY(i*view.getFitHeight());
				
			}
		}
	}
}
				
				
				
				
				
				
				
				
				
				
				
				