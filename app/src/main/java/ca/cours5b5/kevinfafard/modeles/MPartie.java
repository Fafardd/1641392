package ca.cours5b5.kevinfafard.modeles;

import java.util.Map;

import ca.cours5b5.kevinfafard.global.GCouleur;
import ca.cours5b5.kevinfafard.serialisation.AttributSerialisable;

public class MPartie extends Modele{

    private MGrille grille;
    private GCouleur couleurCourante;

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
    }

    public MParametresPartie getParametres() {



        return parametres;
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

    public MGrille getGrille(){

        return grille;
    }

    private void initialiserCouleurCourante(){

    }

    /*private fournirActionPlacerJeton(){
        //Appeler fournirAction
    }*/

    protected void jouerCoup(int colonne){

    }

    private void prochaineCouleurCourante(){

    }
}
