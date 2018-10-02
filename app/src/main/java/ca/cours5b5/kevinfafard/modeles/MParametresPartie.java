package ca.cours5b5.kevinfafard.modeles;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.kevinfafard.exceptions.ErreurDeSerialisation;
import ca.cours5b5.kevinfafard.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){

        MParametresPartie mParametresPartie = new MParametresPartie();

        mParametresPartie.setHauteur(mParametres.parametresPartie.hauteur);
        mParametresPartie.setLargeur(mParametres.parametresPartie.largeur);
        mParametresPartie.setPourGagner(mParametres.parametresPartie.pourGagner);
        Log.d("test22","4");


        return mParametresPartie;
    }

    public MParametresPartie cloner(){

        MParametresPartie mParametresPartie = new MParametresPartie();

        mParametresPartie.setHauteur(this.hauteur);
        mParametresPartie.setLargeur(this.largeur);
        mParametresPartie.setPourGagner(this.pourGagner);


        return mParametresPartie;
    }

    public MParametresPartie(){

    }

    public Integer getHauteur(){
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation{

        for(Map.Entry<String, Object> entry : objetJson.entrySet()){
            if(entry.getKey().equals(__hauteur))
                hauteur = Integer.valueOf((String)entry.getValue());
            else if (entry.getKey().equals(__largeur))
                largeur = Integer.valueOf((String)entry.getValue());
            else if (entry.getKey().equals(__pourGagner))
                pourGagner = Integer.valueOf((String)entry.getValue());


        }
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        Map<String, Object> lesInfos = new HashMap<>();

        lesInfos.put(__hauteur, hauteur.toString());
        lesInfos.put(__largeur, largeur.toString());
        lesInfos.put(__pourGagner, pourGagner.toString());

        return lesInfos;
    }
}
