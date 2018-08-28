package ca.cours5b5.kevinfafard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Parametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE));
        setContentView(R.layout.activity_parametres);

        if(this.getResources().getBoolean(R.bool.est_paysage)){
            Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE) + " paysage");
        } else {
            Log.d("MonEtiquette",this.getResources().getString(R.string.LANGUAGE) + " portrait");
        }
    }
}
