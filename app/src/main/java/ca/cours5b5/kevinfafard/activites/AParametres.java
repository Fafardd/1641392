package ca.cours5b5.kevinfafard.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.modeles.MParametres;
import ca.cours5b5.kevinfafard.modeles.Modele;
import ca.cours5b5.kevinfafard.serialisation.Jsonification;

public class AParametres extends AppCompatActivity {

    static{
        Log.d("Atelier04", AParametres.class.getSimpleName() + ":: static");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onCreate");
        super.onCreate(savedInstanceState);
        Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE));
        setContentView(R.layout.activity_parametres);

        if(this.getResources().getBoolean(R.bool.est_paysage)){
            Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE) + " paysage");
        } else {
            Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE) + " portrait");
        }

        if(savedInstanceState != null){

            restaurerParametre(savedInstanceState);

        }


    }

    private void restaurerParametre(Bundle savedInstanceState) {
        String json = savedInstanceState.getString("MParametre");

        Map<String, Object> objetJson = Jsonification.enObjetJson(json);

        MParametres.instance.aPartirObjetJson(objetJson);

        Log.d("Atelier5", this.getClass().getSimpleName() + "::restaurerParametre, cle: MParametre");
        Log.d("Atelier5", this.getClass().getSimpleName() + "::restaurerParametre" + json);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);


        sauvegarderParametre(outState);
    }

    private void sauvegarderParametre(Bundle outState) {
        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaine(objetJson);

        outState.putString("MParametre",json);


        Log.d("Atelier5", this.getClass().getSimpleName() + "::sauvegarderParametre, cle: MParametre");
        Log.d("Atelier5", this.getClass().getSimpleName() + "::sauvegarderParametre" + json);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onDestroy");
    }
}
