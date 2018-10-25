package ca.cours5b5.kevinfafard.donnees;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import ca.cours5b5.kevinfafard.serialisation.Jsonification;

public class Serveur extends SourceDeDonnees {

    private Serveur(){}

    private static final Serveur instance = null;

    public static Serveur getInstance(){
        return null;
    }
    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);



        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(noeud.toString());

        return objetJson;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        noeud.setValue(objetJson);


    }

    //@Override
    public void detruireSauvegarde(String cheminSauvegarde){
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();
    }
}
