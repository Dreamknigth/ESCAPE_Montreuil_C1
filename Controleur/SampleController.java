package ESCAPE_Montreuil_C1.Controleur;

import java.awt.peer.LabelPeer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import ESCAPE_Montreuil_C1.Modele.Inventaire.Inventaire;
import ESCAPE_Montreuil_C1.Modele.Personnage.Joueur;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{

	@FXML
	private Pane monde;

	@FXML
	private Pane map;

	@FXML
	private ImageView perso;


	@FXML
	private HBox inventaireVue = new HBox();

	private Inventaire iventaireModele=new Inventaire();

	private Map<String, ImageView> dictionnaireImage; 


	private Joueur j1;
	private MapReader mp;

	@FXML
	private void touche(KeyEvent e) throws InterruptedException {
		KeyCode code = e.getCode();
		//System.out.println(this.j1.getY().getValue()+" "+this.j1.getX().getValue());
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
		dictionnaireImage = new HashMap< String,ImageView>(); 
		dictionnaireImage.put("Terre", new ImageView("ESCAPE_Montreuil_C1/source/terre.jpg")); 
		dictionnaireImage.put("bois", new ImageView("ESCAPE_Montreuil_C1/source/tronc.jpg"));
		dictionnaireImage.put("Fer", new ImageView("ESCAPE_Montreuil_C1/source/Fer.png"));

		
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
		map.setOnMousePressed(e -> mouseClicked(e));
		MapReader mr = new MapReader();
		mr.constructeurMap();
		ArrayList<ObservableList <Block>> terrain=mr.getTerrain();
		//this.mp.afficheTerrain();
		Image A= new Image("ESCAPE_Montreuil_C1/source/air.jpg");
		Image T= new Image("ESCAPE_Montreuil_C1/source/solpetit.jpg");
		Image t = new Image("ESCAPE_Montreuil_C1/source/terre.jpg");
		Image f= new Image("ESCAPE_Montreuil_C1/source/feuille.jpg");
		Image F= new Image("ESCAPE_Montreuil_C1/source/tronc.jpg");
		//Image Fer= new Image("ESCAPE_Montreuil_C1/source/Fer.jpg");
		//Image elixir= new Image("ESCAPE_Montreuil_C1/source/elixir.png");
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
		this.perso.setImage(new Image("ESCAPE_Montreuil_C1/source/Joueur/Megamanx running.gif"));

		/**
		 * Deplacement Joueur
		 */

		j1.seDeplacerGraviter();


		this.perso.translateXProperty().bind(j1.getX().multiply(32));
		this.perso.translateYProperty().bind(j1.getY().multiply(32));

		this.monde.translateXProperty().bind(j1.getX().multiply(-32).add(512));
		this.monde.translateYProperty().bind(j1.getY().multiply(-16));

		this.perso.setFitHeight(40);
		this.perso.setFitWidth(40);

		/**
		 * Initialisation des Ressources
		 */
		for (int i = 0 ;i<this.iventaireModele.getListeInventaire().size();i++ ) {
			VBox elementInventaire = new VBox();
			Label valeurRessource = new Label();
			ImageView Image = dictionnaireImage.get(this.iventaireModele.getListeInventaire().get(i).getNom());
			Image.setFitHeight(32);
			Image.setFitWidth(32);
			valeurRessource.textProperty().bind(this.iventaireModele.getListeInventaire().get(i).getValeur().asString());
			elementInventaire.getChildren().add(Image);
			elementInventaire.getChildren().add(valeurRessource);
			
			
			elementInventaire.setTranslateX(i*20);
			inventaireVue.getChildren().add(elementInventaire);
		}
	
	}
}
