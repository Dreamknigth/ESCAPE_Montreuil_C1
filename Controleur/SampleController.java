package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.map.Terrain;

import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{


	@FXML
	private ImageView perso;


	@FXML
	private HBox inventaireVue = new HBox();


	private Map<String, Image> dictionnaireImage; 		


	private Timeline gameLoop=new Timeline();

	private Monde monde;
	private Player lePlayer;
	@FXML
	private Pane map;
	@FXML
	private Pane vue;
	@FXML
	private Pane PageAcceuil;
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
    void play(ActionEvent event) {
    	this.PageAcceuil.setVisible(false);
    	this.map.setVisible(true);
    	this.vue.setVisible(true);
    }

    @FXML
    void quit(ActionEvent event) {
    	System.exit(0);
    }

	@FXML
	private void touche(KeyEvent e) throws InterruptedException {
		KeyCode code = e.getCode();
		//System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue());
		if ( (code == KeyCode.Z || code == KeyCode.UP)  ) {
			this.monde.getJoueur().getEtat().setValue(1);
		}
		if( (code == KeyCode.D || code == KeyCode.RIGHT) ) {
			this.monde.getJoueur().getEtat().setValue(3);
			this.monde.getJoueur().getVersDroite().setValue(true);
		}
		if(code == KeyCode.Q || code == KeyCode.LEFT) {
			this.monde.getJoueur().getEtat().setValue(3);
			this.monde.getJoueur().getVersDroite().setValue(false);
		}
		if(code == KeyCode.S || code == KeyCode.DOWN){
			this.monde.getJoueur().getEtat().setValue(2);
		}
		/*if(code == KeyCode.F1) {
				this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(0));

			if(code == KeyCode.F1) {
				this.EtatInventaire= new Terre();
			}
			if(code == KeyCode.F2) {
				this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(1));
			}
			if(code == KeyCode.F3) {
				this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(2));
			}
			if(code == KeyCode.F4) {
				this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(3));
			}
			if(code == KeyCode.F5) {
				this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(4));
			}
			/*if(code == KeyCode.F3) {
					this.EtatInventaire=new ();
				}*/
	}

	@FXML
	void mouseClicked(MouseEvent event) {
		/**
		 * Recuperation des coordonnées du click
		 */
		int x =(int)event.getX()/32;
		int y =(int)event.getY()/32;
		MouseButton Button = event.getButton();
		//System.out.println(x+";"+y);
		ImageView l= (ImageView) vue.lookup('#'+""+y+'9'+x);
		/**
		 * Changement
		 */
		Monde t= this.monde;
		if(this.monde.getJoueur().modifPossible(y, x)) {
			if (Button==MouseButton.PRIMARY  ) { // rendre Main
				String nomObjetDansLaMain=this.monde.getJoueur().getObjetDansLaMain().faculté(t,x,y).getNom();
				System.out.println(this.monde.getTerrain().getTableTerrain().get(y).get(x).getNom());
				System.out.println(this.monde.getJoueur().getObjetDansLaMain().getNom());
				l.setImage(this.dictionnaireImage.get(nomObjetDansLaMain));
			}
			/*else if (Button==MouseButton.SECONDARY && this.monde.getJoueur().creerPossible(ObjetDans)){
							this.monde.getTerrain().setTerrain(ObjetDans, y, x);
						}*/

		}
	}




	private void initGameLoop() {
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kfDeplacement = new KeyFrame(Duration.seconds(0.3),(ev ->{
			this.monde.getJoueur().seDeplacer();
			this.monde.getJoueur().getEtat().setValue(0);
		}));
		gameLoop.getKeyFrames().add(kfDeplacement);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Declaration et Initialisation 
    	this.PageAcceuil.setVisible(true);
    	this.map.setVisible(false);
    	this.vue.setVisible(false);
		/**
		 * Creation de la map
		 */
		dictionnaireImage = new HashMap< String,Image>(); 
		dictionnaireImage.put("A",new Image("ESCAPE_Montreuil_C1/source/air.jpg" ));
		dictionnaireImage.put("t", new Image("ESCAPE_Montreuil_C1/source/terre.jpg")); 
		//dictionnaireImage.put("bois", new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
		dictionnaireImage.put("B", new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
		dictionnaireImage.put("p", new Image("ESCAPE_Montreuil_C1/source/Fer.png"));
		dictionnaireImage.put("T",new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg"));
		dictionnaireImage.put("f",new Image("ESCAPE_Montreuil_C1/source/feuille.jpg"));
		dictionnaireImage.put("F",new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
		dictionnaireImage.put("P",new Image("ESCAPE_Montreuil_C1/source/pioche.jpeg"));
		dictionnaireImage.put("H",new Image("ESCAPE_Montreuil_C1/source/hache.jpg"));

		//Image Fer= new Image("ESCAPE_Montreuil_C1/source/Fer.jpg");
		//Image elixir= new Image("ESCAPE_Montreuil_C1/source/elixir.png");
		this.monde=new Monde();
		creerVueTerrain();
		this.lePlayer=new Player();
		this.vue.getChildren().add(this.lePlayer);

		
		
		/**
		 * Initialisation des Ressources Dans Inventaire
		 */
	//	creationInventaire();

		/**
		 * bind les positions du player(imageview) avec les positions du joueur
		 */
		this.lePlayer.translateXProperty().bind(this.monde.getJoueur().getX().multiply(32));
		this.lePlayer.translateYProperty().bind(this.monde.getJoueur().getY().multiply(32));
		this.lePlayer.setFitHeight(64);
		this.lePlayer.setFitWidth(32);
		/**
		 * bind les positions de la vue avec les positions du joueur
		 */
		this.vue.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32).add(512));
		this.vue.translateYProperty().bind(this.monde.getJoueur().getY().multiply(-16));
		/**
		 * mettre un listener sur les variables etat et versDroite du Joueur
		 */
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

		//monde.getJoueur().seDeplacerGraviter();
		// https://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableValue.html
		// void addListener(ChangeListener<? super T> listener)

		initGameLoop();
		gameLoop.play();
	}
	/*private void creationInventaire() {
		/*System.out.println("BBD");
		for (int i = 0 ;i<this.monde.getJoueur().getInventaire().getListeInventaire().size();i++ ) {
		}
		
		this.monde.getJoueur().getInventaire().getListeInventaire().addListener( new ListChangeListener< observableList<Block> >() {
			@Override
			public void onChanged(Change<? extends ArrayList<Objet> > c) {
				while(c.next()) {
					if(c.wasReplaced()) {
						
					}
					if(c.wasAdded()) {
						VBox elementInventaire = new VBox();
						Label valeurRessource = new Label();
						System.out.println("ok");
						String nomObjet = monde.getJoueur().getInventaire().getListeInventaire().get(i).get(0).getNom();
						ImageView Image = new ImageView(dictionnaireImage.get(nomObjet));
						Image.setFitHeight(80);
						Image.setFitWidth(Image.getFitHeight());
						valeurRessource.textProperty().bind(this.monde.getJoueur().getInventaire().getListeInventaire().get(i).get(0).getValeur().asString());
						elementInventaire.getChildren().add(Image);
						elementInventaire.getChildren().add(valeurRessource);
						
						elementInventaire.setTranslateX((i+1)*60);
						inventaireVue.getChildren().add(elementInventaire);
						
					}
					if(c.wasRemoved()) {
						
					}
				}
			}
		} );
	}*/
	public void creerVueTerrain() {

		for (int i = 0; i < this.monde.getTerrain().getTableTerrain().size(); i++) {
			for(int j=0;j<this.monde.getTerrain().getTableTerrain().get(i).size();j++) {
				ImageView view = new ImageView() ;
				view.setImage(this.dictionnaireImage.get(this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom()));
				this.vue.getChildren().add(view);
				String s =i+"9"+j;
				view.setId(s);
				view.setTranslateX(j*32);
				view.setTranslateY(i*32);
				view.setFitHeight(32);
				view.setFitWidth(view.getFitHeight());
			}
		}
	}


}