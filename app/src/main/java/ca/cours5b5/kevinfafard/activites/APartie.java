package ca.cours5b5.kevinfafard.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.modeles.MParametres;
import ca.cours5b5.kevinfafard.serialisation.Jsonification;

public class APartie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onCreate");
        super.onCreate(savedInstanceState);
        Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE));
        setContentView(R.layout.activity_jouer);
    }

    private void restaurerParametre(Bundle savedInstanceState) {
        Log.d("Atelier04", "Restore");
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
        Log.d("Atelier04", "onsaveinstance");
        super.onSaveInstanceState(outState);


        sauvegarderParametre(outState);
    }

    private void sauvegarderParametre(Bundle outState) {
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onDestroy");
    }
}
