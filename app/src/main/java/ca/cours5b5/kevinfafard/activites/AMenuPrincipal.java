package ca.cours5b5.kevinfafard.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import ca.cours5b5.kevinfafard.R;

public class AMenuPrincipal extends AppCompatActivity {

    static{
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + ":: static");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onCreate");
        super.onCreate(savedInstanceState);
        Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE));
        setContentView(R.layout.activity_menuprincipal);

        if(this.getResources().getBoolean(R.bool.est_paysage)){
            Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE) + " paysage");
        } else {
            Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE) + " portrait");
        }

        //Intent monIntention = new Intent(this, AParametres.class);
        //startActivity(monIntention);
    }

    public void sendMessage(View view){
        Intent monIntention = new Intent(this, AParametres.class);
        startActivity(monIntention);
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
        outState.putInt("MaCle",10);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onDestroy");
    }
}
