package ESCAPE_Montreuil_C1.Modele.blocks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Air;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.Terre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MapMaker {
	private File fp;
	private FileReader fpr;
	private BufferedReader bfReader;
	private ArrayList<ObservableList <Character>> terrainC;
	private ArrayList<ObservableList <Block>> terrain;
	
	public MapMaker() {
		try {
			this.fp = new File("src/ESCAPE_Montreuil_C1/Ressource/terrain.csv");
			this.fpr = new FileReader(this.fp);
			this.bfReader = new BufferedReader(this.fpr);
		}catch(FileNotFoundException e1) {
			System.out.println("Erreur: le fichier est introuvable");
		}
		catch(IOException e) {
			System.out.println("Erreur le fichier ne peut etre ouvert");
		}
		this.terrainC=new ArrayList<ObservableList <Character>>();
	}
	
	public void constructeurMap() {
		int i=0;
		String [] ligne;
		try {
			//un faire tant que on est pas arriver a la fin
			do {
				ligne=this.bfReader.readLine().split(",");
				if(ligne!=null) {
					lireLigne(i,ligne);
				}
				i++;
			}while(ligne!=null);
		}catch(IOException e) {
			System.out.println("Erreur: le fichier introuvable");
		}catch(NullPointerException e) {
			System.out.println("Fin de la lecture");
		}
	}
	public void lireLigne(int i, String [] ligne) {
		int j=0;
		//la declaration de la liste obersvable dans la liste de liste observable puis ajouter a la liste observable le caractere
		this.terrainC.add(FXCollections.observableArrayList());
		for(j=0;j<ligne.length;j++) {
			this.terrainC.get(i).add(ligne[j].charAt(0));
		}
	}
	
	public void charToBlock() {
		char charBlock;
		for(int i=0;i<this.terrainC.size();i++) {
			this.terrain.add(FXCollections.observableArrayList());
			for(int j=0;j<this.terrainC.get(i).size();j++) {
				charBlock=this.terrainC.get(i).get(j);
				switch(charBlock) {
				case 'A':this.terrain.get(i).add(new Air(true,j,i));
				break;
				case 'T':this.terrain.get(i).add(new Terre(false,j,i));
				}
			}
		}
	}
	
	public void afficheTerrain() {
		System.out.print("-");
		for(int i=0;i<this.terrainC.get(0).size();i++) {
			System.out.print("--");
		}
		System.out.print("\n");
		for(int i=0;i<this.terrainC.size();i++) {
			System.out.print("|");
			for(int j=0;j<this.terrainC.get(i).size();j++) {
				System.out.print(this.terrainC.get(i).get(j)+"|");
			}
			System.out.print("\n-");
			for(int k=0;k<this.terrainC.get(i).size();k++) {
				System.out.print("--");
			}
			System.out.print("\n");
		}
	}
	
	public ArrayList<ObservableList <Character>> getTerrain(){
		return this.terrainC;
	}
}
