package ca.cours5b5.kevinfafard.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.controleurs.ControleurAction;
import ca.cours5b5.kevinfafard.controleurs.interfaces.Fournisseur;
import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.kevinfafard.global.GCommande;
import ca.cours5b5.kevinfafard.global.GConstantes;
import ca.cours5b5.kevinfafard.modeles.MPartieReseau;

public class AMenuPrincipal extends Activite implements Fournisseur {

    private final int CODE_CONNEXION = 123;
    public boolean connecté = false;

    private static List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

    static{

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();


    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirConnexion();

        fournirActionJoindreOuCreerPartieReseau();
    }

    private void fournirActionJoindreOuCreerPartieReseau() {
        ControleurAction.fournirAction(this,
                GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        transitionPartieReseau();

                    }
                });
    }
    private void transitionPartieReseau(){
        Intent intentionPartieReseau = new Intent(this, APartieReseau.class);
        intentionPartieReseau.putExtra(MPartieReseau.class.getSimpleName(), GConstantes.FIXME_JSON_PARTIE_RESEAU);
        startActivity(intentionPartieReseau);
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

        Intent intentionPartie = new Intent(this, APartie.class);
        startActivity(intentionPartie);

    }

    private void fournirConnexion() {
        ControleurAction.fournirAction(this, GCommande.CONNEXION, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                if(!connecté)
                    connexion();
                else
                    deconnexion();
            }
        });

    }

    private void connexion() {
        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion, CODE_CONNEXION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == CODE_CONNEXION){
            if(resultCode == RESULT_OK){
                Log.d("Atelier11", "Connexion réussite");
                connecté=true;

            } else {
                Log.d("Atelier11", "Connexion échoué");
            }
        }
    }

    private void deconnexion(){
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("Atelier11", "Déconnexion terminé");
                connecté=false;
            }
        });
    }





}
