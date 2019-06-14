package ESCAPE_Montreuil_C1.Modele.Inventaire;


import ESCAPE_Montreuil_C1.Modele.Objet.EpeeObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.Objet;
import ESCAPE_Montreuil_C1.Modele.Objet.hacheObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.pelleObjet;
import ESCAPE_Montreuil_C1.Modele.Objet.piocheObjet;
import ESCAPE_Montreuil_C1.Modele.blocks.Block;
import ESCAPE_Montreuil_C1.Modele.blocks.FerBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.PierreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.TerreBlock;
import ESCAPE_Montreuil_C1.Modele.blocks.boisBlock;
import ESCAPE_Montreuil_C1.Modele.map.MapReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

    private ObservableList<Objet> ob ;
    
    public Inventaire() {
        MapReader mr=new MapReader();
        mr.constructeurMap();
        this.ob = FXCollections.observableArrayList();
        this.ob.add(new TerreBlock());
        this.ob.add(new boisBlock());
        this.ob.add(new FerBlock());
        this.ob.add(new PierreBlock());
        this.ob.add(new piocheObjet());
        this.ob.add(new hacheObjet());
        this.ob.add(new EpeeObjet());
        this.ob.add(new pelleObjet());
        
    }
    public ObservableList<Objet> getListeInventaire () {
        return this.ob;
    }

    public Objet recherche(Block unBlock) {
        int i =0;
        while(i<this.ob.size()) {
            if(this.ob.get(i).getNom().equals(unBlock.getNom())) {
                return this.ob.get(i);
            }
            i++;
        }
        return null;
    }
    public Objet recherche(Objet o) {
        int i =0;
        while(i<this.ob.size()) {
            if(this.ob.get(i).getNom().equals(o.getNom())) {
                return this.ob.get(i);
            }
            i++;
        }
        return null;
    }
    public int tailleInv() {
    	return this.ob.size();
    }
	

}

