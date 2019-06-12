package ESCAPE_Montreuil_C1.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class controleurAcceuil {

    @FXML
    void play(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../Vue/Sample.fxml"));
			Scene scene = new Scene(root,1000,1000);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	System.exit(0);
    }

    @FXML
    void quit(ActionEvent event) {
    	System.exit(0);
    }



}
