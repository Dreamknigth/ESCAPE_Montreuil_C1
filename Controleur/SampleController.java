	package ESCAPE_Montreuil_C1.Controleur;
	
	import java.net.URL;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.ResourceBundle;
	
	
	import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
	import ESCAPE_Montreuil_C1.Modele.Objet.Fer;
	import ESCAPE_Montreuil_C1.Modele.map.Monde;
	import ESCAPE_Montreuil_C1.Modele.blocks.Air;
	import ESCAPE_Montreuil_C1.Modele.blocks.Terre;
	import ESCAPE_Montreuil_C1.Modele.blocks.bois;
	import ESCAPE_Montreuil_C1.Modele.blocks.Block;
	import ESCAPE_Montreuil_C1.Vue.Player;
	import javafx.animation.KeyFrame;
	import javafx.animation.Timeline;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
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
		
		private String EtatInventaire= "Air";
	
		@FXML
		private HBox inventaireVue = new HBox();
	
		private Inventaire iventaireModele=new Inventaire();
	
		private Map<String, Image> dictionnaireImage; 		
	
	
		private Timeline gameLoop=new Timeline();
	
		private Monde monde;
		private Player lePlayer;
	
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
			if(code == KeyCode.F1) {
				this.EtatInventaire="Terre";
			}
			if(code == KeyCode.F2) {
				this.EtatInventaire="bois";
			}
			if(code == KeyCode.F3) {
				this.EtatInventaire="Fer";
			}
			
		}

		
	private void initGameLoop() {
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kfGraviter = new KeyFrame(Duration.seconds(0.200),(ev ->{
			this.monde.getJoueur().seDeplacerBas();
		}));
		gameLoop.getKeyFrames().add(kfGraviter);
		
	}
	

	@FXML
	void mouseClicked(MouseEvent event) {
		/**
		 * Recuperation des coordonnées du click
		 */
		int x =(int)event.getX()/32;
		int y =(int)event.getY()/32;
		MouseButton Button = event.getButton();
		System.out.println(x+";"+y);
		Block a;
		Image i;
		ImageView l= (ImageView) vue.lookup('#'+""+y+'9'+x);
		if (Button==MouseButton.PRIMARY && this.monde.getJoueur().modifPossible(y, x) && this.iventaireModele.minerPossible(this.monde.getTerrain().getTableTerrain().get(y).get(x))) {
			a = new Air();
			i = this.dictionnaireImage.get("Air");
			l.setImage(i);
			this.monde.getTerrain().setTerrain(a, y, x);

			}
		else if (this.EtatInventaire.equals("Terre") && this.iventaireModele.creerPossible("Terre") && Button==MouseButton.SECONDARY && this.monde.getJoueur().modifPossible(y, x)) {
			a = new Terre();
			i = this.dictionnaireImage.get(EtatInventaire);
			l.setImage(i);
			this.monde.getTerrain().setTerrain(a, y, x);
		}
		else if (this.EtatInventaire.equals("bois") && this.iventaireModele.creerPossible("bois") &&Button==MouseButton.SECONDARY && this.monde.getJoueur().modifPossible(y, x)) {
			a = new bois();
			i = this.dictionnaireImage.get(EtatInventaire);
			l.setImage(i);
			this.monde.getTerrain().setTerrain(a, y, x);
		}
		/*else if (this.EtatInventaire.equals("Fer") && this.iventaireModele.creerPossible("Fer") &&Button==MouseButton.SECONDARY && this.monde.getJoueur().modifPossible(y, x)) {
			a = new Pierre();
			i = this.dictionnaireImage.get(EtatInventaire);
			l.setImage(i);
			this.monde.getTerrain().setTerrain(a, y, x);
		}*/
		this.EtatInventaire="Air";
		System.out.println("ok");
	}
	
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			//Declaration et Initialisation 
	
			/**
			 * Creation de la map
			 */
			dictionnaireImage = new HashMap< String,Image>(); 
			dictionnaireImage.put("Air",new Image("ESCAPE_Montreuil_C1/source/air.jpg" ));
			dictionnaireImage.put("Terre", new Image("ESCAPE_Montreuil_C1/source/terre.jpg")); 
			dictionnaireImage.put("bois", new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
			dictionnaireImage.put("Fer", new Image("ESCAPE_Montreuil_C1/source/Fer.png"));
			dictionnaireImage.put("solAvecHerbe",new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg"));
			dictionnaireImage.put("Feuille",new Image("ESCAPE_Montreuil_C1/source/feuille.jpg"));
			dictionnaireImage.put("tronc",new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
			//Image Fer= new Image("ESCAPE_Montreuil_C1/source/Fer.jpg");
			//Image elixir= new Image("ESCAPE_Montreuil_C1/source/elixir.png");
			this.monde=new Monde();
			creerVueTerrain();
			this.lePlayer=new Player();
			this.vue.getChildren().add(this.lePlayer);
	
	
			/**
			 * bind les positions du player(imageview) avec les positions du joueur
			 */
	
			this.lePlayer.translateXProperty().bind(this.monde.getJoueur().getX().multiply(32));
			this.lePlayer.translateYProperty().bind(this.monde.getJoueur().getY().multiply(32));
			this.lePlayer.setFitHeight(50);
			this.lePlayer.setFitWidth(50);
	
			/**
			 * bind les positions de la vue avec les positions du joueur
			 */
	
			this.vue.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32).add(512));
			this.vue.translateYProperty().bind(this.monde.getJoueur().getY().multiply(-16));
	
			/**
			 * bind les comportement du joueur avec les comportement du player(qui gere les images)
			 */
	
	
			vue.setOnKeyPressed(e->{
				try {
					touche(e);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	
	
			/**
			 * Initialisation des Ressources Dans Inventaire
			 */
			creationInventaire();
			
	
	
	
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
		private void creationInventaire() {
			for (int i = 1 ;i<this.iventaireModele.getListeInventaire().size();i++ ) {
				VBox elementInventaire = new VBox();
				Label valeurRessource = new Label();
				ImageView Image = new ImageView(dictionnaireImage.get(this.iventaireModele.getListeInventaire().get(i).getNom()));
				Image.setFitHeight(80);
				Image.setFitWidth(Image.getFitHeight());
				valeurRessource.textProperty().bind(this.iventaireModele.getListeInventaire().get(i).getValeur().asString());
				elementInventaire.getChildren().add(Image);
				elementInventaire.getChildren().add(valeurRessource);
	
	
				elementInventaire.setTranslateX(i*60);
				inventaireVue.getChildren().add(elementInventaire);
			}			
		}
		public void creerVueTerrain() {
	
	
			for (int i = 0; i < this.monde.getTerrain().getTableTerrain().size(); i++) {
				for(int j=0;j<this.monde.getTerrain().getTableTerrain().get(i).size();j++) {
					ImageView view = new ImageView() ;
					if(this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom()=='A') {
						view.setImage(this.dictionnaireImage.get("Air"));
					}
					else if(this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom()=='f'){
						view.setImage(this.dictionnaireImage.get("Feuille"));
					}
					else if (this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom() == 'F') {
						view.setImage(this.dictionnaireImage.get("tronc"));
					}
					else if (this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom() == 't'){
						view.setImage(this.dictionnaireImage.get("Terre"));
					}
					else if (this.monde.getTerrain().getTableTerrain().get(i).get(j).getNom() == 'T') {
						view.setImage(this.dictionnaireImage.get("solAvecHerbe"));
					}
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