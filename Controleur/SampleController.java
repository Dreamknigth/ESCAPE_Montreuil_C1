package ESCAPE_Montreuil_C1.Controleur;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Vue.EnnemiVue;
import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
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

	// déclaration 
	@FXML
	private ImageView perso;
	@FXML
	private Pane map;
	@FXML
	private Pane vue;
	@FXML
	private Pane PageAcceuil;
	@FXML
	private Pane tableDeCrafting;
	@FXML
	private HBox inventaire;
	@FXML
	private HBox inventaireVue;

	private boolean etatDesPages=true;
	private Map<String, Image> dictionnaireImage = new HashMap< String,Image>();  		
	private Timeline gameLoop=new Timeline();
	private Monde monde;
	private Player lePlayer;
	private EnnemiVue e = new EnnemiVue();


	//Methodes

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
	void craftEpee(ActionEvent event) {
		this.monde.getJoueur().getCraft().craftingEpee();
	}
	@FXML
	void craftHache(ActionEvent event) {
		this.monde.getJoueur().getCraft().craftingHache();
	}
	@FXML
	void craftPelle(ActionEvent event) {
		this.monde.getJoueur().getCraft().craftingPelle();
	}
	@FXML
	void craftPioche(ActionEvent event) {
		this.monde.getJoueur().getCraft().craftingPioche();
	}


	//touche clavier 
	@FXML
	private void touche(KeyEvent e) throws InterruptedException {
		KeyCode code = e.getCode();
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
		if(code == KeyCode.I ){ // Ouverture de l'inventaire
			etatDesPages=!etatDesPages;
			this.tableDeCrafting.setVisible(etatDesPages);
		}
		// selon les touche on selectionne des objet différent
		if(code == KeyCode.F1) {
			this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(0));		}
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
		if(code == KeyCode.F6) {
			this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(5));
		}
		if(code == KeyCode.F7) {
			this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(6));
		}
		if(code == KeyCode.F8) {
			this.monde.getJoueur().setObjetDansLaMain(this.monde.getJoueur().getInventaire().getListeInventaire().get(7));
		}
	}

	// touche souris
	@FXML
	void mouseClicked(MouseEvent event) {
		//recuperation des clicks 
		int x =(int)event.getX()/32;
		int y =(int)event.getY()/32;
		MouseButton Button = event.getButton();
		ImageView l= (ImageView) vue.lookup('#'+""+y+'9'+x);

		//Changement

		Monde t= this.monde;
		if(this.monde.getJoueur().modifPossible(y, x) && this.monde.getJoueur().getObjetDansLaMain().getValeur().getValue()!=0) {
			if (Button==MouseButton.PRIMARY  ) { // rendre Main
				String nomObjetDansLaMain=this.monde.getJoueur().getObjetDansLaMain().faculte(t,x,y).getNom();
				if (nomObjetDansLaMain != null)
					l.setImage(this.dictionnaireImage.get(nomObjetDansLaMain));
			}

		}
	}

	/**
	 * Gameloop gestion des fps et le timing du jeu 
	 */
	private void initGameLoop() {
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kfPerso = new KeyFrame(Duration.seconds(0.150),(ev ->{
			this.monde.getJoueur().seDeplacer();
			this.monde.getJoueur().getEtat().setValue(0);
			this.monde.graviterEnnemi();
			this.monde.deplaceEnnemi();
			this.monde.activationAttaque();
		}));
		gameLoop.getKeyFrames().add(kfPerso);
	}


	//Initialisation 
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.PageAcceuil.setVisible(etatDesPages);
		this.tableDeCrafting.setVisible(!etatDesPages);
		this.map.setVisible(!etatDesPages);
		this.vue.setVisible(!etatDesPages);
		creerDictionnaire();
		this.monde=new Monde();
		creerVueTerrain();
		this.lePlayer=new Player();
		this.vue.getChildren().add(this.lePlayer);
		gestionPlayer();
		gestionEnnemi();
		initGameLoop();
		gameLoop.play();
		creationInventaire();
		gestionTerrain();
	}
	/**
	 * creation inventaire 
	 */
	private void creationInventaire() {
		for (int i = 0 ;i<this.monde.getJoueur().getInventaire().getTailleInv();i++ ) {
			VBox elementInventaire = new VBox();
			Label boutonA_Appuyé = new Label();
			Label valeurRessource = new Label();
			ImageView Image = new ImageView(dictionnaireImage.get(this.monde.getJoueur().getInventaire().getListeInventaire().get(i).getNom()));
			
			Image.setFitHeight(80);
			Image.setFitWidth(Image.getFitHeight());
			boutonA_Appuyé.setText("F"+(i+1));
			valeurRessource.textProperty().bind(this.monde.getJoueur().getInventaire().getListeInventaire().get(i).getValeur().asString());
			
			elementInventaire.getChildren().add(boutonA_Appuyé);
			elementInventaire.getChildren().add(Image);
			elementInventaire.getChildren().add(valeurRessource);
			elementInventaire.setTranslateX((i+1)*60);
			inventaireVue.getChildren().add(elementInventaire);
		}			

	}
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

	public void creerDictionnaire() {
		dictionnaireImage = new HashMap< String,Image>(); 
		dictionnaireImage.put("A",new Image("ESCAPE_Montreuil_C1/source/air.jpg" ));
		dictionnaireImage.put("t", new Image("ESCAPE_Montreuil_C1/source/terre.jpg")); 
		dictionnaireImage.put("B", new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
		dictionnaireImage.put("I", new Image("ESCAPE_Montreuil_C1/source/Fer.png"));
		dictionnaireImage.put("T",new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg"));
		dictionnaireImage.put("f",new Image("ESCAPE_Montreuil_C1/source/feuille.jpg"));
		dictionnaireImage.put("F",new Image("ESCAPE_Montreuil_C1/source/tronc.jpg"));
		dictionnaireImage.put("P",new Image("ESCAPE_Montreuil_C1/source/pierre.jpg"));
		dictionnaireImage.put("p",new Image("ESCAPE_Montreuil_C1/source/pioche.jpg"));
		dictionnaireImage.put("H",new Image("ESCAPE_Montreuil_C1/source/hache.jpg"));
		dictionnaireImage.put("e",new Image("ESCAPE_Montreuil_C1/source/épée.jpg"));
		dictionnaireImage.put("L",new Image("ESCAPE_Montreuil_C1/source/pelle.jpg"));
	}

	public void gestionPlayer() {
		/**
		 * bind les positions du player(imageview) avec les positions du joueur
		 */
		this.lePlayer.translateXProperty().bind(this.monde.getJoueur().getX().multiply(32));
		this.lePlayer.translateYProperty().bind(this.monde.getJoueur().getY().multiply(32).subtract(15));
		this.lePlayer.getPv().textProperty().bind(this.monde.getJoueur().getPV().asString());
		this.lePlayer.getImagePerso().setFitHeight(64);
		this.lePlayer.getImagePerso().setFitWidth(32);
		this.lePlayer.getImagePerso().setTranslateY(-this.lePlayer.getPv().getMaxHeight());

		/**
		 * bind les positions de la vue avec les positions du joueur
		 */
		this.vue.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32));
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
	}

	public void gestionEnnemi() {
		/**
		 * Les ennemis
		 */

		this.e.addImgEnnemi(this.monde.getEnnemiList());

		for (int i = 0; i<this.monde.getEnnemiList().size();i++) {
			this.vue.getChildren().add(this.e.getImageList().get(i));
		}

		/**
		 * position bind ennemis
		 */

		for (int i = 0; i<this.monde.getEnnemiList().size();i++) {
			this.e.getImageList().get(i).translateXProperty().bind(this.monde.getEnnemiList().get(i).getX().multiply(32));
			this.e.getImageList().get(i).translateYProperty().bind(this.monde.getEnnemiList().get(i).getY().multiply(32));
		}

	}

	public void gestionTerrain() {
		for(int y=0;y<this.monde.getTerrain().getTableTerrain().size();y++) {
			this.monde.getTerrain().getTableTerrain().get(y).addListener(new ListChangeListener<Block>() {

				@Override
				public void onChanged(Change<? extends Block> c) {
					while (c.next()) {
						if (c.wasReplaced()) {
							for (Block b : c.getRemoved()) {
								ImageView l = (ImageView) vue.lookup('#'+b.getID());
							}
						}
					}
				}
			});
		}
	}


}

