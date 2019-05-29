package ESCAPE_Montreuil_C1.Controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import ESCAPE_Montreuil_C1.Modele.map.Monde;
import ESCAPE_Montreuil_C1.Modele.blocks.Air;
import ESCAPE_Montreuil_C1.Vue.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class SampleController implements Initializable{
	
	 	@FXML
	    private Pane vue;

	    @FXML
	    private Pane map;

	    @FXML
	    private ImageView perso;

	    @FXML
	    private ImageView RessourceBois;

	    @FXML
	    private ImageView RessourceFer;

	    @FXML
	    private ImageView RessourceTerre;

	    @FXML
	    private ImageView RessourceElixir;
	
	
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
		System.out.println(lePlayer);
	}
	
	@FXML
	void mouseClicked(MouseEvent event) {

		int x =(int)event.getX()/32;
		int y =(int)event.getY()/32;
		if (this.monde.getJoueur().modifPossible(y, x)) {
			Air a = new Air();
			System.out.println(x+";"+y);
			Image i = new Image("ESCAPE_Montreuil_C1/source/air.jpg");
				ImageView l = (ImageView) vue.lookup('#'+""+y+'9'+x);
				l.setImage(i);
				this.monde.getTerrain2().setTerrain(a, y, x);
		}
		
		
	}
	


	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Declaration et Initialisation 
			
				this.monde=new Monde();
				creerVueTerrain();
				
				this.lePlayer=new Player();
				this.vue.getChildren().add(this.lePlayer);
				
				System.out.println(lePlayer);
				
				//bind les positions du player(imageview) avec les positions du joueur
				this.lePlayer.translateXProperty().bind(this.monde.getJoueur().getX().multiply(32));
				this.lePlayer.translateYProperty().bind(this.monde.getJoueur().getY().multiply(32));
				this.lePlayer.setFitHeight(50);
				this.lePlayer.setFitWidth(50);
				//bind les positions de la vue avec les positions du joueur
				this.vue.translateXProperty().bind(this.monde.getJoueur().getX().multiply(-32).add(512));
				this.vue.translateYProperty().bind(this.monde.getJoueur().getY().multiply(-16));
				//bind les comportement du joueur avec les comportement du player(qui gere les images)
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
				
				System.out.println("le debug de la vie!");
				System.out.println("test "+this.monde.getJoueur().getNom());
			
				//j=new Player();
//				cadre.setImage(new Image("ESCAPE_Montreuil_C1/source/Joueur/Megamanx running.gif"));
//				cadre.setFitHeight(40);
//				cadre.setFitWidth(40);
//				cadre.translateXProperty().bind( j1.getX() );
//				cadre.translateYProperty().bind( j1.getX() );
				System.out.println("le debug de la mort!");
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
				String s = i+"9"+j;
				view.setId(s);
				vue.getChildren().add(view);
				view.setTranslateX(j*view.getFitWidth());
				view.setTranslateY(i*view.getFitHeight());
				
			}
		}
	}
}
				
				
				
				
				
				
				
				
				
				
				
				