package ca.cours5b5.kevinfafard.activites;


import android.os.Bundle;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.controleurs.ControleurAction;
import ca.cours5b5.kevinfafard.controleurs.ControleurModeles;
import ca.cours5b5.kevinfafard.controleurs.interfaces.Fournisseur;
import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.kevinfafard.global.GCommande;
import ca.cours5b5.kevinfafard.modeles.MParametres;
import ca.cours5b5.kevinfafard.modeles.MPartie;


public class AParametres extends Activite implements Fournisseur{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        fournirActions();

    }


    private void fournirActions() {

        ControleurAction.fournirAction(this,
                GCommande.EFFACER_PARTIE_COURANTE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        ControleurModeles.detruireModele(MPartie.class.getSimpleName());

                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }


}
