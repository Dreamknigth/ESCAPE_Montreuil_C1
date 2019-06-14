package ESCAPE_Montreuil_C1.Modele.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.AirBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.feuilleBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.troncBlock;

import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.SolBlock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MapReader {
	//declaration
	private File fp;
	private FileReader fpr;
	private BufferedReader bfReader;
	private ArrayList<ObservableList <Block>> terrain;
	
	/**
	 * Le MapReader permet de traduire la map csv en liste de list observable de Block
	 */
	//constructeur
	public MapReader() {
		try {
			this.fp = new File("src/ESCAPE_Montreuil_C1/source/map5.csv");

			this.fpr = new FileReader(this.fp);
			this.bfReader = new BufferedReader(this.fpr);
		}catch(FileNotFoundException e1) {
			System.out.println("Erreur: le fichier est introuvable");
		}
		catch(IOException e) {
			System.out.println("Erreur le fichier ne peut etre ouvert");
		}
		this.terrain=new ArrayList<ObservableList <Block>>();
	}
	
	//methode
	public void constructeurMap() {
		int i=0;
		String [] ligne;
		try {
			//un faire tant que on est pas arriver a la fin
			do {
				ligne=this.bfReader.readLine().split(","); //separe le resultat en tableaux de String en fonction des point virgule
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
	
	/**
	 * Permet de lire une ligne du fichier csv
	 * creer un objet en fonction de la case du tableaux de String lu
	 */
	private void lireLigne(int i, String [] ligne) {
		int j=0;
		char charBlock;
		this.terrain.add(FXCollections.observableArrayList());
		for(j=0;j<ligne.length;j++) {
			charBlock=ligne[j].charAt(0);

			String a = charBlock+"";
		switch(a) {
			case "A":this.terrain.get(i).add(new AirBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case "T":this.terrain.get(i).add(new TerreBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case "f":this.terrain.get(i).add(new feuilleBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case "F":this.terrain.get(i).add(new troncBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case "P":this.terrain.get(i).add(new PierreBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case "I":this.terrain.get(i).add(new FerBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			default:this.terrain.get(i).add(new SolBlock());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			}
		}
	}
	
	//getter
	public ArrayList<ObservableList <Block>> getTerrain(){
		return this.terrain;
	}
	
	/**
	 * On l'as creer pour verfifer la bonne lecture de la map csv
	 */
	public void afficheTerrain() {
		System.out.print("-");
		for(int i=0;i<this.terrain.get(0).size();i++) {
			System.out.print("--");
		}
		System.out.print("\n");
		for(int i=0;i<this.terrain.size();i++) {
			System.out.print("|");
			for(int j=0;j<this.terrain.get(i).size();j++) {
				System.out.print(this.terrain.get(i).get(j).getNom()+"|");
			}
			System.out.print("\n");
			for(int k=0;k<this.terrain.get(i).size();k++) {
				System.out.print("--");
			}
			System.out.print("\n");
		}
	}

}
