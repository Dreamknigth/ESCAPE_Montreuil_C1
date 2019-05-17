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
		System.out.println(this.j1.getX().getValue()+" "+this.j1.getY().getValue());
		int vitesse=4;
		if ( (code == KeyCode.Z || code == KeyCode.UP)  ) {
			j1.seDeplacerHaut();
			System.out.println("droite");
		}
		if( (code == KeyCode.D || code == KeyCode.RIGHT) ) {
			j1.seDeplacerDroite();
		}
		if(code == KeyCode.Q || code == KeyCode.LEFT) {
			j1.seDeplacerGauche();
		}
		if(code == KeyCode.S || code == KeyCode.DOWN){
			j1.seDeplacerBas();
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
		Image T= new Image("ESCAPE_Montreuil_C1/Ressource/terre.jpg");
		
		perso.setImage(new Image("ESCAPE_Montreuil_C1/Ressource/Joueur/Megamanx running.gif"));
		perso.translateXProperty().bind(j1.getX().multiply(32));
		perso.translateYProperty().bind(j1.getY().multiply(32));


		perso.setFitHeight(40);
		perso.setFitWidth(40);

		
		
		for (int i = 0; i < terrain.size(); i++) {
			for(int j=0;j<terrain.get(i).size();j++) {
				ImageView view = new ImageView() ;
				System.out.println(terrain.get(i).get(j).getTraversable());
				if(terrain.get(i).get(j).getTraversable()) {
					view.setImage(A);
				}
				else{
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
