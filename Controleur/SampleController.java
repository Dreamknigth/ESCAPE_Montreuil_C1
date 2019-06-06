	package ESCAPE_Montreuil_C1.Controleur;
	
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.ResourceBundle;
	
	
	import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
	import ESCAPE_Montreuil_C1.Modele.Objet.Fer;
	import ESCAPE_Montreuil_C1.Modele.Personnage.Cannibale;
	import ESCAPE_Montreuil_C1.Modele.Personnage.Personnage;
	import ESCAPE_Montreuil_C1.Modele.map.Monde;
	import ESCAPE_Montreuil_C1.Modele.blocks.Air;
	import ESCAPE_Montreuil_C1.Modele.blocks.Terre;
	import ESCAPE_Montreuil_C1.Modele.blocks.bois;
	import ESCAPE_Montreuil_C1.Modele.blocks.Block;
	import ESCAPE_Montreuil_C1.Vue.Player;
	import ESCAPE_Montreuil_C1.Vue.Ennemi;
	import javafx.animation.KeyFrame;
	import javafx.animation.Timeline;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.collections.ListChangeListener;
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
		
		private Block EtatInventaire=  new Air();
	
		@FXML
		private HBox inventaireVue = new HBox();
	
		private Inventaire iventaireModele=new Inventaire();
	
		private Map<String, Image> dictionnaireImage = new HashMap< String,Image>();  		
	
	
		private Timeline gameLoop=new Timeline();
	
		private Monde monde;
		private Player lePlayer;
		private ArrayList<Ennemi> e = new ArrayList<>();
	
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
				this.EtatInventaire= new Terre();
			}
			if(code == KeyCode.F2) {
				this.EtatInventaire=new bois();
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
			System.out.println(x+";"+y);
//			ImageView l = (ImageView) vue.lookup('#'+""+y+"9"+x);
			/**
			 * Changement
			 */
			if(this.monde.getJoueur().modifPossible(y, x)) {
				if (Button==MouseButton.PRIMARY  && this.iventaireModele.minerPossible(EtatInventaire)) { // rendre Main
					System.out.println(this.monde.getTerrain().getTableTerrain().get(y).get(x).getID());
						this.monde.getTerrain().setTerrain(new Air(), y, x);
						System.out.println(this.monde.getTerrain().getTableTerrain().get(y).get(x));
						System.out.println(this.monde.getTerrain().getTableTerrain().get(y).get(x).getID());
	 
				}
				else if (Button==MouseButton.SECONDARY && this.iventaireModele.creerPossible(EtatInventaire)) {
					this.monde.getTerrain().setTerrain(EtatInventaire, y, x);
					System.out.println(this.monde.getTerrain().getTableTerrain().get(y).get(x));
				}
				
//				l.setImage(dictionnaireImage.get(iventaireModele.transforme_Block_en_Objet(EtatInventaire).getNom()));
				
					
				}
			this.EtatInventaire = new Air();
			System.out.println("ok");
		}
		
		
		
		
		private void initGameLoop() {
			gameLoop.setCycleCount(Timeline.INDEFINITE);
			KeyFrame kfGraviter = new KeyFrame(Duration.seconds(0.4),(ev ->{
				this.monde.getJoueur().seDeplacerBas();
				this.monde.graviterEnnemi();
				this.monde.DepEnnemi();
			}));
			gameLoop.getKeyFrames().add(kfGraviter);
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			//Declaration et Initialisation 
	
			/**
			 * Creation de la map
			 */
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
			 * Les ennemis
			 */
			
			this.monde.getEnnemiList().add(new Cannibale(1, 23, this.monde.getTerrain()));
			this.monde.getEnnemiList().add(new Cannibale(2, 23, this.monde.getTerrain()));
			this.monde.getEnnemiList().add(new Cannibale(3, 23, this.monde.getTerrain()));
			this.monde.getEnnemiList().add(new Cannibale(0, 23, this.monde.getTerrain()));
			System.out.println(this.monde.getEnnemiList());
			
			for (int i = 0; i<this.monde.getEnnemiList().size()-1;i++) {
				Ennemi Ennemi;
				Ennemi = new Ennemi();
				this.e.add(Ennemi);
				this.vue.getChildren().add(Ennemi);
			}
			
			/**
			 * position ennemis
			 */
			
			for (int i = 0; i<this.monde.getEnnemiList().size()-1;i++) {
				this.e.get(i).translateXProperty().bind(this.monde.getEnnemiList().get(i).getX().multiply(32));
				this.e.get(i).translateYProperty().bind(this.monde.getEnnemiList().get(i).getY().multiply(32));
			}
	
			/**
			 * bind les positions de la vue avec les positions du joueur
			 */
	
			this.vue.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32).add(512));
			this.vue.translateYProperty().bind(this.monde.getJoueur().getY().multiply(-16));
	
			
	
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
			
	
			System.out.println("le debug de la vie!");
			System.out.println("test "+this.monde.getJoueur().getNom());
	
			System.out.println("le debug de la mort!");
			
			for(int y=0;y<this.monde.getTerrain().getTableTerrain().size();y++) {
				this.monde.getTerrain().getTableTerrain().get(y).addListener(new ListChangeListener<Block>() {

					@Override
					public void onChanged(Change<? extends Block> c) {
						while (c.next()) {
							if (c.wasReplaced()) {
								for (Block b : c.getRemoved()) {
									ImageView l = (ImageView) vue.lookup('#'+b.getID());
									l.setImage(dictionnaireImage.get(iventaireModele.transforme_Block_en_Objet(EtatInventaire).getNom()));
									System.out.println("do");
								}
							}
						}
					}
				});
			}
			
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