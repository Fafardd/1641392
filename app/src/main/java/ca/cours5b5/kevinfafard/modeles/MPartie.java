package ca.cours5b5.kevinfafard.modeles;

import java.util.Map;

import ca.cours5b5.kevinfafard.serialisation.AttributSerialisable;

public class MPartie extends Modele{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
    }

    public MParametresPartie getParametres() {



        return MParametres.instance.parametresPartie;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        //rien a faire
    }

    @Override
    public Map<String, Object> enObjetJson() {
        //rien a faire
        return null;
    }
}
