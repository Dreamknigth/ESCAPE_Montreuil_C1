package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import javafx.event.Event;


import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.blocks.Air;
import ESCAPE_Montreuil_C1.Modele.blocks.Terre;
import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{

	@FXML
	private Pane vue;

	@FXML
	private ImageView perso;


	@FXML
	private HBox inventaireVue = new HBox();

	private Inventaire iventaireModele=new Inventaire();

	private Map<String, Image> dictionnaireImage; 


	private Objet objetRessource;


	private Monde monde;
	private Player lePlayer;


	@FXML
	private void touche(KeyEvent e) throws InterruptedException {
		KeyCode code = e.getCode();
		//System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue());
		if ( (code == KeyCode.Z || code == KeyCode.UP)  ) {
			this.monde.getJoueur().seDeplacerSaut();
		}
		else if( (code == KeyCode.D || code == KeyCode.RIGHT) ) {
			this.monde.getJoueur().seDeplacerDroite();
		}
		else if(code == KeyCode.Q || code == KeyCode.LEFT) {
			this.monde.getJoueur().seDeplacerGauche();
		}
		else if(code == KeyCode.S || code == KeyCode.DOWN){
			this.monde.getJoueur().seDeplacerGraviter();
		}
	}
	public Image choixImage(int a , int b) {
		if(this.iventaireModele.transforme_Char_En_String(this.monde.getTerrain2().getTableTerrain().get(b).get(a).getNom()).equals("Terre") || this.iventaireModele.transforme_Char_En_String(this.monde.getTerrain2().getTableTerrain().get(b).get(a).getNom()).equals("bois") || this.iventaireModele.transforme_Char_En_String(this.monde.getTerrain2().getTableTerrain().get(b).get(a).getNom()).equals("Fer")){				
			return dictionnaireImage.get("Terre");
		}
		return null;
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
		Image i = choixImage(x ,y);
		ImageView l = (ImageView) vue.lookup('#'+""+y+'9'+x);
		String nomRessource = this.iventaireModele.transforme_Char_En_String(this.monde.getTerrain2().getTableTerrain().get(y).get(x).getNom());
		this.objetRessource=this.iventaireModele.chercher(nomRessource);
		
		
		if(Button==MouseButton.PRIMARY){
			if (this.monde.getJoueur().modifPossible(y, x) && this.iventaireModele.minerPossible(objetRessource)) {
					l.setImage(dictionnaireImage.get("Air"));
					this.monde.getTerrain2().setTerrain(new Air(), y, x);
			}
        }
		else if(Button==MouseButton.SECONDARY){
        	if (this.monde.getJoueur().modifPossible(y, x) && this.iventaireModele.creerPossible(objetRessource)) {
    				l.setImage(i);
    				System.out.println("ok");
    				this.monde.getTerrain2().setTerrain(new Terre(), y, x);
    		}
        }
        else if(Button==MouseButton.MIDDLE){
        }
    

		
		//System.out.println(this.iventaireModele.chercher(this.monde.getTerrain2().getTableTerrain().get(x).get(y).getClass().getName()));
		//		System.out.println("ok");
	

	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

		/**
		 * Creation de la map
		 */


		MapReader mr = new MapReader();
		mr.constructeurMap();

		/**onKeyPressed="#touche"
		 * Initialisation des Variables
		 */

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

		this.lePlayer.getVersDroite().bind( this.monde.getJoueur().getVersDroite() );
		this.lePlayer.getEtat().bind( this.monde.getJoueur().getEtat() );

		vue.setOnKeyPressed(e->{
			try {
				touche(e);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});


		/**
		 * Initialisation des Ressources
		 */
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


		for (int i = 0; i < this.monde.getTerrain().size(); i++) {
			for(int j=0;j<this.monde.getTerrain().get(i).size();j++) {
				ImageView view = new ImageView() ;
				if(this.monde.getTerrain().get(i).get(j).getNom()=='A') {
					view.setImage(this.dictionnaireImage.get("Air"));
				}
				else if(this.monde.getTerrain().get(i).get(j).getNom()=='f'){
					view.setImage(this.dictionnaireImage.get("Feuille"));
				}
				else if (this.monde.getTerrain().get(i).get(j).getNom() == 'F') {
					view.setImage(this.dictionnaireImage.get("tronc"));
				}
				else if (this.monde.getTerrain().get(i).get(j).getNom() == 't'){
					view.setImage(this.dictionnaireImage.get("Terre"));
				}
				else if (this.monde.getTerrain().get(i).get(j).getNom() == 'T') {
					view.setImage(this.dictionnaireImage.get("solAvecHerbe"));
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











