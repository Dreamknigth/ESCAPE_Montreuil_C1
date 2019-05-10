package ESCAPE_Montreuil_C1.Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class MapController {
	private File fp;
	private FileReader fpr;
	private BufferedReader bfReader;
	private ArrayList<ObservableList <Character>> Terrain;
	
	public MapController() {
		try {
			this.fp = new File("src/ESCAPE_Montreuil_C1/Ressource/terrain.csv");
			this.fpr = new FileReader(this.fp);
			this.bfReader = new BufferedReader(this.fpr);
		}catch(FileNotFoundException e1) {
			System.out.println("Erreur: le fichier est introuvable");
		}
		catch(IOException e) {
			System.out.println("Erreur le fichier ");
		}
		System.out.println("fpr:"+this.fpr);
	}
	
	public void constructeurMap() {
		try {
			String[] ligne;
			
			ligne=this.bfReader.readLine().split(",");
			System.out.println(ligne);
			
		}catch(IOException e) {
			System.out.println("Erreur: le fichier introuvable");
		}
	}
	
	public int tailleTableaux(String[] tableau) {
		int i=0;
		for(i=0;tableau[i]!=null;i++) {}
		return i;
	}
	
}
