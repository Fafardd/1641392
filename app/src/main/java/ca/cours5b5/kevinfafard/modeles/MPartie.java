package ca.cours5b5.kevinfafard.modeles;

import java.util.Map;

import ca.cours5b5.kevinfafard.controleurs.ControleurAction;
import ca.cours5b5.kevinfafard.controleurs.interfaces.Fournisseur;
import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.kevinfafard.global.GCommande;
import ca.cours5b5.kevinfafard.global.GCouleur;
import ca.cours5b5.kevinfafard.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    private MGrille grille;
    private GCouleur couleurCourante;

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
        initialiserCouleurCourante();
        grille = new MGrille(this.parametres.getLargeur());
        fournirActionPlacerJeton();
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
        couleurCourante = GCouleur.JAUNE;
    }

    private void fournirActionPlacerJeton(){
        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                jouerCoup((int)args[0]);
            }
        });
    }

    protected void jouerCoup(int colonne){
        grille.placerJeton(colonne, couleurCourante);
        prochaineCouleurCourante();
    }

    private void prochaineCouleurCourante(){
        if (couleurCourante ==(GCouleur.ROUGE))
            couleurCourante = (GCouleur.JAUNE);
        else
            couleurCourante = GCouleur.ROUGE;
    }
}
