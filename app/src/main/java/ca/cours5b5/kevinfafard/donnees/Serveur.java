package ca.cours5b5.kevinfafard.donnees;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import ca.cours5b5.kevinfafard.serialisation.Jsonification;

public class Serveur extends SourceDeDonnees {

    private Serveur(){}

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }
    @Override
    public void chargerModele(String cheminSauvegarde, final ListenerChargement listenerChargement) {

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        noeud.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Map<String, Object> objectJson = (Map<String, Object>) dataSnapshot.getValue();

                    listenerChargement.reagirSucces(objectJson);
                } else{
                    listenerChargement.reagirErreur(new Exception("Pas de données dans le noeud"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                    listenerChargement.reagirErreur(new Exception("Erreur de lecture"));
            }
        });



        //Map<String, Object> objetJson = Jsonification.aPartirChaineJson(noeud.toString());



    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        noeud.setValue(objetJson);


        Log.d("atelier11", noeud.toString());
    }

    //@Override
    public void detruireSauvegarde(String cheminSauvegarde){
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();
    }
}
