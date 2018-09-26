package ca.cours5b5.kevinfafard.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.kevinfafard.global.GConstantes;
import ca.cours5b5.kevinfafard.serialisation.AttributSerialisable;

public class MParametres extends Modele{

    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String __parametresPartie = "parametresPartie";

    @AttributSerialisable
    public Integer hauteur;
    private  final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private  final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private  final String __pourGagner = "pourGagner";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){
        //MParametres instance = new MParametres();
        hauteur = GConstantes.hauteurDefaut;
        largeur = GConstantes.largeurDefaut;
        pourGagner = GConstantes.pourGagnerDefaut;

        choixHauteur = new ArrayList<Integer>();
        choixLargeur = new ArrayList<Integer>();
        choixPourGagner = new ArrayList<Integer>();
        genererListesDeChoix();
    }

    private void genererListesDeChoix() {
        choixHauteur = genererListeChoix(GConstantes.hauteurMin,GConstantes.hauteurMax);
        choixLargeur = genererListeChoix(GConstantes.largeurMin,GConstantes.largeurMax);
        choixPourGagner = genererListeChoix(GConstantes.pourGagnerMin, GConstantes.pourGagnerMax);
    }

    private List<Integer> genererListeChoix(int min, int max) {
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = min;i<=max;i++){
            temp.add(i);
        }
        return temp;
    }

    public List<Integer> getChoixHauteur() {
        return choixHauteur;
    }

    public List<Integer> getChoixLargeur() {
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner() {
        return choixPourGagner;
    }

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur){
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
       // hauteur = Integer.valueOf((String)entry.getValue);

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
    public Map<String, Object> enObjetJson() {
        Map<String, Object> lesInfos = new HashMap<>();

        lesInfos.put(__hauteur, hauteur.toString());
        lesInfos.put(__largeur, largeur.toString());
        lesInfos.put(__pourGagner, pourGagner.toString());

        return lesInfos;
    }
}
