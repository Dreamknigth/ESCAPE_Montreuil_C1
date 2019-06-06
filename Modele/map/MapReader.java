package ESCAPE_Montreuil_C1.Modele.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ESCAPE_Montreuil_C1.Modele.blocks.Air;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.Sol;
import ESCAPE_Montreuil_C1.Modele.blocks.Terre;
import ESCAPE_Montreuil_C1.Modele.blocks.bois;
import ESCAPE_Montreuil_C1.Modele.blocks.feuille;
import ESCAPE_Montreuil_C1.Modele.blocks.tronc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MapReader {
	private File fp;
	private FileReader fpr;
	private BufferedReader bfReader;
	private ArrayList<ObservableList <Block>> terrain;

	public MapReader() {
		try {
//			this.fp = new File("src/ESCAPE_Montreuil_C1/source/terrain.csv");
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
	private void lireLigne(int i, String [] ligne) {
		int j=0;
		char charBlock;
		//la declaration de la liste observable dans la liste de liste observable puis ajouter a la liste observable le caractere
		this.terrain.add(FXCollections.observableArrayList());
		for(j=0;j<ligne.length;j++) {
			charBlock=ligne[j].charAt(0);
			switch(charBlock) {
			case 'A':this.terrain.get(i).add(new Air());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case 'T':this.terrain.get(i).add(new Terre());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case 'f':this.terrain.get(i).add(new feuille());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			case 'F':this.terrain.get(i).add(new tronc());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			default:this.terrain.get(i).add(new Sol());
					this.terrain.get(i).get(j).setID(""+i+"9"+j);
			break;
			}
		}
	}
	
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
	
	public ArrayList<ObservableList <Block>> getTerrain(){
		return this.terrain;
	}
}
