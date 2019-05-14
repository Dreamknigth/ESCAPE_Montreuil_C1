package ESCAPE_Montreuil_C1.Controleur;

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
	private ArrayList<ObservableList <Character>> terrain;
	
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
		String[] ligne;
		try {
			int i=0;
			System.out.println("debug1");
			do{
				ligne=this.bfReader.readLine().split(",");
				System.out.println(ligne[0]);
				System.out.println("debug1."+i);
				for(int j=0;j<ligne.length;j++) {
					System.out.println("debug1."+i+"."+j+".0");
					this.terrain.add(new Ober) //TODO faire la declaration de la liste obersvable dans la liste de liste observable puis ajouter a la liste observable le caractere
					this.terrain.get(i).add(ligne[j].charAt(0));
					System.out.println("debug1."+i+"."+j+".1");
				}
				i++;
			}while(ligne!=null);
		}catch(IOException e) {
			System.out.println("Erreur: le fichier introuvable");
		}catch(NullPointerException e) {
			System.out.println("Fin de la lecture");
		}
	}
	
}
