package ca.cours5b5.kevinfafard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Parametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MonEtiquette","Bonjour!");
        setContentView(R.layout.activity_parametres);
    }
}
